
import java.util.ArrayList;
import java.util.Scanner;

class Professor{
    String nome_p;
    int cpf;
    String email;
    String senha;
    
    Professor(String nome_p, int cpf, String email, String senha){
        this.nome_p = nome_p;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }
    void mostrarProfessor() {
        System.out.println("------------------------------");
        System.out.println("------Cadastro realizado------");
        System.out.println("------------------------------");
        System.out.println("nome: " + this.nome_p);
        System.out.println("cpf: "+ this.cpf);
        System.out.println("email: "+this.email);
        System.out.println("senha: " + this.senha);
    }

    public String getNome_p() {
        return nome_p;
    }
    public void setNome_p(String nome_p) {
        this.nome_p = nome_p;
    }
    
    public int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}


public class registro_professores {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<Professor> listaProfessores = new ArrayList<>();
        int resposta = 0;

        while(resposta != 4){
            System.out.println("------------editar informaçoes------------");
            System.out.println("digite o que deseja fazer");
            System.out.println(" 1. realizar cadastro de professor \n 2. mostrar lista de professores \n 3. editar as informaçoes de um professor \n 4. sair");
            resposta = sc.nextInt();
            
            while(resposta == 1){
                System.out.println("realizar o cadastro de um professor");
                System.out.print("nome: ");
                String nome_p = sc.next();
                System.out.print("cpf: ");
                int cpf = sc.nextInt();
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
                            int novoCpf = sc.nextInt();
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
        }

        
        
    }
}
