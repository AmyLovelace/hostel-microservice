package com.ms.hostel.controller;

import com.ms.hostel.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class HostelController {

    static final String STUDENT_URL_MS = "http://localhost:8081/";


    @Bean
    public RestTemplate getTemplate() {
        return new RestTemplate();    }


    @Autowired
    public RestTemplate restTemplate;


    @GetMapping("/find/{roll:\\d+}")
    @ResponseBody
    public Student fetchStudent(@PathVariable int roll) {

        Student student = restTemplate.exchange(STUDENT_URL_MS+"all/"+roll, HttpMethod.GET,null,Student.class).getBody();
        return student;
    }

        @GetMapping("/find")
        public Student fetchAllStudent(){
            return restTemplate.exchange(STUDENT_URL_MS+"all", HttpMethod.GET,null,Student.class).getBody();
        }

    }

