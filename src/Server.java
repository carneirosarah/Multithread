import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;

    public Server(int port) throws IOException {

        this.serverSocket = new ServerSocket(port);
    }

    public Socket acceptConnection () throws IOException {

        return this.serverSocket.accept();
    }

    public static void closeSocket (Socket socket) {

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {

            Server server = new Server(5000);
            System.out.println("Server - Aguardando Conexão na porta 5000 ...");

            // Dispacher
            while (true) {

                Socket socket = server.acceptConnection();
                System.out.println("Server - Cliente Conectado");

                // cria um worker
                Thread worker = new Thread(new Worker(socket));
                worker.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
