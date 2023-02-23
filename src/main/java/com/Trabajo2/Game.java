package com.Trabajo2;

public class Game {

    static int gamesWon = 0;
    static int gamesLost = 0;
    static int catEsp = 0;
    static int cat1 = 0;
    static int cat2 = 0;
    static int cat3 = 0;
    static int cat4 = 0;
    static int cat5 = 0;


    public String juegoUnico(Boleto userBoleto) {
        Boleto cpu = new Boleto();

        System.out.println("Tu Boleto: " + userBoleto.toString());
        System.out.println(cpu); // toString?
        switch (apuestasPremiadas(userBoleto.getBoletoNums(), userBoleto.getBoletoComplemento(), userBoleto.getBoletoIntegro(), cpu.getBoletoNums(), cpu.getBoletoComplemento(), cpu.getBoletoIntegro())) {
            case -1:
                gamesLost++;
                return "No has ganado.";
            case 0:
                gamesWon++;
                catEsp++;
                return "Has ganado el premio especial!";
            case 1:
                gamesWon++;
                cat1++;
                return "Has ganado el premio de categoria 1!";
            case 2:
                gamesWon++;
                cat2++;
                return "Has ganado el premio de categoria 2!";
            case 3:
                gamesWon++;
                cat3++;
                return "Has ganado el premio de categoria 3!";
            case 4:
                gamesWon++;
                cat4++;
                return "Has ganado el premio de categoria 4!";
            case 5:
                gamesWon++;
                cat5++;
                return "Has ganado el premio de categoria 5!";
        }
        return "err";
    }

    /**
     * es un metodo que se ejecuta hasta obtener el premio especial
     * pero como se puede ejecutar muchas veces le he puesto una pausa de 1 segundo
     * para que no consuma mucha cpu.
     * @param userBoleto el boleto del user para comprar.
     * @return devuelve si has ganado o no.
     */
    public boolean jugarHastaPremioEspecial(Boleto userBoleto) {
        Boleto cpu = new Boleto();

        while (true) {
            String resultadoJuego = juegoUnico(userBoleto);
            if (resultadoJuego.equals("Has ganado el premio especial!")) {
                System.out.println(resultadoJuego);
                return true;
            }
            try {
                Thread.sleep(1000); // Pausa de un segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




    private int apuestasPremiadas(int[] userNums, int userComp, int userReintegro, int[] cpuBombo, int cpuComp, int cpuReintegro) {
        int amountCorrect = 0;
        boolean correctComp = false;
        boolean correctReintegro = false;

        for (int uItem : userNums) {
            for (int bItem : cpuBombo) {
                if (uItem == bItem) {
                    amountCorrect++;
                }
            }
        }

        if (userComp == cpuComp)
            correctComp = true;
        if (userReintegro == cpuReintegro)
            correctReintegro = true;

        switch (amountCorrect){
            case 3:
                return 5;
            case 4:
                return 4;
            case 5:
                if (correctComp)
                    return 2;
                else
                    return 3;
            case 6:
                if (correctReintegro)
                    return 0;
                else
                    return 1;
            default:
                return -1;
        }
    }
}
