

package registro_professores;
import java.util.Scanner;


public class login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(resposta != 3){
            System.out.println("login professor");
            System.out.println("deseja realizar o login com email ou cpf?");
            System.out.println(" 1. logar com cpf \n 2. logar com email \n 3. sair");
            int resposta = sc.nextInt();
            System.out.println("");

        }


    }
}
