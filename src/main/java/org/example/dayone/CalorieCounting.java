package org.example.dayone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalorieCounting {
    /**
     * <p>This approach uses a string representation of a list of elf calories</p>
     * @param data String input representing list of elf calories
     * @return maximum calorie
     */
    public static int calorieCounterPartOne(String data) {
        int sum, counter = 0;
        List<Integer> elfCalorieList = new ArrayList<>();
        var res = data.split("\n");

        for (String re : res) {
            if (!re.isBlank()) {
                sum = Integer.parseInt(re);
                counter += sum;
            } else {
                elfCalorieList.add(counter);
                counter = 0;
            }
        }
        var maxCalorie = Collections.max(elfCalorieList);
        System.out.println("Largest Calorie: " + maxCalorie);
        Collections.sort(elfCalorieList);

        var sumOfLargestThreeCalories = elfCalorieList.subList(Math.max(elfCalorieList.size() - 3, 0), elfCalorieList.size())
                .stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum of Largest Calories: " + sumOfLargestThreeCalories);
        return maxCalorie;
    }



    /**
     * <p>This approach reads input from a file</p>
     * @param filePath path to file to be read
     * @return maximum calories
     */
    public static int calorieCounterFileReader(String filePath) throws IOException {
        File file = new File(filePath);
        StringBuilder fileContents = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String lines;

        while ((lines = reader.readLine()) != null) {
            fileContents.append(lines);
            fileContents.append("\n");
        }
        reader.close();
        return calorieCounterPartOne(fileContents.toString());
    }
}
