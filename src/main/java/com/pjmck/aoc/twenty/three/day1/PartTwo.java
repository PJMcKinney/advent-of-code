package com.pjmck.aoc.twenty.three.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartTwo {

    public static void main(String[] args) {

        int sumOfCalibrationValues = getSumOfCalibrationValues("twenty/three/day1/input1.txt");

        System.out.println(sumOfCalibrationValues);
    }

    protected static int getSumOfCalibrationValues(String inputFile) {

        int sumOfCalibrationValues = 0;

        String matchDigitRegex = "one|two|three|four|five|six|seven|eight|nine|\\d";

        Pattern calibrationPattern = Pattern.compile(matchDigitRegex);

        InputStream input = PartTwo.class.getClassLoader().getResourceAsStream(inputFile);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(input))) {

            String line;
            while ((line = br.readLine()) != null) {

                List<String> matchedDigits = new ArrayList<>();
                while (line.length() > 0) {
                    Matcher calibrationMatcher = calibrationPattern.matcher(line);

                    while (calibrationMatcher.find()) {

                        matchedDigits.add(calibrationMatcher.group());
                    }
                    line = line.substring(1);
                }

                String firstDigit = matchedDigits.get(0);
                String lastDigit = matchedDigits.get(matchedDigits.size() - 1);
                String finalCalibrationValue = getIntStringValue(firstDigit) + getIntStringValue(lastDigit);

                sumOfCalibrationValues = sumOfCalibrationValues + Integer.parseInt(finalCalibrationValue);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sumOfCalibrationValues;
    }

    private static String getIntStringValue(String string) {

        return switch (string) {
            case "one" -> "1";
            case "two" -> "2";
            case "three" -> "3";
            case "four" -> "4";
            case "five" -> "5";
            case "six" -> "6";
            case "seven" -> "7";
            case "eight" -> "8";
            case "nine" -> "9";
            default -> string;
        };
    }
}
