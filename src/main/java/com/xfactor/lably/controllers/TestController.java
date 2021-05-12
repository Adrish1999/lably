package com.xfactor.lably.controllers;

import java.util.ArrayList;

import javax.websocket.server.PathParam;

import com.xfactor.lably.entity.Test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;

@RestController
@RequestMapping("/test")
public class TestController
{

    ArrayList<Test> tests = new ArrayList<Test>();

    @PostMapping("/registerTest")
    public Test registerTest(@RequestBody Test test)
    {
        tests.add(test);
        return test;
    }

    @GetMapping("/getAllTests")
    public ArrayList<Test> getAllTests()
    {
        return tests;
    }

    @GetMapping("/getTestByName")
    public Test getTestByName(@RequestParam String name)
    {
        Test testList = null;
        for (Test test : tests)
        {
            if (test.getName().equals(name))
            {
                testList = test;
            }
        }
        return testList;
    }

}
