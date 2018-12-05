package com.dog.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DogServiceImpl implements DogService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DogServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addDog(String name, Date rescued, Boolean vaccinated) {
        jdbcTemplate.update("INSERT INTO Dog (name, rescued, vaccinated) VALUES (?,?,?) ", name, rescued, vaccinated);


    }

    @Override
    public void deleteDog(String name, Long id) {
        jdbcTemplate.update("delete from dog where id=? and name=?", name, id);
    }

    @Override
    public List<String> listDogs(Date rescued) {
        String sql = "SELECT * FROM dog";
        List<String> dogList = new ArrayList<>();
        jdbcTemplate.query(sql, (ResultSetExtractor<List>) rs -> {

            while (rs.next()) {
                String name = rs.getString("name");
                dogList.add(name);

            }
            return dogList;
        });
        return dogList;
    }
}
