package clf.winner.spring.mvc.web.controller;

import clf.winner.spring.mvc.service.EchoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/selectView")
public class ViewResolverController {

    private static final Logger logger = LoggerFactory.getLogger(ViewResolverController.class);

    @Autowired
    private EchoService echoService;

    @RequestMapping(value="/{to}")
    public String to(@PathVariable("to") String to, Model model){

        logger.info("direct to {}", to);

        model.addAttribute("msg", echoService.echo());
        if (to.equals("ftl")) {
            return "FreeMarkerView"; //跳转到FreeMarker页面
        } else if (to.equals("jsp")) {
            return "JspView";//跳转到JSP页面
        } else {
            return "error";
        }

    }

}