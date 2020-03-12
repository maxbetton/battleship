package com.ynov.test;

import com.ynov.main.Menu;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestMenu {
    private Menu menu = new Menu();

    @Test
    public void shouldMenuChoice1CorrectlyDisplayed() throws IOException {
        Assert.assertEquals("choice 1", menu.menuChoiceSelected(1));
    }

    @Test
    public void shouldMenuChoice2CorrectlyDisplayed() throws IOException {
        Assert.assertEquals("choice 2", menu.menuChoiceSelected(2));
    }

    @Test
    public void shouldMenuChoice3CorrectlyDisplayed() throws IOException {
        Assert.assertEquals("quit game", menu.menuChoiceSelected(3));
    }
}
