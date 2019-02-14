package com.example.nonweb;

import com.example.nonweb.service.HelloMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.exit;

@SpringBootApplication
public class NonwebApplication  implements CommandLineRunner {

    @Autowired
    private HelloMessageService helloService;

    public static void main(String[] args) throws Exception{

        //disabled banner, don't want to see the spring logo
        SpringApplication app = new SpringApplication(NonwebApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0) {
            System.out.println(helloService.getMessage(args[0].toString()));
        } else {
            System.out.println(helloService.getMessage());
        }

        //exit(0);

    }
}

