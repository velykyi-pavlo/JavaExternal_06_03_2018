package com.sorting.task1;

public class Task1 {

    public static void main(String[] args) {
	// write your code here
        FigureDraw[] figureDraws = {new Rectangle(15,4),
                            new RectangularTriangle(30,50),
                            new EquilateralTriangle(100),
                            new Rhomb(25,100)};

        for (FigureDraw f :
                figureDraws) {
            f.print();
        }

    }
}

interface FigureDraw {
    void print();
}

class Rectangle implements FigureDraw {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void print() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}

class RectangularTriangle implements FigureDraw {

    private double width;
    private double height;

    public RectangularTriangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void print() {
        double tanges =  width/height;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <= Math.ceil(i * tanges); j++) {
                 System.out.print("* ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}

class EquilateralTriangle implements FigureDraw {

    private double sideLength;
    private double heightTriangle;

    public EquilateralTriangle(double sideLength) {
        this.sideLength = sideLength;
        setHeightTriangle();
    }

    private void setHeightTriangle() {
        this.heightTriangle =  Math.ceil(this.sideLength
                                                * Math.cos(Math.PI / 6));
    }

    @Override
    public void print() {
        for (int i = 1; i <= heightTriangle; i++) {
            for (int j = 1; j <= sideLength; j++) {
                if (j > (sideLength / 2 - i * Math.tan(Math.PI / 6))
                        && j < (sideLength / 2 + i * Math.tan(Math.PI / 6))) {
                    System.out.print("* ");
                } else {
                    System.out.print(" ");
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }

    }
}

class Rhomb implements FigureDraw {

    private double width;
    private double height;

    public Rhomb(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void print() {
        for (int i = 1; i <= height / 2; i++) {
            for (int j = 1; j <= width; j++) {
                if (j > ( width / 2 - i *  width / height)
                        && j < (width / 2 + i *  width / height)) {
                    System.out.print("* ");
                } else {
                    System.out.print(" ");
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
        for (int i = 1; i <= (height - 1)/ 2; i++) {
            for (int j = 1; j <= width; j++) {
                if (j > ( width / 2 - ((height - 1)/ 2 - i ) *  width / height)
                        && j < (width / 2 + ((height - 1)/ 2 - i ) *  width / height)) {
                    System.out.print("* ");
                } else {
                    System.out.print(" ");
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }
}
