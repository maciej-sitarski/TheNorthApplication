package theNorthApplication.app.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import theNorthApplication.app.dto.StoreDto;
import theNorthApplication.app.service.SearcherService;
import theNorthApplication.app.service.ShopsNamesService;
import theNorthApplication.app.service.TownService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class SearchStoresController {

    private final TownService townService;
    private final ShopsNamesService shopsNamesService;
    private final SearcherService searcherService;

    @Autowired
    public SearchStoresController(TownService townService, ShopsNamesService shopsNamesService, SearcherService searcherService) {
        this.townService = townService;
        this.shopsNamesService = shopsNamesService;

        this.searcherService = searcherService;
    }

    @GetMapping("/searchStore")
    public ModelAndView getHomeView(HttpServletRequest req) {
        Map<String, Object> params = new HashMap<>();
        String choice = req.getParameter("choice");
        if(choice.equals("form")){
          req.getSession().setAttribute("choice", "form");
        } else{
            req.getSession().setAttribute("choice", "shopDetails");
        }
        return new ModelAndView("searchStoreView", params);
    }

    @RequestMapping(value = "/city")
    public @ResponseBody
    List<String> getAutocompleteCityList(@RequestParam(value = "term") String city) {
        return townService.getAutocompleteTownList(city);

    }

    @RequestMapping(value = "/shop")
    public @ResponseBody
    List<String> getAutocompleteShopList(@RequestParam(value = "term") String shop) {
        return shopsNamesService.getAutocompleteShopList(shop);
    }

    @GetMapping("/validationOfShops")
    public ModelAndView getSpecificStores(HttpServletRequest req) throws IOException, UnirestException, InterruptedException {
        Map<String, Object> params = new HashMap<>();
        String city = req.getParameter("city");
        String shop = req.getParameter("shop");
        String choice = (String)req.getSession().getAttribute("choice");

        if (townService.checkAvailabilityOfTown(city) && shopsNamesService.checkAvailabilityOfShop(shop)) {
            List<StoreDto> storeDtoList = searcherService.getStoreDtoList(shop, city).stream().filter(storeDto -> storeDto.getName().toLowerCase().startsWith(shop.toLowerCase().substring(0, 2))).collect(Collectors.toList());
            params.put("listOfStores", storeDtoList);
            params.put("city", city);
            params.put("shop", shop);
            if(choice.equals("form")){
                params.put("choice", "form");
            } else {
                params.put("choice", "shopDetails");
            }

        } else {
            params.put("city", "empty");
            params.put("shop", "empty");
        }
        return new ModelAndView("searchStoreView2", params);
    }

}
