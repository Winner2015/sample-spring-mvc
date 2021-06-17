package clf.winner.spring.mvc.web.controller;


import clf.winner.spring.mvc.web.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SessionAttributes(value={"sessionUser"})
@Controller
@RequestMapping("/paramPass")
public class ParamPassController {

    private static final Logger logger = LoggerFactory.getLogger(ParamPassController.class);

    @RequestMapping(value="/init")
    public String init() {
        return "paramPassInit";
    }

    @RequestMapping(value="/byDefault")
    public String byAutoMatch(String name, Integer age, Model model) {
        logger.info("========byDefault========");
        logger.info("name: " + name + ", age: " + age);

        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return "paramPassResult";
    }

    @RequestMapping(value="/byDefault2")
    public String byDefault2(User user, Model model) {
        logger.info("========byDefault2========");
        logger.info("name: " + user.getName() + ", age: " + user.getAge());

        model.addAttribute("name", user.getName());
        model.addAttribute("age", user.getAge());

        return "paramPassResult";
    }

    @RequestMapping(value="/byRequestParam")
    public String byRequestParam(@RequestParam(value = "myName", required = true) String name, @RequestParam Integer age, Model model) {
        logger.info("========byRequestParam========");
        logger.info("name: " + name + ", age: " + age);

        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return "paramPassResult";
    }

    @RequestMapping(value="/byPathVariable/{myName}/{age}")
    public String byPathVariable(@PathVariable("myName") String name, Integer age, Model model) {
        logger.info("========byPathVariable========");
        logger.info("name: " + name + ", age: " + age);

        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return "paramPassResult";
    }

    @RequestMapping(value="/byHttpServletRequest")
    public String byHttpServletRequest(HttpServletRequest request, HttpServletResponse response, Model model) {

        String name = request.getParameter("name");
        String age = request.getParameter("age");

        logger.info("========byHttpServletRequest========");
        logger.info("name: " + name + ", age: " + age);

        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return "paramPassResult";
    }

    @RequestMapping(value="/byModelAttribute")
    public String byModelAttribute(@ModelAttribute("user") User user, Model model) {
        logger.info("========byModelAttribute========");
        logger.info("name: " + user.getName() + ", age: " + user.getAge());

        //@ModelAttribute会把User自动添加到视图的数据模型当中
        // 等同于: model.addAttribute("user", user);

        return "paramPassResult";
    }

    //如果注解在方法上，该方法会在此controller每个方法执行前被执行，
    //因此对于一个controller映射多个URL的用法来说，要谨慎使用
    @ModelAttribute("id")
    public Long populateModel(Model model) {
        //等同于: model.addAttribute("id", 666666L);
        return 666666L;
    }


    //@SessionAttributes(value={"sessionUser"})，必须注解在类上
    //如果发现model中有名为'sessionUser'参数，就会存入session
    @RequestMapping(value="/setSessionAttributes")
    public String bySessionAttributes(String name, Integer age, Model model) {
        logger.info("========setSessionAttributes========");
        logger.info("name: " + name + ", age: " + age);

        User user = new User();
        user.setName(name);
        user.setAge(age);

        model.addAttribute("sessionUser", user); //会将user放入session

        return "paramPassResult";
    }

    //@SessionAttribute用在方法上，获取session中的变量
    @RequestMapping(value="/getSessionAttributes")
    public String getSessionAttributes(@SessionAttribute("sessionUser") User user, Model model) {

        logger.info("========getSessionAttributes========");
        logger.info("name: " + user.getName() + ", age: " + user.getAge());

        model.addAttribute("user", user);

        return "paramPassResult";
    }


    @RequestMapping(value="/byCookieValue")
    public String byCookieValue(@CookieValue("JSESSIONID") String sessionId, Model model) {
        logger.info("========byCookieValue========");
        logger.info("sessionId: " + sessionId);

        return "paramPassResult";
    }

    @RequestMapping(value="/byRequestHeader")
    public String byRequestHeader(@RequestHeader(value = "Content-Type", defaultValue = "application/json") String contentType, Model model) {
        logger.info("========byRequestHeader========");
        logger.info("contentType: " + contentType);

        return "paramPassResult";
    }


}


