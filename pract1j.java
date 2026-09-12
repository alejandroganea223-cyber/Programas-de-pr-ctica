import java.util.Scanner;

public class pract1j {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escribe cara o cruz: ");
        String x = scanner.nextLine();
        if(x.equals("cara")){
            System.out.println("Tu elección es cara");
        } else {
            System.out.println("Tu elección es cruz");
        }
    }
}
