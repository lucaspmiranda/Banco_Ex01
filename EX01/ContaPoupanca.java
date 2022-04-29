package EX01;

import java.util.Scanner;

public class ContaPoupanca implements Conta {
    
    public static void limparBuffer(Scanner scan)
    {
        if(scan.hasNextLine())
        {
            scan.nextLine();
        }
    }
    
    private Pessoa Poupante;
    private int num, senha;
    private float saldo = 0;
    
    @Override
    public void Deposito(float valor)
    {
        saldo+=valor;
        System.out.println("\nValor Deposito: R$ " +valor);
        
    }
    
    @Override
    public void Saque(float valor)
    {
        this.saldo-=valor;
        System.out.println("\nValor Saque: R$ " +valor);
        
    }
    
    @Override
    public void ExibirSaldo()
    {
        System.out.println("\nSaldo: R$" +saldo);
    }
    
    @Override
    public void Cadastrar(Scanner scan, int tipo)
    {
        if(tipo == 1)
        {
            Poupante = new Fisica();
            Poupante.Cadastrar(scan);
        }
        else
        {
            Poupante = new Juridica();
            Poupante.Cadastrar(scan);
        }
        
        System.out.println("\nDigite os Dados da Conta Poupanca");
        System.out.println("Numero da Conta: ");
        num = scan.nextInt();
        limparBuffer(scan);
        System.out.println("Senha da Conta: ");
        senha = scan.nextInt();
        limparBuffer(scan);
        System.out.println("Saldo - R$ ");
        saldo = scan.nextFloat();
        
        
    }
    
    @Override
    public void Exibir(int i)
    {
        System.out.println("\n------------------------------");
        System.out.println("Dados da Conta Poupanca "+(i+1));
        Poupante.Listar();
        System.out.println("Numero da Conta: " +num);
        System.out.println("------------------------------");
    
    }
       
    @Override
    public boolean VerificarAcesso(int num, int senha)
    {
        return(this.num == num && this.senha==senha);
    }
    
}
