package com.evertonreis.domain;

import com.evertonreis.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    
    private Long id;
    private String name;
    private String email;
    private String senha;
    private List<Request> request = new ArrayList<>();
    private List<RequestStage> stages = new ArrayList<>();
    private Role role;
}
