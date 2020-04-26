package theNorthApplication.app.service;

import org.springframework.stereotype.Service;
import theNorthApplication.app.dto.StoreDto;
import theNorthApplication.app.dto.StoreEntityDto;
import theNorthApplication.app.entity.Store;
import theNorthApplication.app.mapper.StoreEntityMapper;
import theNorthApplication.app.repositories.StoreRepository;

import java.util.Optional;

@Service
public class StoreService {

    private final StoreRepository storeRepository;
    private final StoreEntityMapper storeEntityMapper;

    public StoreService(StoreRepository storeRepository, StoreEntityMapper storeEntityMapper) {
        this.storeRepository = storeRepository;
        this.storeEntityMapper = storeEntityMapper;
    }

    public StoreEntityDto findStoreById(String id) {
        if (id.equals("82113b27a70a22748e7ceaef498b9d351de10ac2")){
            String dasds =null;
            String d = dasds + "";
        }

        Optional<Store> store = storeRepository.findById(id);

        StoreEntityDto storeEntityDto = storeEntityMapper.mapStoreToDto(store.orElse(null));
        return storeEntityDto;
    }

    public void saveUpdateStoreAndAvalibility(String id, String queueTrue,String queueFalse, String maskTrue,String maskFalse, String glovesTrue,String glovesFalse, String gelTrue,String gelFalse){
        StoreEntityDto storeEntityDto = findStoreById(id);
        if(storeEntityDto!=null){

        } else {
            Store store = new Store();
//            store.setId(id);
//            store.set
//            storeRepository.save(storeEntityDto1);
        }
    }

}
