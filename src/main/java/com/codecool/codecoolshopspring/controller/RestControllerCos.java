package com.codecool.codecoolshopspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class RestControllerCos {

    @GetMapping("/testuje")
    public List<Integer> integerList() {
        List<Integer> cos = new ArrayList<>(Arrays.asList(1,2,3));

        return cos;





    }
}
