package theNorthApplication.app.service;

import org.springframework.stereotype.Service;
import theNorthApplication.app.dto.StoreEntityDto;
import theNorthApplication.app.entity.Availability;
import theNorthApplication.app.entity.Statistic;
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
        Optional<Store> store = storeRepository.findById(id);

        StoreEntityDto storeEntityDto = storeEntityMapper.mapStoreToDto(store.orElse(null));
        return storeEntityDto;
    }

    public void saveUpdateStoreAndAvalibility(String id, String queueTrue, String maskTrue, String glovesTrue, String gelTrue){
        StoreEntityDto storeEntityDto = findStoreById(id);
        if(storeEntityDto.getId()!=null){
            Store store = storeRepository.findById(id).orElseThrow();
            Statistic statistic = store.getStatistic();
            Availability availability = store.getAvailability();
            if(queueTrue!=null){
                if(queueTrue.equals("true")){
                    if(statistic.getQueueSize()<3){
                        Integer size = statistic.getQueueSize()+1;
                        statistic.setQueueSize(size);
                    }
                } else{
                    if(statistic.getQueueSize()>0){
                        Integer size = statistic.getQueueSize()-1;
                        statistic.setQueueSize(size);
                    }
                }
            }

            if(maskTrue!=null){
                if(maskTrue.equals("true")){
                    if(availability.getMaskAvailability()<3){
                        Integer size = availability.getMaskAvailability()+1;
                        availability.setMaskAvailability(size);
                    }
                } else{
                    if(availability.getMaskAvailability()>0){
                        Integer size = availability.getMaskAvailability()-1;
                        availability.setMaskAvailability(size);
                    }
                }
            }

            if(glovesTrue!=null){
                if(glovesTrue.equals("true")){
                    if(availability.getGlovesAvailability()<3){
                        Integer size = availability.getGlovesAvailability()+1;
                        availability.setGlovesAvailability(size);
                    }
                } else{
                    if(availability.getGlovesAvailability()>0){
                        Integer size = availability.getGlovesAvailability()-1;
                        availability.setGlovesAvailability(size);
                    }
                }
            }

            if(gelTrue!=null){
                if(gelTrue.equals("true")){
                    if(availability.getGelAvailability()<3){
                        Integer size = availability.getGelAvailability()+1;
                        availability.setGelAvailability(size);
                    }
                } else {
                    if(availability.getGelAvailability()>0){
                        Integer size = availability.getGelAvailability()-1;
                        availability.setGelAvailability(size);
                    }
                }
            }

            store.setStatistic(statistic);
            store.setAvailability(availability);
            storeRepository.save(store);

        } else {
            Store store = new Store();
            store.setId(id);

            Statistic statistic = new Statistic();
            if(queueTrue!=null){
                if(queueTrue.equals("true")){
                    statistic.setQueueSize(1);
                } else {
                    statistic.setQueueSize(0);
                }
            } else{
                statistic.setQueueSize(0);
            }
            store.setStatistic(statistic);

            Availability availability = new Availability();
            if(maskTrue!=null){
                if(maskTrue.equals("true")){
                    availability.setMaskAvailability(1);
                } else {
                    availability.setMaskAvailability(0);
                }
            }else {
                availability.setMaskAvailability(0);
            }

            if(glovesTrue!=null){
                if(glovesTrue.equals("true")){
                    availability.setGlovesAvailability(1);
                } else {
                    availability.setGlovesAvailability(0);
                }
            } else {
                availability.setGlovesAvailability(0);
            }

            if(gelTrue!=null){
                if(gelTrue.equals("true")){
                    availability.setGelAvailability(1);
                } else {
                    availability.setGelAvailability(0);
                }
            } else {
                availability.setGelAvailability(0);
            }
            store.setAvailability(availability);

            storeRepository.save(store);
        }
    }
}
