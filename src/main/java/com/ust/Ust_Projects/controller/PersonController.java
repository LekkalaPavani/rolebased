package com.ust.Ust_Projects.controller;

import com.ust.Ust_Projects.common.PersonConstant;
import com.ust.Ust_Projects.model.Person;
import com.ust.Ust_Projects.repository.Personrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private Personrepository repo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registerPerson(@RequestBody Person person) {
        //person.setRoles(PersonConstant.DEFAULT_ROLE);
        String encodedPassword = passwordEncoder.encode(person.getPassword());
        person.setPassword(encodedPassword);
        repo.save(person);
        return "hi "+ person.getUsername() + " registration successful";
    }

    @GetMapping("/getallperson")
    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Person> getAllPerson(){
        return repo.findAll();
    }
}
