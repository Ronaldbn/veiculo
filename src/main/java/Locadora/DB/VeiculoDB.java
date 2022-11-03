package Locadora.DB;

import Locadora.Model.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeiculoDB {
    public static List<Veiculo> veiculos= new ArrayList<>();

    public Veiculo cadastrarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        return veiculo;
    }

    public List<Veiculo> listVeiculos() {
        return veiculos;
    }


    public Veiculo buscaVeiculo(String placa) {
        Optional<Veiculo> op = veiculos
                .stream()
                .filter(v -> v.getPlaca().equals(placa))
                .findFirst();

        if (op.isPresent()) {
            return op.get();
        }
        return null;

    }



}
