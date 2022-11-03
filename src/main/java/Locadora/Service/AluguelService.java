package Locadora.Service;

import Locadora.DB.AluguelDB;
import Locadora.Model.Aluguel;
import Locadora.Model.VeiculoAlugado;
import Locadora.Model.Veiculo;

import java.util.List;

public class AluguelService {

    private AluguelDB aluguelDB = new AluguelDB();
    private VeiculoService veiculoService = new VeiculoService();


    public Aluguel cadastrarAluguel(Veiculo veiculo, List<VeiculoAlugado> carrosAlugados) {
        return null; //rever método
    }
}