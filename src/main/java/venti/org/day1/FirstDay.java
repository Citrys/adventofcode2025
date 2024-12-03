package venti.org.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FirstDay {

    public static void main(String[] args) {
        String filePath = "lists.csv";

        try {
            Pair<ArrayList<Integer>, ArrayList<Integer>> result = readCsvFile(filePath);
            ArrayList<Integer> id1List = result.getFirst();
            ArrayList<Integer> id2List = result.getSecond();
            Collections.sort(id1List);
            Collections.sort(id2List);

            int totalDistance = 0;

            for (int i = 0; i < id1List.size(); i ++) {
                totalDistance += Math.abs(id2List.get(i) - id1List.get(i));;
            }

            System.out.println("totalDistance:  " + totalDistance);
            System.out.println("score: " + getSimilarityScore(id1List, id2List));
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    private static int getSimilarityScore(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        HashMap<Integer, Integer> scoreMap = new HashMap<>();

        for (Integer i: l2) {
            scoreMap.put(i, scoreMap.getOrDefault(i, 0) + 1);
        }

        int score = 0;

        for (Integer j: l1) {
            if (scoreMap.containsKey(j)) {
                score += j * scoreMap.get(j);
            }
        }

        return score;
    }

    public static Pair<ArrayList<Integer>, ArrayList<Integer>> readCsvFile(String filePath) throws IOException {
        ArrayList<Integer> id1List = new ArrayList<>();
        ArrayList<Integer> id2List = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] values = line.split(",");
                if (values.length >= 2) {
                    id1List.add(Integer.parseInt(values[0].trim()));
                    id2List.add(Integer.parseInt(values[1].trim()));
                }
            }
        }

        return new Pair<>(id1List, id2List);
    }
}


class Pair<T1, T2> {
    private final T1 first;
    private final T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }
}

