package com.client.controller;


import com.client.request.CreateStudentRequest;
import com.client.response.StudentResponse;
import com.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/get/{id}")
     public StudentResponse getStudent(@PathVariable Integer id){
          return clientService.getStudent(id);
    }

    @PostMapping("/create")
    public StudentResponse createStudent(@RequestBody CreateStudentRequest createStudentRequest){
        return clientService.createStudent(createStudentRequest);
    }
}
