package com.crudoperation.crud.service;

import com.crudoperation.crud.Exception.ResourceNotFoundException;
import com.crudoperation.crud.JpaRepo.JpaRepo;
import com.crudoperation.crud.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    JpaRepo jpa;

    public Registration addData(Registration regi) {
        return this.jpa.save(regi);
    }

    public List<Registration> getAllRecords() {
        return this.jpa.findAll();
    }

    public Optional<Registration> getById(Integer id) {
        return this.jpa.findById(id);
    }

    public Registration updateRecord(Integer id, Registration regi) {
        Registration oldRecords = this.jpa.findById(id).orElseThrow(() -> new ResourceNotFoundException("user data not found"));
        oldRecords.setName(regi.getName());
        oldRecords.setDepartment(regi.getDepartment());
        oldRecords.setAddress(regi.getAddress());
        return this.jpa.save(oldRecords);
    }

    public String deleteRecords(Integer del){
        this.jpa.deleteById(del);
        return "successfully deleted";
    }

}