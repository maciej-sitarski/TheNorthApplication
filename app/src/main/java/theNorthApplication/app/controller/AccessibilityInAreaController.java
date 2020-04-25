package theNorthApplication.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AccessibilityInAreaController {

    @GetMapping("/accessibilityinyourarea")
    public ModelAndView getAccessibilityInAreaPage(@RequestParam boolean isProtectiveGlovesNeeded,
                                    @RequestParam boolean isDisinfectantNeeded,
                                    @RequestParam boolean isMaskNeeded) {
        Map<String, Object> params = new HashMap<>();
        params.put("isProtectiveGlovesNeeded", isProtectiveGlovesNeeded);
        params.put("isDisinfectantNeeded", isDisinfectantNeeded);
        params.put("isMaskNeeded", isMaskNeeded);
        return new ModelAndView("accessibilityinyourarea", params);
    }
}
