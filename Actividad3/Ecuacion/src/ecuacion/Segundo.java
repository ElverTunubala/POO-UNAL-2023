/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecuacion;

public class Segundo{
    private double a;
    private double b;
    private double c;
    
    public Segundo(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public double[] calcularSoluciones() {
        double discriminante = Math.pow(b, 2) - 4 * a * c;
        double[] soluciones = new double[2];
        
        if (discriminante < 0) {
            soluciones[0] = Double.NaN;
            soluciones[1] = Double.NaN;
        } else if (discriminante == 0) {
            soluciones[0] = (-b) / (2 * a);
            soluciones[1] = Double.NaN;
        } else {
            soluciones[0] = (-b + Math.sqrt(discriminante)) / (2 * a);
            soluciones[1] = (-b - Math.sqrt(discriminante)) / (2 * a);
        }
        return soluciones;
    }
}
