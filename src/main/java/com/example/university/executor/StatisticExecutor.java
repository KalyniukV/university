package com.example.university.executor;

import com.example.university.data.StatisticData;
import com.example.university.exception.DepartmentNotFoundException;
import com.example.university.service.DepartmentService;


public class StatisticExecutor extends BaseDepartmentCheacker implements Executor {
    private String departmentName;

    public StatisticExecutor(DepartmentService departmentService) {
        super(departmentService);
    }

    @Override
    public void execute() {
        try {
            verifyDepartment(departmentName);
            StatisticData statistic = departmentService.getStatisticByDepartmentName(departmentName);
            String answer = String.format(
                            "assistants - %d \n" +
                            "associate professors - %d\n" +
                            "professors - %d",
                    statistic.getAssistantsCount(),
                    statistic.getAssociateProfessorsCount(),
                    statistic.getProfessorsCount());
            System.out.println(answer);
        } catch (DepartmentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void setIncomeParameter(String parameter) {
        this.departmentName = parameter;
    }
}
