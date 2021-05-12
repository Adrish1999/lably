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
public class AdminController
{

    ArrayList<Admin> admins = new ArrayList<Admin>();

    @PostMapping("/registerAdmin")
    public Admin registerAdmin(@RequestBody Admin admin) 
    {
        admins.add(admin);
        return admin;
    }

    @GetMapping("/getAllAdmins")
    public ArrayList<Admin> getAllAdmins()
    {
        return admins;
    }

    @GetMapping("/getAdminByUserName")
    public Admin getAdminByUserName(@RequestParam String username)
    {
        Admin adminList = null;
        for (Admin admin : admins)
        {
            if (admin.getUsername().equals(username))
            {
                adminList = admin;
            }
        }
        return adminList;
    }

}