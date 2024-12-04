package venti.org.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ForthDay {
    final int[] ROW_DIRECTIONS = {-1, -1, -1, 0, 0, 1, 1, 1};
    final int[] COL_DIRECTIONS = {-1, 0, 1, -1, 1, -1, 0, 1};

    public char[][] buildGridFromFile(String filePath) throws IOException {
        List<char[]> rows = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                rows.add(line.toCharArray());
            }
        }
        return rows.toArray(new char[0][]);
    }


    public int countWordOccurrences(char[][] grid, String word) {
        int rows = grid.length;
        int cols = grid[0].length;
        int wordLength = word.length();
        int count = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == word.charAt(0)) {
                    for (int direction = 0; direction < 8; direction++) {
                        if (searchFrom(grid, word, row, col, direction, wordLength)) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    private boolean searchFrom(char[][] grid, String word, int row, int col, int direction, int wordLength) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int k = 0; k < wordLength; k++) {
            int newRow = row + k * ROW_DIRECTIONS[direction];
            int newCol = col + k * COL_DIRECTIONS[direction];

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                return false;
            }

            if (grid[newRow][newCol] != word.charAt(k)) {
                return false;
            }
        }

        return true;
    }

    public int countXMASPatterns(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int row = 1; row < rows - 1; row++) {
            for (int col = 1; col < cols - 1; col++) {
                if (grid[row][col] == 'A' && isXMASPattern(grid, row, col)) {
                    count++;
                }
            }
        }

        return count;
    }

    private  boolean isXMASPattern(char[][] grid, int row, int col) {

        boolean diagonal1 = grid[row - 1][col - 1] == 'M' &&
                grid[row + 1][col + 1] == 'S';

        boolean diagonal2 = grid[row - 1][col + 1] == 'M' &&
                grid[row + 1][col - 1] == 'S';

        boolean reverseDiagonal1 = grid[row - 1][col - 1] == 'S' &&
                grid[row + 1][col + 1] == 'M';

        boolean reverseDiagonal2 = grid[row - 1][col + 1] == 'S' &&
                grid[row + 1][col - 1] == 'M';

        return (diagonal1 && diagonal2) || (reverseDiagonal1 && reverseDiagonal2);
    }
}
