package theNorthApplication.app.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import theNorthApplication.app.api.SearchResults;
import org.springframework.web.context.WebApplicationContext;
import theNorthApplication.app.api.searcherClasses.Results;
import theNorthApplication.app.dto.ShopNameDto;
import theNorthApplication.app.service.ShopsNamesService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShopsSearcherParser {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ShopsNamesService shopsNamesService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${API_Key}")
    private String apiKey;

    @Autowired
    public ShopsSearcherParser(ShopsNamesService shopsNamesService) {
        this.shopsNamesService = shopsNamesService;
    }

    public SearchResults parseSearch(String shop, String town) throws UnirestException, IOException, InterruptedException {

        SearchResults searchResults = getResponseFromApi(shop, town);
        logger.info("Parse searching to objects");

        SearchResults nexPageResult = new SearchResults();

        while (searchResults.getNextPageToken() != null) {
            Thread.sleep(1600L);
            nexPageResult = getNextPageResults(searchResults.getNextPageToken());
            nexPageResult.getResultsList().forEach(results -> searchResults.getResultsList().add(results));
            searchResults.setNextPageToken(nexPageResult.getNextPageToken());
        }
        return searchResults;
    }

    public SearchResults parseSearchByCoordinatesAndRadius(String lat, String lng, String radius) throws UnirestException, IOException, InterruptedException {

        logger.info("Parse searching based on arguments lat={}, lng={}, radius={} is to be done", lat, lng, radius);

        SearchResults searchResults = getResponseFromApiByCoordinatesAndRadius(lat, lng, radius);

        SearchResults nexPageResult;

        while (searchResults.getNextPageToken() != null) {
            Thread.sleep(1600L);
            nexPageResult = getNextPageResults(searchResults.getNextPageToken());
            nexPageResult.getResultsList().forEach(results -> searchResults.getResultsList().add(results));
            searchResults.setNextPageToken(nexPageResult.getNextPageToken());
        }
        return searchResults;
    }

    public SearchResults parseSearchByCoordinatesAndRadiusByM(String lat, String lng, String radius) throws IOException, UnirestException{
        List<ShopNameDto> shopsNames = shopsNamesService.getShopsNames();
        SearchResults searchResults = getResponseFromApiByCoordinatesAndRadiusByM(lat, lng, radius, shopsNames.get(0).getName(), shopsNames.get(0).getType());
        shopsNames.remove(0);
        shopsNames.forEach(shopNameDto -> {
            try {
                searchResults.getResultsList().addAll(getResponseFromApiByCoordinatesAndRadiusByM(lat, lng, radius, shopNameDto.getName(), shopNameDto.getType()).getResultsList());
            } catch (UnirestException | IOException e) {
                e.printStackTrace();
            }
        });

        return searchResults;
    }

    private SearchResults getResponseFromApi(String shop, String town) throws UnirestException, IOException {
        HttpResponse<String> response = Unirest.get("https://maps.googleapis.com/maps/api/place/textsearch/json?" +
                "query=" + shop + "+" + town +
                "&key=" + apiKey).asString();
        return objectMapper.readValue(response.getBody(), SearchResults.class);
    }

    private SearchResults getResponseFromApiByCoordinatesAndRadius(String lat, String lng, String radius) throws UnirestException, IOException {

        String requestUri = String.format("https://maps.googleapis.com/maps/api/place/textsearch/json?query=%s+%s+%s+%s+%s+%s&location=%s,%s&radius=%s&key=%s",
                "supermarket",
                "grocery_or_supermarket",
                "food",
                "point_of_interest",
                "store",
                "establishment",
                lat,
                lng,
                radius,
                apiKey);

        HttpResponse<String> response = Unirest.get(requestUri).asString();
        return objectMapper.readValue(response.getBody(), SearchResults.class);
    }

    private SearchResults getResponseFromApiByCoordinatesAndRadiusByM(String lat, String lng, String radius, String shopName, String shopType) throws UnirestException, IOException {

        String requestUri = String.format("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+ lat + "," + lng +"&radius="+ radius + "&type="+ shopType + "&name=" + shopName + "&key=" + apiKey);

        HttpResponse<String> response = Unirest.get(requestUri).asString();
        return objectMapper.readValue(response.getBody(), SearchResults.class);
    }


    private SearchResults getNextPageResults(String nexPageToken) throws UnirestException, IOException {
        HttpResponse<String> response = Unirest.get("https://maps.googleapis.com/maps/api/place/textsearch/json?" +
                "pagetoken=" + nexPageToken +
                "&key=" + apiKey).asString();
        return objectMapper.readValue(response.getBody(), SearchResults.class);
    }
}
