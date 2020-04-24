package theNorthApplication.app.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mashape.unirest.http.Headers;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;
import theNorthApplication.app.domain.googleApi.SearchResults;
import theNorthApplication.app.domain.googleApi.searcherClasses.Results;

import java.io.IOException;
import java.util.List;

@Service
public class ShopsSearcherParser {

    private ObjectMapper objectMapper = new ObjectMapper();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    String apiKey = "AIzaSyByf6Wfz_btg3iIOcdwav_UCOJGucPln4g";

    public SearchResults parseSearch(String shop, String town, String country) throws UnirestException, IOException {

        SearchResults searchResults = getResponseFromApi(shop, town, country);
        logger.info("Parse searching to objects");

        SearchResults nexPageResult = new SearchResults();

        while (searchResults.getNextPageToken() != null){
            nexPageResult = getNextPageResults(searchResults.getNextPageToken());
            nexPageResult.getResultsList().forEach(results -> searchResults.getResultsList().add(results));
            searchResults.setNextPageToken(nexPageResult.getNextPageToken());
        }

        return searchResults;
    }

    private SearchResults getResponseFromApi(String shop, String town, String country) throws UnirestException, IOException {
        HttpResponse<String> response = Unirest.get("https://maps.googleapis.com/maps/api/place/textsearch/json?" +
                "query=" + shop + "+" + country + "+" + town +
                "&key=" + apiKey).asString();
        return objectMapper.readValue(response.getBody(), SearchResults.class);
    }

    private SearchResults getNextPageResults(String nexPageToken) throws UnirestException, IOException {
        HttpResponse<String> response = Unirest.get("https://maps.googleapis.com/maps/api/place/textsearch/json?" +
                "pagetoken=" + nexPageToken +
                "&key=" + apiKey).asString();
        return objectMapper.readValue(response.getBody(), SearchResults.class);
    }

}
