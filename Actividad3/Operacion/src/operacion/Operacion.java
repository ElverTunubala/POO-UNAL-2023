/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package operacion;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class Operacion extends JFrame {
    private JPanel contentPane;
    private JLabel lblCantidadNumeros;
    private JTextField txtCantidadNumeros;
    private JButton btnIngresarNumeros;
    private JTable tblResultados;
    private DefaultTableModel modeloTabla;

    public Operacion() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Cálculo de Raíz Cuadrada, Cuadrado y Cubo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setResizable(false);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        setContentPane(contentPane);

        lblCantidadNumeros = new JLabel("Cantidad de números a ingresar:");
        txtCantidadNumeros = new JTextField(10);
        btnIngresarNumeros = new JButton("Ingresar números");
        btnIngresarNumeros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnIngresarNumerosActionPerformed(evt);
            }
        });

        JPanel panelCantidadNumeros = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelCantidadNumeros.add(lblCantidadNumeros);
        panelCantidadNumeros.add(txtCantidadNumeros);
        panelCantidadNumeros.add(btnIngresarNumeros);

        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Número");
        modeloTabla.addColumn("Raíz cuadrada");
        modeloTabla.addColumn("Cuadrado");
        modeloTabla.addColumn("Cubo");

        tblResultados = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tblResultados);

        contentPane.add(panelCantidadNumeros);
        contentPane.add(scrollPane);
    }

    private void btnIngresarNumerosActionPerformed(ActionEvent evt) {
        int cantidadNumeros = Integer.parseInt(txtCantidadNumeros.getText());

        modeloTabla.setRowCount(0);

        for (int i = 0; i < cantidadNumeros; i++) {
            String numero = JOptionPane.showInputDialog(this, "Ingrese el número " + (i + 1) + ":");
            int num = Integer.parseInt(numero);
            double raizCuadrada = Math.sqrt(num);
            int cuadrado = num * num;
            int cubo = num * num * num;

            modeloTabla.addRow(new Object[] {numero, String.format("%.2f", raizCuadrada), cuadrado, cubo});
        }
    }

    public static void main(String[] args) {
        Operacion frame = new Operacion();
        frame.setVisible(true);
    }
}
