package com.Trabajo2;

import java.util.Arrays;
import java.util.Random;

public class Bombo {

    private int[] rolledNums = new int[6];
    private int complemento;
    private int reintegro;

    public Bombo() {
        this.rolledNums = primerBombo();
        this.complemento = complemento();
        this.reintegro = reintegro();
    }

    public int[] getRolledNums() {
        return rolledNums;
    }
    public int getComplemento() {
        return complemento;
    }
    public int getReintegro() {
        return reintegro;
    }

    @Override
    public String toString() {
        return "Bombo{" +
                "rolledNums=" + Arrays.toString(rolledNums) +
                ", complemento=" + complemento +
                ", reintegro=" + reintegro +
                '}';
    }

    private int[] primerBombo() {
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

    private int complemento() {
        int num;
        do {
            num = randNum(1, 49);
        } while (containsNum(num));
        return num;
    }

    private int reintegro() {
        return randNum(0, 9);
    }

    private void reset() {
        for (int item : this.rolledNums) {
            item = 0;
        }
    }

    /**
     * Generates random number between the two inputs.
     * @param min
     * @param max
     * @return returns random num between
     */
    private int randNum(int min, int max) {
        Random rand = new Random();
        int output;

        output = rand.nextInt(max - min + 1) + min;
        return output;
    }

    /**
     * Checks if rolledNums contains a number.
     * @param num num to check
     * @return returns true or false depending on if the num is in arr
     */
    private boolean containsNum(int num) {
        for (int item : rolledNums) {
            if (item == num)
                return true;
        }
        return false;
    }
}
