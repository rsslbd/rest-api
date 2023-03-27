package com.example.maven_jstl_template.entity;

import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student3 {
@Id
@GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private String gender;
    private String dob;
    private String ssc;
    private String jsc;
    private String hsc;
    private String education;

    private String subject;

}
