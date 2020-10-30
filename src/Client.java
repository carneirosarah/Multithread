import java.io.IOException;
import java.net.Socket;


public class Client {
    public static void main(String[] args) {

        try {

            while (true) {

                Socket socket = new Socket("localhost", 5000);

                // T1 - Gera um número aleatorio e envia para o servidor
                Thread numberGenarator = new Thread(new NumberGenerator(socket));
                numberGenarator.start();

                // T2 - Recebe a resposta do servidor (o número é ou não primo) e imprime na tela
                Thread isPrimeNumber = new Thread(new PrimeNumber());
                isPrimeNumber.start();
            }
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
