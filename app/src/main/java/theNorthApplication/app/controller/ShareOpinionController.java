package theNorthApplication.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ShareOpinionController {

    @GetMapping("/shareopinion/{id}")
    public ModelAndView getHomeView(@PathVariable String id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return new ModelAndView("formView", params);
    }
}
