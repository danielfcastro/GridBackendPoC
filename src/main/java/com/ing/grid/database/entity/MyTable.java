package com.ing.grid.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class MyTable {
    @Id
    private Long id;
    private Integer age;
    private String name;
    private String description;
}
