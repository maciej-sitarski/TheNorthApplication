package theNorthApplication.app.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import theNorthApplication.app.service.SearcherService;

import java.io.IOException;

@Controller
public class TestController {

private final SearcherService searcherService;

    public TestController(SearcherService searcherService) {
        this.searcherService = searcherService;
    }

    @GetMapping("/main")
    ResponseEntity<String> postResults() throws IOException, UnirestException {
        return new ResponseEntity<String>(searcherService.getStoreDtoList("lidl", "gdansk", "poland").toString(), HttpStatus.OK);
    }
}
