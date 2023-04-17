/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salario;

public class Empleado {
    private String nombre;
    private double salarioBasico;
    private double horasTrabajadas;
    
    public Empleado(String nombre, double salarioBasico, double horasTrabajadas) {
        this.nombre = nombre;
        this.salarioBasico = salarioBasico;
        this.horasTrabajadas = horasTrabajadas;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public double calcularSalarioMensual() {
        double salarioMensual = salarioBasico * horasTrabajadas;
        if (salarioMensual > 450000) {
            return salarioMensual;
        } else {
            return 0;
        }
    }
}