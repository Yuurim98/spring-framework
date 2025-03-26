package com.example.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesController {

    @Autowired
    private PropertiesConfiguration propertiesConfiguration;

    @RequestMapping("/currency-config")
    public PropertiesConfiguration getCourseList() {
        return propertiesConfiguration;
    }

    /*
    * {
        "url": "http://default.url",
        "username": "defaultusername",
        "key": "defaultkey"
        }
            *
    * */
}
