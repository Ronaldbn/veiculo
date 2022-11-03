package Locadora.DB;

import Locadora.Model.Aluguel;

import java.util.ArrayList;
import java.util.List;

public class AluguelDB {

    private static List<Aluguel> aluguels = new ArrayList<>();

    public Aluguel cadastrarAluguel(Aluguel aluguel) {
        aluguels.add(aluguel);
        return aluguel;
    }
}
