package EX01;

import java.util.Scanner;

public class Fisica extends Pessoa {
    
    public static void limparBuffer(Scanner scan)
    {
        if(scan.hasNextLine())
        {
            scan.nextLine();
        }
    }
    
    private String Nome, CPF, DtNasc;
    
    @Override
    public void Cadastrar(Scanner scan)
    {
        System.out.println("\nDigite os Dados da Pessoa Fisica");
        System.out.println("Nome: ");
        Nome = scan.nextLine();
        System.out.println("CPF: ");
        CPF = scan.nextLine();
        System.out.println("Data de Nascimento: ");
        DtNasc = scan.nextLine();
        System.out.println("Rua: ");
        setRua(scan.nextLine());
        System.out.println("Numero: ");
        setNumero(scan.nextInt());
        limparBuffer(scan);
        System.out.println("Bairro: ");
        setBairro(scan.nextLine());
        System.out.println("Cidade: ");
        setCidade(scan.nextLine());
        
    }
    
    @Override
    public void Listar()
    {
        System.out.println("Pessoa Fisica");
        System.out.println("Nome: " +Nome);
        System.out.println("CPF: " +CPF);
    }
    
}
