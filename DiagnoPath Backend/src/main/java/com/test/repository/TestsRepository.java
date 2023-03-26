package com.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.tests;

public interface TestsRepository extends JpaRepository<tests, Integer> {

    List<tests> findAll();
    
}
