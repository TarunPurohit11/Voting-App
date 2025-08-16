package com.app.votingPoll.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String question;

    @ElementCollection
    private List<OptionVote> options = new ArrayList<>();

}
