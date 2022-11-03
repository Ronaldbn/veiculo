package Locadora.DB;

import Locadora.Model.Veiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BooleanSupplier;

public class VeiculoDBTest {


//    listar
//    buscar
    private VeiculoDB veiculoDB = new VeiculoDB();

    @Test
    public void testCadastrarVeiculoDB() {
        Veiculo veiculo
                = new Veiculo("modelo", "placa", true);
        Veiculo retorno = veiculoDB.cadastrarVeiculo(veiculo);

        Assertions.assertEquals("modelo", retorno.getModelo());
        Assertions.assertEquals("placa", retorno.getPlaca());
        Assertions.assertTrue(true);

    }
    @Test
    public void testListVeiculoDB() {
        Veiculo veiculo
                = new Veiculo("modelo", "placa", true);
        veiculoDB.cadastrarVeiculo(veiculo);

        List<Veiculo> retorno = veiculoDB.listVeiculos();
        Assertions.assertTrue(retorno.size() > 0);

    }
    @Test
    public void testBuscaVeiculoDB() {
        Veiculo veiculo
                = new Veiculo("modelo", "placa", true);
        veiculoDB.cadastrarVeiculo(veiculo);

        Veiculo retorno = veiculoDB.buscaVeiculo("placa");
        Assertions.assertEquals("modelo", retorno.getModelo());
        Assertions.assertEquals("placa", retorno.getPlaca());
        Assertions.assertTrue(true);

    }
    @Test
    public void testBuscaVeiculoNaoExiste() {
        Veiculo veiculo = veiculoDB.buscaVeiculo("123abc");
        Assertions.assertNull(veiculo);

    }

}
