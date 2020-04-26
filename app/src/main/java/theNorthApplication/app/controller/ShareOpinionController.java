package theNorthApplication.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        String queueFalse = req.getParameter("queueFalse");
        String maskTrue = req.getParameter("maskTrue");
        String maskFalse = req.getParameter("maskFalse");
        String glovesTrue = req.getParameter("glovesTrue");
        String glovesFalse = req.getParameter("glovesFalse");
        String gelTrue = req.getParameter("gelTrue");
        String gelFalse = req.getParameter("gelFalse");
        storeService.saveUpdateStoreAndAvalibility(id,queueTrue,queueFalse,maskTrue,maskFalse,glovesTrue,glovesFalse,gelTrue,gelFalse);
        return new ModelAndView("shareOpinionPositive", params);
    }
}
