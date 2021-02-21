package com.example.university.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Lector {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "lector_degree")
    @Enumerated(EnumType.STRING)
    private Degree degree;

    @Column(name = "salary")
    private BigDecimal salary;

    @OneToMany(mappedBy = "headOfDepartment", fetch = FetchType.LAZY)
    private Set<Department> subordinateDepartments;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "department_lector",
            joinColumns = @JoinColumn(name = "lector_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    private Set<Department> departments;

    @Override
    public String toString() {
        return "Lector{" +
                "id=" + id +
                '}';
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
