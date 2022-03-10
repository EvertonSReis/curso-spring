package com.evertonreis.repository;

import com.evertonreis.domain.Request;
import com.evertonreis.domain.Stage;
import com.evertonreis.enums.RequestStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    public List<Request> findAllByUserId(Long id);

    @Query("UPDATE request SET stage = ?2 WHERE id = ?1")
    public Request updateStatus(Long id, RequestStage stage);

}
