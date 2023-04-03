package org.lessons.HomeWork5.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    private int id;

    @Column
    private String name;

    @Column
    private String mark;

    @Override
    public String toString() {
        return String.format("id = %s; name = %s; mark = %s;", id, name, mark);
    }
}
