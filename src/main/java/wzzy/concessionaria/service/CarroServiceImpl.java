package wzzy.concessionaria.service;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import wzzy.concessionaria.model.CarroModel;
import wzzy.concessionaria.model.Mensagem;

@Service
public class CarroServiceImpl {

    @Autowired
    private Mensagem mensagem;

    @Autowired
    private CarroRepository carroRepository;

    public ResponseEntity<?> cadastrarCarro(CarroModel carro) {
        if (carro.getNome().equals("")) {
            mensagem.setMensagem("O nome do carro precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);

        } else if (carro.getModelo().equals("")) {
            mensagem.setMensagem("O modelo precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);

        } else if (carro.getAno() < 0) {
            mensagem.setMensagem("O ano precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);

        } else if (carro.getCor().equals("")) {
            mensagem.setMensagem("A cor precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);

        } else if (carro.getPreco() == null || carro.getPreco().equals("")) {
            mensagem.setMensagem("O preco do carro precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (carro.getPreco().equals("") || carro.getPreco().equals("")) {
            mensagem.setMensagem("A preco do carro precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(carroRepository.save(carro), HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> listar(){
        return new ResponseEntity<>(carroRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> listarPorCarro(int codigo){
        if(carroRepository.countByCodigo(codigo) == 0) {
            mensagem.setMensagem("Código inválido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(carroRepository.findByCodigo(codigo), HttpStatus.OK);
        }
    }
}
