package theNorthApplication.app;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import theNorthApplication.app.parser.ShopsSearcherParser;
import theNorthApplication.app.service.SearcherService;

import java.io.IOException;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);

	}

}
