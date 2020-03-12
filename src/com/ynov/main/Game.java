package com.ynov.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    static String[][]  grid = new String[11][11];
    static String[][] gridIA = new String[11][11];
    static String[][] hiddenGrid = new String[11][11];
    static String you = "";
    static int line = 0;
    static int column = 0;
    static int coordinate = 0;
    static int counter = 1;
    static int touch = 0;
    static int touchA = 0;

    public Game() throws IOException {
        initGrids();

        initIAGrid();

        initPlayerGrid();

        play();
    }
    public static void main(String [] args) {
//        initGrids();
//
//        initIAGrid();
//
//        initPlayerGrid();
    }



    public static String choice1(){
        return "choice 1";
    }

    public static String initGrids() {

        String ia = "";


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

    public static String[][] getGrid(){
        return grid;
    }

    public String[][] getGridIA(){
        return gridIA;
    }

    public static String[][] getHiddenGrid(){
        return hiddenGrid;
    }

    public static String initIAGrid() {
        placeIABoats(gridIA);
        return firstPrint(gridIA);
    }


    public static void initPlayerGrid() {
        placePlayerBoats(grid, you);
        firstPrint(grid);
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

    private static void placePlayerBoats(String[][] grid, String you) {
        //coordinates for the 5 boxes boat
        placeBoat(grid, 5) ;
        //coordinates for the 4 boxes boat
        placeBoat(grid, 4) ;
        //coordinates for the first 3 boxes boat
        placeBoat(grid, 3) ;
        //coordinates for the second 3 boxes boat
        placeBoat(grid, 3) ;
        //coordinates for the 2 boxes boat
        placeBoat(grid, 2) ;

    }


    public static int placeBoat(String[][] grid, int number)
    {
        int error;

        if (number > 5 || number < 0)
            error = 0;
        else {


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
                                    if (grid[line][j].equals("\04")) {
                                        error = 0;
                                        i = colomn + number;
                                        break;
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
                                    if (grid[j][colomn].equals("\04")) {
                                        error = 0;
                                        i = line + number;
                                        break;
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
        return error;
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
                else if(j == 0)
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

    public void play() throws IOException {
        //Boucle qui répète tant que tout les bâteaux du joueur 1 ou du joueur 2 sont
        //coulés
        do
        {
            //Affiche un titre
            System.out.println("   " + you.toUpperCase() + "              " + "l'ordi" + "\n") ;

            //Affiche les deux grilles de jeu
            printTwoGrids(grid, hiddenGrid) ;

            //Compteur mod 2 pour que les joueurs jouent chacun à leur tour.
            if (counter % 2 == 1)
            {
                do
                {
                    //Appelle la fonction d'entrée de coordonnée pour la ligne du joueur
                    line = line(line) ;
                    //Puis de la colonne
                    column = column(column) ;
                }
                while (hiddenGrid[line][column] == " " || hiddenGrid[line][column] == "X") ;

                touchOrSunkPlayer(gridIA, hiddenGrid, line, column);

            }
            else
            {
                do
                {
                    //Appelle la fonction d'entrée de coordonnée pour la ligne de l'ordi
                    line = (int)(Math.random() * (10) + 1) ;
                    //Puis la colonne
                    column = (int)(Math.random() * (10) + 1) ;
                }
                while(grid[line][column] == " " || grid[line][column] == "X") ;

            }
        }
        while(touch != 17 && touchA != 17) ;

        //Vous dis si vous avez perdu ou gagner
        if (touchA == 17)
        {
            printTwoGrids(grid, hiddenGrid) ;
            System.out.println("\n" + you + " : you loose\n") ;
        }
        else
        {
            printTwoGrids(grid, hiddenGrid) ;
            System.out.println("\n" + you + " : you win\n") ;
        }

    }


    public static String touchOrSunkPlayer(String[][] gridIA, String[][] hiddenGrid, int line, int column){
        //Touché ou à côté, suivant le cas
         if (gridIA[line][column] == "\04")
        {
            hiddenGrid[line][column] = "X" ;
            touchA = touchA + 1 ;
            System.out.println("you touch");
            return "you touch";
        }
        counter = counter + 1 ;
        return "";
    }


    public int line(int a) throws IOException // ligne de départ
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;

        boolean erreur = false ;

        do
        {
            erreur = false ;

            try
            {
                do
                {
                    System.out.println("\nEntrez la ligne de depart") ;
                    a = Integer.parseInt(in.readLine()) ;
                }
                while (a < 1 || a > 10) ;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Veuillez entrer un entier entre 1 et 10\n");
                erreur = true ;
            }
        }
        while(erreur != false) ;

        return a ;
    }

    public int column(int a) throws IOException // colonne de départ
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;

        boolean erreur = false ;

        do
        {
            erreur = false ;

            try
            {
                do
                {
                    System.out.println("\nEntrez la colonne de depart") ;
                    a = Integer.parseInt(in.readLine()) ;
                }
                while (a < 1 || a > 10) ;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Veuillez entrer un entier entre 1 et 10\n");
                erreur = true ;
            }
        }
        while(erreur != false) ;

        return a ;
    }



}
