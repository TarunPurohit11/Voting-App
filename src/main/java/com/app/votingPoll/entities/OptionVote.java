package com.app.votingPoll.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
public class OptionVote {
    private String optionText;
    private int voteCount = 0;
}
