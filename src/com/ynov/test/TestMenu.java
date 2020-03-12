package com.ynov.test;

import com.ynov.main.Menu;
import org.junit.Assert;
import org.junit.Test;

public class TestMenu {
    private Menu menu = new Menu();

    @Test
    public void shouldMenuChoice1CorrectlyDisplayed() {
        Assert.assertEquals("choice 1", menu.menuChoiceSelected(1));
    }

    @Test
    public void shouldMenuChoice2CorrectlyDisplayed() {
        Assert.assertEquals("choice 2", menu.menuChoiceSelected(2));
    }
}
