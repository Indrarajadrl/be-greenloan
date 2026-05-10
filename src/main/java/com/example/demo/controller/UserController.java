package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepositoryDao;

@SpringBootApplication
@RestController
@RequestMapping("/user")
@ComponentScan("com.example.demo")
public class UserController {

    
    public static void main(String[] args) {
        SpringApplication.run(UserController.class, args);
    }

    @Autowired
    UserRepositoryDao objUserRepositoryDao;


    @GetMapping("/list")
    public ResponseEntity<List<UserModel>> getData() {
        try {
            List<UserModel> objUserModel = new ArrayList<UserModel>();

            objUserRepositoryDao.getData().forEach(objUserModel::add);
           
            if (objUserModel.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            }
            return new ResponseEntity<>(objUserModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
