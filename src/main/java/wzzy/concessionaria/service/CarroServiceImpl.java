package wzzy.concessionaria.service;

import jakarta.persistence.Id;
import org.jetbrains.annotations.NotNull;
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

    public ResponseEntity<?> cadastrarCarro(@NotNull CarroModel carro) {
        if (carro.getNome().isEmpty()) {
            mensagem.setMensagem("O nome do carro precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);

        } else if (carro.getModelo().isEmpty()) {
            mensagem.setMensagem("O modelo precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);

        } else if (carro.getAno() < 0) {
            mensagem.setMensagem("O ano precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);

        } else if (carro.getCor().isEmpty()) {
            mensagem.setMensagem("A cor precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);

        } else if (carro.getPreco() == null) {
            mensagem.setMensagem("A preco do carro precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(carroRepository.save(carro), HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> listar() {
        return new ResponseEntity<>(carroRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> listarPorCarro(int codigo) {
        if (carroRepository.countByCodigo(codigo) == 0) {
            mensagem.setMensagem("Código inválido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(carroRepository.findByCodigo(codigo), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> editarDadosCarro(@NotNull CarroModel carroModel) {
        if (carroModel.getNome().isEmpty()) {
            mensagem.setMensagem("O nome do carro precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);

        } else if (carroModel.getModelo().isEmpty()) {
            mensagem.setMensagem("O modelo precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);

        } else if (carroModel.getAno() < 0) {
            mensagem.setMensagem("O ano precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);

        } else if (carroModel.getCor().isEmpty()) {
            mensagem.setMensagem("A cor precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);

        } else if (carroModel.getPreco() == null) {
            mensagem.setMensagem("A preco do carro precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(carroRepository.save(carroModel), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> removerCarro(int codigo) {
        if (carroRepository.countByCodigo(codigo) == 0) {
            mensagem.setMensagem("O código informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        } else {
            CarroModel carroModel = carroRepository.findByCodigo(codigo);
            carroRepository.delete(carroModel);
            mensagem.setMensagem("Pessoa removida com sucesso");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }
}
