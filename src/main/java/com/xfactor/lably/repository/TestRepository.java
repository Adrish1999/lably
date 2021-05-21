package com.xfactor.lably.repository;

import java.util.List;

import com.xfactor.lably.entity.Test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TestRepository extends JpaRepository<Test, Long>
{
    Test findTestByName(String name);

    @Query("SELECT AVG(test.price) FROM Test test")
    Double getAverageTestPrice();

    @Query("SELECT test FROM Test test WHERE test.price <= :budget")
    List<Test> retrieveTestByBudget(double budget);
}
