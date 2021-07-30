package clf.winner.spring.mvc.web.controller;

import clf.winner.spring.mvc.web.model.ConvertorSampleVO;
import clf.winner.spring.mvc.web.model.FormatterSampleVO;
import clf.winner.spring.mvc.web.model.JacksonSampleVO;
import clf.winner.spring.mvc.web.model.MessageVO;
import com.alibaba.fastjson.JSON;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/convert")
public class ConvertController {

    @RequestMapping(value="/init")
    public String init() {
        return "convert";
    }

    //使用Spring自带的转换器将String转换Date
    @ResponseBody
    @RequestMapping("/bySpringDateTimeFormat")
    public String convertBySpring(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date dataStr) {
        System.out.println(dataStr.getTime());

        return "OK";
    }

    //使用自定义的Formatter将String转换成FormatterSampleVO
    @ResponseBody
    @RequestMapping("/byCustomFormatter")
    public String convertByCustomFormatter(@RequestParam(name="sample") FormatterSampleVO sample) {
        System.out.println(JSON.toJSONString(sample, true));

        return "OK";
    }

    //使用自定义的Convertor将String转换成ConvertorSampleVO
    @ResponseBody
    @RequestMapping("/byCustomConvertor")
    public String convertByCustomConvertor(@RequestParam(name="sample") ConvertorSampleVO sample) {
        System.out.println(JSON.toJSONString(sample, true));

        return "OK";
    }


    //JacksonConvertor本质上是一个HttpMessageConverter，是从request的body体中获取json数据
    @ResponseBody
    @RequestMapping("/byJacksonConvertor")
    public JacksonSampleVO convertByJacksonConvertor(@RequestBody JacksonSampleVO sample) {
        //{"name":"陈龙飞","age":30,"specialDay":"2021~01~03 11~00~00","birthDay":"1989-01-03 11:00:00","money":"88888888.666666"}
        System.out.println(JSON.toJSON(sample));

        return sample;
    }

    @ResponseBody
    @RequestMapping(value = "/byCustomHttpMessageConverter", consumes = { "application/clf" })
    public MessageVO sendMessage(@RequestBody MessageVO message) {
        System.out.println(JSON.toJSONString(message));

        MessageVO response = new MessageVO();
        response.setFrom("沙悟净");
        response.setTo("二师兄");
        response.setContent("师傅被妖怪抓走了！");

        return response;
    }

}
