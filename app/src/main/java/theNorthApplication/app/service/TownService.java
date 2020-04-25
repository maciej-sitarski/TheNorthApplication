package theNorthApplication.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import theNorthApplication.app.dto.TownsDto;
import theNorthApplication.app.mapper.LocationsMapper;
import theNorthApplication.app.repositories.LocationsRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TownService {

    private final LocationsRepository locationsRepository;

    private final LocationsMapper locationsMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public TownService(LocationsRepository locationsRepository, LocationsMapper locationsMapper) {
        this.locationsRepository = locationsRepository;
        this.locationsMapper = locationsMapper;
    }

    public List<TownsDto> getTownsList() {
        List<TownsDto> townsList = new ArrayList<>();
        locationsRepository.findAll().forEach(locations -> townsList.add(locationsMapper.mapLocationsToTownsDto(locations)));
        logger.info("get towns list from locations");
        return townsList;
    }
}
