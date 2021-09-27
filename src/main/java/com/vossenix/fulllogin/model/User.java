package com.vossenix.fulllogin.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Email(message = "Invalid e-mail")
    @NotEmpty(message = "E-mail cannot empty")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    @Transient
    private String password;

    @NotEmpty(message = "Firstname should not be empty")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Lastname should not be empty")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "enabled")
    private boolean enabled;

    //for every user register, confirmation token will be generated to that user
    //will be part of the link sent to the user email
    @Column(name = "confirmation_token")
    private String confirmationToken;
}
