package com.example.university.repository;

import com.example.university.domain.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LectorRepo extends JpaRepository<Lector, Long> {

    @Query("select concat(l.firstName,' ', l.lastName) " +
            "from Lector l " +
            "where " +
            "upper(l.firstName) like %:template% " +
            "or upper(l.lastName) like %:template%")
    List<String> globalSearch(String template);
}
