package clf.winner.spring.mvc.web.exception.handler;


import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ArithmeticExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        Map<String, Object> model = new HashMap<String, Object>();


        if (ex instanceof ArithmeticException) {
            model.put("msg", "除数为零");
            ModelAndView mv = new ModelAndView("ArithmeticException", model);
            return mv;
        }

        return null;
    }

}
