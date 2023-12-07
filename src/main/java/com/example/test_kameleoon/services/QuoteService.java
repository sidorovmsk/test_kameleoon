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
        // Логика создания цитаты
        return quoteRepository.save(quote);
    }

    public List<Quote> getTop10Quotes() {
        // Логика получения лучших 10 цитат
        // (например, использование метода в репозитории, который возвращает топ-цитаты)
        return null;
    }

    public List<Quote> getWorst10Quotes() {
        // Логика получения худших 10 цитат
        // (аналогично использование метода в репозитории)
        return null;
    }

    public Quote getQuoteById(int quoteId) {
        // Логика получения цитаты по ID
        return quoteRepository.findById(quoteId).orElse(null);
    }

    public void deleteQuote(int quoteId) {
        // Логика удаления цитаты
        quoteRepository.deleteById(quoteId);
    }

}

