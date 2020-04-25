package theNorthApplication.app.mapper;

import org.springframework.stereotype.Component;
import theNorthApplication.app.dto.AvailabilityDto;
import theNorthApplication.app.entity.Availability;

@Component
public class AvailabilityMapper {

    public AvailabilityDto mapAvailabilityToDto(Availability availability) {
        AvailabilityDto availabilityDto = new AvailabilityDto();
        availabilityDto.setGelAvailability(availability.getGelAvailability() > 1.5);
        availabilityDto.setGlovesAvailability(availability.getGlovesAvailability() > 1.5);
        availabilityDto.setMaskAvailability(availability.getMaskAvailability() > 1.5);
        return availabilityDto;
    }
}
