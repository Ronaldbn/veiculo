package Locadora.Service;

import Locadora.DB.VeiculoDB;
import Locadora.Model.Veiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class VeiculoServiceTest {

    @InjectMocks
    private VeiculoService veiculoService;

    @Mock
    private VeiculoDB veiculoDB;

    @Test
    public void testCadastraVeiculo() {
        //String modelo, String placa, Boolean disponivel
        Veiculo veiculo = new Veiculo("modelo", "123abc", true);

        Mockito.when(veiculoDB.cadastrarVeiculo(Mockito.any())).thenReturn(veiculo);

        Veiculo retorno = veiculoService
                .cadastrarVeiculo("modelo", "123abc", true);

        Assertions.assertEquals("modelo", retorno.getModelo());
        Assertions.assertEquals("123abc", retorno.getPlaca());
        Assertions.assertTrue(true);

    }
    @Test
    public void testCadastraVeiculoModeloNull() {
        Veiculo retorno = veiculoService.cadastrarVeiculo(null, "123abc", true);
        Assertions.assertNull(retorno);
    }
    @Test
    public void testCadastraVeiculoPlacaNull() {
        Veiculo retorno = veiculoService.cadastrarVeiculo("modelo", null, true);
        Assertions.assertNull(retorno);
    }
    @Test
    public void testCadastraVeiculoNaoDisponível() {
        Veiculo retorno = veiculoService.cadastrarVeiculo("modelo", "123abc", false);
        Assertions.assertNull(retorno);
    }

    @Test
    public void testListaVeiculo() {

        List<Veiculo> veiculos = new ArrayList<>();
        veiculos.add(new Veiculo("modelo 1", "1", true));
        veiculos.add(new Veiculo("modelo 2", "2", true));

        Mockito.when(veiculoDB.listVeiculos()).thenReturn(veiculos);
        List<Veiculo> lista = veiculoService.listaVeiculo();
        Assertions.assertEquals(2, lista.size());
        Assertions.assertFalse(lista.isEmpty());
        Assertions.assertEquals("1", lista.get(0).getPlaca());
        Assertions.assertEquals("2", lista.get(1).getPlaca());
    }
    @Test
    public void testListVeiculosVazio() {

        Mockito.when(veiculoDB.listVeiculos()).thenReturn(new ArrayList<>());

        List<Veiculo> lista = veiculoService.listaVeiculo();
        Assertions.assertEquals(0, lista.size());
        Assertions.assertTrue(lista.isEmpty());

    }
    @Test
    public void testBuscaVeiculos(){

            Veiculo veiculo = new Veiculo("modelo 1", "placa", true);
            Mockito.when(veiculoDB.buscaVeiculo("placa")).thenReturn(veiculo);
            Veiculo retorno = veiculoService.buscaVeiculo("placa");
            Assertions.assertEquals("modelo 1", retorno.getModelo());
            Assertions.assertEquals("placa", retorno.getPlaca());
            Assertions.assertTrue(true);

    }



}
