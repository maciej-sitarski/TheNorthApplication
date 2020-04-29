package theNorthApplication.app.mapper;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Component;
import theNorthApplication.app.api.searcherClasses.Geometry;
import theNorthApplication.app.api.searcherClasses.Location;
import theNorthApplication.app.api.searcherClasses.Results;
import theNorthApplication.app.dto.StoreDto;
import theNorthApplication.app.entity.Locations;
import theNorthApplication.app.entity.Store;

import java.util.Objects;
import java.util.Optional;


@Component
public class SearchResultsDtoMapper {

    public StoreDto mapSearchResultToDto(Results results) {

        StoreDto storeDto = new StoreDto();
        String[] address = results.getAddress().split(",");

        String country = null;
        String street = null;
        String town = null;
        if (address.length>2) {
            country = address[2];
            street = address[0];
            town = getTownFormAddress(address[1]);
        } else {
            country = address[1];
            street = "";
            town = getTownFormAddress(address[0]);
        }

        String lat = Optional.of(results)
                .map(Results::getGeometry)
                .map(Geometry::getLocation)
                .map(Location::getLat)
                .orElse(null);

        String lng = Optional.of(results)
                .map(Results::getGeometry)
                .map(Geometry::getLocation)
                .map(Location::getLng)
                .orElse(null);

        storeDto.setId(results.getId());
        storeDto.setName(results.getName());
        storeDto.setCountry(country);
        storeDto.setStreet(street);
        storeDto.setTown(town);
        storeDto.setLat(lat);
        storeDto.setLng(lng);
        return storeDto;
    }

    private String getTownFormAddress(String postalCodeAndTown) {
        String[] separatedPostalCodeAndTown = postalCodeAndTown.stripLeading().split(" ");
        if (separatedPostalCodeAndTown.length>1) {
            return separatedPostalCodeAndTown[1];
        } else {
            return separatedPostalCodeAndTown[0];
        }
    }

    public StoreDto nearByMapToDto(Results results){

        String id = Optional.ofNullable(results)
                .map(Results::getId)
                .orElse(null);

        String name = Optional.ofNullable(results)
                .map(Results::getName)
                .orElse(null);

        String lat = Optional.ofNullable(results)
                .map(Results::getGeometry)
                .map(Geometry::getLocation)
                .map(Location::getLat)
                .orElse(null);

        String lng = Optional.ofNullable(results)
                .map(Results::getGeometry)
                .map(Geometry::getLocation)
                .map(Location::getLng)
                .orElse(null);

        String [] address = Objects.requireNonNull(Optional.ofNullable(results)
                .map(Results::getVicinity)
                .orElse(null))
                .split(",");

        StoreDto storeDto = new StoreDto();

        storeDto.setId(id);
        storeDto.setName(name);
        storeDto.setLat(lat);
        storeDto.setLng(lng);
        if(address.length>1) {
            storeDto.setStreet(address[0]);
            storeDto.setTown(address[1]);
        } else storeDto.setTown(address[0]);

        return storeDto;
    }
}
