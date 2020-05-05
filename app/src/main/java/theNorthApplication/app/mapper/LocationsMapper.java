package theNorthApplication.app.mapper;

import org.springframework.stereotype.Component;
import theNorthApplication.app.dto.TownsDto;
import theNorthApplication.app.entity.Locations;
import theNorthApplication.app.entity.Statistic;

import java.util.Optional;

@Component
public class LocationsMapper {

    public TownsDto mapLocationsToTownsDto(Locations locations) {

        String town = Optional.ofNullable(locations)
                .map(Locations::getTown)
                .orElse(null);

        TownsDto townsDto = new TownsDto();

        townsDto.setTown(town);

        return townsDto;
    }
}
