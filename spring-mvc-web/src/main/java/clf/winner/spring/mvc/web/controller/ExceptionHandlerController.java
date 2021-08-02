package clf.winner.spring.mvc.web.controller;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/exceptionHandler")
public class ExceptionHandlerController {

    @RequestMapping(value="/init")
    public String init() {
        return "exceptionHandler";
    }

    @RequestMapping("/ArithmeticException")
    public String ArithmeticException() {
        System.out.println(10 / 0);
        return "success";
    }

    @RequestMapping("/NPE")
    public String NPE() {
        Long num = null;
        num.byteValue();
        return "success";
    }

    @RequestMapping("/IndexOutOfBoundsException")
    public String IndexOutOfBoundsException () {
        List<Integer> list = Lists.newArrayList();
        list.get(1);
        return "success";
    }

    @ExceptionHandler({ NullPointerException.class })
    public String NullPointerExceptionHandler(Exception e, Model model) {
        System.out.println("NullPointerException:" + e);
        // 跳转到指定页面
        model.addAttribute("msg", "空指针异常");
        return "error";
    }

}
