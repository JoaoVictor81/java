package App;

class Professor{
    String nome_p;
    String cpf;
    String email;
    String senha;
    
    public Professor(String nome_p, String cpf, String email, String senha){
        this.nome_p = nome_p;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }
    void mostrarProfessor(){
        System.out.println("------------------------------");
        System.out.println("------Cadastro realizado------");
        System.out.println("------------------------------");
        System.out.println("nome: " + this.nome_p);
        System.out.println("cpf: "+ this.cpf);
        System.out.println("email: "+this.email);
        System.out.println("senha: " + this.senha);
    }

    

    public String getNome_p(){
        return nome_p;
    }
    public String getCpf(){
        return cpf;
    }
    public String getEmail(){
        return email;
    }
    public String getSenha(){
        return senha;
    }
    
    public void setNome_p(String nome_p){
        this.nome_p = nome_p;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
