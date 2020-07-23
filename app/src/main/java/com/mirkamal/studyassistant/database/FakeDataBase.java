package com.mirkamal.studyassistant.database;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class FakeDataBase {

    private static FakeDataBase dataBase;
    private static Map<String, Exam> exams;
    private static Map<String, Assignment> assignments;
    private static String studiedTime;

    private FakeDataBase() {
        exams = new HashMap<>();
        exams.put("Math", new Exam("Math", LocalDateTime.of(2020, 11, 8, 11, 0)));
        exams.put("Physics", new Exam("Physics", LocalDateTime.of(2020, 10, 1, 11, 45)));

        assignments = new HashMap<>();
        assignments.put("Math", new Assignment("Math", "Calculus", LocalDateTime.of(2020, 9, 18, 12, 0)));
        assignments.put("Geometry", new Assignment("Geometry", "Triangles", LocalDateTime.of(202, 10, 3, 12, 0)));

        studiedTime = "1:14";
    }

    public static FakeDataBase getInstance() {
        if (dataBase == null) {
            dataBase = new FakeDataBase();
            return dataBase;
        }
        return dataBase;
    }

    public Map<String, Exam> getExams() {
        return exams;
    }

    public Map<String, Assignment> getAssignments() {
        return assignments;
    }

    public String getStudiedTime() {
        return studiedTime;
    }

    public void setStudiedTime(String studiedTime) {
        FakeDataBase.studiedTime = studiedTime;
    }
}
