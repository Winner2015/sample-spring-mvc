package clf.winner.spring.mvc.web.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenlongfei
 *  Jackson反序列化接口，将指定格式的字符串转换为Date
 */
public class CustomJacksonDateDeserializer extends JsonDeserializer<Date> {

    private static final String FORMAT = "yyyy~MM~dd HH~mm~ss";

    @Override
    public Date deserialize(JsonParser p, DeserializationContext cxt) throws IOException, JsonProcessingException {

        DateFormat df = new SimpleDateFormat(FORMAT);
        String raw = p.getText();
        try {
            return df.parse(raw);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
