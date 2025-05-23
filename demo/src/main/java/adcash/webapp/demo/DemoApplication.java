package adcash.webapp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        // Colors colors = new Colors();
        SpringApplication.run(DemoApplication.class, args);
        // System.out.println(colors.GREEN + "Server started on : " + colors.CYAN + "http://localhost:8080/");
    }

}
