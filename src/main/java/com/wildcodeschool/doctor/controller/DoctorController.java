package com.wildcodeschool.doctor.controller;

import java.util.List;

import com.fasterxml.jackson.databind.util.ClassUtil.Ctor;
import com.wildcodeschool.doctor.model.Doctor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DoctorController {

    @GetMapping("/doctor/{number}")
    @ResponseBody
    @ResponseStatus
    Doctor getDoctorByNumber(@PathVariable("number") final int number) {
        if ( number <= 12) {
            throw new ResponseStatusException(HttpStatus.FOUND, "Doctor " + number + " Found");
        } else if ( number == 13){
            return new Doctor(13, "Jodie Whittaker"); 
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation " + number); 
    }
}
