package theNorthApplication.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import theNorthApplication.app.service.SearcherService;
import theNorthApplication.app.service.StoreService;
import theNorthApplication.app.service.TownService;

@Controller
public class TestController {

    private final SearcherService searcherService;

    private final TownService townService;

    private final StoreService storeService;

    public TestController(SearcherService searcherService, TownService townService, StoreService storeService) {
        this.searcherService = searcherService;
        this.townService = townService;
        this.storeService = storeService;
    }

    @GetMapping("/test")
    ResponseEntity<String> postResults() {
        return new ResponseEntity<String>(storeService.findStoreById("1").toString(), HttpStatus.OK);
    }
}
