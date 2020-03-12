package com.ynov.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int menu = 0;

        System.out.println("================");
        System.out.println("BATTLESHIP");
        System.out.println("================\n\n");
        System.out.println("MENU\n");
        System.out.println("1. Play against IA\n");
        System.out.println("2. Rules\n");
        System.out.println("3. Quit game\n\n");
        System.out.println("What is your choice ?");

        menu = getPlayerMenuChoice(in);
        menuChoiceSelected(menu);
    }

    public static int getPlayerMenuChoice(BufferedReader in) {
        try {
            return Integer.parseInt(in.readLine());
        } catch (NumberFormatException | IOException e) {
            System.out.println("\nPlease enter a number between 1 et 3\n");
            e.printStackTrace();
        }
        return 0;
    }
    public static String menuChoiceSelected(int menu){
        switch (menu) {
            case 1:
                Game game = new Game();
                return "choice 1";
            case 2:
                Rules rules = new Rules();
                return "choice 2";
            case 3:
                return "quit game";
            default:
                return "";
        }
    }
}

