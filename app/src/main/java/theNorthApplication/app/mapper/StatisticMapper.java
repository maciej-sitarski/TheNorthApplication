package theNorthApplication.app.mapper;

import org.springframework.stereotype.Component;
import theNorthApplication.app.dto.StatisticDto;
import theNorthApplication.app.entity.Statistic;

@Component
public class StatisticMapper {

    public StatisticDto mapStatisticToDto(Statistic statistic) {
        StatisticDto statisticDto = new StatisticDto();
        statisticDto.setId(statistic.getId());
        statisticDto.setQueueSize(statistic.getQueueSize());
        return statisticDto;
    }
}
