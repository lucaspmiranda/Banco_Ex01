package EX01;

import java.util.Scanner;

public class Principal {
    
    public static void main(String args[])
    {
        int menu;
        Banco banco = new Banco();
        Scanner scan = new Scanner(System.in);
        
        do{
            menu = exibirMenu(scan);
            
            switch(menu)
            {
                case 1:
                {
                    acessarAtendente(scan, banco);
                    break;
                }
                case 2:
                {
                    acessarCliente(scan, banco);
                    break;
                }
                case 0:
                {
                    banco.FecharBanco();
                    System.out.println("Programa Finalizado!");
                    break;
                }
                default:
                {
                    System.out.println("Opcao Inexistente!");
                }
            }
        }while(menu!=0);
        
    }
    
    public static void limparBuffer(Scanner scan)
    {
        if(scan.hasNextLine())
        {
            scan.nextLine();
        }
    }
    
    public static int exibirMenu(Scanner scan)
    {
        System.out.println("\n------------------------------");
        System.out.println("ESTAMOS EM UM BANCO");
        System.out.println("Selecione sua funcao!");
        System.out.println("1- Atendente");
        System.out.println("2 - Cliente");
        System.out.println("0 - SAIR");
        System.out.println("------------------------------");
        
        int menu = scan.nextInt();
        limparBuffer(scan);
        
        return menu;
        
    }
    
    public static void acessarAtendente(Scanner scan, Banco banco)
    {
        int menu, pessoa;
        
        do{
            System.out.println("\n------------------------------");
            System.out.println("ATENDENTE");
            System.out.println("1 - Cadastrar Conta Corrente");
            System.out.println("2 - Cadastrar Conta Poupanca");
            System.out.println("3 - Listar Correntistas");
            System.out.println("4 - Listar Poupantes");
            System.out.println("0 - Voltar");
            System.out.println("------------------------------");
            
            menu = scan.nextInt();
            limparBuffer(scan);
            
            switch(menu)
            {
                case 1:
                {
                    pessoa = informarTipoPessoa(scan);
                    
                    if(pessoa == 1 || pessoa == 2)
                    {
                        banco.AbreCorrente(scan, pessoa);
                    }
                    else if(pessoa != 0)
                        System.out.println("\nOpcao Inexistente");
                }
                break;
                
                case 2:
                {
                    pessoa = informarTipoPessoa(scan);
                    
                    if(pessoa == 1 || pessoa == 2)
                    {
                        banco.AbrePoupanca(scan, pessoa);
                    }
                    else if(pessoa != 0)
                    {
                        System.out.println("\nOpcao Inexistente!");
                    }
                break;
                }
                
                case 3:
                {
                    System.out.println("\nLista de Correntistas: ");
                    banco.ListarCorrentistas();
                    break;
                }
                
                case 4:
                {
                    System.out.println("\nLista de Poupantes: ");
                    banco.ListarPoupantes();
                    break;
                }
                
                case 0:
                {
                    System.out.println("\nVoce saiu do perfil do Atendente!");
                }
                
                default:
                {
                    System.out.println("\nOpcao Inexistente!");
                    break;
                }
            }
        }while(menu!=0);
    }
    
    public static int informarTipoPessoa(Scanner scan)
    {
        System.out.println("\n------------------------------");
        System.out.println("CLIENTE");
        System.out.println("Selecione o tipo de pessoa!");
        System.out.println("1 - Pessoa Fisica");
        System.out.println("2 - Pessoa Juridica");
        System.out.println("0 - Voltar");
        System.out.println("------------------------------");
        
        int menu = scan.nextInt();
        limparBuffer(scan);
        
        return menu;
    }
    
    public static void acessarCliente(Scanner scan, Banco banco)
    {
        int tipo, numero, senha;
        Conta conta;
        
        tipo = informarTipoConta(scan);
        
        if(tipo == 1 || tipo == 2)
        {
            System.out.println("\nDigite os dados solicitados!");
            
            System.out.println("Numero da conta: ");
            numero = scan.nextInt();
            limparBuffer(scan);
            
            System.out.println("Numero da senha: ");
            senha = scan.nextInt();
            limparBuffer(scan);
            
            conta = banco.BuscarConta(tipo, numero, senha);
            
            if(conta != null)
            {
                exibirMenuCliente(scan, conta);
            }
            else
            {
                System.out.println("\nConta nao cadastrada!");
            }
        }
        else if(tipo != 0)
        {
            System.out.println("\nOpcao Inexistente!");
        }
                
    }
    
    public static void exibirMenuCliente(Scanner scan, Conta conta)
    {
        int menu;
        
        do{
            System.out.println("\n------------------------------");
            System.out.println("CONTA");
            System.out.println("1 - Deposito");
            System.out.println("2 - Saque");
            System.out.println("3 - Saldo");
            System.out.println("0 - Voltar");
            System.out.println("------------------------------");
            
            menu = scan.nextInt();
            limparBuffer(scan);
            
            switch(menu)
            {
                case 1:
                {
                    System.out.println("\nDigite o valor do deposito - R$ ");
                    float valor = scan.nextFloat();
                    conta.Deposito(valor);
                    break;
                }
                case 2:
                {
                    System.out.println("Digite o valor do saque - R$ ");
                    float valor = scan.nextFloat();
                    conta.Saque(valor);
                    break;
                }
                case 3:
                {
                    conta.ExibirSaldo();
                    break;
                }
                case 0:
                {
                    System.out.println("\nFim da operacao!");
                    break;
                }
                default:
                {
                    System.out.println("\nOpcao Inexistente");
                    break;
                }
            }
            
            
        }while(menu!=0);
    }
    
    public static int informarTipoConta(Scanner scan)
    {
        int menu;
        
        System.out.println("\n------------------------------");
        System.out.println("Selecione o tipo da conta!");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupanca");
        System.out.println("0 - Voltar");
        System.out.println("------------------------------");
        
        menu = scan.nextInt();
        limparBuffer(scan);
        
        if(menu == 0)
        {
            System.out.println("\nVoce saiu do perfil do cliente!");
        }
        else if(menu > 2 && menu <0)
        {
            System.out.println("\nOpcao Inexistente");
        }
        
        return menu;
    }
    
}
