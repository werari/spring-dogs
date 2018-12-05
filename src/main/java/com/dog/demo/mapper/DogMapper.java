package com.dog.demo.mapper;

import com.dog.demo.model.Dog;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DogMapper implements RowMapper<Dog> {
    @Override
    public Dog mapRow(ResultSet resultSet, int i) throws SQLException {
        Dog dog = new Dog();
        dog.setId(resultSet.getLong("id"));
        dog.setName(resultSet.getString("name"));
        dog.setRescued(resultSet.getDate("rescued"));
        dog.setVaccinated(resultSet.getBoolean("vaccinated"));


        return dog;
    }
}
