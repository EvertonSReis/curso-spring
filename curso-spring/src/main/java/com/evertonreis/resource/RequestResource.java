package com.evertonreis.resource;

import com.evertonreis.domain.Request;
import com.evertonreis.domain.Stage;
import com.evertonreis.services.RequestService;
import com.evertonreis.services.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "requests")
public class RequestResource {

    @Autowired
    private RequestService service;
    @Autowired
    private StageService stageService;

    @PostMapping
    public ResponseEntity<Request> save(@RequestBody Request request){
        Request createdRequest  = service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Request> update(@PathVariable(name = "id") Long id,@RequestBody Request request){
        request.setId(id);

        Request updateRequest = service.save(request);
        return ResponseEntity.ok(updateRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> getById(@PathVariable(name = "id") Long id){
        Request obj = service.getById(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<Request>> listByRequest(){
        List<Request> obj = service.listByRequest();
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/{id}/stages")
    public ResponseEntity<List<Stage>> listAllStageById(@PathVariable(name = "id") Long id){
        List<Stage> obj = stageService.listAllByStageId(id);
        return ResponseEntity.ok(obj);
    }
}
