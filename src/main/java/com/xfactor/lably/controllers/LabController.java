package com.xfactor.lably.controllers;

import java.util.ArrayList;

import javax.websocket.server.PathParam;

import com.xfactor.lably.entity.Lab;

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
@RequestMapping("/lab")
public class LabController
{

    ArrayList<Lab> labs = new ArrayList<Lab>();

    @PostMapping("/registerLab")
    public Lab registerLab(@RequestBody Lab lab)
    {
        labs.add(lab);
        return lab;
    }

    @GetMapping("/getAllLabs")
    public ArrayList<Lab> getAllLabs()
    {
        return labs;
    }

    @GetMapping("/getLabByName")
    public Lab getLabByName(@RequestParam String name)
    {
        Lab labList = null;
        for (Lab lab : labs)
        {
            if (lab.getName().equals(name))
            {
                labList = lab;
            }
        }
        return labList;
    }

}
