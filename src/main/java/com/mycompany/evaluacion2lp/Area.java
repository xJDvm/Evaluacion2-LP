package com.mycompany.evaluacion2lp;

public class Area {

    private static void validarCampos(String valor1, String valor2, String valor3) {
        // Puedes ajustar la lógica de validación según tus necesidades
        if (valor1 == null || valor1.isEmpty() || (valor2 != null && valor2.isEmpty())
                || (valor3 != null && valor3.isEmpty())) {
            throw new IllegalArgumentException("Error: Todos los campos requeridos deben tener valores.");
        }
    }

    public static double calcularArea(String figuraSeleccionada, String[] valores) {
        double resultado = 0;
        FigurasGeometricas figura = null;

        switch (figuraSeleccionada) {
            case "Cuadrado":
                validarCampos(valores[0], null, null);
                figura = new Cuadrado(Double.parseDouble(valores[0]));
                resultado = figura.area();
                break;

            case "Triangulo":
                validarCampos(valores[0], valores[1], valores[2]);
                figura = new Triangulo(
                        Double.parseDouble(valores[0]),
                        Double.parseDouble(valores[1]),
                        Double.parseDouble(valores[2]));
                resultado = figura.area();
                break;

            case "Rectangulo":
                validarCampos(valores[0], valores[1], null);
                figura = new Rectangulo(
                        Double.parseDouble(valores[0]),
                        Double.parseDouble(valores[1]));
                resultado = figura.area();
                break;

            case "Paralelogramo":
                validarCampos(valores[0], valores[1], null);
                figura = new Paralelogramo(
                        Double.parseDouble(valores[0]),
                        Double.parseDouble(valores[1]));
                resultado = figura.area();
                break;

            case "Rombo":
                validarCampos(valores[0], null, null);
                figura = new Rombo(
                        Double.parseDouble(valores[0]));
                resultado = figura.area();
                break;

            case "Cometa":
                validarCampos(valores[0], valores[1], null);
                figura = new Cometa(
                        Double.parseDouble(valores[0]),
                        Double.parseDouble(valores[1]));
                resultado = figura.area();
                break;

            case "Trapecio":
                validarCampos(valores[0], valores[1], valores[2]);
                figura = new Trapecio(
                        Double.parseDouble(valores[0]),
                        Double.parseDouble(valores[1]),
                        Double.parseDouble(valores[2]));
                resultado = figura.area();
                break;

            case "Circulo":
                validarCampos(valores[0], null, null);
                figura = new Circulo(
                        Double.parseDouble(valores[0]));
                resultado = figura.area();
                break;

            case "Poligono Regular":
                validarCampos(valores[0], valores[1], valores[2]);
                figura = new PoligonoRegular(
                        Double.parseDouble(valores[0]),
                        Double.parseDouble(valores[1]),
                        Double.parseDouble(valores[2]));
                resultado = figura.area();
                break;

            case "Corona Circular":
                validarCampos(valores[0], valores[1], null);
                figura = new CoronaCircular(
                        Double.parseDouble(valores[0]),
                        Double.parseDouble(valores[1]));
                resultado = figura.area();
                break;

            case "Sector Circular":
                validarCampos(valores[0], valores[1], null);
                figura = new SectorCircular(
                        Double.parseDouble(valores[0]),
                        Double.parseDouble(valores[1]));
                resultado = figura.area();
                break;

            default:
                throw new IllegalArgumentException("Figura no reconocida");
        }

        return resultado;
    }
}
