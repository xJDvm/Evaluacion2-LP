package com.mycompany.evaluacion2lp;

public interface FigurasGeometricas {
    double area();

    double perimetro();

    double volumen();

    public static String[] obtenerNombresFiguras() {
        return new String[] {
                "Cuadrado", "Triangulo", "Rectangulo", "Paralelogramo", "Rombo",
                "Cometa", "Trapecio", "Circulo", "Poligono Regular", "Corona Circular",
                "Sector Circular", "Cubo", "Cilindro", "Ortoedro", "Prisma Recto", "Cono",
                "Tronco de Cono", "Esfera", "Piramide", "Tetraedro Regular", "Octaedro Regular",
                "Tronco de Piramide", "Casquete Esferico", "Cuña Esferica", "Segmento Esferico"
        };
    }

    String obtenerInstrucciones();
}

class Cuadrado implements FigurasGeometricas {
    double a;

    public Cuadrado(double a) {
        this.a = a;
    }

    public double area() {
        return a * a;
    }

    public double perimetro() {
        return 4 * a;
    }

    public double volumen() {
        return 0;
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para el cuadrado: <br> El valor A = lado.</html>";
    }
}

class Triangulo implements FigurasGeometricas {
    double a, b, c;

    Triangulo(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        double semiperimetro = (a + b + c) / 2;
        return Math.sqrt(semiperimetro * (semiperimetro - a) * (semiperimetro - b) * (semiperimetro - c));
    }

    public double perimetro() {
        return a + b + c;
    }

    public double volumen() {
        return 0;
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para el triangulo: <br> Los valores a, b y c, corresponden a cada lado del triangulo";
    }
}

class Rectangulo implements FigurasGeometricas {
    double a, b;

    Rectangulo(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {
        return (a * b);
    }

    public double perimetro() {
        return 2 * (b + a);
    }

    public double volumen() {
        return 0;
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para el rectangulo: <br> Los valores a y b corresponden a los lados.";
    }
}

class Paralelogramo implements FigurasGeometricas {
    double a, b;

    Paralelogramo(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {
        double altura = Math.sqrt(a * a - (b / 2) * (b / 2));
        return (altura * b);
    }

    public double perimetro() {
        return 2 * (b + a);
    }

    public double volumen() {
        return 0;
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para el paralelogramo: <br> Solo utiliza los valores a y b";
    }
}

class Rombo implements FigurasGeometricas {
    double a;

    Rombo(double a) {
        this.a = a;
    }

    public double area() {
        double diagonal1 = 2 * Math.sqrt(a * a - (a / 2) * (a / 2));
        double diagonal2 = 2 * Math.sqrt(a * a - (a / 2) * (a / 2));
        return (diagonal1 * diagonal2) / 2;
    }

    public double perimetro() {
        return 4 * a;
    }

    public double volumen() {
        return 0;
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para el rombo: <br> Solo se utiliza el valor de a";
    }
}

class Cometa implements FigurasGeometricas {
    double a, b;

    Cometa(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {
        double theta = Math.acos((b * b - a * a) / (2 * a * b));
        double diagonalMayor = Math.sqrt(a * a + b * b + 2 * a * b * Math.cos(theta));
        double diagonalMenor = Math.sqrt(a * a + b * b - 2 * a * b * Math.cos(theta));
        return (diagonalMayor * diagonalMenor) / 2;
    }

    public double perimetro() {
        return 2 * (b + a);
    }

    public double volumen() {
        return 0;
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para el cometa: <br> Solo utiliza el valor de a y b";
    }
}

class Trapecio implements FigurasGeometricas {
    double a, b, c;

    Trapecio(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double h = Math.sqrt(b * b - Math.pow((c - a) / 2, 2));
        return (a + c) * h / 2;
    }

    public double perimetro() {
        double h = Math.sqrt(b * b - Math.pow((c - a) / 2, 2));
        return h + a + b + c;
    }

    public double volumen() {
        return 0;
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para el trapecio: <br> Utiliza los valores a, b y c.";
    }

}

class Circulo implements FigurasGeometricas {
    double a;

    Circulo(double a) {
        this.a = a;
    }

    public double area() {
        return (Math.PI) * (a * a);
    }

    public double perimetro() {
        return 2 * (Math.PI) * a;
    }

    public double volumen() {
        return 0;
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para el circulo: <br> El valor A corresponde al radio.";
    }
}

class PoligonoRegular implements FigurasGeometricas {
    double a, b;

    PoligonoRegular(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {
        double perimetro = 6 * b;
        return (perimetro * a) / 2;
    }

    public double perimetro() {
        return 6 * b;
    }

    public double volumen() {
        return 0;
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para el poligono regular: <br> El valor A representa la apotema. <br> El valor b representa el tamaño de los lados.";
    }
}

class CoronaCircular implements FigurasGeometricas {
    double a, b;

    CoronaCircular(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {
        return Math.PI * ((a * a) - (b * b));
    }

    @Override
    public double perimetro() {
        return 0;
    }

    public double volumen() {
        return 0;
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para la corona circular: <br> El valor A representa el radio externo <br> El valor B representa el radio interno";
    }
}

class SectorCircular implements FigurasGeometricas {
    double a, b;

    SectorCircular(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {
        return (Math.PI * (a * a) * b) / 360;
    }

    @Override
    public double perimetro() {
        return 0;
    }

    public double volumen() {
        return 0;
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para el sector circular: <br> El valor A representa el radio <br> El valor b representa el ángulo.";
    }

}

// INICIO DE FIGURAS CON VOLUMENES

class Cubo implements FigurasGeometricas {
    double a;

    public Cubo(double a) {
        this.a = a;
    }

    public double area() {
        return 6 * (a * a);
    }

    public double volumen() {
        return a * a * a;
    }

    public double perimetro() {
        return 0;
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para el cubo: <br> El valor A representa la longitud de los lados";
    }
}

class Cilindro implements FigurasGeometricas {
    double a;
    double b;

    public Cilindro(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {
        return (2 * (Math.PI)) * (a * (b + a));
    }

    public double volumen() {
        return Math.PI * (a * a) * b;
    }

    public double perimetro() {
        return 0;
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para el cilindro: <br> El valor A representa el radio. <br> El valor B representa la altura.";
    }
}

class Ortoedro implements FigurasGeometricas {
    double a, b, c;

    Ortoedro(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        return 2 * ((a * b) + (a * c) + (b * c));
    }

    public double perimetro() {
        return 0;
    }

    public double volumen() {
        return a * b * c;
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para el ortoedro: <br> El valor A representa el ancho <br> El valor B representa el largo <br> El valor C representa la altura.";
    }
}

class PrismaRecto implements FigurasGeometricas {
    double a, b, c;

    PrismaRecto(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        double areabase = a * b;
        double arealateral = 2 * (a + b) * c;
        return 2 * areabase + arealateral;
    }

    public double perimetro() {
        return 0;
    }

    public double volumen() {
        return a * b * c;
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para el prisma recto: <br> El valor A representa la longitud de la base <br> El valor B representa el ancho de la base <br> El valor C representa la altura del prisma.";
    }
}

class Cono implements FigurasGeometricas {
    double a, b, c;

    Cono(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        return (Math.PI * a) * (a + c);
    }

    public double perimetro() {
        return 0;
    }

    public double volumen() {
        return (Math.PI * (a * a) * b) / 3;
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para el cono: <br> El valor A representa el radio de la base. <br> El valor B representa la altura del cono <br> El valor C representa la generatriz del cono.";
    }
}

class TroncoDeCono implements FigurasGeometricas {
    double a, b, c;

    TroncoDeCono(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        double radiosuperior = (c * c) / (2 * a);
        return Math.PI * (c * (radiosuperior + a) + (radiosuperior * radiosuperior) + (a * a));
    }

    public double perimetro() {
        return 0;
    }

    public double volumen() {
        double radiosuperior = (c * c) / (2 * a);
        return (Math.PI * b * ((a * a) + (radiosuperior * radiosuperior) + a * radiosuperior)) / 3;
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para el tronco de cono: <br> El valor A representa el radio de la base. <br> El valor B representa la altura del cono <br> El valor C representa la generatriz del cono.";
    }
}

class Esfera implements FigurasGeometricas {
    double a;

    public Esfera(double a) {
        this.a = a;
    }

    public double area() {
        return 4 * Math.PI * (a * a);
    }

    public double perimetro() {
        return 0;
    }

    public double volumen() {
        return (4 * Math.PI * (a * a * a) / 3);
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para la esfera: <br> el valor A representa el Radio.";
    }

}

class Piramide implements FigurasGeometricas {
    double a, b, c;

    Piramide(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        double perimetrobase = 4 * a;
        return (perimetrobase * (a + b) / 2);
    }

    public double perimetro() {
        return 0;
    }

    public double volumen() {
        double areabase = a * a;
        return (areabase * c) / 3;
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para la piramide: <br> El valor A representa la longitud de la base <br> El valor B representa la longtitud de la base lateral <br> El valor C representa la altura de la piramide.";
    }
}

class TetraedroRegular implements FigurasGeometricas {
    double a;

    public TetraedroRegular(double a) {
        this.a = a;
    }

    public double area() {
        return Math.sqrt(3) * (a * a);
    }

    public double perimetro() {
        return 0;
    }

    public double volumen() {
        return (Math.sqrt(2) * (a * a * a) / 12);
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para el tetraedro regular: <br> El valor A representa la longitud del lado.";
    }
}

class OctaedroRegular implements FigurasGeometricas {
    double a;

    public OctaedroRegular(double a) {
        this.a = a;
    }

    public double area() {
        return 2 * Math.sqrt(3) * (a * a);
    }

    public double perimetro() {
        return 0;
    }

    public double volumen() {
        return (Math.sqrt(2) * (a * a * a) / 3);
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para el octaedro regular: <br> El valor A representa la longitud del lado.";
    }

}

class TroncoDePiramide implements FigurasGeometricas {
    double a, b, c;

    TroncoDePiramide(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        double apotema = Math.sqrt(a / Math.sqrt(3)); // Apotema asumida
        return a + b + Math.sqrt(a * b) + 2 * apotema * Math.sqrt((a - b) + c * c);
    }

    public double perimetro() {
        return 0;
    }

    public double volumen() {
        return (a + b + Math.sqrt(a * b)) * c / 3;
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para el tronco de piramide: <br> El valor A representa el area de la base inferior <br> El valor B representa el area de la base superior <br> El valor C representa la altura de la figura.";
    }
}

class CasqueteEsferico implements FigurasGeometricas {
    double a, b;

    CasqueteEsferico(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {
        return ((2 * Math.PI) * a * b);
    }

    public double perimetro() {
        return 0;
    }

    public double volumen() {
        return (Math.PI * (b * b) * ((3 * a) - b)) / 3;
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para el casquete esferico: <br> El valor A representa el radio <br> El valor b representa la altura del casquete.";
    }
}

class CunaEsferica implements FigurasGeometricas {
    double a, b;

    CunaEsferica(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {
        return ((4 * Math.PI) * (a * a) * b) / 360;
    }

    public double perimetro() {
        return 0;
    }

    public double volumen() {
        return ((4 * Math.PI) * (a * a * a) * b) / (3 * 360);
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para la cuña esferica: <br> El valor A representael radio <br> El valor B representa el ángulo.";
    }
}

class SegmentoEsferico implements FigurasGeometricas {
    double a, b, c;

    SegmentoEsferico(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        return ((2 * Math.PI) * a * b);
    }

    public double perimetro() {
        return 0;
    }

    public double volumen() {
        double radiosuperior = Math.sqrt(c * c + Math.pow(a + b, 2));
        return (Math.PI * b * ((b * b) + (3 * (b * b)) + (3 * (radiosuperior * radiosuperior)))) / 6;
    }

    public String obtenerInstrucciones() {
        return "<html>Instrucciones para el segmento esferico: <br> El valor A representa la altura del segmento <br> El valor B representa la altura dentro del segmento <br> El valor C representa el radio inferior. <br>La formula de radio superior se calcula como: <br> R=√(c^2+(a+b)^2)";
    }

}