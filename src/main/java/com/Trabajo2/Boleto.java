package com.Trabajo2;

import java.util.Random;

public class Boleto {

    Bombo b = new Bombo();
    private int[] primerBombo = new int[6];
    int[] playerBombo = new int[6];
    int playerComplemento = b.complemento();
    int playerIntegro = b.reintegro();
    public Boleto(int[] playerBombo) {
        this.playerBombo = playerBombo;
    }

    /**
     * se guarda el array nuemros en un nuevo nuevo array
     * par agregar al length + 2 posiciones para el reintegro y
     * el numero adicional y luego devuelve el nuevo array de enteros
     * con los números guardados.
     * @param numeros los pimeros 6 numeros
     * @param numeroAdicional el septimo numero
     * @param reintegro y el reintego
     * @return devuelve el boleto ya completo
     */
    public static int[] boleto(int[] numeros, int numeroAdicional, int reintegro) {
        int[] numerosReintegro = new int[numeros.length + 2];
        System.arraycopy(numeros, 0, numerosReintegro, 0, numeros.length);
        numerosReintegro[numeros.length] = numeroAdicional;
        numerosReintegro[numeros.length + 1] = reintegro;
        return numerosReintegro;
    }
    /* para usar el metodo
    int[] numeros = {1, 2, 3, 4, 5, 6};
    int numeroAdicional = 7;
    int reintegro = 8;
    int[] numerosConReintegro = guardarNumeros(numeros, numeroAdicional, reintegro);
     */
    /**
     * Generates an array that is filled with 6
     * @return Array of 6 rand nums.
     */

    private boolean containsNum(int num) {
        for (int item : primerBombo) {
            if (item == num)
                return true;
        }
        return false;
    }

    public int[] primerBombo() {
        int num;
        int[] numArr = new int[6];
        for (int i = 0; i < 6; i++) {
            do {
                num = randNum(1, 49);
            } while (containsNum(num));
            numArr[i] = num;
        }
        return numArr;
    }
    private int randNum(int min, int max) {
        Random rand = new Random();
        int output;

        output = rand.nextInt(max - min + 1) + min;
        return output;
    }
    public void reset() {
        this.primerBombo = primerBombo();
    }

    public Boleto() {
        this.primerBombo = primerBombo();
    }
}
