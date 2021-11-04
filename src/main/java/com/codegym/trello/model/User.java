package com.codegym.trello.model;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.persistence.Column;
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
    @Size(min = 4, max = 15)
    @Column(unique = true)
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    @Column(unique = true)
    private String email;

    private String image;

    @NotEmpty
    private String nickname;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Roles> roles;
}
