package EX01;

import java.util.Scanner;

public class Juridica extends Pessoa {
    
    public static void limparBuffer(Scanner scan)
    {
        if(scan.hasNextLine())
        {
            scan.nextLine();
        }
    }
    
    private String RzSocial, CNPJ, DtAbert;
    
    @Override
    public void Cadastrar(Scanner scan)
    {
        System.out.println("\nDigite os Dados da Pessoa Juridica");
        System.out.println("Razao Social: ");
        RzSocial = scan.nextLine();
        System.out.println("CNPJ: ");
        CNPJ = scan.nextLine();
        System.out.println("Data de Abertura: ");
        DtAbert = scan.nextLine();
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
        System.out.println("Pessoa Juridica");
        System.out.println("Razao Social: " +RzSocial);
        System.out.println("CNPJ: " +CNPJ);
    }
        
}
