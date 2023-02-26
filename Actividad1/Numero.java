public class Numero {
    public static void main(String[] args) {
        int numero,cuadrado,cubo;

        System.out.println("Ingrese un numero: ");
        Scanner entrada= new Scanner(System.in);
        numero = entrada.nextInt();

        cuadrado = numero*numero;
        cubo =cuadrado*numero;

        System.out.println("El cuadrado es: " + cuadrado);
        System.out.println("El cubo es: " + cubo);
    }
}