package com.example.test_kameleoon.controllers;

import com.example.test_kameleoon.models.Quote;
import com.example.test_kameleoon.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quotes")
public class QuoteController {
    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PostMapping
    public ResponseEntity<Quote> createQuote(@RequestBody Quote quote) {
        Quote createdQuote = quoteService.createQuote(quote);
        return new ResponseEntity<>(createdQuote, HttpStatus.CREATED);
    }

    @GetMapping("/top10")
    public ResponseEntity<List<Quote>> getTop10Quotes() {
        List<Quote> topQuotes = quoteService.getTop10Quotes();
        return new ResponseEntity<>(topQuotes, HttpStatus.OK);
    }

    @GetMapping("/worst10")
    public ResponseEntity<List<Quote>> getWorst10Quotes() {
        List<Quote> topQuotes = quoteService.getWorst10Quotes();
        return new ResponseEntity<>(topQuotes, HttpStatus.OK);
    }

    @GetMapping("/{quoteId}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable int quoteId) {
        Quote quote = quoteService.getQuoteById(quoteId);
        return quote != null ? new ResponseEntity<>(quote, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{quoteId}")
    public ResponseEntity<Void> deleteQuote(@PathVariable int quoteId) {
        quoteService.deleteQuote(quoteId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

