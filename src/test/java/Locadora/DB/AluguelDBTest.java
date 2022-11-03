package Locadora.DB;

import Locadora.Model.Aluguel;
import Locadora.Model.VeiculoAlugado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AluguelDBTest {

    private AluguelDB aluguelDB = new AluguelDB();

    @Test
    public void testCasdastrarAluguelDB() {

        List<VeiculoAlugado> alugueis = new ArrayList<>();
        alugueis.add(new VeiculoAlugado("modelo", 50.0));
        alugueis.add(new VeiculoAlugado("modelo 1", 55.0));

        Aluguel aluguel = new Aluguel();
        aluguel.setCarros(alugueis);

        Aluguel aluguelRetorno = aluguelDB.cadastrarAluguel(aluguel);
        Assertions.assertEquals(2, aluguelRetorno.getCarros().size());
        Assertions.assertEquals("modelo", aluguelRetorno.getCarros().get(0).getModelo());
        Assertions.assertEquals(50.0, aluguelRetorno.getCarros().get(0).getPreco());


    }
}
