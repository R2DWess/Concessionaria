package wzzy.concessionaria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import wzzy.concessionaria.carro.DadosAtualizacaoCarro;
import wzzy.concessionaria.carro.DadosCadastrarCarro;
import wzzy.concessionaria.carro.Marca;

@Entity
@Table(name = "carros")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class CarroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String nome;
    private Double preco;
    private String modelo;
    private String cor;
    private int ano;

    @Enumerated(EnumType.STRING)
    private Marca marca;

    private Boolean ativo;

    public CarroModel(DadosCadastrarCarro carro) {

        this.marca = carro.marca();
        this.preco = carro.preco();
        this.modelo = carro.modelo();
        this.cor = carro.cor();
        this.ano = carro.ano();
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoCarro carro){
        if (carro.nome()!= null) {
            this.nome = carro.nome();
        }
        if (carro.modelo() != null) {
            this.modelo = carro.modelo();
        }
        if (carro.cor() != null) {
            this.cor = carro.cor();
        }
        if (carro.preco() != null) {
            this.preco = carro.preco();
        }
        if (carro.ano() < 0){
            this.ano = carro.ano();
            }
        }

        public void excluir(){
        this.ativo = false;
    }

}
