package theNorthApplication.app.restcontroller;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import theNorthApplication.app.dto.StoreDto;
import theNorthApplication.app.service.SearcherService;

import java.io.IOException;
import java.util.List;

@RestController
public class NearbyShopsRestController {

    @Autowired
    private SearcherService searcherService;

    @GetMapping("/rest/api/nearbyshops")
    public List<StoreDto> getNearbyShops(@RequestParam("lat") String lat,
                                         @RequestParam("lng") String lng,
                                         @RequestParam("radius") String radius) throws IOException, UnirestException, InterruptedException {
        return searcherService.getStoresByCoordinatesAndRadius(lat, lng, radius);
    }
}
