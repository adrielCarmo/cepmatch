package model;

public class Endereco {
    public String rua;
    public String bairro;
    public String cidade;
    public String estado;
    public String cep;
    public int numero;

    public Endereco(EnderecoViaCEP endereco) {
        this.cep = endereco.cep();
        this.rua = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cidade = endereco.localidade();
        this.estado = endereco.uf();
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public int getNumero() {
        return numero;
    }
}
