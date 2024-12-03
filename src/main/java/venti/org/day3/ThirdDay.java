package venti.org.day3;

import utils.FileLoader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThirdDay {
    public int getSumOfNumbersMultiplication(String input) {
        int totalSum = 0;
        String regex = "mul\\((\\d+),(\\d+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            totalSum += x * y;
        }

        return totalSum;
    }

    public int getSumOfNumbersMultiplicationWithDoAndDont(String input) {
        int totalSum = 0;
        boolean isMulEnabled = true;

        Pattern instructionPattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)");

        Matcher matcher = instructionPattern.matcher(input);

        while (matcher.find()) {
            String match = matcher.group();

            if (match.startsWith("mul")) {
                if (isMulEnabled) {
                    String[] operands = match.substring(4, match.length() - 1).split(",");
                    int operand1 = Integer.parseInt(operands[0]);
                    int operand2 = Integer.parseInt(operands[1]);
                    totalSum += operand1 * operand2;
                }
            } else if (match.equals("do()")) {
                isMulEnabled = true;
            } else if (match.equals("don't()")) {
                isMulEnabled = false;
            }
        }

        return totalSum;
    }

    public int processInputFile(String filePath) {
        FileLoader fileLoader = new FileLoader();
        String data = fileLoader.loadFile(filePath);
        return this.getSumOfNumbersMultiplication(data);
    }

    public int processInputFileDoDont(String filePath) {
        FileLoader fileLoader = new FileLoader();
        String data = fileLoader.loadFile(filePath);
        return this.getSumOfNumbersMultiplicationWithDoAndDont(data);
    }
}
