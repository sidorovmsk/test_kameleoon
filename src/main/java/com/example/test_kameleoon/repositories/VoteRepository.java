package com.example.test_kameleoon.repositories;

import com.example.test_kameleoon.models.Quote;
import com.example.test_kameleoon.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {
}
