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
                "Tronco de Piramide", "Casquete Esférico", "Cuña Esferica", "Segmento Esferico"
        };
    }
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
}

class PoligonoRegular implements FigurasGeometricas {
    double a, b, c;

    PoligonoRegular(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        double perimetro = c * b;
        return (perimetro * a) / 2;
    }

    public double perimetro() {
        return c * b;
    }

    public double volumen() {
        return 0;
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
}

class PrismaRecto implements FigurasGeometricas {
    double a, b, c;

    PrismaRecto(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        return 2 * (a * b + a * c + b * c);
    }

    public double perimetro() {
        return 0;
    }

    public double volumen() {
        return a * b * c;
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
}

class TroncoDeCono implements FigurasGeometricas {
    double a, b, c;

    TroncoDeCono(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        return Math.PI * (b * b + c * c + Math.sqrt((b - c) * (b + c) + a * a));
    }

    public double perimetro() {
        return 0;
    }

    public double volumen() {
        return (Math.PI * a / 3) * (b * b + b * c + c * c);
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
        return (Math.PI * b * ((b * b) + (3 * (b * b)) + (3 * (c * c)))) / 6;
    }
}