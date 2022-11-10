package com.elevadoruso.reinaldo;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ElevadorServiceImpl implements IElevadorService{
    private final Input input;

    public ElevadorServiceImpl(Input input) {
        this.input = input;
    }


    @Override
    public List<Integer> andarMenosUtilizado() {
        List<Elevador> elevadores = input.elevadores;
        List<Integer> andares = elevadores.stream().map(Elevador::getAndar).toList();
        int min = Math.toIntExact(Collections.min(andares.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())).values()));
        return  andares.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())).entrySet().stream()
                .filter(e -> e.getValue() == min)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public List<Character> elevadorMaisFrequentado() {
        List<Elevador> elevadores = input.elevadores;
        return getCharactersMax(elevadores.stream().map(Elevador::getElevador));
    }

    @Override
    public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() {
        List<Elevador> elevadorMaisFrequentado = input.elevadores.stream().filter(e -> elevadorMaisFrequentado().contains(e.getElevador())).toList();
        return getCharactersMax(elevadorMaisFrequentado.stream().map(Elevador::getTurno));
    }

    @Override
    public List<Character> elevadorMenosFrequentado() {
        List<Elevador> elevadores = input.elevadores;
        return getCharactersMin(elevadores.stream().map(Elevador::getElevador));
    }

    @Override
    public List<Character> periodoMenorFluxoElevadorMenosFrequentado() {
        List<Elevador> elevadorMenosFrequentado = input.elevadores.stream().filter(e -> elevadorMenosFrequentado().contains(e.getElevador())).toList();
        return getCharactersMin(elevadorMenosFrequentado.stream().map(Elevador::getTurno));
    }

    @Override
    public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {
        List<Elevador> elevadores = input.elevadores;
        return getCharactersMax(elevadores.stream().map(Elevador::getTurno));
    }

    @Override
    public float percentualDeUsoElevadorA() {
        List<Elevador> elevadores = input.elevadores;
        return (float) elevadores.stream().filter(e -> e.getElevador() == 'A').count() / elevadores.size() * 100;
    }

    @Override
    public float percentualDeUsoElevadorB() {
        List<Elevador> elevadores = input.elevadores;
        return (float) elevadores.stream().filter(e -> e.getElevador() == 'B').count() / elevadores.size() * 100;
    }

    @Override
    public float percentualDeUsoElevadorC() {
        List<Elevador> elevadores = input.elevadores;
        return (float) elevadores.stream().filter(e -> e.getElevador() == 'C').count() / elevadores.size() * 100;
    }

    @Override
    public float percentualDeUsoElevadorD() {
        List<Elevador> elevadores = input.elevadores;
        return (float) elevadores.stream().filter(e -> e.getElevador() == 'D').count() / elevadores.size() * 100;
    }

    @Override
    public float percentualDeUsoElevadorE() {
        List<Elevador> elevadores = input.elevadores;
        return (float) elevadores.stream().filter(e -> e.getElevador() == 'E').count() / elevadores.size() * 100;
    }

    private List<Character> getCharactersMax(Stream<Character> characterStream) {
        List<Character> turnos = characterStream.toList();
        int max = Math.toIntExact(Collections.max(turnos.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())).values()));
        return turnos.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())).entrySet().stream()
                .filter(e -> e.getValue() == max)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private List<Character> getCharactersMin(Stream<Character> characterStream) {
        List<Character> turnos = characterStream.toList();
        int min = Math.toIntExact(Collections.min(turnos.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())).values()));
        return turnos.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())).entrySet().stream()
                .filter(e -> e.getValue() == min)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
