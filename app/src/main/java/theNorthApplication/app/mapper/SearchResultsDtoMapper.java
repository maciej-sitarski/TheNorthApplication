package theNorthApplication.app.mapper;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Component;
import theNorthApplication.app.api.searcherClasses.Results;
import theNorthApplication.app.dto.StoreDto;


@Component
public class SearchResultsDtoMapper {

    public StoreDto mapSearchResultToDto(Results results) {

        StoreDto storeDto = new StoreDto();
        String[] address = results.getAddress().split(",");
        address[1] = address[1].substring(0, 6);

        storeDto.setId(results.getId());
        storeDto.setName(results.getName());
        storeDto.setCountry(address[2]);
        storeDto.setStreet(address[0]);
        storeDto.setTown(address[1]);
        return storeDto;
    }


}
