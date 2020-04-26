package theNorthApplication.app.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import theNorthApplication.app.dto.StoreDto;
import theNorthApplication.app.service.SearcherService;
import theNorthApplication.app.service.StoreService;

import theNorthApplication.app.service.TownService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    private final SearcherService searcherService;

    private final TownService townService;
    private final StoreService storeService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public TestController(SearcherService searcherService, TownService townService, StoreService storeService) {
        this.searcherService = searcherService;
        this.townService = townService;
        this.storeService = storeService;
    }

    @GetMapping("/test")
    ResponseEntity<String> postResults() throws IOException, UnirestException, InterruptedException {
        List<StoreDto> storeDtos = searcherService.getStoreDtoList("Carrefour", "Polska");
        logger.info(String.valueOf(storeDtos.size()));

        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }
}
