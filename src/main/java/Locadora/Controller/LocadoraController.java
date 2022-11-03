package Locadora.Controller;

import Locadora.Model.Veiculo;
import Locadora.Service.VeiculoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class LocadoraController {

    private VeiculoService veiculoService = new VeiculoService();

    @GetMapping("/veiculo")
    public List<Veiculo> listVeiculos() {
        return veiculoService.listaVeiculo();

    }
    @PostMapping("/veiculo")
    public Veiculo cadastrarVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoService.cadastrarVeiculo(veiculo.getModelo(),
                veiculo.getPlaca(), veiculo.getDisponivel());

    }

}
