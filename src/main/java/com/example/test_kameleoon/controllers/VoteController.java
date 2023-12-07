package com.example.test_kameleoon.controllers;

import com.example.test_kameleoon.models.Vote;
import com.example.test_kameleoon.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/votes")
public class VoteController {
    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping("/{quoteId}")
    public ResponseEntity<Vote> voteForQuote(@PathVariable Long quoteId, @RequestParam boolean upvote) {
        Vote vote = voteService.voteForQuote(quoteId, upvote);
        return new ResponseEntity<>(vote, HttpStatus.OK);
    }

    // Другие методы контроллера
}
