package clf.winner.spring.mvc.web.converter;

import clf.winner.spring.mvc.web.model.FormatterSampleVO;
import org.springframework.format.Formatter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class CustomFormatter implements Formatter<FormatterSampleVO>, Serializable {

    private static final long serialVersionUID = 1L;

    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Override
    public String print(FormatterSampleVO vo, Locale locale) {
        return "print FormatterSampleVO";
    }

    //将定制化的字符串转换成FormatterSampleVO
    @Override
    public FormatterSampleVO parse(String text, Locale locale) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(FORMAT);

        String [] valueArr = text.split("~");

        FormatterSampleVO vo = new FormatterSampleVO();
        vo.setDateValue(format.parse(valueArr[0]));
        vo.setTimestampValue(new Timestamp(format.parse(valueArr[1]).getTime()));
        vo.setDoubleValue(Double.parseDouble(valueArr[2]));
        vo.setBigDecimalValue(new BigDecimal(valueArr[3]));

        return vo;
    }


}
