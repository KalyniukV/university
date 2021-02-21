package com.example.university.executor;

import com.example.university.service.LectorService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GlobalSearchExecutor implements Executor {
    private final LectorService lectorService;
    private String template;

    @Override
    public void execute() {
        List<String> searchResult = lectorService.globalSearch(template);
        String answer = searchResult.stream().map(Object::toString).collect(Collectors.joining(", "));
        System.out.println(answer);
    }

    @Override
    public void setIncomeParameter(String parameter) {
        this.template = parameter;
    }
}
