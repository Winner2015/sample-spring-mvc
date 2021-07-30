package clf.winner.spring.mvc.web.model;

import clf.winner.spring.mvc.web.converter.CustomJacksonDateDeserializer;
import clf.winner.spring.mvc.web.converter.CustomJacksonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.util.Date;

public class JacksonSampleVO {

    //可以定制日期格式
    @JsonSerialize(using = CustomJacksonDateSerializer.class)
    @JsonDeserialize(using = CustomJacksonDateDeserializer.class)
    private Date specialDay;

    private Date birthDay;

    private BigDecimal money;

    private String name;

    private int age;

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getSpecialDay() {
        return specialDay;
    }

    public void setSpecialDay(Date specialDay) {
        this.specialDay = specialDay;
    }
}
