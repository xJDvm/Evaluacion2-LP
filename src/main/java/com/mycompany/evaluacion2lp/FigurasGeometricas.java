package com.mycompany.evaluacion2lp;

public interface FigurasGeometricas {
    double area();

    double perimetro();

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
}