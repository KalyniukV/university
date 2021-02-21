package com.example.university.repository;

import com.example.university.data.StatisticData;
import com.example.university.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

    Department getByName(String name);

    @Query(value = "select " +
            "count(select l.lector_degree where l.lector_degree = 'ASSISTANT') as assistantsCount, " +
            "count(select l.lector_degree where l.lector_degree = 'ASSOCIATE_PROFESSOR') as associateProfessorsCount, " +
            "count(select l.lector_degree where l.lector_degree = 'PROFESSOR') as professorsCount " +
            "from department d " +
            "inner join department_lector dl on dl.department_id = d.id " +
            "inner join lector l on l.id = dl.lector_id " +
            "where d.department_name = :name", nativeQuery = true)
    StatisticData getStatisticByName(String name);

    @Query("select  avg (l.salary) from Department d join d.lectors l where d.name = :name")
    BigDecimal getAverageSalary(String name);
}
