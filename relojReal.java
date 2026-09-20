import java.util.Scanner;
public class relojReal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int horas;
        int minutos;
        int segundos;

        System.out.println("Introduce tu hora exacta");
        System.out.println("-------------------------------");
        System.out.println("horas");
        horas = input.nextInt();
        System.out.println("minutos");
        minutos = input.nextInt();
        System.out.println("Segundos");
        segundos = input.nextInt();
        System.out.println("-------------------------------");
        while (true) {
            if (horas <= 23 && minutos <= 59 && segundos <= 59){
                if (horas >= 0 && minutos >= 0 && segundos >=0) {
                    if (horas == 23){
                    if (minutos == 59){
                        if (segundos == 59){
                            horas = 0;
                            minutos = 0;
                            segundos = 0;
                            System.out.println(horas + ":" + minutos + ":" + segundos);
                        } else {
                            segundos = segundos + 1;
                            System.out.println(horas + ":" + minutos + ":" + segundos);
                        }
                    } else {
                        if (segundos == 59){
                            segundos = 0;
                            minutos = minutos + 1;
                            System.out.println(horas + ":" + minutos + ":" + segundos);
                        } else {
                            segundos = segundos + 1;
                            System.out.println(horas + ":" + minutos + ":" + segundos);
                        }
                    }
                } else {
                    if (minutos == 59 && segundos == 59){
                        minutos = 0;
                        segundos = 0;
                        horas = horas + 1;
                        System.out.println(horas + ":" + minutos + ":" + segundos);
                    } else if (segundos == 59) {
                        minutos = minutos + 1;
                        segundos = 0;
                        System.out.println(horas + ":" + minutos + ":" + segundos);
                    } else {
                        segundos = segundos + 1;
                        System.out.println(horas + ":" + minutos + ":" + segundos);
                    }
                }
                }
            } else {
                System.out.println("Error, valor incorrecto");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }    
    }
}
