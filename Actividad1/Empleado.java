public class Empleado {
    public static void main(String[] args) {
        int horas = 48;
        float valor_hora = 5000;
        float retencion = 0.125F; // porcentaje de la retención en la fuente (12.5%)

        // el salario bruto es igual al número de horas trabajadas por el valor de la hora.
        float salario_bruto = horas * valor_hora;

        // la retención en la fuente es igual al salario bruto por el porcentaje de retención en la fuente.
        float retencion_valor = salario_bruto * retencion;

        // el salario neto es igual al salario bruto menos la retencion en la fuente
        float salario_neto = salario_bruto - retencion_valor;

        System.out.println("El salario bruto es: " + salario_bruto);
        System.out.println("La retencion de fuente es: " + retencion_valor);
        System.out.println("El salario neto es: " + salario_neto);
    }
}