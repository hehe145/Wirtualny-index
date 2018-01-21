package com.app.model;

import com.app.validation.IllegalNumber;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;

    @PESEL
    private String pesel;

    @NotEmpty
    private String password;

    @Transient
    private String passwordConfirm;

    @NotNull
    @Past
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @NotEmpty
    private String email;

    @NotEmpty
    private String ulica;

    @NotEmpty
    private String nrDomu;

    @NotEmpty
    private String miejscowosc;

    private String photoName;

    private String maturaPhoto;

    @IllegalNumber
    @Pattern(regexp = "^(0|[1-9][0-9]*)$")
    @NotEmpty
    @Column(name = "phone_number")
    private String phoneNumber;

    @Valid
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles"
            , joinColumns = @JoinColumn(name = "user_id")
            , inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_directions"
            , joinColumns = @JoinColumn(name = "user_id")
            , inverseJoinColumns = @JoinColumn(name = "direction_id"))
    private List<Direction> directions;


}
