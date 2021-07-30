package clf.winner.spring.mvc.web.config;

import clf.winner.spring.mvc.web.converter.CustomConverter;
import clf.winner.spring.mvc.web.converter.CustomFormatter;
import clf.winner.spring.mvc.web.converter.CustomHttpMessageConverter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.List;

//@EnableWebMvc
//@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        CustomHttpMessageConverter customHttpMessageConverter = new CustomHttpMessageConverter();
        converters.add(customHttpMessageConverter);

        //重置默认converter的属性
        for (HttpMessageConverter<?> converter : converters) {
            if (converter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter) converter).setDefaultCharset(Charset.forName("UTF-8"));
            }
            if (converter instanceof MappingJackson2HttpMessageConverter) {
                ((MappingJackson2HttpMessageConverter) converter).getObjectMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            }
        }
    }


    @Override
    public void addFormatters(FormatterRegistry registry) {

        //Formatter与Convertor都是转换接口，都会被适配成GenericConverter，加入到GenericConversionService.converters中

        registry.addFormatter(new CustomFormatter());  //Formatter实现了Printer、Parser接口，会被适配成两个GenericConverter：String——》FormatterSampleVO，FormatterSampleVO——》String

        registry.addConverter(new CustomConverter());  //Convertor会被适配成一个GenericConverter: String——》ConvertorSampleVO
    }

}
