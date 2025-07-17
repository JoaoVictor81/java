

import java.util.Scanner;


public class login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int resposta = 0;

        while(resposta != 3){
            System.out.println("login professor");
            System.out.println("deseja realizar o login com email ou cpf?");
            System.out.println(" 1. logar com cpf \n 2. logar com email \n 3. sair");
            resposta = sc.nextInt();
            System.out.println("");

        }


    }
}
