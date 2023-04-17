/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comparar;

public class Valor {
    private double a;
    private double b;

    public Valor(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public String comparar() {
        if (a > b) {
            return "  A es mayor que B";
        } else if (a < b) {
            return "  A es menor que B";
        } else {
            return "  A es igual a B";
        }
    }
}

    

