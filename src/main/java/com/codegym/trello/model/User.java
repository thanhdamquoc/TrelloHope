package com.codegym.trello.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 6, max = 15)
    private String username;

    @NotEmpty
    private String password;

    private String image;

    @NotEmpty
    private String nickname;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Roles> roles;
}
