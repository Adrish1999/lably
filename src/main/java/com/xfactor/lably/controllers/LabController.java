package com.xfactor.lably.controllers;

import java.util.List;

import com.xfactor.lably.entity.Lab;
import com.xfactor.lably.repository.LabRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/lab")
public class LabController
{
    @Autowired
    LabRepository labRepository;

    @PostMapping("/registerLab")
    public Lab registerLab(@RequestBody Lab lab)
    {
        Lab persistedLab = labRepository.save(lab);
        return persistedLab;
    }

    @GetMapping("/getAllLabs")
    public List<Lab> getAllLabs()
    {
        List<Lab> persistedLabs = labRepository.findAll();
        return persistedLabs;
    }

    @GetMapping("/getLabByName")
    public Lab getLabByName(@RequestParam String name)
    {
        List<Lab> persistedLabs = labRepository.findAll();
        Lab labList = null;
        for (Lab lab : persistedLabs)
        {
            if (lab.getName().equals(name))
            {
                labList = lab;
            }
        }
        return labList;
    }

}
