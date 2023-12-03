package com.pjmck.aoc.twenty.three.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DayOneTest {

    @Test
    public void testGetSumOfCalibrationValues() {

        int sumOfCalibrationValues = DayOne.getSumOfCalibrationValues("twenty/three/day1/input1_1.txt");

        Assertions.assertEquals(142, sumOfCalibrationValues);
    }

}