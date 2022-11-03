package Locadora.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {

    private String modelo;
    private String placa;
    private Boolean disponivel;

//    private Boolean verificaModeloDisponível() {
//        if (disponivel == true) { // VERIFICAR SE É POSSÍVEL FAZER A APLICAÇÃO
//
//
//        }
//
    }
    // modelo, placa e disponivel.

