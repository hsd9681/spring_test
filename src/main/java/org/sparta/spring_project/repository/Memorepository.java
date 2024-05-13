package org.sparta.spring_project.repository;

import org.sparta.spring_project.entitiy.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Memorepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByOrderByModifiedAtDesc();
}
