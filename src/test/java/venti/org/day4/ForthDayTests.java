package venti.org.day4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class ForthDayTests {
    ForthDay day4 = new ForthDay();
    @Test
    public void getXmas() {
        char[][] grid = {
                {'M', 'M', 'M', 'S', 'X', 'X', 'M', 'A', 'S', 'M'},
                {'M', 'S', 'A', 'M', 'X', 'M', 'S', 'M', 'S', 'A'},
                {'A', 'M', 'X', 'S', 'X', 'M', 'A', 'A', 'M', 'M'},
                {'M', 'S', 'A', 'M', 'A', 'S', 'M', 'S', 'M', 'X'},
                {'X', 'M', 'A', 'S', 'A', 'M', 'X', 'A', 'M', 'M'},
                {'X', 'X', 'A', 'M', 'M', 'X', 'X', 'A', 'M', 'A'},
                {'S', 'M', 'S', 'M', 'S', 'A', 'S', 'X', 'S', 'S'},
                {'S', 'A', 'X', 'A', 'M', 'A', 'S', 'A', 'A', 'A'},
                {'M', 'A', 'M', 'M', 'M', 'X', 'M', 'M', 'M', 'M'},
                {'M', 'X', 'M', 'X', 'A', 'X', 'M', 'A', 'S', 'X'}
        };
       int countXmas = day4.countWordOccurrences(grid, "XMAS");
       Assertions.assertEquals(countXmas, 18);
    }

    @Test
    public void getXmasFromFile() throws IOException {
        char[][] grid = day4.buildGridFromFile("src/main/resources/day4.txt");
        int countXmas = day4.countWordOccurrences(grid, "XMAS");
        Assertions.assertEquals(countXmas, 2532);
    }

    @Test
    public void getXMASSSFromFile() throws IOException {
        char[][] grid = day4.buildGridFromFile("src/main/resources/day4.txt");
        int countXmasPattern = day4.countXMASPatterns(grid);
        Assertions.assertEquals(countXmasPattern, 447);
    }
}
