package org.example.validation;

import org.example.repositiry.impl.EmployeesRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {


    public static boolean isValidName(String str){
        String regex = "^[A-Za-z]{3,15}$";       // Имя должно содержать от 3 до 15 букв

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean isValidPosition(String position){
        String regex = "^[A-Za-z]{3,10}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(position);
        return matcher.matches();
    }
    public static boolean isValidSalary(String salary){
        try {
            double resultSalary = Double.parseDouble(salary);
            return resultSalary >=0 && resultSalary <= 5000.0 && salary.matches("\\d+");
        } catch (NumberFormatException e){
            return false;
        }
    }
    public static boolean isValidCity(String city){
        String regex = "^[A-Za-z]{3,8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(city);
        return matcher.matches();
    }

    public static boolean isValidZipCode(String zipCode){
        // Проверка на неотрицательность, длину не более 6 символов и отсутствие букв и других символов
        return zipCode.matches("\\d{1,6}") && Integer.parseInt(zipCode) >= 0;
    }
}
