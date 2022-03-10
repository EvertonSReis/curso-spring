package com.evertonreis.domain;

import com.evertonreis.enums.RequestStage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "requestStage")
public class Stage implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(columnDefinition = "text")
    private String descricao;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datarealizacao;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestStage stage;

    @ManyToOne
    @JoinColumn(name = "id_request", nullable = false)
    private Request request;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

}
