package com.codegym.trello.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag implements Comparable<Tag> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String color;

    @Override
    public int compareTo(Tag o) {
        if (id == o.id)
            return 0;
        else if (id > o.id)
            return 1;
        else
            return -1;
    }
}
