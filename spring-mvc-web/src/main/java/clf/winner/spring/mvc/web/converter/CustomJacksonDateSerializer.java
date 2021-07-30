package clf.winner.spring.mvc.web.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenlongfei
 * Jackson序列化接口，将Date转换成指定格式的数据
 */
public class CustomJacksonDateSerializer extends JsonSerializer<Date> {

    private static final String FORMAT = "yyyy~MM~dd HH~mm~ss";

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers)
            throws IOException, JsonProcessingException {
        DateFormat df = new SimpleDateFormat(FORMAT);
        gen.writeString(df.format(value));
    }

}