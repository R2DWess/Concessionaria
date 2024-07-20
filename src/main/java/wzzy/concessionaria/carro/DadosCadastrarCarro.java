package wzzy.concessionaria.carro;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastrarCarro(

        @NotBlank
        String nome,

        @NotNull
        Double preco,

        @NotBlank
        String modelo,

        @NotBlank
        String cor,

        @NotBlank
        @Pattern(regexp = "\\d{4}")
        int ano,

        @NotBlank
        @Valid
        Marca marca) {
}
