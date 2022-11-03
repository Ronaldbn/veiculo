package Locadora.Service;

import Locadora.DB.VeiculoDB;
import Locadora.Model.Veiculo;

import java.util.List;

public class VeiculoService {

    private VeiculoDB veiculoDB = new VeiculoDB();

    public Veiculo cadastrarVeiculo(String modelo, String placa, Boolean disponivel) {
        if (modelo == null || modelo.isEmpty()) {
            return null;
        }
        if (placa == null || placa.isEmpty()) {
            return null;
        }
        if (disponivel == null || !disponivel) { // !disponivel == false
            return null;
        }
        Veiculo veiculo = new Veiculo(modelo, placa, true);
        return veiculoDB.cadastrarVeiculo(veiculo);

    }

    public List<Veiculo> listaVeiculo() {
        return veiculoDB.listVeiculos();

    }

    public Veiculo buscaVeiculo (String placa) {
        return veiculoDB.buscaVeiculo(placa);

    }



}
