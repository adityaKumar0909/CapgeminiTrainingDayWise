package com.galgotias.Repository;

import com.galgotias.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

    @Query("select t from Training t where t.endDate >= :today")
    List<Training> getOngoingAndUpcomingTrainings(LocalDate today);

    @Query("select t from Training t where t.endDate >= :today and lower(t.topic) like lower(concat('%', :name, '%'))")
    List<Training> getOngoingAndUpcomingTrainingsByName(LocalDate today, String name);

    @Query("select t from Training t where t.startDate > :today and lower(t.topic) like lower(concat('%', :name, '%'))")
    List<Training> getUpcomingTrainingsByName(LocalDate today, String name);
}