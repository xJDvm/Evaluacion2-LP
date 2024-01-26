package com.mycompany.evaluacion2lp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private JTextField valorA, valorB, valorC;
    private JComboBox<String> comboBox1, comboBox2;
    private JButton calcularButton, limpiarButton;
    private JLabel resultadoLabel;
    private JPanel imagePanel;
    private JSeparator separator;

    public GUI() {
        // Configuración de la ventana
        setTitle("Calculadora Avanzada");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creación de componentes
        valorA = new JTextField(15);
        valorB = new JTextField(15);
        valorC = new JTextField(15);

        comboBox1 = new JComboBox<>(new String[] { "Area", "Perímetro", "Volumen" });

        comboBox2 = new JComboBox<>(FigurasGeometricas.obtenerNombresFiguras());

        calcularButton = new JButton("Calcular");
        limpiarButton = new JButton("Limpiar");

        resultadoLabel = new JLabel("Resultado:");
        resultadoLabel.setHorizontalAlignment(JLabel.CENTER);

        separator = new JSeparator(JSeparator.VERTICAL);

        // Configuración del panel izquierdo
        JPanel panelIzquierdo = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panelIzquierdo.add(new JLabel("Valor A:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panelIzquierdo.add(valorA, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelIzquierdo.add(new JLabel("Valor B:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panelIzquierdo.add(valorB, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panelIzquierdo.add(new JLabel("Valor C:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panelIzquierdo.add(valorC, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panelIzquierdo.add(new JLabel("Calculo:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panelIzquierdo.add(comboBox1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panelIzquierdo.add(new JLabel("Figura Geometrica:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panelIzquierdo.add(comboBox2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panelIzquierdo.add(new JLabel(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        panelIzquierdo.add(calcularButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        panelIzquierdo.add(limpiarButton, gbc);

        // Configuración del panel derecho
        imagePanel = new JPanel();
        // Añade aquí la lógica para cargar y mostrar una imagen
        // imagePanel.add(new JLabel(new ImageIcon("ruta_de_la_imagen")));

        // Configuración del panel principal que contiene la imagen y la línea
        // separadora
        JPanel panelDerecho = new JPanel(new BorderLayout());
        panelDerecho.add(imagePanel, BorderLayout.CENTER);

        // Configuración del panel principal que contiene los paneles izquierdo y
        // derecho
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(panelIzquierdo, BorderLayout.WEST);
        mainPanel.add(panelDerecho, BorderLayout.EAST);

        // Configuración del panel inferior con la línea separadora y los resultados
        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.add(separator, BorderLayout.CENTER);
        panelInferior.add(resultadoLabel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });

        // Configuración del ActionListener para el botón "Limpiar"
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
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

                System.out.println("perimetroseleccinado");
            }

            else {
                // Add logic for other calculations if needed
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

    // public void validarCampos(String figuraSeleccionada, JTextField... campos) {
    // if (figuraSeleccionada.equals("Cuadrado")) {
    // if (!campos[0].getText().isEmpty()) {
    // return; // Campo válido para el Cuadrado
    // } else {
    // throw new IllegalArgumentException(
    // "Error: El primer campo debe estar lleno para el cálculo del cuadrado.");
    // }
    // } else {
    // for (JTextField campo : campos) {
    // if (!campo.getText().isEmpty()) {
    // continue; // Campo válido para otras figuras
    // } else {
    // throw new IllegalArgumentException(
    // "Error: Todos los campos deben estar llenos para esta figura geométrica.");
    // }
    // }
    // }
    // }
    // private void calculer() {
    // String calculoSeleccionado = (String) comboBox1.getSelectedItem();
    // String figuraSeleccionada = (String) comboBox2.getSelectedItem();

    // if ("Area".equals(calculoSeleccionado)) {
    // try {
    // double resultado = 0;
    // FigurasGeometricas figura = null;

    // switch (figuraSeleccionada) {
    // case "Cuadrado":
    // validarCampos(valorA);
    // asignarImagen(figuraSeleccionada);
    // // Crear un objeto Cuadrado con el valor de 'a'
    // figura = new Cuadrado(Double.parseDouble(valorA.getText()));
    // // Llamar al método area sin argumentos
    // resultado = figura.area();
    // break;

    // case "Triangulo":
    // validarCampos(valorA, valorB, valorC);
    // asignarImagen(figuraSeleccionada);
    // figura = new Triangulo(
    // Double.parseDouble(valorA.getText()),
    // Double.parseDouble(valorB.getText()),
    // Double.parseDouble(valorC.getText()));
    // resultado = figura.area();
    // break;

    // case "Rectangulo":
    // validarCampos(valorA, valorB);
    // asignarImagen(figuraSeleccionada);
    // figura = new Rectangulo(
    // Double.parseDouble(valorA.getText()),
    // Double.parseDouble(valorB.getText()));
    // resultado = figura.area();
    // break;

    // case "Paralelogramo":
    // validarCampos(valorA, valorB);
    // asignarImagen(figuraSeleccionada);
    // figura = new Paralelogramo(
    // Double.parseDouble(valorA.getText()),
    // Double.parseDouble(valorB.getText()));
    // resultado = figura.area();
    // break;

    // case "Rombo":
    // validarCampos(valorA);
    // asignarImagen(figuraSeleccionada);
    // figura = new Rombo(
    // Double.parseDouble(valorA.getText()));
    // resultado = figura.area();
    // break;

    // case "Cometa":
    // validarCampos(valorA, valorB);
    // asignarImagen(figuraSeleccionada);
    // figura = new Cometa(
    // Double.parseDouble(valorA.getText()),
    // Double.parseDouble(valorB.getText()));
    // resultado = figura.area();
    // break;

    // case "Trapecio":
    // validarCampos(valorA, valorB, valorC);
    // asignarImagen(figuraSeleccionada);
    // figura = new Trapecio(
    // Double.parseDouble(valorA.getText()),
    // Double.parseDouble(valorB.getText()),
    // Double.parseDouble(valorC.getText()));

    // // Llamar al método area sin argumentos
    // resultado = figura.area();
    // break;

    // case "Circulo":
    // validarCampos(valorA);
    // asignarImagen(figuraSeleccionada);
    // figura = new Circulo(
    // Double.parseDouble(valorA.getText()));
    // resultado = figura.area();
    // break;

    // default:
    // resultadoLabel.setText("Figura no reconocida");
    // return;
    // }

    // resultadoLabel.setText("Resultado: " + resultado);
    // } catch (NumberFormatException ex) {
    // resultadoLabel.setText("Error: Ingresa valores numéricos válidos.");
    // } catch (IllegalArgumentException ex) {
    // resultadoLabel.setText(ex.getMessage());
    // }
    // } else {
    // // Agrega lógica para otros cálculos si es necesario
    // resultadoLabel.setText("Resultado: ");
    // }
    // }

    // public void validarCampos(JTextField... campos) {
    // for (JTextField campo : campos) {
    // if (campo.getText().isEmpty()) {
    // throw new IllegalArgumentException(
    // "Error: Todos los campos deben estar llenos para esta figura geométrica.");
    // }
    // }
    // }

    private void limpiar() {
        valorA.setText("");
        valorB.setText("");
        valorC.setText("");
        comboBox1.setSelectedIndex(0); // Restablece la selección de "Area"
        comboBox2.setSelectedIndex(0); // Restablece la selección de "Cuadrado"
        resultadoLabel.setText("Resultado: ");
    }
}
