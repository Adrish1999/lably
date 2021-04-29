package com.xfactor.lably.controllers;

import java.util.ArrayList;

import javax.websocket.server.PathParam;

import com.xfactor.lably.entity.Admin;

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
@RequestMapping("/admin")
public class AdminController {

    ArrayList<Admin> admins = new ArrayList<Admin>();

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin) 
    {
        admins.add(admin);
        return admin;
    }

    @GetMapping("/getAdmins")
    public ArrayList<Admin> getAdmins()
    {
        return admins;
    }

    @GetMapping("/searchAdmin")
    public Admin searchAdmin(@RequestParam String username)
    {
        boolean flag = false;
        Admin adminList = null;

        for(Admin a : admins)
        {
            if(a.getUsername().equals(username))
            {
                flag = true;
                adminList = a;
            }
        }

        if(flag == true)
        {
            return adminList;
        }
        else
        {
            return null;
        }
    }

    // // http://localhost:8080/test/hello/xfactor
    // @GetMapping("/hello/{name}")
    // @ResponseBody
    // public String index_greetings(@PathVariable String name) {
    // return "Greetings :" + name;
    // }

    // // http://localhost:8080/test/hello2?id=16
    // @GetMapping("/hello2")
    // @ResponseBody
    // public String getFoos(@RequestParam String id) {
    // return "ID: " + id;
    // }

    // @PostMapping("/employees")
    // Employee newEmployee(@RequestBody Employee newEmployee) {
    // return repository.save(newEmployee);
    // }

}
