package com.ynov.test;

import com.ynov.main.Game;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestGame {
    //private Game game = new Game();

    public TestGame() throws IOException {
    }

    @Test
    public void gridsCorrectlyDisplayed() {
        Assert.assertEquals("   12345678910           12345678910\n" +
                "1  **********         1  **********\n" +
                "2  **********         2  **********\n" +
                "3  **********         3  **********\n" +
                "4  **********         4  **********\n" +
                "5  **********         5  **********\n" +
                "6  **********         6  **********\n" +
                "7  **********         7  **********\n" +
                "8  **********         8  **********\n" +
                "9  **********         9  **********\n" +
                "10 **********         10 **********\n", Game.initGrids());
    }

    @Test
    public void iaGirdCorrectlyDisplayed() {
        Game.initGrids();
        Pattern p = Pattern.compile("   12345678910\n" +
                "1  .*\n" +
                "2  .*\n" +
                "3  .*\n" +
                "4  .*\n" +
                "5  .*\n" +
                "6  .*\n" +
                "7  .*\n" +
                "8  .*\n" +
                "9  .*\n" +
                "10 .*\n");
        Matcher m = p.matcher(Game.initIAGrid());
        Assert.assertTrue(m.matches());
    }

    @Test
    public void shouldPlaceA5CasePlayerBoat() throws IOException {
        Game.initGrids();
        String[][] grid = Game.getGrid();
        Assert.assertEquals(1, Game.placeBoat(grid, 5));
    }


    @Test
    public void shouldPlaceA4CasePlayerBoat() {
        Game.initGrids();
        String[][] grid = Game.getGrid();
        Assert.assertEquals(1, Game.placeBoat(grid, 4));
    }

    @Test
    public void shouldPlaceA3CasePlayerBoat() {
        Game.initGrids();
        String[][] grid = Game.getGrid();
        Assert.assertEquals(1, Game.placeBoat(grid, 3));
    }

    @Test
    public void shouldPlaceA2CasePlayerBoat() {
        Game.initGrids();
        String[][] grid = Game.getGrid();
        Assert.assertEquals(1, Game.placeBoat(grid, 2));
    }

    @Test
    public void shouldReturnErrorWhenPlaceABoatMoreThan5Case(){
        Game.initGrids();
        String[][] grid = Game.getGrid();
        Assert.assertEquals(0, Game.placeBoat(grid, 12));
    }

    @Test
    public void shouldReturnErrorWhenPlaceABoaLessThan0Case(){
        Game.initGrids();
        String[][] grid = Game.getGrid();
        Assert.assertEquals(0, Game.placeBoat(grid, -1));
    }


    @Test
    public void shouldPlayerTouchIA() {
        Game.initGrids();
        String[][] hiddenGrid = Game.getHiddenGrid();
        String[][] myGrid = new String[100][100];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                myGrid[i][j] = "*";
            }
        }
        //Then numbers
        for (int i = 0; i < 11; i++) {
            myGrid[i][0] = i + "";
            myGrid[0][i] = i + "";
        }

        myGrid[0][0] = "\04";
        Game.firstPrint(myGrid);
        Assert.assertEquals("you touch", Game.touchOrSunkPlayer(myGrid, hiddenGrid, 0, 0));
    }

    @Test
    public void shouldPlayerSunk() {
        Game.initGrids();
        String[][] hiddenGrid = Game.getHiddenGrid();
        String[][] myGrid = new String[100][100];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                myGrid[i][j] = "*";
            }
        }
        //Then numbers
        for (int i = 0; i < 11; i++) {
            myGrid[i][0] = i + "";
            myGrid[0][i] = i + "";
        }

        myGrid[0][0] = "*";
        Game.firstPrint(myGrid);
        Assert.assertEquals("you sunk", Game.touchOrSunkPlayer(myGrid, hiddenGrid, 0, 0));
    }

    @Test
    public void shouldReturnPlayerWin() {
        Assert.assertEquals("you win", Game.playerWinOrLoose(17));
    }
}
