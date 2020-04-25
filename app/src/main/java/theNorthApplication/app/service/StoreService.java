package theNorthApplication.app.service;

import org.springframework.stereotype.Service;
import theNorthApplication.app.dto.StoreDto;
import theNorthApplication.app.dto.StoreEntityDto;
import theNorthApplication.app.entity.Store;
import theNorthApplication.app.mapper.StoreEntityMapper;
import theNorthApplication.app.repositories.StoreRepository;

@Service
public class StoreService {

    private final StoreRepository storeRepository;
    private final StoreEntityMapper storeEntityMapper;

    public StoreService(StoreRepository storeRepository, StoreEntityMapper storeEntityMapper) {
        this.storeRepository = storeRepository;
        this.storeEntityMapper = storeEntityMapper;
    }

    public StoreEntityDto findStoreById(String id) {
        return storeEntityMapper.mapStoreToDto(storeRepository.findById(id));
    }

}
