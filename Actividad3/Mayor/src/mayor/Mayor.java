/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mayor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mayor extends JFrame implements ActionListener {

    private JLabel label;
    private JTextField inputField;
    private JButton submitButton;
    private JTextArea outputArea;
    private JScrollPane scrollPane;

    public Mayor() {
        // configurar la ventana
        setTitle("Encontrar el Mayor Valor");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // configurar los componentes de la GUI
        label = new JLabel("Ingrese la cantidad de números:");
        inputField = new JTextField(10);
        submitButton = new JButton("Ingresar");
        outputArea = new JTextArea(3,20);
        outputArea.setEditable(false);
        scrollPane = new JScrollPane(outputArea);

        // configurar el layout y agregar componentes
        setLayout(new FlowLayout());
        add(label);
        add(inputField);
        add(submitButton);
        add(scrollPane);

        // agregar un listener al botón
        submitButton.addActionListener(this);

        // hacer visible la ventana
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            // obtener la cantidad de números ingresados
            int numCount = Integer.parseInt(inputField.getText());

            // crear un arreglo para almacenar los números
            int[] numbers = new int[numCount];

            // solicitar los números y encontrar el mayor valor
            int maxValue = 0;
            for (int i = 0; i < numCount; i++) {
                int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número #" + (i + 1)));
                numbers[i] = num;
                if (num > maxValue) {
                    maxValue = num;
                }
            }

            // mostrar el resultado
            outputArea.setText("El mayor valor es: " + maxValue);
        }
    }

    public static void main(String[] args) {
        new Mayor();
    }
}

