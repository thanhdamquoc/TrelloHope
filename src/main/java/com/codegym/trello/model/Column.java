
package com.codegym.trello.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "columns")
public class Column implements Comparable<Column> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @OneToMany
    private List<Card> cards;
    private Long position;

    @Override
    public int compareTo(Column o) {
        if (position == o.position)
            return 0;
        else if (position > o.position)
            return 1;
        else
            return -1;
    }
}
