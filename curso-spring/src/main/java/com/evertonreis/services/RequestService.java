package com.evertonreis.services;

import com.evertonreis.domain.Request;
import com.evertonreis.enums.RequestStage;
import com.evertonreis.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    private RequestRepository repository;

    public Request save(Request request){
        request.setStage(RequestStage.ABERTO);
        request.setDataCriacao(new Date());


        Request createdRequest = repository.save(request);
        return createdRequest;
    }

    public Request update(Request request){
        Request updateRequeste = repository.save(request);
        return updateRequeste;
    }

    public Request getById(Long id){
        Optional<Request> obj = repository.findById(id);
        return obj.get();
    }

    public List<Request> listByRequest(){
        List<Request> requests = repository.findAll();
        return requests;
    }

    public List<Request> listAllByUsuarioId(Long usuarioId){
        List<Request> requests = repository.findAllByUsuarioId(usuarioId);
        return requests;
    }

}
