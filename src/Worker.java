import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Worker implements Runnable {

    private Socket socket;

    public Worker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            int count = 0;
            Boolean flag = true;
            ObjectInputStream input = new ObjectInputStream(this.socket.getInputStream());

            Integer number = (Integer) input.readObject();
            System.out.println("Server - Mensagem Recebida: " + number );

            for (int i = 1; i < number; i ++) {

                if (count > 2) {

                    flag = false;
                    break;

                } else if (number % i == 0) {

                    count++;
                }
            }
            Message message = new Message(number, flag);

            Socket socket = new Socket("localhost", 7000);
            ObjectOutput output = new ObjectOutputStream(socket.getOutputStream());


            output.writeObject(message);
            output.flush();

            input.close();
            output.close();

        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();
        } finally {
            Server.closeSocket(socket);
            System.out.println("Server - Cliente Finalizado");
        }
    }
}
