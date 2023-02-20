package com.Trabajo2;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random rand = new Random();
    //private int reintegro;
    //int complemntNumber;
    static Scanner lector = new Scanner(System.in);

    public static void main(String[] args){
        int menu,submenu;
        int[] playerNumber;


        do{
            menu();
            menu = lector.nextInt();
            lector.nextLine();
            switch(menu){
                case 1:

                    playerNumber  = firtsSixNumber();
                    subMenu();
                    //PLACED HERE TO SEE THE RANDOM NUMBER THAT WAS GENERATED USING RAND
                    //TEMPORARY PLACE TO CONFIRM THAT IT WORKS
                    System.out.println(Arrays.toString(playerNumber));
                    do {
                        submenu = lector.nextInt();
                        lector.nextLine();
                        switch (submenu) {
                            case 1 -> System.out.println("1");
                            case 2 -> System.out.println("2");
                            case 3 -> System.out.println("3");
                            case 4 -> System.out.println("4");
                            case 5 -> System.out.println("5");
                            case 0 -> System.out.println("0");
                            default -> {
                            }
                        }
                    }while(submenu != 0);
                case 0:
                default:

            }
        }while(menu != 0);
        lector.close();
    }

    /**
     * method to make 6 random numbers
     * taking in account that there cant be 2 same numbers
     * @return array
     */
    private static int[] firtsSixNumber(){
        int[] array = new int[6];
        int numb;
        boolean go;
        for (int i = 0; i< array.length;i++){
            go = false;
            do {
                numb = rand.nextInt(49 - 1) + 1;
                if (NoSameNumber(array, numb)) {
                    array[i] = numb;
                    go = true;
                }
            }while(!go);
        }
        return array;
    }

    /**
     * Method to confirm that the number is not repeated in an array
     * @param array from method to make the six numbers
     * @param numb the number that we need to see if is in array
     * @return true or false depending if number is present in array
     */
    private static boolean NoSameNumber(int[] array, int numb){
        for (int j : array) {
            if (j == numb)
                return false;
        }
        return true;
    }

    /**
     * Metodo para imprimir el menu
     */
    private static void menu(){
        System.out.println("Benividos al juego de la primitiva");
        System.out.println("Pular 1 para jugar a primitiva");
        System.out.println("Pulsar 0 para salir del menu");
    }

    /**
     * Metodo para imprimir el submenu
     */
    private static void subMenu(){
        System.out.println("***********************************");
        System.out.println("1- Juego unico");
        System.out.println("2- Jugar hasta premio");
        System.out.println("3 - Jugar hasta premio sin reintegro");
        System.out.println("4 - Jugar 100 jugadas");
        System.out.println("5 - Jugar hasta premio especial");
        System.out.println("0 - Salir");
        System.out.println("***********************************");
    }
}
