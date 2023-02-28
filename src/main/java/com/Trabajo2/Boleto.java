package com.Trabajo2;

import java.util.Arrays;
import java.util.Random;

public class Boleto {

    private Bombo b = new Bombo();
    private int[] boletoNums;
    private int boletoComplemento = b.complemento();
    private int boletoIntegro = b.reintegro();
    public Boleto(int[] playerNums) {
        this.boletoNums = playerNums;
    }
    public Boleto() {
        this.boletoNums = b.primerBombo();
    }

    public int[] getBoletoNums() {
        return boletoNums;
    }

    public int getBoletoComplemento() {
        return boletoComplemento;
    }

    public int getBoletoIntegro() {
        return boletoIntegro;
    }

    @Override
    public String toString() {
        return "Boleto{" +
                ", boletoNums=" + Arrays.toString(boletoNums) +
                ", boletoComplemento=" + boletoComplemento +
                ", boletoIntegro=" + boletoIntegro +
                '}';
    }





}
