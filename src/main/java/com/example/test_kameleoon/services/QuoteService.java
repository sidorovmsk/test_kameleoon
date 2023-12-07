package com.example.test_kameleoon.services;

import com.example.test_kameleoon.models.Quote;
import com.example.test_kameleoon.repositories.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {
    private final QuoteRepository quoteRepository;

    @Autowired
    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public Quote createQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    public List<Quote> getTop10Quotes() {
        return quoteRepository.findTop10ByOrderByVotesDesc();
    }

    public List<Quote> getWorst10Quotes() {
        return quoteRepository.findWorst10ByOrderByVotesAsc();
    }

    public Quote getQuoteById(int quoteId) {
        return quoteRepository.findById(quoteId).orElse(null);
    }

    public void deleteQuote(int quoteId) {
        quoteRepository.deleteById(quoteId);
    }

}

