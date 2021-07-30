package clf.winner.spring.mvc.web.converter;

import clf.winner.spring.mvc.web.model.ConvertorSampleVO;
import org.springframework.core.convert.converter.Converter;

public class CustomConverter implements Converter<String, ConvertorSampleVO> {

    //将定制化的字符串"123456~陈龙飞"转换成ConvertorSampleVO
    @Override
    public ConvertorSampleVO convert(String source) {
        String [] valueArr = source.split("~");
        ConvertorSampleVO sample = new ConvertorSampleVO();
        sample.setId(Long.parseLong(valueArr[0]));
        sample.setName(valueArr[1]);
        return sample;
    }

}
