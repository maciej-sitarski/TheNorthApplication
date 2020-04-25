package theNorthApplication.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import theNorthApplication.app.service.ShopsNamesService;
import theNorthApplication.app.service.TownService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SearchStoresController {

    private final TownService townService;
    private final ShopsNamesService shopsNamesService;

    @Autowired
    public SearchStoresController(TownService townService, ShopsNamesService shopsNamesService) {
        this.townService = townService;
        this.shopsNamesService = shopsNamesService;
    }

    @GetMapping("/searchStore")
    public ModelAndView getHomeView() {
        Map<String, Object> params = new HashMap<>();
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
    public ModelAndView getSpecificStores(HttpServletRequest req) {
        Map<String, Object> params = new HashMap<>();
        String city = req.getParameter("city");
        String shop = req.getParameter("shop");


        return new ModelAndView("searchStoreView2", params);
    }

}
