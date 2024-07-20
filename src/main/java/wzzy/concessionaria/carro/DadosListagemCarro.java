package wzzy.concessionaria.carro;

import wzzy.concessionaria.model.CarroModel;

public record DadosListagemCarro(

        int codigo,
        String nome,
        Double preco,
        String modelo,
        String cor,
        int ano,
        Marca marca) {

    public DadosListagemCarro(CarroModel carroModel) {
        this(carroModel.getCodigo(),
             carroModel.getNome(),
             carroModel.getPreco(),
             carroModel.getModelo(),
             carroModel.getCor(),
             carroModel.getAno(),
             carroModel.getMarca());
    }
}
