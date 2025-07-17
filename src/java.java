import java.util.ArrayList;
import java.util.Scanner;

class Usuario {
    String user;
    String senha;

    // Construtore para juntar as informações em um objeto
    Usuario(String user, String senha) {
        // This significa "este registro"
        this.user = user;
        this.senha = senha;
    }

    // Função para mostrar informações de usuário
    // void significa "Sem retorno"
    void mostrarUsuario() {
        System.out.println("--------------------------------------------");
        System.out.println("------ Cadastro realizado com sucesso ------");
        System.out.println("--------------------------------------------");
        System.out.println("Usuario: " + this.user);
        System.out.println("Senha: " + this.senha);
    }

    // Função para retornar verdadeiro ou falso
    // Vendo se o login foi digitado corretamente para acessar a conta
    boolean validarLogin(String userLogin, String senhaLogin) {
        return (this.user.equals(userLogin) && this.senha.equals(senhaLogin));
    }

    // Função com retorno - Para visulaizar informações
    public String getUser() {
        return user;
    }

    // Função sem retorno - para alterar informações
    public void setUser(String user) {
        this.user = user;
    }

    // Função com retorno - Para visulaizar informações
    public String getSenha() {
        return senha;
    }

    // Função sem retorno - para alterar informações
    public void setSenha(String senha) {
        this.senha = senha;
    }

}

class Produto {
    String nome;
    int estoque;

    Produto(String nome, int estoque) {
        this.nome = nome;
        this.estoque = estoque;
    }

    void mostrarProduto() {
        System.out.println("--------------------------------------------");
        System.out.println("----- Cadastro de produto com sucesso ------");
        System.out.println("--------------------------------------------");
        System.out.println("Produto: " + this.nome);
        System.out.println("Estoque: " + this.estoque);
    }

    // Função com retorno - Para visulaizar informações
    public String getNome() {
        return nome;
    }

    // Função sem retorno - para alterar informações
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Função com retorno - Para visulaizar informações
    public int getEstoque() {
        return estoque;
    }

    // Função sem retorno - para alterar informações
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}

class Cliente {
    String nome;
    String cpf;
    String contato;

    public Cliente(String nome, String cpf, String contato) {
        this.nome = nome;
        this.cpf = cpf;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
    
    
}

public class java {
    public static void main(String[] args) throws Exception {
        // Declarando scanner "sc" para poder receber informações digitadas
        Scanner sc = new Scanner(System.in);
        boolean verificacaoLogin = false;
        // ArrayList para podemos adicionar vários produtos no sistema
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        System.out.println("----------------------------------------------");
        System.out.println("------ Realizando cadastro de sua conta ------");
        System.out.println("----------------------------------------------");
        // Coletando dados do usuário - @ e senha
        System.out.println("Digite seu novo usuário");
        String user = sc.next();
        System.out.println("Digite sua nova senha");
        String senha = sc.next();
        // Chamando o construtor de Usuario para fazer o registro
        Usuario usuario = new Usuario(user, senha);
        // Chamando a função de mostrar as informações para o
        // usuário que acabou de ser cadastrado
        usuario.mostrarUsuario();
        // Adicionando repetição para várias tentativas de login
        while (true) {
            // Realizar validação de login
            System.out.println("------------------------------");
            System.out.println("------ Realizando login ------");
            System.out.println("-------------------------------");
            System.out.println("Digite seu nome de usuário: ");
            String userLogin = sc.next();
            System.out.println("Digite sua senha de acesso: ");
            String senhaLogin = sc.next();

            // Validação do login
            verificacaoLogin = usuario.validarLogin(userLogin, senhaLogin);
            if (verificacaoLogin) {
                System.out.println("Login realizado com sucesso");
                // Break para parar a repetição (apenas momentaneamente)
                break;
            } else {
                System.out.println("Cadastro inválido, Digite novamente: ");
            }
        }

        // Sistema para cadastro de produto
        while (verificacaoLogin) {
            System.out.println("----------------------------------------------");
            System.out.println("--------- Acesso ao sistema realizado --------");
            System.out.println("----------------------------------------------");
            System.out.println("Digite 1 para acessar o módulo produto");
            System.out.println("Digite 2 para para acessar o módulo Cliente");
            System.out.println("Digite 3 para sair");
            int opcaoMenu1 = sc.nextInt();
            if (opcaoMenu1 == 1){
                // Módulo Produto
                System.out.println("Digite 1 para cadastrar produto");
                System.out.println("Digite 2 para alterar o estoque de um produto");
                System.out.println("Digite 3 para excluir um produto");
                System.out.println("Digite 4 para visualizar todo o estoque");
                System.out.println("Digite 5 para sair do sistema");
                int opcao = sc.nextInt();
                // Adicionar opção de excluir produto
                if (opcao == 1) {
                    System.out.println("----------------------------------------------");
                    System.out.println("------- Realizando cadastro de produto -------");
                    System.out.println("----------------------------------------------");
                    // Coletando dados do usuário - @ e senha
                    System.out.println("Digite o nome do produto");
                    String nome = sc.next();
                    System.out.println("Digite a quantidade do estoque");
                    int estoque = sc.nextInt();
                    // Chamando o construtor de Produto para fazer o registro
                    Produto produto = new Produto(nome, estoque);
                    produto.mostrarProduto();
                    listaProdutos.add(produto);
                } else if (opcao == 2) {
                    System.out.println("----------------------------------------------");
                    System.out.println("-------- Alterando estoque de produto --------");
                    System.out.println("----------------------------------------------");
                    // O indice é para mostrar qual o número do produto que vamos acessar
                    int indiceProduto = 1;
                    for (Produto produto : listaProdutos) {
                        System.out.println("----------------------------------------------");
                        System.out.println("Produto " + indiceProduto + ": ");
                        produto.mostrarProduto();
                        indiceProduto += 1;
                        System.out.println("----------------------------------------------");
                    }
                    System.out.println("Digite o número do produto que você deseja alterar");
                    int codigoProduto = sc.nextInt();
                    indiceProduto = 1;
                    for (Produto produto : listaProdutos) {
                        if (indiceProduto == codigoProduto) {
                            System.out.println("Quantos produtos agora temos em estoque?");
                            int estoqueNovo = sc.nextInt();
                            produto.setEstoque(estoqueNovo);
                        }
                        indiceProduto += 1;
                    }
                    System.out.println("Estoque alterado com sucesso");
                } else if (opcao == 3) {
                    System.out.println("----------------------------------------------");
                    System.out.println("-------------- Excluir um produto ------------");
                    System.out.println("----------------------------------------------");
                    // O indice é para mostrar qual o número do produto que vamos acessar
                    int indiceProduto = 1;
                    for (Produto produto : listaProdutos) {
                        System.out.println("----------------------------------------------");
                        System.out.println("Produto " + indiceProduto + ": ");
                        produto.mostrarProduto();
                        indiceProduto += 1;
                        System.out.println("----------------------------------------------");
                    }
                    System.out.println("Digite o número do produto que você deseja alterar");
                    int codigoProduto = sc.nextInt();
                    codigoProduto -= 1;
                    listaProdutos.remove(codigoProduto);
                    System.out.println("Produto removido com sucesso");
                } else if (opcao == 4) {
                    System.out.println("----------------------------------------------");
                    System.out.println("--------- Listando todos os produtos ---------");
                    System.out.println("----------------------------------------------");
                    for (Produto produto : listaProdutos) {
                        produto.mostrarProduto();
                    }
                } else {
                    System.out.println("Saindo do programa...");
                    break;
                }
            }else if (opcaoMenu1 == 2){
                // Módulo cliente
                System.out.println("Digite 1 para cadastrar cliente");
                System.out.println("Digite 2 para visualizar todos os clientes");
                System.out.println("Digite 3 para voltar ao início");
                int opcaoCliente = sc.nextInt();
                if(opcaoCliente == 1){
                    System.out.println("Digite seu nome");
                    String nomeCliente = sc.next();
                    System.out.println("Digite seu CPF");
                    String cpfCliente = sc.next();
                    System.out.println("Digite seu telefone");
                    String telefone = sc.next();
                    Cliente cliente = new Cliente(nomeCliente, cpfCliente, telefone);
                    listaClientes.add(cliente);
                    System.out.println("------ Cliente cadastrado com sucesso ------");
                }else if(opcaoCliente == 2){
                    System.out.println("----------------------------------------------");
                    System.out.println("--------- Listando todos os clientes ---------");
                    System.out.println("----------------------------------------------");
                    for (Cliente cliente : listaClientes) {
                        System.out.println("Nome: " + cliente.getNome());
                        System.out.println("CPF: " + cliente.getCpf());
                        System.out.println("Contato: " + cliente.getContato());
                    }
                }else if(opcaoCliente == 3){
                    System.out.println("Voltando ao início...");
                }
            }
            
        }
    }
}