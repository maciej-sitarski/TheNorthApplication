package theNorthApplication.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class AccessibilityInAreaController {

    @GetMapping("/accessibilityinyourarea")
    public ModelAndView getAccessibilityInAreaPage(HttpServletRequest req) {

        Boolean isProtectiveGlovesNeeded = Optional.ofNullable(req.getParameter("isProtectiveGlovesNeeded")).isPresent();
        Boolean isDisinfectantNeeded = Optional.ofNullable(req.getParameter("isDisinfectantNeeded")).isPresent();
        Boolean isMaskNeeded = Optional.ofNullable(req.getParameter("isMaskNeeded")).isPresent();
        Map<String, Object> params = new HashMap<>();
        params.put("isProtectiveGlovesNeeded", isProtectiveGlovesNeeded);
        params.put("isDisinfectantNeeded", isDisinfectantNeeded);
        params.put("isMaskNeeded", isMaskNeeded);
        return new ModelAndView("accessibilityinyourarea", params);
    }
}
