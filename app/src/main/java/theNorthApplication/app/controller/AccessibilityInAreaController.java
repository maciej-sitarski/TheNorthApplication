package theNorthApplication.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AccessibilityInAreaController {

    @GetMapping("/accessibilityinyourarea")
    public ModelAndView getMainPage() {
        Map<String, Object> params = new HashMap<>();
        return new ModelAndView("accessibilityinyourarea", params);
    }
}
