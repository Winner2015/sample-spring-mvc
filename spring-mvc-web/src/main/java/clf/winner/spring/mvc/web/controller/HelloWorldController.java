package clf.winner.spring.mvc.web.controller;

import clf.winner.spring.mvc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @Autowired
    private TestService testService;

    @RequestMapping("hello")
    public ModelAndView hello() {

        System.out.println("hello world");

        //模型视图，springMVC自带的
        ModelAndView mav = new ModelAndView();

        //设置的模型数据，用于传递到jsp页面
        mav.addObject("msg", "hello springmvc...");

        //设置打开的视图名字
        mav.setViewName("/WEB-INF/jsp/hello.jsp");

        return mav;
    }

    @RequestMapping("/helloworld")
    public String hello2() {
        String name = testService.getName();
        System.out.println("hello world, " + name);
        return "index";
    }

    @RequestMapping("/jsonTest")
    @ResponseBody
    public String json() {
        return "hello world";
    }

}
