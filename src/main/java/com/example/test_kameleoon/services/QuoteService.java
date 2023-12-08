package com.example.test_kameleoon.services;

import com.example.test_kameleoon.dto.QuoteDTO;
import com.example.test_kameleoon.exceptions.ResourceNotFoundException;
import com.example.test_kameleoon.models.Quote;
import com.example.test_kameleoon.repositories.QuoteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class QuoteService {
    private final QuoteRepository quoteRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public QuoteService(QuoteRepository quoteRepository, ModelMapper modelMapper) {
        this.quoteRepository = quoteRepository;
        this.modelMapper = modelMapper;
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

    public Quote getRandomQuote() {
        Pageable pageable = PageRequest.of(0, 1);
        return quoteRepository.findRandomQuote(pageable).get(0);
    }

    public Quote updateQuote(int quoteId, QuoteDTO quoteDTO) {
        Quote existingQuote = quoteRepository.findById(quoteId)
                .orElseThrow(() -> new ResourceNotFoundException("Quote not found with id: " + quoteId));

        modelMapper.map(quoteDTO, existingQuote);
        existingQuote.setCreateOrUpdateDate(new Date());
        return quoteRepository.save(existingQuote);
    }

    public ResponseEntity<String> upvoteQuote(int quoteId) {
        try {
            Quote existingQuote = quoteRepository.findById(quoteId)
                    .orElseThrow(() -> new ResourceNotFoundException("Quote not found with id: " + quoteId));
            existingQuote.getVote().setVoteCount(existingQuote.getVote().getVoteCount() + 1);
            quoteRepository.save(existingQuote);
            return ResponseEntity.ok("Upvoted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error upvoting quote");
        }
    }

    public ResponseEntity<String> downvoteQuote(int quoteId) {
        try {
            Quote existingQuote = quoteRepository.findById(quoteId)
                    .orElseThrow(() -> new ResourceNotFoundException("Quote not found with id: " + quoteId));
            existingQuote.getVote().setVoteCount(existingQuote.getVote().getVoteCount() - 1);
            quoteRepository.save(existingQuote);
            return ResponseEntity.ok("Downvoted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error downvoting quote");
        }
    }
}
