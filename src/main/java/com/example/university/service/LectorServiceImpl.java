package com.example.university.service;

import com.example.university.repository.LectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("lectorService")
public class LectorServiceImpl implements LectorService {
    @Autowired
    LectorRepo lectorRepo;

    @Override
    public List<String> globalSearch(String template) {
        return lectorRepo.globalSearch(template.toUpperCase());
    }
}
