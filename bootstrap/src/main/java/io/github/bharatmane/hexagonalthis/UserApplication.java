package io.github.bharatmane.hexagonalthis;

import io.github.bharatmane.hexagonalthis.domainapi.model.port.RequestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "io.github.bharatmane.hexagonalthis")
public class UserApplication  implements CommandLineRunner {


    @Autowired
    private RequestUser requestUser;

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);

    }

    @Override
    public void run(String... args) {
        System.out.println(requestUser.getAllUsers().get(0).getFirstName());
    }
}
