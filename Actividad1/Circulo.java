import java.util.Scanner;
public class Circulo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a,r,l; // área,radio y longitud

        System.out.print("Introduce el radio de un circulo: ");
        r = sc.nextDouble();
        a=Math.PI*(r*r);
        l=Math.PI*(r+r);

        System.out.println("El área del circulo de radio " + r + " es: " + a);
        System.out.println("La longitud de la circunferencia es: " + l);
    }
}