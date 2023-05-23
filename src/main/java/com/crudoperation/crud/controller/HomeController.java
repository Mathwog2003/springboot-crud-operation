package com.crudoperation.crud.controller;

import com.crudoperation.crud.model.Registration;
import com.crudoperation.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    StudentService stu;
    @PostMapping("/registration")
    public Registration addValues(@RequestBody Registration regi){

        return this.stu.addData(regi) ;
    }

    @GetMapping("/getrecords")
    public List<Registration> getRecords(){
        return this.stu.getAllRecords();
    }

    @GetMapping("/getbyid/{id}")
    public Optional<Registration> getRecord(@PathVariable (value = "id") Integer sigledata){
        return this.stu.getById(sigledata);
    }

    @PutMapping("/updateRecords/{id}")
    public Registration updateRec(@PathVariable (value = "id") Integer identity, @RequestBody Registration regi){
        return this.stu.updateRecord(identity,regi);
    }

    @DeleteMapping("/deleteRecords/{del}")
    public String deleteRec(@PathVariable (value = "del") Integer stdid)
    {
        return this.stu.deleteRecords(stdid);
    }
}
