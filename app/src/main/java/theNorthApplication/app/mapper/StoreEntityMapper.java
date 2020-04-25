package theNorthApplication.app.mapper;

import org.springframework.stereotype.Component;
import theNorthApplication.app.dto.StoreEntityDto;
import theNorthApplication.app.entity.Store;

@Component
public class StoreEntityMapper {

    private final StatisticMapper statisticMapper;
    private final AvailabilityMapper availabilityMapper;

    public StoreEntityMapper(StatisticMapper statisticMapper, AvailabilityMapper availabilityMapper) {
        this.statisticMapper = statisticMapper;
        this.availabilityMapper = availabilityMapper;
    }


    public StoreEntityDto mapStoreToDto(Store store) {
        StoreEntityDto storeEntityDto = new StoreEntityDto();
        storeEntityDto.setId(store.getId());
        storeEntityDto.setAvailabilityDto(availabilityMapper.mapAvailabilityToDto(store.getAvailability()));
        storeEntityDto.setStatisticDto(statisticMapper.mapStatisticToDto(store.getStatistic()));
        return storeEntityDto;
    }
}
