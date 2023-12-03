package com.pjmck.aoc.twenty.three.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartOne {

    public static void main(String[] args) {

        int sumOfCalibrationValues = getSumOfCalibrationValues("twenty/three//day1/input1.txt");

        System.out.println(sumOfCalibrationValues);
    }

    protected static int getSumOfCalibrationValues(String inputFile) {

        int sumOfCalibrationValues = 0;
        Pattern calibrationPattern = Pattern.compile("^.*?(\\d).*?(\\d)?\\D*$");
        InputStream input = PartOne.class.getClassLoader().getResourceAsStream(inputFile);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(input))){

            String line;
            while ((line = br.readLine()) != null) {
                Matcher calibrationMatcher = calibrationPattern.matcher(line);

                if (calibrationMatcher.find()) {

                    String firstDigit = calibrationMatcher.group(1);
                    String secondDigit = calibrationMatcher.group(2);

                    if (secondDigit == null) {
                        secondDigit = firstDigit;
                    }

                    String finalCalibrationValue = firstDigit + secondDigit;
                    sumOfCalibrationValues = sumOfCalibrationValues + Integer.parseInt(finalCalibrationValue);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sumOfCalibrationValues;
    }
}
