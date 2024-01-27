package com.mycompany.evaluacion2lp;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class AppJava extends JFrame {
    private JPanel leftPanel;
    private JPanel rightPanel;

    public AppJava() {
        setTitle("App Java");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI();
    }

    private void initUI() {
        // Configurar el panel izquierdo
        leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);

        // Configurar el panel derecho con una imagen
        rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());

        // Ruta relativa de la imagen desde el directorio de trabajo del proyecto
        String imagePath = "src/main/java/com/mycompany/evaluacion2lp/img/cuadrado.jpg";
        ImageIcon imageIcon = new ImageIcon(imagePath);
        JLabel imageLabel = new JLabel(imageIcon);
        rightPanel.add(imageLabel, BorderLayout.CENTER);

        // Configurar el diseño principal de la aplicación con BorderLayout
        setLayout(new BorderLayout());
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppJava app = new AppJava();
            app.setVisible(true);
        });
    }
}