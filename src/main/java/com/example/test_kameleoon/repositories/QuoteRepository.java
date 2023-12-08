package com.example.test_kameleoon.repositories;

import com.example.test_kameleoon.models.Quote;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {
    List<Quote> findTop10ByOrderByVoteDesc();

    @Query(value = "SELECT q FROM Quote q ORDER BY q.vote.voteCount ASC NULLS LAST")
    List<Quote> findWorst10Quotes(Pageable pageable);

    @Query(value = "SELECT q FROM Quote q ORDER BY FUNCTION('RAND')")
    List<Quote> findRandomQuote(Pageable pageable);
}
