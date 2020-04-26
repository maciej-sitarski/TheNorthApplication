package theNorthApplication.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import theNorthApplication.app.dto.StoreEntityDto;
import theNorthApplication.app.service.StoreService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class StoreDetailsController {

    private final StoreService storeService;

    @Autowired
    public StoreDetailsController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/storeDetails")
    public ModelAndView getStoreDetails(HttpServletRequest req) {
        Map<String, Object> params = new HashMap<>();
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String street = req.getParameter("street");
        String town = req.getParameter("town");

        StoreEntityDto storeEntityDto = storeService.findStoreById(id);
        if(storeEntityDto.getId() != null) {
            if(storeEntityDto.getAvailabilityDto().isMaskAvailability()){
                params.put("mask", "mask");
            }
            if(storeEntityDto.getAvailabilityDto().isGlovesAvailability()){
                params.put("gloves", "gloves");
            }
            if(storeEntityDto.getAvailabilityDto().isGelAvailability()){
                params.put("gel", "gel");
            }

        }else{
            params.put("noData", "noData");
        }
        params.put("id", id);
        params.put("name", name);
        params.put("street", street);
        params.put("town", town);

        return new ModelAndView("storeDetails", params);
    }
}

