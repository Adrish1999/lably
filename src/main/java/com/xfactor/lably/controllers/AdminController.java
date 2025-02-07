package com.xfactor.lably.controllers;

import java.util.List;

import com.xfactor.lably.entity.Admin;
import com.xfactor.lably.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
public class AdminController
{

    @Autowired
    AdminRepository adminRepository;

    @PostMapping("/registerAdmin")
    public Admin registerAdmin(@RequestBody Admin admin) 
    {
        Admin persistedAdmin = adminRepository.save(admin);
        return persistedAdmin;
    }

    @GetMapping("/getAllAdmins")
    public List<Admin> getAllAdmins()
    {
        List<Admin> persistedAdmins = adminRepository.findAll();
        return persistedAdmins;
    }

    @GetMapping("/getAdminByUserName")
    public Admin getAdminByUserName(@RequestParam String username)
    {
        Admin persistedAdmin = adminRepository.findAdminByUsername(username);
        return persistedAdmin;
    }

    @GetMapping("/getAdminByDepartment")
    public List<Admin> getAdminByDepartment(@RequestParam String department)
    {
        List<Admin> persistedAdmins = adminRepository.retrieveAdminByDepartment(department);
        return persistedAdmins;
    }

}
