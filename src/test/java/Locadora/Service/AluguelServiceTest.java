package Locadora.Service;

import Locadora.DB.AluguelDB;
import Locadora.Model.Aluguel;
import Locadora.Model.VeiculoAlugado;
import Locadora.Model.Veiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AluguelServiceTest {

    @InjectMocks
    private AluguelService aluguelService;

    @Mock
    private VeiculoService veiculoService;

    @Mock
    private AluguelDB aluguelDB;

    @Test
    public void testCadastrarPedido() {

        Veiculo veiculo = new Veiculo("Modelo", "placa", true);

        List<VeiculoAlugado> veiculos = new ArrayList<>();
        veiculos.add(new VeiculoAlugado("modelo 1", 100.0));
        veiculos.add(new VeiculoAlugado("modelo 2", 55.0));

        Mockito
                .when(veiculoService.buscaVeiculo("placa"))
                .thenReturn(veiculo);

        Mockito
                .when(aluguelDB.cadastrarAluguel(Mockito.any()))
                .thenReturn(new Aluguel(LocalDateTime.now(), LocalDateTime.now().plusDays(7), true, 50.0,veiculos));

        Aluguel aluguel = aluguelService.cadastrarAluguel(veiculo, veiculos);
        Assertions.assertEquals(2, aluguel.getCarros().size());
        Assertions.assertEquals("modelo", aluguel.getCarros().get(0).getModelo());
        Assertions.assertEquals(50.0, aluguel.getCarros().get(0).getPreco());
        Assertions.assertEquals(LocalDateTime.now().getDayOfWeek(), aluguel.getDataEmprestimo().getDayOfWeek());

    }

    @Test
    public void testCadastrarAluguelErroVeiculoNaoEncontrado() {
        Veiculo veiculo = new Veiculo(null, "1", true);

        Mockito
                .when(veiculoService.buscaVeiculo("1"))
                .thenReturn(null);

        List<VeiculoAlugado> carroAlugados = new ArrayList<>();
        carroAlugados.add(new VeiculoAlugado("modelo 1", 50.0));
        carroAlugados.add(new VeiculoAlugado("modelo 2", 55.0));

        Aluguel aluguel = aluguelService.cadastrarAluguel(veiculo, carroAlugados);
        Assertions.assertNull(aluguel);
    }

    @Test
    public void testCadastrarAluguelErroListaItensVazio() {
        Veiculo veiculo = new Veiculo("", "placa", true);

        Mockito
                .when(veiculoService.buscaVeiculo("1"))
                .thenReturn(veiculo);

        Aluguel aluguel = aluguelService.cadastrarAluguel(veiculo, null);
        Assertions.assertNull(aluguel);
    }




}
