import java.util.Random;
import java.util.Scanner;
public class proyect1 {
    private static volatile boolean running = true;
    public static void main(String[] args){
        System.out.print("\033[2J\033[?25h");
        Thread renderThread = new Thread( () -> {
            Random random = new Random();
            while (running) {
                int x = random.nextInt(2);
                int y = random.nextInt(2);
                System.out.print("\033[1;1H\033[2K");
                System.out.print("=== Iniciando Juego de Monedas ===");
                System.out.print("\033[2;1H\033[2K");
                if (x == 0 && y == 0) {
                System.out.println("Cara | Cara");
            } else if (x == 0 && y == 1) {
                System.out.println("Cara | Cruz");
            } else if (x == 1 && y == 0) {
                System.out.println("Cruz | Cara");
            } else {
                System.out.println("Cruz | Cruz");
            }

            System.out.print("\033[4;1H>> ");
            System.out.flush();
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
        });
        renderThread.start();
        Scanner scanner = new Scanner(System.in);
        while (running) {
            String command = scanner.nextLine();
            if ("the end".equalsIgnoreCase(command.trim())) {
                running = false;
                renderThread.interrupt();
            }
        }
        System.out.print("\033[?25h\033[5;1H\nPrograma finalizado con éxito.\n");
        scanner.close();
    }
}
