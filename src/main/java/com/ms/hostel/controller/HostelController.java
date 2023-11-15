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
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
public class HostelController {


    @Autowired
    public RestTemplate restTemplate;

    static final String STUDENT_URL_MS = "http://localhost:8080/";

    @GetMapping("/find/{roll}")
    @ResponseBody
    public Student fetchStudent(@PathVariable  int roll) {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(STUDENT_URL_MS)
                .path("/all/{roll}")
                .buildAndExpand(roll);

        return restTemplate.getForObject(uriComponents.toUriString(), Student.class);

    }

        @GetMapping("/find")
        public Student fetchAllStudent(){
            return restTemplate.exchange(STUDENT_URL_MS+"all", HttpMethod.GET,null,Student.class).getBody();
        }

    }

