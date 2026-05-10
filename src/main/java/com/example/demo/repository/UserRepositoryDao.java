
package com.example.demo.repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserModel;



@Repository
public class  UserRepositoryDao implements UserRepositoryInt {

    @Autowired
    private JdbcTemplate jdbctemplate;

    @Override
    public List<UserModel> getData(){
        return jdbctemplate.query("SELECT * FROM auth.users", BeanPropertyRowMapper.newInstance(UserModel.class));
    }
}