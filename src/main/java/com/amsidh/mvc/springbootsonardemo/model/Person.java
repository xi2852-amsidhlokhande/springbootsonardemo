package com.amsidh.mvc.springbootsonardemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person implements Serializable {

    private String personId;
    private String personName;
    private Integer age;
}
