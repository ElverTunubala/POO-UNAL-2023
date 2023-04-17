/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universidad;

public class Estudiante {
    private int numeroInscripcion;
    private String nombres;
    private double patrimonio;
    private int estratoSocial;

    public Estudiante(int numeroInscripcion, String nombres, double patrimonio, int estratoSocial) {
        this.numeroInscripcion = numeroInscripcion;
        this.nombres = nombres;
        this.patrimonio = patrimonio;
        this.estratoSocial = estratoSocial;
    }

    public double calcularPagoMatricula() {
        double pagoMatricula = 50000;

        if (patrimonio > 2000000 && estratoSocial > 3) {
            pagoMatricula += patrimonio * 0.03;
        }

        return pagoMatricula;
    }
}
