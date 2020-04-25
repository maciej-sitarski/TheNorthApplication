package theNorthApplication.app.dto;

import lombok.Data;
import theNorthApplication.app.entity.Availability;

@Data
public class StoreEntityDto {
    private String id;
    private AvailabilityDto availabilityDto;
    private StatisticDto statisticDto;

}
