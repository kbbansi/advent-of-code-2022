package org.example.dayone;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CalorieCountingTest {

    @Test
    void calorieCounter() {
        String input = "1000\n2000\n3000\n\n4000\n\n5000\n6000\n\n7000\n8000\n9000\n\n10000";
        var expected = CalorieCounting.calorieCounterPartOne(input);
        assertEquals(expected, findActual(input), " Error!");
    }

    @Test
    void calorieCounterActualData() throws IOException {
        String filePath = "src/main/resources/aoc_input/day1.txt";
        assertEquals(CalorieCounting.calorieCounterFileReader(filePath), findActualWithFileReader(filePath), " OOps... Check your impl!");
    }


    private int findActual(String data) {
        return CalorieCounting.calorieCounterPartOne(data);
    }

    private int findActualWithFileReader(String filePath) throws IOException {
        return CalorieCounting.calorieCounterFileReader(filePath);
    }
}