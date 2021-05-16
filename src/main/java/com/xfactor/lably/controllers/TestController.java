package com.xfactor.lably.controllers;

import java.util.List;

import com.xfactor.lably.entity.Test;
import com.xfactor.lably.repository.TestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController
{

    @Autowired
    TestRepository testRepository;

    @PostMapping("/registerTest")
    public Test registerTest(@RequestBody Test test)
    {
        Test persistedTest = testRepository.save(test);
        return persistedTest;
    }

    @GetMapping("/getAllTests")
    public List<Test> getAllTests()
    {
        List<Test> persistedTests = testRepository.findAll();
        return persistedTests;
    }

    @GetMapping("/getTestByName")
    public Test getTestByName(@RequestParam String name)
    {
        List<Test> persistedTests = testRepository.findAll();
        Test testList = null;
        for (Test test : persistedTests)
        {
            if (test.getName().equals(name))
            {
                testList = test;
            }
        }
        return testList;
    }

}
