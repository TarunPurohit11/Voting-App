package com.app.votingPoll.controllers;

import com.app.votingPoll.entities.Poll;
import com.app.votingPoll.request.Vote;
import com.app.votingPoll.services.PollServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
@CrossOrigin("http://localhost:4200/")
public class PollController {


    @Autowired
    private PollServiceImpl pollService;


    @PostMapping
    public Poll createPoll(@RequestBody Poll poll){
        return pollService.createPoll(poll);
    }

    @GetMapping
    public List<Poll> getAllPolls(){
        return pollService.getPolls();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getById(@PathVariable int id){
        return pollService.getPollById(id)
                .map(ResponseEntity::ok).
                orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/vote")
    public void vote(@RequestBody Vote vote){
        pollService.vote(vote.getPollId(),vote.getOptionIndex());
    }
}
