package com.example.university;

import com.example.university.executor.*;
import com.example.university.service.DepartmentService;
import com.example.university.service.LectorService;
import com.example.university.util.CommandAsker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Profile("production")
public class Application implements CommandLineRunner {

    private final static String HEAD_OF_DEPARTMENT = "Who is head of department [a-x]";
    private final static String STATISTIC = "Show *[a-x]* statistics";
    private final static String AVERAGE_SALARY = "Show the average salary for the department [a-x]";
    private final static String COUNT_OF_EMPLOYEE = "Show count of employee for [a-x]";
    private final static String GLOBAL_SEARCH = "Global search by [a-x]";

    private final Set<String> commands = Set.of(HEAD_OF_DEPARTMENT, STATISTIC, AVERAGE_SALARY, COUNT_OF_EMPLOYEE, GLOBAL_SEARCH);

    @Autowired
    DepartmentService departmentService;
    @Autowired
    LectorService lectorService;
    @Autowired
    CommandAsker commandAsker;

    @Override
    @Transactional
    public void run(String... args) {
        while (true) {
            String ask = commandAsker.ask("Enter your question. For exit program enter \"exit\"");
            if (ask.equals("exit")) {
                break;
            }

            commands.forEach(c -> {
                Matcher matcher = Pattern.compile(c, Pattern.CASE_INSENSITIVE).matcher(ask);
                boolean isFind = matcher.find();
                if (isFind) {
                    execute(c, ask);
                }
            });

            System.out.println("--------------------------------------------------------------\n");
        }
    }

    private void execute(String command, String ask) {
        Executor executor;
        switch (command) {
            case HEAD_OF_DEPARTMENT:
                executor = new HeadOfDepartmentExecutor(departmentService);
                execute(executor, ask.split(" ")[5]);
                break;
            case STATISTIC:
                executor = new StatisticExecutor(departmentService);
                execute(executor, ask.split(" ")[1]);
                break;
            case AVERAGE_SALARY:
                executor = new AverageSalaryExecutor(departmentService);
                execute(executor, ask.split(" ")[7]);
                break;
            case COUNT_OF_EMPLOYEE:
                executor = new CountOfEmployeeExecutor(departmentService);
                execute(executor, ask.split(" ")[5]);
                break;
            case GLOBAL_SEARCH:
                executor = new GlobalSearchExecutor(lectorService);
                execute(executor, ask.split(" ")[3]);
                break;
        }
    }

    private void execute(Executor executor, String incomeParameter) {
        executor.setIncomeParameter(incomeParameter);
        executor.execute();
    }
}
