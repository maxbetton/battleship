package com.ynov.test;

import com.ynov.main.Game;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestGame {
    private Game game = new Game();

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
                "10 **********         10 **********\n", game.initGrids());
    }

    @Test
    public void iaGirdCorrectlyDisplayed() {
        game.initGrids();
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
        Matcher m = p.matcher(game.initIAGrid());
        Assert.assertTrue(m.matches());
    }

    @Test
    public void shouldPlaceA5CasePlayerBoat() throws IOException {

    }

}
