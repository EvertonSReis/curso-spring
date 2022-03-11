package com.evertonreis.services;

import com.evertonreis.domain.Request;
import com.evertonreis.domain.Stage;
import com.evertonreis.enums.RequestStage;
import com.evertonreis.repository.RequestRepository;
import com.evertonreis.repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StageService {

    @Autowired
    private StageRepository repository;

    @Autowired
    private RequestRepository requestRepository;

    public Stage save(Stage stage){
        stage.setDatarealizacao(new Date());

        Stage createdStage = repository.save(stage);

        Long requestId = stage.getRequest().getId();
        RequestStage status = stage.getStage();
        requestRepository.updateStatus(requestId,status);

        return createdStage;
    }

    public Stage getById(Long id){
        Optional<Stage> obj  = repository.findById();
        return obj.get();
    }

    public List<Stage> listAllByStageId(Long requestid){
        List<Stage> stage = repository.findAllByRequestId(requestid);
        return stage;
    }
}
