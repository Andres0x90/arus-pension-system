package co.com.arus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
public class ApplicationMain {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(ApplicationMain.class, args);
    }
}
