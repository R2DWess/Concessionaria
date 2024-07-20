package wzzy.concessionaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wzzy.concessionaria.carro.DadosCadastrarCarro;
import wzzy.concessionaria.model.CarroModel;
import wzzy.concessionaria.service.CarroRepository;
import wzzy.concessionaria.service.CarroServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private CarroServiceImpl carroServiceImpl;

    @PostMapping
    public ResponseEntity<?> cadastrarCarro(@RequestBody CarroModel carroModel) {
        return carroServiceImpl.cadastrarCarro(carroModel);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return carroServiceImpl.listar();
    }

    @GetMapping("/listar/{codigo}")
    public ResponseEntity<?> listarPorCarro(@PathVariable int codigo) {
        return carroServiceImpl.listarPorCarro(codigo);
    }

    @PatchMapping("/editar")
    public ResponseEntity<?> editar(@RequestBody CarroModel carroModel) {
        return carroServiceImpl.editarDadosCarro(carroModel);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> remover(@PathVariable int codigo) {
        return carroServiceImpl.removerCarro(codigo);
    }

    @DeleteMapping("/desativar/{codigo}")
    public void inativar(@PathVariable int codigo) {
        var carroModel = carroRepository.getReferenceById(codigo);
        carroModel.excluir();
    }

    @PostMapping("/cadastrar/varios")
    public ResponseEntity<?> cadastrarVarios(@RequestBody List<DadosCadastrarCarro> carrosList) {
        return carroServiceImpl.cadastrarVarios(carrosList);
    }
}
