package theNorthApplication.app.mapper;

import org.springframework.stereotype.Component;
import theNorthApplication.app.dto.AvailabilityDto;
import theNorthApplication.app.entity.Availability;

import java.util.Optional;

@Component
public class AvailabilityMapper {

    public AvailabilityDto mapAvailabilityToDto(Availability availability) {

        Boolean gelAvailability = Optional.ofNullable(availability)
                .map(Availability::getGelAvailability)
                .map(gelavailibility -> gelavailibility > 1.5)
                .orElse(null);

        Boolean glovesAvailability = Optional.ofNullable(availability)
                .map(Availability::getGlovesAvailability)
                .map(glovesavailability -> glovesavailability > 1.5)
                .orElse(null);

        Boolean maskAvailability = Optional.ofNullable(availability)
                .map(Availability::getMaskAvailability)
                .map(maskavailability -> maskavailability > 1.5)
                .orElse(null);

        Double maskPrize = Optional.ofNullable(availability)
                .map(Availability::getMaskPrize)
                .orElse(null);

        Double glovesPrize = Optional.ofNullable(availability)
                .map(Availability::getGlovesPrize)
                .orElse(null);

        Double gelPrize = Optional.ofNullable(availability)
                .map(Availability::getGelPrize)
                .orElse(null);

        AvailabilityDto availabilityDto = new AvailabilityDto();

        availabilityDto.setGelAvailability(gelAvailability);
        availabilityDto.setGlovesAvailability(glovesAvailability);
        availabilityDto.setMaskAvailability(maskAvailability);
        availabilityDto.setMaskPrize(maskPrize);
        availabilityDto.setGlovesPrize(glovesPrize);
        availabilityDto.setGelPrize(gelPrize);

        return availabilityDto;
    }
}
