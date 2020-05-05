package theNorthApplication.app.service;

import org.springframework.stereotype.Service;
import theNorthApplication.app.dto.StoreEntityDto;
import theNorthApplication.app.entity.Availability;
import theNorthApplication.app.dto.Questionnaire;
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

    public void saveUpdateStoreAndAvalibility(Questionnaire questionnaire) {
        StoreEntityDto storeEntityDto = findStoreById(questionnaire.getId());
        if (storeEntityDto.getId() != null) {
            Store store = storeRepository.findById(questionnaire.getId()).orElseThrow();
            Statistic statistic = store.getStatistic();
            Availability availability = store.getAvailability();
            if (questionnaire.getQueueTrue() != null) {
                if (questionnaire.getQueueTrue().equals("true")) {
                    if (statistic.getQueueSize() < 3) {
                        Integer size = statistic.getQueueSize() + 1;
                        statistic.setQueueSize(size);
                    }
                } else {
                    if (statistic.getQueueSize() > 0) {
                        Integer size = statistic.getQueueSize() - 1;
                        statistic.setQueueSize(size);
                    }
                }
            }

            if (questionnaire.getMaskTrue() != null) {
                if (questionnaire.getMaskTrue().equals("true")) {
                    if (availability.getMaskAvailability() < 3) {
                        Integer size = availability.getMaskAvailability() + 1;
                        availability.setMaskAvailability(size);
                    }
                } else {
                    if (availability.getMaskAvailability() > 0) {
                        Integer size = availability.getMaskAvailability() - 1;
                        availability.setMaskAvailability(size);
                    }
                }
            }

            if (questionnaire.getGlovesTrue() != null) {
                if (questionnaire.getGlovesTrue().equals("true")) {
                    if (availability.getGlovesAvailability() < 3) {
                        Integer size = availability.getGlovesAvailability() + 1;
                        availability.setGlovesAvailability(size);
                    }
                } else {
                    if (availability.getGlovesAvailability() > 0) {
                        Integer size = availability.getGlovesAvailability() - 1;
                        availability.setGlovesAvailability(size);
                    }
                }
            }

            if (questionnaire.getGelTrue() != null) {
                if (questionnaire.getGelTrue().equals("true")) {
                    if (availability.getGelAvailability() < 3) {
                        Integer size = availability.getGelAvailability() + 1;
                        availability.setGelAvailability(size);
                    }
                } else {
                    if (availability.getGelAvailability() > 0) {
                        Integer size = availability.getGelAvailability() - 1;
                        availability.setGelAvailability(size);
                    }
                }
            }

            if (questionnaire.getMaskPrice() != null && !questionnaire.getMaskPrice().equals("")) {
                try {
                    availability.setMaskPrize(Double.parseDouble(questionnaire.getMaskPrice().replaceAll(",", ".")));
                } catch (Exception ignored) {

                }
            }

            if (questionnaire.getGlovesPrice() != null && !questionnaire.getGlovesPrice().equals("")) {
                try {
                    availability.setGlovesPrize(Double.parseDouble(questionnaire.getGlovesPrice().replaceAll(",", ".")));
                } catch (Exception ignored) {

                }
            }

            if (questionnaire.getGelPrice() != null && !questionnaire.getGelPrice().equals("")) {
                try {
                    availability.setGelPrize(Double.parseDouble(questionnaire.getGelPrice().replaceAll(",", ".")));
                } catch (Exception ignored) {

                }
            }

            store.setStatistic(statistic);
            store.setAvailability(availability);
            storeRepository.save(store);

        } else {
            Store store = new Store();
            store.setId(questionnaire.getId());

            Statistic statistic = new Statistic();
            if (questionnaire.getQueueTrue() != null) {
                if (questionnaire.getQueueTrue().equals("true")) {
                    statistic.setQueueSize(1);
                } else {
                    statistic.setQueueSize(0);
                }
            } else {
                statistic.setQueueSize(0);
            }
            store.setStatistic(statistic);

            Availability availability = new Availability();
            if (questionnaire.getMaskTrue() != null) {
                if (questionnaire.getMaskTrue().equals("true")) {
                    availability.setMaskAvailability(1);
                } else {
                    availability.setMaskAvailability(0);
                }
            } else {
                availability.setMaskAvailability(0);
            }

            if (questionnaire.getGlovesTrue() != null) {
                if (questionnaire.getGlovesTrue().equals("true")) {
                    availability.setGlovesAvailability(1);
                } else {
                    availability.setGlovesAvailability(0);
                }
            } else {
                availability.setGlovesAvailability(0);
            }

            if (questionnaire.getGelTrue() != null) {
                if (questionnaire.getGelTrue().equals("true")) {
                    availability.setGelAvailability(1);
                } else {
                    availability.setGelAvailability(0);
                }
            } else {
                availability.setGelAvailability(0);
            }

            if (questionnaire.getMaskPrice() != null && !questionnaire.getMaskPrice().equals("")) {
                try {
                    availability.setMaskPrize(Double.parseDouble(questionnaire.getMaskPrice().replaceAll(",", ".")));
                } catch (Exception ignored) {

                }
            }

            if (questionnaire.getGlovesPrice() != null && !questionnaire.getGlovesPrice().equals("")) {
                try {
                    availability.setGlovesPrize(Double.parseDouble(questionnaire.getGlovesPrice().replaceAll(",", ".")));
                } catch (Exception ignored) {

                }
            }

            if (questionnaire.getGelPrice() != null && !questionnaire.getGelPrice().equals("")) {
                try {
                    availability.setGelPrize(Double.parseDouble(questionnaire.getGelPrice().replaceAll(",", ".")));
                } catch (Exception ignored) {

                }
            }

            store.setAvailability(availability);

            storeRepository.save(store);
        }
    }
}
