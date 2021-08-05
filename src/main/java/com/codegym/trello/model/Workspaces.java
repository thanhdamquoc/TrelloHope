package com.codegym.trello.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Workspaces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String type;

    @ManyToOne
    private User owner;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> members;

    @OneToMany
    private Set<Board> boards;

}
