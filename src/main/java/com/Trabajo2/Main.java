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
        Bombo bombo = new Bombo();
        int[] boletoAleatorio = Boleto.boleto(bombo.getPrimerBombo(), bombo.getComplemento(), bombo.getReintegro());
        Game juego = new Game();
        int[] userNums = new int[6];
        int userIn;

        do{
            menu();
            menu = lector.nextInt();
            lector.nextLine();
            switch(menu){
                case 1:
                    subMenu();
                    do {
                        submenu = lector.nextInt();
                        lector.nextLine();
                        switch (submenu) {
                            case 1:
                                System.out.println("Introduce tus numeros. (1-49)");
                                for (int i = 0; i < 6; i++) {
                                    userNums[i] = lector.nextInt();
                                    lector.nextLine();
                                }
                                System.out.println(juego.juegoUnico(userNums));

                                subMenu();

                                break;
                            case 2:
                                System.out.println("2");
                                break;
                            case 3:
                                System.out.println("3");
                                break;
                            case 4:
                                System.out.println("4");
                                break;
                            case 5:
                                System.out.println("5");
                                break;
                            case 0:
                                System.out.println("0");
                                break;
                            default:
                                System.out.println("Seleciona un numero entre 0-5");
                                break;
                        }
                    }while(submenu != 0);
                case 0:
                default:

            }
        }while(menu != 0);
        lector.close();
    }

    /**
     * Metodo para imprimir el menu
     */
    private static void menu(){
        System.out.println("************************************");
        System.out.println("Bienvenidos al juego de la primitiva.");
        System.out.println("1. - Jugar a la primitiva.");
        System.out.println("0. - Salir");
        System.out.println("***********************************");
    }

    /**
     * Metodo para imprimir el submenu
     */
    private static void subMenu(){
        System.out.println("***********************************");
        System.out.println("1. - Juego unico.");
        System.out.println("2. - Jugar hasta premio.");
        System.out.println("3. - Jugar hasta premio sin reintegro.");
        System.out.println("4. - Jugar 100 jugadas.");
        System.out.println("5. - Jugar hasta premio especial.");
        System.out.println("0. - Salir.");
        System.out.println("***********************************");
    }

}
