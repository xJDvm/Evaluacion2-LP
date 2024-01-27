package com.mycompany.evaluacion2lp;

public class Instrucciones {
    public static String instruccionFigura(String figuraSeleccionada) {
        String instrucciones = "";
        FigurasGeometricas figura = null;

        switch (figuraSeleccionada) {
            case "Cuadrado":
                figura = new Cuadrado(0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Triangulo":
                figura = new Triangulo(0, 0, 0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Rectangulo":
                figura = new Rectangulo(0, 0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Paralelogramo":
                figura = new Paralelogramo(0, 0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Rombo":
                figura = new Rombo(0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Cometa":
                figura = new Cometa(0, 0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Trapecio":
                figura = new Trapecio(0, 0, 0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Circulo":
                figura = new Circulo(0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Poligono Regular":
                figura = new PoligonoRegular(0, 0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Corona Circular":
                figura = new CoronaCircular(0, 0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Sector Circular":
                figura = new SectorCircular(0, 0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Cubo":
                figura = new Cubo(0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Cilindro":
                figura = new Cilindro(0, 0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Ortoedro":
                figura = new Ortoedro(0, 0, 0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Prisma Recto":
                figura = new PrismaRecto(0, 0, 0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Cono":
                figura = new Cono(0, 0, 0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Tronco de Cono":
                figura = new TroncoDeCono(0, 0, 0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Esfera":
                figura = new Esfera(0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Piramide":
                figura = new Piramide(0, 0, 0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Tetraedro regular":
                figura = new TetraedroRegular(0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Octaedro regular":
                figura = new OctaedroRegular(0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Tronco de Piramide":
                figura = new TroncoDePiramide(0, 0, 0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Casquete Esferico":
                figura = new CasqueteEsferico(0, 0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Cuña Esferica":
                figura = new CunaEsferica(0, 0);
                instrucciones = figura.obtenerInstrucciones();
                break;
            case "Segmento Esferico":
                figura = new SegmentoEsferico(0, 0, 0);
                instrucciones = figura.obtenerInstrucciones();
                break;

            default:
                instrucciones = "Figura no reconocida";
                break;
        }

        return instrucciones;
    }

}
