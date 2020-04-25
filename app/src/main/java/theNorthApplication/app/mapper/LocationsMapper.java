package theNorthApplication.app.mapper;

import org.springframework.stereotype.Component;
import theNorthApplication.app.dto.TownsDto;
import theNorthApplication.app.entity.Locations;

@Component
public class LocationsMapper {

    public TownsDto mapLocationsToTownsDto(Locations locations) {
        TownsDto townsDto = new TownsDto();
        townsDto.setTown(locations.getTown());
        return townsDto;
    }
}
