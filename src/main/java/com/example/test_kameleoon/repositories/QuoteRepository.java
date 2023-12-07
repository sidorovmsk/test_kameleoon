package com.example.test_kameleoon.repositories;

import com.example.test_kameleoon.models.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {
    List<Quote> findTop10ByOrderByVotesDesc();
    List<Quote> findWorst10ByOrderByVotesAsc();
}
