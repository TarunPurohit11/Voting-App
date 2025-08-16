package com.app.votingPoll.services;

import com.app.votingPoll.entities.Poll;

import java.util.List;
import java.util.Optional;

public interface PollService {

    public Poll createPoll(Poll poll);
    public List<Poll> getPolls();
    public Optional<Poll> getPollById(int id);
    public void vote(int pollId,int optionIndex);
}
