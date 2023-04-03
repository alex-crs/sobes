package org.lessons.HomeWork5;

import org.lessons.HomeWork5.entities.Student;
import org.lessons.HomeWork5.service.StudentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class HW5Start {
    static final StudentService studentService = new StudentService();

    static final List<String> forbiddenNames = Arrays.asList("all", "false");

    public static void main(String[] args) {
        startConsole();
    }

    static void startConsole() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] commands;
        boolean exit = false;
        int result = 0;
        System.out.println("Добро пожаловать в базу данных студентов. Введите запрос:");
        while (!exit) {
            try {
                sb.append(bufferedReader.readLine());
                commands = sb.toString().split(" ");
                switch (commands[0]) {
                    case "get":
                        Student student = null;
                        if (commands.length == 2 && commands[1].equals("all")) {
                            System.out.println(studentService.getAllStudents());
                        } else if (isNaN(commands[1])) {
                            student = studentService.getStudentById(Integer.parseInt(commands[1]));
                            System.out.println(student != null ? student : "Нет такого студента в базе");
                        } else {
                            student = studentService.getStudentByName(commands[1]);
                            System.out.println(student != null ? student : "Нет такого студента в базе");
                        }

                        break;

                    case "add":
                        if (commands.length == 3 && isForbiddenName(commands[1])) {
                            result = studentService.addStudent(commands[1], commands[2]);
                        } else {
                            System.out.println("Невозможно выполнить команду, неверные аргументы (add name mark)");
                        }
                        if (result > 0) {
                            System.out.println("Студент успешно добавлен в базу данных");
                        } else {
                            System.out.println("Ошибка добавления студента в базу");
                        }
                        result = 0;
                        break;

                    case "change":
                        if (commands.length == 4 && isNaN(commands[1])) {
                            result = studentService.changeStudentById(Integer.parseInt(commands[1]), commands[2], commands[3]);
                        } else {
                            System.out.println("Невозможно выполнить команду, неверные аргументы (change newName newMark)");
                        }
                        if (result > 0) {
                            System.out.println("Информация о студенте успешно обновлена");
                        } else {
                            System.out.println("Ошибка обновления информации о студенте");
                        }
                        result = 0;
                        break;

                    case "delete":
                        if (commands.length == 2 && isNaN(commands[1])) {
                            result = studentService.deleteById(Integer.parseInt(commands[1]));
                        } else {
                            System.out.println("Невозможно выполнить команду, неверные аргументы (change newName newMark)");
                        }
                        if (result > 0) {
                            System.out.println("Запись успешно удалена");
                        } else {
                            System.out.println("Ошибка удаления записи");
                        }
                        result = 0;
                        break;

                    case "fill":
                        if (commands.length == 2 && isNaN(commands[1])) {
                            addSetOfEntry(Integer.parseInt(commands[1]));
                        }
                        break;

                    case "exit":
                        exit = true;
                        break;

                    default:
                        System.out.println("Нераспознанная команда");
                        break;
                }
                sb.delete(0, sb.length());
            } catch (IOException e) {
                System.out.println("Неверный ввод");
            }
        }
    }

    static boolean isNaN(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    static boolean isForbiddenName(String name) {
        int i = 0;
        if (!forbiddenNames.contains(name)) {
            i++;
        }
        if (!isNaN(name)) {
            i++;
        }
        return i == 2;
    }

    static void addSetOfEntry(int count) {
        for (int i = 0; i < count; i++) {
            studentService.addStudent("Name" + i, UUID.randomUUID().toString());
        }
        System.out.println("Добавлене в базу завершено:");
    }
}
