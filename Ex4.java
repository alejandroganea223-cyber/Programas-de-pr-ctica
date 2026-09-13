import java.util.Scanner;
public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce número 1: ");
        int number1 = scanner.nextInt();
        System.out.println("Introduce número 2: ");
        int number2 = scanner.nextInt();
        
        System.out.println("""
            Introduce un opción segun el signo:
            1: +
            2: -
            3: /
            4: *
        
        """);
        int operation = scanner.nextInt();
        System.out.println("----------------------------------------------------");
        switch (operation) {
            case 1:
                System.out.println(number1 + number2);
                break;
            case 2:
                System.out.println(number1 - number2);
                break;
            case 3:
                System.out.println(number1 / number2);
                break;
            case 4:
                System.out.println(number1 * number2);
                break;
            default:
                System.out.println("Error, intentalo de nuevo");
                break;
        }
        scanner.close();

    }
}
