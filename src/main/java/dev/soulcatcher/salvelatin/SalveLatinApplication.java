package dev.soulcatcher.salvelatin;

import dev.soulcatcher.salvelatin.models.Declension;
import dev.soulcatcher.salvelatin.models.Noun;
import dev.soulcatcher.salvelatin.repos.NounRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class SalveLatinApplication {

    public static void main(String[] args) {

        SpringApplication.run(SalveLatinApplication.class, args);
    }

}
