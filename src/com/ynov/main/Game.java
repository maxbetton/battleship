package com.ynov.main;

import java.io.IOException;

public class Game {
    static String[][]  grid = new String[11][11];
    static String[][] gridIA = new String[11][11];
    static String[][] hiddenGrid = new String[11][11];
    static String you = "";

    public static void main(String [] args) throws IOException {
        initGrids();

        initIAGrid();

        initPlayerGrid();
    }



    public static String choice1(){
        return "choice 1";
    }

    public static String initGrids() {

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

    public String[][] getGrid(){
        return grid;
    }

    public static String initIAGrid() {
        placeIABoats(gridIA);
        return firstPrint(gridIA);
    }


    public static String initPlayerGrid() throws IOException {
        placePlayerBoats(grid, you);
        return firstPrint(grid);
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

    private static void placeIABoats(String[][] gridIA) {
        //coordinates for the 5 boxes boat
        placeBoat(gridIA, 5) ;
        //coordinates for the 4 boxes boat
        placeBoat(gridIA, 4) ;
        //coordinates for the first 3 boxes boat
        placeBoat(gridIA, 3) ;
        //coordinates for the second 3 boxes boat
        placeBoat(gridIA, 3) ;
        //coordinates for the 2 boxes boat
        placeBoat(gridIA, 2) ;

    }

    private static void placePlayerBoats(String[][] grid, String you) throws IOException {
        //coordinates for the 5 boxes boat
        placeBoat(gridIA, 5) ;
        //coordinates for the 4 boxes boat
        placeBoat(gridIA, 4) ;
        //coordinates for the first 3 boxes boat
        placeBoat(gridIA, 3) ;
        //coordinates for the second 3 boxes boat
        placeBoat(gridIA, 3) ;
        //coordinates for the 2 boxes boat
        placeBoat(gridIA, 2) ;

    }


    public static void placeBoat(String[][] grid, int number)
    {
        int error;

        do
        {
            int i;
            int coordinate = (int)(Math.random() * (2) + 1) ;
            int line = (int)(Math.random() * (10) + 1) ;
            int colomn = (int)(Math.random() * (10) + 1) ;

            error = 1 ;

            switch (coordinate)
            {
                case 1 :
                {
                    if((colomn + number) > 11)
                    {
                        error = 0 ;
                    }
                    else
                    {
                        do
                        {
                            i = colomn ;

                            for (int j = colomn ; j < (colomn + number) ; j++)
                            {
                                if(grid[line][j].equals("\04"))
                                {
                                    error = 0 ;
                                    i = colomn + number ;
                                }
                            }

                            if (error != 0)
                            {
                                for (int j = colomn ; j < (colomn + number) ; j++)
                                {
                                    grid[line][j] = "\04" ;

                                }
                                i = colomn + number ;
                            }
                        }
                        while(i < colomn + number );
                    }
                }
                break ;

                case 2 :
                {
                    if((line + number) > 11)
                    {
                        error = 0 ;
                    }
                    else
                    {
                        do
                        {
                            i = line ;

                            for (int j = line ; j < (line + number) ; j++)
                            {
                                if(grid[j][colomn].equals("\04"))
                                {
                                    error = 0 ;
                                    i = line + number ;
                                }
                            }

                            if (error != 0)
                            {
                                for (int j = line ; j < (line + number) ; j++)
                                {
                                    grid[j][colomn] = "\04" ;

                                }
                                i = line + number ;
                            }
                        }
                        while(i < line + number );
                    }
                }
                break ;
            }
        }
        while(error != 1) ;
    }

    public static String firstPrint(String[][] a) // Affiche la grille quand vous placez les bateaux
    {
        StringBuilder res = new StringBuilder();
        for (int i = 0 ; i < 11 ; i++)
        {
            for (int j = 0 ; j < 11 ; j++)
            {
                if (j == 0 && i == 0)
                {
                    System.out.print("   ") ;
                    res.append("   ");
                }
                else if(j == 0 && i == 10)
                {
                    System.out.print(a[i][j] + " ") ;
                    res.append(a[i][j]).append(" ");
                }
                else if(j == 0 && i > 0)
                {
                    System.out.print(a[i][j] + "  ") ;
                    res.append(a[i][j]).append("  ");
                }
                else
                {
                    System.out.print(a[i][j]) ;
                    res.append(a[i][j]);
                }
            }

            System.out.println() ;
            res.append("\n");
        }

        System.out.println() ;
        return res.toString();
    }

}
