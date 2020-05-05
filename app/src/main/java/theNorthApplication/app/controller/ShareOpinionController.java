package theNorthApplication.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import theNorthApplication.app.dto.Questionnaire;
import theNorthApplication.app.service.StoreService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
    public ModelAndView getSuccessOpinionView(@Valid Questionnaire questionnaire) {
        Map<String, Object> params = new HashMap<>();
        storeService.saveUpdateStoreAndAvalibility(questionnaire);
        return new ModelAndView("shareOpinionPositive", params);
    }
}
