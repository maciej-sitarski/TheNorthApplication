package theNorthApplication.app.restcontroller;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import theNorthApplication.app.dto.StoreDto;
import theNorthApplication.app.dto.StoreEntityDto;
import theNorthApplication.app.service.SearcherService;
import theNorthApplication.app.service.StoreService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class NearbyShopsRestController {

    private final SearcherService searcherService;
    private final StoreService storeService;

    @Autowired
    public NearbyShopsRestController(SearcherService searcherService, StoreService storeService) {
        this.searcherService = searcherService;
        this.storeService = storeService;
    }

    @GetMapping("/rest/api/nearbyshops")
    public List<StoreDto> getNearbyShops(@RequestParam("lat") String lat,
                                         @RequestParam("lng") String lng,
                                         @RequestParam("radius") String radius) throws IOException, UnirestException, InterruptedException {

        List<StoreDto> storeDtos = searcherService.getStoresByCoordinatesAndRadius(lat, lng, radius);

        List<StoreDto> newStoreDtos = storeDtos.stream().map(store -> {
            String storeId = store.getId();
            StoreEntityDto storeEntityDto1 = storeService.findStoreById(storeId);
            store.setStoreEntityDto(storeEntityDto1);
            return store;
            }
        ).collect(Collectors.toList());

        return newStoreDtos;
    }
}
