import java.util.Scanner;
public class Edadmama {
    public static void main(String[] args) {
        int edjuan, edana, edalberto, edmama;

        System.out.println("Ingrese su edad");
        Scanner entrada= new Scanner(System.in);
        edjuan = entrada.nextInt();
        
        edalberto = 2 * (edjuan/3);
        edana = 4 * (edjuan/3);
        edmama = edjuan+edalberto+edana;
        
        System.out.println("La edad de Alberto es: " + edalberto);
        System.out.println("La edad de Juan es: " + edjuan);
        System.out.println("La edad de Ana es: " + edana);
        System.out.println("La edad de la mama es: " + edmama);
    }
}