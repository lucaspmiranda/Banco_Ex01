package EX01;

import java.util.Scanner;

public class Banco {
    
    private int NumBanco, aux_Corrente = 0, aux_Poupanca =0;
    private String Agencia;
    private ContaPoupanca[] Poupanca;
    private ContaCorrente[] Corrente;
    
    public void IniciarBanco()
    {
        Corrente = new ContaCorrente[10];
        Poupanca = new ContaPoupanca[10];
    }
    
    public void AbreCorrente(Scanner scan, int pessoa)
    {
        if(aux_Corrente == 10)
        {
            System.out.println("\nChegou ao limite de cadastros!");
        }
        else
        {
            ContaCorrente corrente = new ContaCorrente();
            corrente.Cadastrar(scan, pessoa);
            Corrente[aux_Corrente] = corrente;
            aux_Corrente++;
        }
    }
    
    public void AbrePoupanca(Scanner scan, int pessoa)
    {
        if(aux_Poupanca == 10)
        {
           System.out.println("\nChegou ao limite de cadastros!");
        }
        else
        {
            ContaPoupanca poupanca = new ContaPoupanca();
            poupanca.Cadastrar(scan, pessoa);
            Poupanca[aux_Poupanca] = poupanca;
            aux_Poupanca++;
        }
    }
    
    public void ListarCorrentistas()
    {
        for(int i = 0; i<aux_Corrente; i++)
        {
            Corrente[i].Exibir(i);
        }
    }
    
    public void ListarPoupantes()
    {
        for(int i = 0; i<aux_Poupanca; i++)
        {
            Poupanca[i].Exibir(i);
        }
    }
    
    public Conta BuscarConta(int tipo, int num, int senha)
    {
        Conta conta;
        
        if(tipo == 1)
        {
            for(int i = 0; i<aux_Corrente; i++)
            {
                if(Corrente[i].VerificarAcesso(num, senha))
                {
                    conta = Corrente[i];
                    return conta;
                }
            }
            
            return null;
        }
        else
        {
            for(int i = 0; i<aux_Poupanca; i++)
            {
                if(Poupanca[i].VerificarAcesso(num, senha))
                {
                    conta = Poupanca[i];
                    return conta;
                }
            }
            
            return null;
            
        }
    }
    
    public void FecharBanco()
    {
        Corrente = null;
        Poupanca = null;
        
    }
    
    //Métodos Acessores
    
    public ContaCorrente getContaCorrente(int indice)
    {
        return Corrente[indice];
    }
    
    public ContaPoupanca getContaPoupanca(int indice)
    {
        return Poupanca[indice];
    }
    
    //Método Construtor
    
    public Banco()
    {
        IniciarBanco();
    }
}
