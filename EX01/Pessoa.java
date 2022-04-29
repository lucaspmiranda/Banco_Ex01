package EX01;

import java.util.Scanner;

public abstract class Pessoa {
    
    private String Rua, Bairro, Cidade;
    private int Numero;
    
    public abstract void Cadastrar(Scanner scan);
    
    public abstract void Listar();

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }
       
}
