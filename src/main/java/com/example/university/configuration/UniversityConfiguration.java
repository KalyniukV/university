package com.example.university.configuration;

import com.example.university.util.CommandAsker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UniversityConfiguration {

    @Bean
    public CommandAsker commandAsker() {
        return new CommandAsker(System.in, System.out);
    }

}
