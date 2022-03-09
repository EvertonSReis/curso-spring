package com.evertonreis.domain;

import com.evertonreis.enums.RequestStage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 75, nullable = false)
    private String subject;

    @Column(columnDefinition = "text")
    private String descição;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestStage stage;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "request")
    private List<Stage> stages = new ArrayList<>();
}
