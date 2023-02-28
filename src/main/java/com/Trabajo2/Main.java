package com.Trabajo2;
import java.util.Random;
import java.util.Scanner;
public class Main {
    static Random rand = new Random();
    static Scanner lector = new Scanner(System.in);
    public static void main(String[] args){
        final int NUMEROJUGADAS = 10000;
        int menu,submenu;
        Game juego = new Game();
        do{
            menu();
            menu = lector.nextInt();
            lector.nextLine();
            switch(menu){
                //Star games
                case 1:
                    do {
                        subMenu();
                        submenu = lector.nextInt();
                        lector.nextLine();
                        switch (submenu) {
                            //Single game
                            case 1:
                                Boleto userBoleto = pedirNumerosBoleto();
                                System.out.println(juego.juegoUnico(userBoleto));
                                break;
                            //Juego unico
                            case 2:
                                Boleto userBoleto2 = pedirNumerosBoleto();
                                System.out.println(juego.juegoIndefinido(userBoleto2, false));
                                //System.out.println("2");
                                break;
                            // Juego hasta obtener premio
                            case 3:
                                Boleto userBoleto3 = pedirNumerosBoleto();
                                System.out.println(juego.juegoIndefinido(userBoleto3, true));
                                break;
                            // Juego hasta obtener premio sin reintegro
                            case 4:
                                Boleto userBoleto4 = pedirNumerosBoleto();
                                System.out.println("Tu Boleto: " + userBoleto4);
                                System.out.println(recordOfWinLose(juego.diezMilJugadas(userBoleto4,NUMEROJUGADAS)));
                                break;
                            // Ciclo de 10000 sorteos
                            case 5:
                                Boleto userBoleto5 = pedirNumerosBoleto();
                                System.out.println(juego.jugarHastaPremioEspecial(userBoleto5));
                                break;
                            // Jugar hasta obtener premio categoría especial
                            case 0:

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
        System.out.println("Muchas gracias por jugar. Que tenga un buen dia");
        lector.close();
    }
    /**
     * Method to print out the main menu
     */
    private static void menu(){
        System.out.println("*************************************");
        System.out.println("Bienvenidos al juego de la primitiva.");
        System.out.println("1. - Jugar a la primitiva.");
        System.out.println("0. - Salir");
        System.out.println("*************************************");
    }

    /**
     * Method to print out the submenu with the six options
     */
    private static void subMenu(){
        System.out.println("***************************************");
        System.out.println("1. - Juego unico.");
        System.out.println("2. - Jugar hasta premio.");
        System.out.println("3. - Jugar hasta premio sin reintegro.");
        System.out.println("4. - Jugar 10000 jugadas.");
        System.out.println("5. - Jugar hasta premio especial.");
        System.out.println("0. - Salir.");
        System.out.println("**************************************");
    }

    /**
     * Pide los numeros del boleto si quieres que sean manuales o aleatorios.
     * @return devuelve los numeros del boleto.
     */
    public static Boleto pedirNumerosBoleto() {
        Scanner lector = new Scanner(System.in);
        int[] userNums = new int[6];
        Boleto userBoleto = new Boleto();
        System.out.println("Quieres numeros aleatorios? (S/N)");
        String userInStr = lector.nextLine();
        if (userInStr.equalsIgnoreCase("n")) {
            System.out.println("Introduce tus numeros. (1-49)");
            for (int i = 0; i < 6; i++) {
                userNums[i] = lector.nextInt();
                lector.nextLine();
                if ((userNums[i] < 1) || (userNums[i] > 49)) {
                    System.out.println("El número introducido no está dentro del rango permitido.");
                    i--;
                }
            }
            userBoleto = new Boleto(userNums);
        } else {
            // Generar un boleto aleatorio si el usuario no quiere introducir sus números
            userBoleto = new Boleto();
        }
        return userBoleto;
    }
    public static String recordOfWinLose(int [] aray){
        StringBuilder sb = new StringBuilder();
        sb.append("Juegos perdidos-").append(aray[0]).append("\n");
        sb.append("Juegos ganados categoria especial- ").append(aray[1]).append("\n");
        sb.append("Juegos ganados categoria 1- ").append(aray[2]).append("\n");
        sb.append("Juegos ganados categoria 2- ").append(aray[3]).append("\n");
        sb.append("Juegos ganados categoria 3- ").append(aray[4]).append("\n");
        sb.append("Juegos ganados categoria 4- ").append(aray[5]).append("\n");
        sb.append("Juegos ganados categoria 5- ").append(aray[6]).append("\n");
        return sb.toString();
    }
}
