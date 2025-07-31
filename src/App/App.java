
package App;
import java.util.ArrayList;
import java.util.Scanner;

class Menu{

    void menuPrincipal(){
        System.out.println("---------------------------");
        System.out.println("-----sistema da escola-----");
        System.out.println("---------------------------");
        System.out.println("o que deseja fazer?");
        System.out.println(" 1. realizar login como aluno \n 2. realizar login como professor \n 3. realizar login como administrador \n 4. sair");
    }

    void menuAdmin(){
        System.out.println("---------------------------");
        System.out.println("------login realizado------");
        System.out.println("---------------------------");
        System.out.println("---- menu administrador----");
        System.out.println("---------------------------");
        System.out.println("o que deseja fazer?");
        System.out.println(" 1. modulo aluno \n 2. modulo professor \n 3. voltar");
    }
    void menuAdminProfessor(){
        System.out.println("------------modulo professor------------");
        System.out.println("digite o que deseja fazer");
        System.out.println(" 1. realizar cadastro de professor \n 2. mostrar lista de professores \n 3. editar as dados de um professor \n 4. sair");
    }
    
}

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Professor> listaProfessores = new ArrayList<>();
    public static void main(String[] args) throws Exception {

    int respostaMenu = 0;
    Menu menu = new Menu();
    
        
        
        do{
            menu.menuPrincipal();
            respostaMenu = sc.nextInt();
            switch(respostaMenu){
                case 1:
                System.out.println("----login aluno----");


                break;
                case 2: 
                System.out.println("----login professor----");
                
                System.out.println("realizando login como professor");
                System.out.println("digite seu email e senha");
                System.out.print("email: ");
                String loginEmail = sc.next();
                System.out.print("senha: ");
                String loginSenha = sc.next();

                Professor professorLogado = fazerLoginProfessor(loginEmail, loginSenha);

                if (professorLogado != null){
                    System.out.println("login realizado");
                    System.out.println(professorLogado.getNome_p());
                }else{
                    System.out.println("email ou senha incorretos. tente novamente");
                }


                break;
                case 3:

                System.out.println("----login administrador----");
                System.out.print("user: ");
                String userAdmin = sc.next();
                System.out.print("senha: ");
                String senhaAdmin = sc.next();
                if(userAdmin.equals("admin") && senhaAdmin.equals("123")){

                    
                    int opcaoAdmin;
                    do{
                    menu.menuAdmin();
                    opcaoAdmin = sc.nextInt();
                    switch (opcaoAdmin){

                        case 1:
                            System.out.println("modulo aluno");
                            

                        break;

                        case 2:
                        menu.menuAdminProfessor();
                        int resposta = sc.nextInt();
                        
                        while(resposta == 1){
                            System.out.println("realizar o cadastro de um professor");
                            System.out.print("nome: ");
                            String nome_p = sc.next();
                            System.out.print("cpf: ");
                            String cpf = sc.next();
                            System.out.print("e-mail: ");
                            String email = sc.next();
                            System.out.print("senha: ");
                            String senha = sc.next();

                            Professor professor = new Professor(nome_p, cpf, email, senha);
                    
                            professor.mostrarProfessor();
                            listaProfessores.add(professor);

                            System.out.println("deseja adicionar outro professor?");
                            System.out.println(" 1. adicionar outro professor\n 2. voltar");
                            int repetir = sc.nextInt();
                            if (repetir == 1) {
                                resposta = 1;
                            }else{
                                resposta = 0;
                            }
                        }

                        if (resposta == 2) {
                            for (Professor professor : listaProfessores){
                                professor.mostrarProfessor();
                            }
                            resposta = 0;
                        }

                        while (resposta == 3) {
                            System.out.println("---editar informaçoes---");

                            int indiceProfessor = 1;
                            for (Professor professor : listaProfessores){
                                System.out.println("--------------------------------- ");
                                System.out.println("id: "+indiceProfessor);
                                professor.mostrarProfessor();
                                indiceProfessor += 1;
                                System.out.println("--------------------------------- ");
                            }
                            System.out.println("digite o id do professor que deseja editar");
                            int idProfessor = sc.nextInt();
                            
                            indiceProfessor = 1;
                            for (Professor professor : listaProfessores){
                                if(indiceProfessor == idProfessor){
                                    System.out.println("qual informaçao voce deseja editar");
                                    System.out.println(" 1. nome\n 2. cpf\n 3. email\n 4. senha");
                                    resposta = sc.nextInt();
                                    
                                    if (resposta == 1 ){
                                        System.out.println("digite o novo nome");
                                        String novoNome_p = sc.next();
                                        professor.setNome_p(novoNome_p);
                                    }else if(resposta == 2 ){
                                        System.out.println("digite o novo cpf");
                                        String novoCpf = sc.next();
                                        professor.setCpf(novoCpf);
                                    }else if(resposta == 3 ){
                                        System.out.println("digite o novo email");
                                        String novoEmail = sc.next();
                                        professor.setEmail(novoEmail);
                                    }else if(resposta == 4 ){
                                        System.out.println("digite a nova senha");
                                        String novoSenha = sc.next();
                                        professor.setSenha(novoSenha);
                                    }
                                }
                                indiceProfessor += 1;
                                resposta = 0;
                            }
                        }
                        
                        break;
                        
                        case 3:
                        System.out.println("voltar");
                        break;
                        default:
                        System.out.println("digite uma opcao valida");
                        break;
                    }}while(opcaoAdmin != 3);

                }else{
                    System.out.println("!!!erro usuario ou senha incorretos!!!");
                }
                break;
                case 4:
                System.out.println("saindo do sistema...");
                break;
                default:
                System.out.println("!!! erro digite um numero valido !!!");
            }
        }while(respostaMenu != 4);

        sc.close();
    }
     public static Professor fazerLoginProfessor(String email, String senha) {
        for (Professor professor : listaProfessores) {
            // Compara o email e a senha fornecidos com os do professor atual na lista
            if (professor.getEmail().equals(email) && professor.getSenha().equals(senha)) {
                return professor; // Retorna o objeto Professor se as credenciais forem válidas
            }
        }
        return null; // Retorna null se nenhum professor corresponder às credenciais
}}