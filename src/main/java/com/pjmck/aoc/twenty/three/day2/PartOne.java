package com.pjmck.aoc.twenty.three.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartOne {

    public static void main(String[] args) {

        int sumOfValidGameIds = getSumOfValidGameIds("twenty/three/day2/input1.txt");

        System.out.println(sumOfValidGameIds);
    }

    protected static int getSumOfValidGameIds(String inputPath) {
        Pattern gameOutcomePattern = Pattern.compile("(\\d+) (green|red|blue)?,? ?");

        InputStream resourceAsStream = PartOne.class.getClassLoader().getResourceAsStream(inputPath);

        int sumOfValidGameIds = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] gameIdToOutcomeListArray = line.split(": ");
                int gameId = Integer.parseInt(gameIdToOutcomeListArray[0].split("Game ")[1]);

                String allGameOutcomes = gameIdToOutcomeListArray[1];

                boolean isValidGame = true;

                Matcher matcher = gameOutcomePattern.matcher(allGameOutcomes);

                while (matcher.find()) {

                    int number = Integer.parseInt(matcher.group(1));
                    String colour = matcher.group(2);

                    isValidGame = isValidNumberOfCubes(colour, number);
                    if (!isValidGame) {
                        break;
                    }
                }

                if (isValidGame) {
                    sumOfValidGameIds += gameId;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sumOfValidGameIds;
    }

    private static boolean isValidNumberOfCubes(String colour, int number) {
        return switch (colour) {
            case "red" -> number <= 12;
            case "green" -> number <= 13;
            case "blue" -> number <= 14;
            default -> false;
        };
    }


}
