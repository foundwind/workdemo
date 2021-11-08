package demo.springbatch.config;

import demo.springbatch.dto.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor
        implements ItemProcessor<Person, String> {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(PersonItemProcessor.class);

    //打印日志信息
    @Override
    public String process(Person person) throws Exception {
        String greeting = "Hello " + person.getFirstName() + " "
                + person.getLastName() + "!";

        LOGGER.info("converting '{}' into '{}'", person, greeting);
        return greeting;
    }


}
