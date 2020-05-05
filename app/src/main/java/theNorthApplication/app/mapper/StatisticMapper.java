package theNorthApplication.app.mapper;

import org.springframework.stereotype.Component;
import theNorthApplication.app.dto.AvailabilityDto;
import theNorthApplication.app.dto.StatisticDto;
import theNorthApplication.app.entity.Statistic;
import theNorthApplication.app.entity.Store;

import java.util.Optional;

@Component
public class StatisticMapper {

    public StatisticDto mapStatisticToDto(Statistic statistic) {

        Long id = Optional.ofNullable(statistic)
                .map(Statistic::getId)
                .orElse(null);

        Integer queueSize = Optional.ofNullable(statistic)
                .map(Statistic::getQueueSize)
                .orElse(null);

        StatisticDto statisticDto = new StatisticDto();

        statisticDto.setId(id);
        statisticDto.setQueueSize(queueSize);

        return statisticDto;
    }
}
