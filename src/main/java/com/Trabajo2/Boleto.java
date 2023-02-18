package com.Trabajo2;

public class Boleto {

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


}
