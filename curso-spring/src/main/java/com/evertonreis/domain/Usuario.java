package com.evertonreis.domain;

import com.evertonreis.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 75)
    private String nome;
    @Column(length = 75)
    private String email;
    @Column(length = 100)
    private String senha;
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user")
    private List<Request> request = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Stage> stages = new ArrayList<>();
}
