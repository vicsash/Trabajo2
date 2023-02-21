package com.Trabajo2;

public class pruebas {


    public static boolean validarEntrada(int[] numeros) {
        while (numeros.length != 6) { System.out.println("Introduce 6 n￺meros entre 1 y 49");
            for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] < 1 || numeros[i] > 49) { System.out.println("Introduce 6 n￺meros entre 1 y 49");
            } for (int j = 0; j < i; j++) {
                if (numeros[j] == numeros[i]) { System.out.println("Introduce 6 n￺meros entre 1 y 49 sin n￺meros repetidos");
            }
            }
        } return true;
        }
        return false;
    }
}
