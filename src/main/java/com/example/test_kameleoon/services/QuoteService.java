package com.example.test_kameleoon.services;

import com.example.test_kameleoon.models.Quote;
import com.example.test_kameleoon.repositories.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
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
        List<Quote> top10Quotes = quoteRepository.findTop10ByOrderByVoteDesc();
        top10Quotes.sort(Comparator.comparingInt(q -> q.getVote().getVoteCount()));
        return top10Quotes;
    }

    public List<Quote> getWorst10Quotes() {
        Pageable pageable = PageRequest.of(0, 10);
        List<Quote> worst10Quotes = quoteRepository.findWorst10Quotes(pageable);
        worst10Quotes.sort(Comparator.comparingInt(q -> q.getVote().getVoteCount()));
        return worst10Quotes;
    }

    public Quote getQuoteById(int quoteId) {
        return quoteRepository.findById(quoteId).orElse(null);
    }

    public void deleteQuote(int quoteId) {
        quoteRepository.deleteById(quoteId);
    }

}
