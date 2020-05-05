package theNorthApplication.app.dto;

import lombok.Data;

@Data
public class StoreEntityDto {

    private String id;
    private AvailabilityDto availabilityDto;
    private StatisticDto statisticDto;
}
