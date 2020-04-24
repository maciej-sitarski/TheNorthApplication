package theNorthApplication.app.mapper;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import theNorthApplication.app.api.searcherClasses.Results;
import theNorthApplication.app.dto.StoreDto;
import theNorthApplication.app.parser.ShopsSearcherParser;

import javax.naming.directory.SearchResult;
import java.io.IOException;
import java.util.Arrays;

@Component
public class SearchResultsDtoMapper {

    public StoreDto mapSearchResultToDto(Results results) throws IOException, UnirestException {

        StoreDto storeDto = new StoreDto();

        String[] address = results.getAddress().split(",");
        char[] town = address[1].toCharArray();
        town[1] = ' ';
        town[2] = ' ';
        town[3] = ' ';
        town[4] = ' ';
        town[5] = ' ';
        town[6] = ' ';
        address[1] = Arrays.toString(town);

        address[1] = address[1].replaceAll(" ","");
        address[1] = address[1].replaceAll(",","");

        storeDto.setId(results.getId());
        storeDto.setName(results.getName());
        storeDto.setCountry(address[2]);
        storeDto.setStreet(address[0]);
        storeDto.setTown(address[1]);
        return storeDto;
    }


}
