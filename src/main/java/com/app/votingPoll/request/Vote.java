package com.app.votingPoll.request;

import lombok.Data;

@Data
public class Vote {
    private int pollId;
    private int optionIndex;
}
