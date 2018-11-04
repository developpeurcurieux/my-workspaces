package com.easysoft.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@NoArgsConstructor
@Data
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    @Column(name = "user_name")
    private String username;
    private String password;
    private boolean actived;

    @OneToMany
    private Collection<Role> roles;

    public User(String username, String password, boolean actived) {
        this.username = username;
        this.password = password;
        this.actived = actived;
    }
}
