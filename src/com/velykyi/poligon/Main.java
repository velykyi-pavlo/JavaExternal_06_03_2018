package com.velykyi.poligon;

import javax.swing.text.MutableAttributeSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Throwable {
        Point p1 = new Point(5,6);
        Point p2 = new Point(7,8);

        Point pl1 = new Point(1,2);
        Point pl2 = new Point(1,3);

        Line l1 = new Line(pl1, pl2);

        Triangle triangle = new Triangle(p1, pl2 ,p2);

        Poligon poligon = new Poligon(new Point(0,0), new Point(1,12), new Point(13,13), new Point(26,0), new Point(4, -34));

        poligon.putFigure(p1);
        poligon.putFigure(p2);
        poligon.putFigure(l1);
        poligon.putFigure(triangle);


    }


}

class Poligon {
    private Point[] points;
    private List<Figure> figures = new ArrayList<Figure>();

    /*
     put points in a clockwise direction
      */
    public Poligon(Point... p) {
        points = p;
    }

    public void putFigure(Figure figure) throws Throwable {
        if (this.isValid(figure)) {
            figures.add(figure);
        } else {
            throw new Throwable("Figure is not valid");
        }
    }

    private boolean isValid(Figure figure) {
        if (figure instanceof Point)
            return this.pointIsValid((Point) figure);
        else if (figure instanceof Line)
            return this.pointIsValid(((Line) figure).getP1())
                    && this.pointIsValid(((Line) figure).getP2());
        else if (figure instanceof Triangle)
            return this.pointIsValid(((Triangle) figure).getP1())
                    && this.pointIsValid(((Triangle) figure).getP2())
                    && this.pointIsValid(((Triangle) figure).getP3());
        else return false;

    }

    private   boolean pointIsValid(Point curentPoint) {
        double sum = 0;
        Point previousPoit = points[points.length -1];
        Point nextPoint ;

        for (int i = 0 ; i < points.length; i++) {
            nextPoint = points[i];
            sum+= this.angleBetwennPoints(previousPoit, curentPoint, nextPoint);
        }
        if (((sum - Math.PI) < 0.0001) && ((sum - Math.PI) > -0.0001) )
        return true;
        else return false;
    }

    private double angleBetwennPoints(Point previousPoit, Point curentPoint, Point nextPoint) {
        return Math.PI / 5;
    }


}
