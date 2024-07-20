package wzzy.concessionaria.carro;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCarro(

        @NotNull
        int codigo,
        String nome,
        String modelo,
        String cor,
        Double preco,
        int ano
) {
}
