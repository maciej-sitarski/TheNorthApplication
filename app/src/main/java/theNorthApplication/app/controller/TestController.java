package theNorthApplication.app.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import theNorthApplication.app.service.SearcherService;
import theNorthApplication.app.service.ShopsNamesService;
import theNorthApplication.app.service.TownService;

import java.io.IOException;

@Controller
public class TestController {

    private final SearcherService searcherService;

    private final TownService townService;

    private final ShopsNamesService shopsNamesService;

    public TestController(SearcherService searcherService, TownService townService, ShopsNamesService shopsNamesService) {
        this.searcherService = searcherService;
        this.townService = townService;
        this.shopsNamesService = shopsNamesService;
    }

    @GetMapping("/test")
    ResponseEntity<String> postResults() {
        return new ResponseEntity<String>(shopsNamesService.getShopsNames().toString(), HttpStatus.OK);
    }
}
