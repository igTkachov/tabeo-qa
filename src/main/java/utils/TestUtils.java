package utils;

import com.github.javafaker.Faker;
import config.SpringContextAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestUtils implements SpringContextAware {

    @Autowired
    private Faker faker;

    public String generateEmail() { return faker.internet().emailAddress();}

    public String generatePassword() { return faker.internet().password(); }

    public String generateCvv() { return String.valueOf(faker.number().numberBetween(100, 999)); }

    public String generateExpirationDate() {
        var month = String.valueOf(faker.number().numberBetween(1, 12));
        var year =  String.valueOf(faker.number().numberBetween(22, 26));
        return month.concat(year);
    }
}
