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
public class Request {

    private Long id;
    private String produto;
    private String descição;
    private Date dataCriacao;
    private RequestStage stage;
    private Usuario usuario;
    private List<RequestStage> stages = new ArrayList<>();
}
