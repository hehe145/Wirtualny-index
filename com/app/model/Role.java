package com.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "roles")
@Setter
@Getter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(value = EnumType.STRING)
    private Types types;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(Types types) {
        this.types = types;
    }

    public enum Types {
        ROLE_USER,
        ROLE_ADMIN,
        ROLE_DZIEKANAT,
        ROLE_DZIEKAN
    }
}
