package com.example.test_kameleoon;

import com.example.test_kameleoon.models.Quote;
import com.example.test_kameleoon.models.User;
import com.example.test_kameleoon.models.Vote;
import com.example.test_kameleoon.services.QuoteService;
import com.example.test_kameleoon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Component
public class DataInitializer implements CommandLineRunner {

    private final QuoteService quoteService;
    private final UserService userService;

    @Autowired
    public DataInitializer(QuoteService quoteService, UserService userService) {
        this.quoteService = quoteService;
        this.userService = userService;
    }

    @Override
    @Transactional
    public void run(String... args) {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password");
        user.setDateOfCreation(new Date());
        userService.createUser(user);

        Quote quote1 = new Quote();
        quote1.setContent("To be or not to be, that is the question.");
        quote1.setDateOfCreation(new Date());
        quote1.setUser(user);
        Vote vote1 = new Vote();
        vote1.setVoteCount(0);
        quote1.setVote(vote1);
        quoteService.createQuote(quote1);

        Quote quote2 = new Quote();
        quote2.setContent("The only limit to our realization of tomorrow will be our doubts of today.");
        quote2.setDateOfCreation(new Date());
        quote2.setUser(user);
        Vote vote2 = new Vote();
        vote2.setVoteCount(5);
        quote2.setVote(vote2);
        quoteService.createQuote(quote2);

        for (int i = 0; i < 100; i++) {
            Quote loopQuote = new Quote();
            loopQuote.setContent("Created in loop " + i);
            loopQuote.setDateOfCreation(new Date());
            loopQuote.setUser(user);
            Vote loopVote = new Vote();
            loopVote.setVoteCount((int) (Math.random() * 1000));
            loopQuote.setVote(loopVote);
            quoteService.createQuote(loopQuote);
        }

    }
}

