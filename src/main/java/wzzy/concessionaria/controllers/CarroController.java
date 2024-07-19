package wzzy.concessionaria.controllers;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wzzy.concessionaria.model.CarroModel;
import wzzy.concessionaria.model.Mensagem;
import wzzy.concessionaria.service.CarroRepository;
import wzzy.concessionaria.service.CarroServiceImpl;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private Mensagem mensagem;
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private CarroServiceImpl carroServiceImpl;

    @PostMapping
    public ResponseEntity<?> cadastrarCarro(@RequestBody CarroModel carroModel){
        return carroServiceImpl.cadastrarCarro(carroModel);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return carroServiceImpl.listar();
    }

    @GetMapping("/listar/{codigo}")
    public ResponseEntity<?> ListarPorCarro(@PathVariable int codigo){
        return carroServiceImpl.listarPorCarro(codigo);
    }

    @PatchMapping("/editar")
    public ResponseEntity<?> editar(@RequestBody CarroModel carroModel){
        return carroServiceImpl.editarDadosCarro(carroModel);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> remover(@PathVariable int codigo){
        return carroServiceImpl.removerCarro(codigo);
    }
}
