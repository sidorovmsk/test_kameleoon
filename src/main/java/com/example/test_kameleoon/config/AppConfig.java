package com.example.test_kameleoon.config;

import com.example.test_kameleoon.DataInitializer;
import com.example.test_kameleoon.services.QuoteService;
import com.example.test_kameleoon.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DataInitializer dataInitializer(QuoteService quoteService, UserService userService) {
        return new DataInitializer(quoteService, userService);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
