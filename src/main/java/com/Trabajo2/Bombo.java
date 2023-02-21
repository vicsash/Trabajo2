package com.Trabajo2;

import java.util.Arrays;
import java.util.Random;

public class Bombo {

    private int[] primerBombo = new int[6];
    private int complemento;
    private int reintegro;

    public Bombo() {
        this.primerBombo = primerBombo();
        this.complemento = complemento();
        this.reintegro = reintegro();
    }

    public int[] getPrimerBombo() {
        return primerBombo;
    }
    public int getComplemento() {
        return complemento;
    }
    public int getReintegro() {
        return reintegro;
    }

    @Override
    public String toString() {
        return "Primer Bombo: " + Arrays.toString(primerBombo) +
                ", Complemento: " + complemento +
                ", Reintegro: " + reintegro;
    }

    /**
     * Generates an array that is filled with 6
     * @return Array of 6 rand nums.
     */
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

    /**
     * Generates a number between 1 and 49 separate from primerBombo.
     * @return Num between 1-49.
     */
    public int complemento() {
        int num;
        do {
            num = randNum(1, 49);
        } while (containsNum(num));
        return num;
    }

    /**
     * Generates a random number between 0 and 9.
     * @return Num between 0-9.
     */
    public int reintegro() {
        return randNum(0, 9);
    }

    /**
     * Resets the array.
     */
    public void reset() {
        this.primerBombo = primerBombo();
        this.complemento = complemento();
        this.reintegro = reintegro();
    }

    /**
     * Generates random number between the two inputs.
     * @param min Min num.
     * @param max Max num.
     * @return Random num between min-max.
     */
    private int randNum(int min, int max) {
        Random rand = new Random();
        int output;

        output = rand.nextInt(max - min + 1) + min;
        return output;
    }

    /**
     * Checks if rolledNums contains a number.
     * @param num Num to check.
     * @return True or false depending on if the num is in arr.
     */
    private boolean containsNum(int num) {
        for (int item : primerBombo) {
            if (item == num)
                return true;
        }
        return false;
    }

}
