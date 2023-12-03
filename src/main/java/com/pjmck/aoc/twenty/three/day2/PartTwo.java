package com.pjmck.aoc.twenty.three.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartTwo {

    public static void main(String[] args) {

        int sumOfValidGameIds = getSumOfValidGameIds("twenty/three/day2/input1.txt");

        System.out.println(sumOfValidGameIds);
    }

    protected static int getSumOfValidGameIds(String inputPath) {
        Pattern gameOutcomePattern = Pattern.compile("(\\d+) (green|red|blue)?,? ?");

        InputStream resourceAsStream = PartTwo.class.getClassLoader().getResourceAsStream(inputPath);

        int sumOfPowers = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] gameIdToOutcomeListArray = line.split(": ");
                int gameId = Integer.parseInt(gameIdToOutcomeListArray[0].split("Game ")[1]);

                String allGameOutcomes = gameIdToOutcomeListArray[1];
                String[] rounds = allGameOutcomes.split(";");

                Map<String, Integer> colourToMinNum = new HashMap<>();
                colourToMinNum.put("red", 0);
                colourToMinNum.put("green", 0);
                colourToMinNum.put("blue", 0);

                for (String round : rounds) {

                    Matcher matcher = gameOutcomePattern.matcher(allGameOutcomes);
                    while (matcher.find()) {

                        int number = Integer.parseInt(matcher.group(1));
                        String colour = matcher.group(2);

                        Integer currentColourValue = colourToMinNum.get(colour);

                        if (currentColourValue < number) {
                            colourToMinNum.put(colour, number);
                        }
                    }
                }

                int powerOfSetOfCubes = 1;
                for (Integer value : colourToMinNum.values()) {
                    powerOfSetOfCubes *= value;
                }

                sumOfPowers += powerOfSetOfCubes;

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sumOfPowers;
    }

}
