package demo.springbatch;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Springbatch2020829Application {
    @Autowired
    static ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(Springbatch2020829Application.class, args);
    }
}