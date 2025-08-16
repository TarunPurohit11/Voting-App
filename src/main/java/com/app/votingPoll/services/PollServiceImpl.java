package com.app.votingPoll.services;

import com.app.votingPoll.entities.OptionVote;
import com.app.votingPoll.entities.Poll;
import com.app.votingPoll.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollServiceImpl implements PollService{

    @Autowired
    private PollRepository pollRepository;

    @Override
    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    @Override
    public List<Poll> getPolls() {
        return pollRepository.findAll();
    }

    @Override
    public Optional<Poll> getPollById(int id){
        return pollRepository.findById(id);
    }

    @Override
    public void vote(int pollId, int optionIndex) {

        Poll poll = pollRepository.findById(pollId)
                            .orElseThrow(() -> new RuntimeException("Poll not found"));

            //Get all the options
            List<OptionVote> optionVotes = poll.getOptions();

            //Check the index availability
            if(optionIndex < 0 || optionIndex >= optionVotes.size()){
                throw  new IllegalArgumentException("Invalid Option index");
            }

            //Select the option and increase the voteCount
            OptionVote selected = optionVotes.get(optionIndex);
            selected.setVoteCount(selected.getVoteCount()+1);

            pollRepository.save(poll);
    }
}
