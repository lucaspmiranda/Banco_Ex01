package EX01;

import java.util.Scanner;

public interface Conta {
    
    public abstract void Cadastrar(Scanner scan, int pessoa);
    public abstract void Deposito(float valor);
    public abstract void Exibir(int i);
    public abstract void ExibirSaldo();
    public abstract void Saque(float valor);
    public abstract boolean VerificarAcesso(int num, int senha);
    
}
