import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class PrimeNumber implements Runnable{

    private static Server server;

    static {
        try {
            server = new Server(7000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        try {
            // Aguarda conexão na porta 7000
            Socket socket = this.server.acceptConnection();

            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            Message message = (Message) input.readObject();

            if (message.getPrimeNumber()) {
                System.out.println("Client - O número " + message.getNumber() + " é primo!!");
            } else {
                System.out.println("Client - O número " + message.getNumber() + " não é primo!!");
            }

            input.close();

            Server.closeSocket(socket);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
