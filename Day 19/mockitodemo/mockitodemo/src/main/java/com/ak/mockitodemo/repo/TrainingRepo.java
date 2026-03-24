package com.ak.mockitodemo.repo;

import com.ak.mockitodemo.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //converts sql exception to runtimeexception
public interface TrainingRepo extends JpaRepository<Training, Integer> {

}
