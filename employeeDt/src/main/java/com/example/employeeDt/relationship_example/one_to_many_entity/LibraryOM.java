package com.example.employeeDt.relationship_example.one_to_many_entity;

import lombok.*;

import javax.persistence.*;

import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class LibraryOM {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "libraryOM")
    private Set<Book> books;

    //...

}