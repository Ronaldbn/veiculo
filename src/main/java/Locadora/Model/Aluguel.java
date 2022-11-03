package Locadora.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluguel {

    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;
    private boolean veiculoAlugado;
    private double valorAluguel;
    private List<VeiculoAlugado> carros = new ArrayList<>();

    // dataEmprestimo, dataDevolucao e o veiculo alugado.
}
