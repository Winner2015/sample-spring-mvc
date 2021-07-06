package clf.winner.spring.mvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/convert")
public class ConvertController {

    @RequestMapping(value="/init")
    public String init() {
        return "convert";
    }

}
