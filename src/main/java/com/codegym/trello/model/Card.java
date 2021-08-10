package com.codegym.trello.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card implements Comparable<Card>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;
    private String content;
    private int position;
    @ManyToMany
    private List<User> users;
    @ManyToMany
    private List<Tag> tags;

    @Override
    public int compareTo(Card o) {
        if (position == o.position)
            return 0;
        else if (position > o.position)
            return 1;
        else
            return -1;
    }
}
