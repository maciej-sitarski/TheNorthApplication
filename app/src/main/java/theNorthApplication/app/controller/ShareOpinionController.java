package theNorthApplication.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import theNorthApplication.app.service.StoreService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ShareOpinionController {

    private final StoreService storeService;

    @Autowired
    public ShareOpinionController(StoreService storeService) {
        this.storeService = storeService;
    }


    @GetMapping("/shareopinion")
    public ModelAndView getHomeView(HttpServletRequest req) {
        Map<String, Object> params = new HashMap<>();
        String id = req.getParameter("id");
        params.put("id", id);
        return new ModelAndView("formView", params);
    }

    @GetMapping("/shareopinionsucces")
    public ModelAndView getSuccessOpinionView(HttpServletRequest req) {
        Map<String, Object> params = new HashMap<>();
        String id = req.getParameter("id");
        String queueTrue = req.getParameter("queueTrue");
        String maskTrue = req.getParameter("maskTrue");
        String glovesTrue = req.getParameter("glovesTrue");
        String gelTrue = req.getParameter("gelTrue");
        String maskPrize = req.getParameter("maskPrice");
        String glovesPrize = req.getParameter("glovesPrice");
        String gelPrize = req.getParameter("gelPrice");
        storeService.saveUpdateStoreAndAvalibility(id,queueTrue,maskTrue,glovesTrue,gelTrue,maskPrize,glovesPrize,gelPrize);
        return new ModelAndView("shareOpinionPositive", params);
    }
}
