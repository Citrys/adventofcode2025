package venti.org.day2;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class LoadData {
    public static List<List<Integer>> loadFile(String filePath) {
        List<List<Integer>> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("\\s+");
                List<Integer> row = new ArrayList<>();
                for (String token : tokens) {
                    row.add(Integer.parseInt(token));
                }
                data.add(row);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integer: " + e.getMessage());
        }
        return data;
    }
}


class SecondDay {

    public static boolean isMonotonicByWithAtLeastOneRemovalAndNot(List<Integer> numbers) {
        if (numbers == null || numbers.size() <= 1) {
            return true;
        }

        if (isValid(numbers, true) || isValid(numbers, false)) {
            return true;
        }

        for (int i = 0; i < numbers.size(); i++) {
            List<Integer> modifiedList = new ArrayList<>(numbers);
            modifiedList.remove(i);
            if (isValid(modifiedList, true) || isValid(modifiedList, false)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isValid(List<Integer> numbers, boolean isIncreasing) {
        return IntStream.range(1, numbers.size())
                .mapToObj(i -> numbers.get(i) - numbers.get(i - 1))
                .allMatch(diff -> {
                    if (isIncreasing) {
                        return diff > 0 && (diff == 1 || diff == 2 || diff == 3);
                    } else {
                        return diff < 0 && (diff == -1 || diff == -2 || diff == -3);
                    }
                });
    }

    public static void main(String[] args) {
        String filePath = "src/main/resources/day2.txt";

        List<List<Integer>> loadedData = LoadData.loadFile(filePath);

        int good = 0;
        int bad = 0;

        for (List<Integer> list: loadedData) {
            boolean status = isMonotonicByWithAtLeastOneRemovalAndNot(list);
            if (status)  {
                System.out.println(list);
                good++;
            } else { bad ++; };
        }


        System.out.println("good: " + good);
        System.out.println("bad: " + bad);
    }
}