package dev.jihun.sqs_practice;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SqsPracticeApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SqsPracticeApplication.class, args);
    }

    @Override
    public void run(final ApplicationArguments args) throws Exception {

    }
}
