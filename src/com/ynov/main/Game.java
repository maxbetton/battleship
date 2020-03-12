package com.ynov.main;

import java.io.IOException;

public class Game {
    public static void main(String [] args){

    }


    public static String choice1(){
        return "choice 1";
    }

    public static String initGrids() {
        String grid[][] = new String[11][11];
        String gridIA[][] = new String[11][11];
        String hiddenGrid[][] = new String[11][11];
        String you = "";
        String ia = "";
        int line = 0;
        int column = 0;
        int coordinate = 0;
        int counter = 1;
        int touch = 0;
        int touchA = 0;
        boolean error;

        //create 2 grids
        //first *
        for (int i = 0 ; i < 11 ; i++)
        {
            for (int j = 0 ; j < 11 ; j++)
            {
                grid[i][j] = "*";
                gridIA[i][j] = "*";
                hiddenGrid[i][j] = "*";
            }
        }

        //Then numbers
        for (int i = 0 ; i < 11 ; i++)
        {
            grid[i][0] = i + "";
            grid[0][i] = i + "";
            gridIA[i][0] = i + "";
            gridIA[0][i] = i + "";
            hiddenGrid[i][0] = i + "";
            hiddenGrid[0][i] = i + "";
        }
        return printTwoGrids(grid, hiddenGrid);
    }
    public static String printTwoGrids(String[][] a, String[][] b) {
        StringBuilder res = new StringBuilder();
        for (int i = 0 ; i < 11 ; i++)
        {
            for (int j = 0 ; j < 11 ; j++)
            {
                if (j == 0 && i == 0){
                    System.out.print("   ") ;
                    res.append("   ");
                }
                else
                {
                    if (j == 0 && i == 10) {
                        System.out.print(a[i][j] + " ");
                        res.append(a[i][j]).append(" ");
                    }
                    else
                    {
                        if(j == 0) {
                            System.out.print(a[i][j] + "  ");
                            res.append(a[i][j]).append("  ");
                        }
                        else {
                            System.out.print(a[i][j]);
                            res.append(a[i][j]);
                        }
                    }
                }
            }

            System.out.print("         ") ;
            res.append("         ");
            for (int k = 0 ; k < 11 ; k++)
            {
                if (i == 0 && k == 0) {
                    System.out.print("  ");
                    res.append("  ");
                }
                else
                {
                    if (k == 0 && i == 10) {
                        System.out.print(b[i][k] + " ");
                        res.append(b[i][k]).append(" ");
                    }
                    else
                    {
                        if(k == 0) {
                            System.out.print(b[i][k] + "  ");
                            res.append(b[i][k]).append("  ");
                        }
                        else {
                            System.out.print(b[i][k]);
                            res.append(b[i][k]);
                        }
                    }
                }
            }
            System.out.println();
            res.append("\n");
        }
        System.out.println() ;
        return res.toString();
    }
}
