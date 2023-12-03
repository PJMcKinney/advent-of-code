package com.pjmck.aoc.twenty_three.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DayOneTest {

    @Test
    public void testGetSumOfCalibrationValues() {

        int sumOfCalibrationValues = DayOne.getSumOfCalibrationValues("day1/input.txt");

        Assertions.assertEquals(142, sumOfCalibrationValues);
    }

}