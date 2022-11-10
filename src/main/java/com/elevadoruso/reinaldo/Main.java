package com.elevadoruso.reinaldo;
import java.io.IOException;
import java.text.DecimalFormat;
public class Main {
    public static void main(String[] args) throws IOException {
        Input input = new Input();
        ElevadorServiceImpl elevadorService = new ElevadorServiceImpl(input);
        final DecimalFormat decform = new DecimalFormat("0.00");


        System.out.println("O(s) andar(es) menos utilizado(s): " + elevadorService.andarMenosUtilizado());
        System.out.println("O(s) elevador(es) mais frequentado(s): " + elevadorService.elevadorMaisFrequentado() +" | o(s) período(s) de maior fluxo : "+ elevadorService.periodoMaiorFluxoElevadorMaisFrequentado());
        System.out.println("O(s) elevador(es) menos frequentado(s): " + elevadorService.elevadorMenosFrequentado() +" | o(s) período(s) de menor fluxo : "+ elevadorService.periodoMenorFluxoElevadorMenosFrequentado());
        System.out.println("O período de maior utilização do conjunto de elevadores é: " + elevadorService.periodoMaiorUtilizacaoConjuntoElevadores());
        System.out.println("O percentual de uso do elevador A é: " + decform.format(elevadorService.percentualDeUsoElevadorA())+"%");
        System.out.println("O percentual de uso do elevador B é: " + decform.format(elevadorService.percentualDeUsoElevadorB())+"%");
        System.out.println("O percentual de uso do elevador C é: " + decform.format(elevadorService.percentualDeUsoElevadorC())+"%");
        System.out.println("O percentual de uso do elevador D é: " + decform.format(elevadorService.percentualDeUsoElevadorD())+"%");
        System.out.println("O percentual de uso do elevador E é: " + decform.format(elevadorService.percentualDeUsoElevadorE()) +"%");
    }
}