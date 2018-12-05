package com.dog.demo.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Dog {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date rescued;
    private Boolean vaccinated;

}
