package EX01;

import java.util.Scanner;

public class ContaCorrente implements Conta {
    
    public static void limparBuffer(Scanner scan)
    {
        if(scan.hasNextLine())
        {
            scan.nextLine();
        }
    }
    
    private Pessoa Correntista;
    private int num, senha;
    private float saldo, limite;
    
    @Override
    public void Deposito(float valor)
    {
        saldo+=valor;
        System.out.println("\nValor Deposito: R$" +valor);
    }
    
    @Override
    public void Saque(float valor)
    {
        if(valor>(saldo + limite))
        {
            System.out.println("Saldo Insuficiente!");
        }
        else
        {
            this.saldo -= valor;
            System.out.println("Valor Saque: R$" +valor);
        }
    }
    
    @Override
    public void ExibirSaldo()
    {
        System.out.println("Saldo: " +saldo);   
    }
    
    @Override
    public void Cadastrar(Scanner scan, int pessoa)
    {
        if(pessoa == 1)
        {
            Correntista = new Fisica();
            Correntista.Cadastrar(scan);
        }
        else
        {
            Correntista = new Juridica();
            Correntista.Cadastrar(scan);
        }
        
        System.out.println("\nDigite os dados da conta correte");
        System.out.println("Numero da Conta:");
        num = scan.nextInt();
        limparBuffer(scan);
        System.out.println("Senha da Conta:");
        senha = scan.nextInt();
        limparBuffer(scan);
        System.out.println("Saldo - R$ ");
        saldo = scan.nextFloat();
        System.out.println("Limite - R$ ");
        limite = scan.nextFloat();
              
    }
    
    @Override
    public void Exibir(int i)
    {
        System.out.println("\n------------------------------");
        System.out.println("Dados da Conta Corrente "+(i+1));
        Correntista.Listar();
        System.out.println("Numero da conta: " +num);
        System.out.println("------------------------------");
    
    }
    
    @Override
    public boolean VerificarAcesso(int num, int senha)
    {
        return(this.num == num && this.senha==senha);
    }
    
    
}
