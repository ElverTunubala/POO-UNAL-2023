/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleado;

public class Emplead {
    private int codigo;
    private String nombres;
    private int horasTrabajadas;
    private double valorHora;
    private double retencion;

    public Emplead(int codigo, String nombres, int horasTrabajadas, double valorHora, double retencion) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
        this.retencion = retencion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public double getRetencion() {
        return retencion;
    }

    public double calcularSalarioBruto() {
        return horasTrabajadas * valorHora;
    }

    public double calcularSalarioNeto() {
        double salarioBruto = calcularSalarioBruto();
        double retencion = salarioBruto * (this.retencion / 100);
        return salarioBruto - retencion;
    }
}

