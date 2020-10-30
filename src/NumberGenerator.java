import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class NumberGenerator implements Runnable {

    private Socket socket;

    public NumberGenerator(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {

            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

            Random random = new Random();
            Integer number = random.nextInt(1000000);

            output.writeObject(number);
            output.flush();

            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
