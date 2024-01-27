package com.mycompany.evaluacion2lp;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private JTextField valorA, valorB, valorC;
    private JComboBox<String> comboBox1, comboBox2;
    private JButton calcularButton, limpiarButton;
    private JLabel resultadoLabel;
    private JPanel imagePanel;
    private JSeparator separator;

    public GUI() {
        setTitle("Calculadora - Juan Valdes");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        valorA = new JTextField(15);
        valorB = new JTextField(15);
        valorC = new JTextField(15);

        comboBox1 = new JComboBox<>(new String[] { "Area", "Perímetro", "Volumen" });

        comboBox2 = new JComboBox<>(FigurasGeometricas.obtenerNombresFiguras());

        calcularButton = new JButton("Calcular");
        limpiarButton = new JButton("Limpiar");

        resultadoLabel = new JLabel("Resultado:");
        resultadoLabel.setHorizontalAlignment(JLabel.CENTER);
        resultadoLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        separator = new JSeparator(JSeparator.VERTICAL);

        JPanel panelIzquierdo = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        String[] labels = { "Valor A:", "Valor B:", "Valor C:", "Calculo:", "Figura Geometrica:" };
        JTextField[] textFields = { valorA, valorB, valorC };
        int row = 0;

        for (int i = 0; i < labels.length && row < textFields.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = row++;
            panelIzquierdo.add(new JLabel(labels[i]), gbc);

            gbc.gridx = 1;
            panelIzquierdo.add(textFields[i], gbc);
        }

        gbc.gridx = 0;
        gbc.gridy = row++;
        panelIzquierdo.add(new JLabel("Calculo:"), gbc);

        gbc.gridx = 1;
        panelIzquierdo.add(comboBox1, gbc);

        gbc.gridx = 0;
        gbc.gridy = row++;
        panelIzquierdo.add(new JLabel("Figura Geometrica:"), gbc);

        gbc.gridx = 1;
        panelIzquierdo.add(comboBox2, gbc);

        gbc.gridx = 0;
        gbc.gridy = row++;
        gbc.gridwidth = 2;
        panelIzquierdo.add(new JLabel(), gbc);

        gbc.gridx = 0;
        gbc.gridy = row++;
        gbc.gridwidth = 2;
        panelIzquierdo.add(calcularButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = row++;
        gbc.gridwidth = 2;
        panelIzquierdo.add(limpiarButton, gbc);

        imagePanel = new JPanel();

        JLabel imagenLabel = new JLabel();
        imagenLabel.setIcon(new ImageIcon("src/main/java/com/mycompany/evaluacion2lp/img/cuadrado.jpg")); // Ajusta la
                                                                                                          // ruta y el
                                                                                                          // nombre de
                                                                                                          // tu imagen

        imagePanel.add(imagenLabel);

        JPanel panelDerecho = new JPanel(new BorderLayout());
        panelDerecho.add(imagePanel, BorderLayout.CENTER);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(panelIzquierdo, BorderLayout.WEST);
        mainPanel.add(panelDerecho, BorderLayout.EAST);

        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.add(separator, BorderLayout.CENTER);
        panelInferior.add(resultadoLabel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        calcularButton.addActionListener(e -> calcular());
        limpiarButton.addActionListener(e -> limpiar());
        comboBox2.addActionListener(e -> actualizarImagen());
        actualizarImagen();
    }

    private void calcular() {
        String calculoSeleccionado = (String) comboBox1.getSelectedItem();
        String figuraSeleccionada = (String) comboBox2.getSelectedItem();

        try {
            double resultado = 0;
            String[] valores = { valorA.getText(), valorB.getText(), valorC.getText() };

            if ("Area".equals(calculoSeleccionado)) {
                resultado = Area.calcularArea(figuraSeleccionada, valores);

            } else if ("Perímetro".equals(calculoSeleccionado)) {
                resultado = Perimetro.calcularPerimetro(figuraSeleccionada, valores);
                System.out.println("perimetroseleccinado");

            } else if ("Volumen".equals(calculoSeleccionado)) {
                resultado = Volumen.calcularVolumen(figuraSeleccionada, valores);
                System.out.println("volumenseleccioanado");
            }

            else {
                resultadoLabel.setText("Resultado: ");
                return;
            }

            resultadoLabel.setText("Resultado: " + resultado);
        } catch (NumberFormatException ex) {
            resultadoLabel.setText("Error: Ingresa valores numéricos válidos.");
        } catch (IllegalArgumentException ex) {
            resultadoLabel.setText(ex.getMessage());
        }
    }

    private void limpiar() {
        valorA.setText("");
        valorB.setText("");
        valorC.setText("");
        comboBox1.setSelectedIndex(0);
        comboBox2.setSelectedIndex(0);
        resultadoLabel.setText("Resultado: ");
    }

    private void actualizarImagen() {
        String figuraSeleccionada = (String) comboBox2.getSelectedItem();

        String rutaImagen = "src/main/java/com/mycompany/evaluacion2lp/img/" + figuraSeleccionada.toLowerCase()
                + ".jpg";

        ImageIcon nuevaImagen = new ImageIcon(rutaImagen);
        JLabel imagenLabel = new JLabel();
        imagenLabel.setIcon(nuevaImagen);

        imagePanel.removeAll();
        String instrucciones = Instrucciones.instruccionFigura(figuraSeleccionada);

        JLabel instruccionesLabel = new JLabel(instrucciones);
        instruccionesLabel.setHorizontalAlignment(JLabel.CENTER);

        instruccionesLabel.setBorder(BorderFactory.createEmptyBorder(10, 3, 3, 3));

        imagePanel.setLayout(new BorderLayout());
        imagePanel.add(instruccionesLabel, BorderLayout.NORTH);
        imagePanel.add(imagenLabel, BorderLayout.CENTER);

        imagePanel.revalidate();
        imagePanel.repaint();
    }
}
