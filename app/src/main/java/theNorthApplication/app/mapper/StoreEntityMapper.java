package theNorthApplication.app.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import theNorthApplication.app.dto.AvailabilityDto;
import theNorthApplication.app.dto.StatisticDto;
import theNorthApplication.app.dto.StoreEntityDto;
import theNorthApplication.app.entity.Store;

import java.util.Optional;

@Component
public class StoreEntityMapper {

    private final StatisticMapper statisticMapper;
    private final AvailabilityMapper availabilityMapper;

    @Autowired
    public StoreEntityMapper(StatisticMapper statisticMapper, AvailabilityMapper availabilityMapper) {
        this.statisticMapper = statisticMapper;
        this.availabilityMapper = availabilityMapper;
    }


    public StoreEntityDto mapStoreToDto(Store store) {

        String id =Optional.ofNullable(store)
                .map(Store::getId)
                .orElse(null);

        AvailabilityDto availabilityDto = Optional.ofNullable(store)
                .map(Store::getAvailability)
                .map(availabilityMapper::mapAvailabilityToDto)
                .orElse(null);

        StatisticDto statisticDto = Optional.ofNullable(store)
                .map(Store::getStatistic)
                .map(statisticMapper::mapStatisticToDto)
                .orElse(null);

        StoreEntityDto storeEntityDto = new StoreEntityDto();

        storeEntityDto.setId(id);
        storeEntityDto.setAvailabilityDto(availabilityDto);
        storeEntityDto.setStatisticDto(statisticDto);

        return storeEntityDto;
    }
}
