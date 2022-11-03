package com.epam.training.student_veronika_tarasova.triangle.src.main.java.com.epam.rd.autotasks.triangle;

class Triangle {
   private Point a;
   private  Point b;
   private  Point c;

    public Triangle(Point a, Point b, Point c){
        if(a == null || b == null || c == null){
            throw new IllegalArgumentException();
        }
        double lengthA = Math.sqrt(Math.pow((c.getX() - b.getX()),2) + (Math.pow((c.getY() - b.getY()),2)));
        double lengthB = Math.sqrt(Math.pow((a.getX() - c.getX()),2) + (Math.pow((a.getY() - c.getY()),2)));
        double lengthC = Math.sqrt(Math.pow((b.getX() - a.getX()),2) + (Math.pow((b.getY() - a.getY()),2)));

        if(lengthA > lengthB && lengthA > lengthC){

            if(!(lengthB + lengthC >lengthA)){
                throw new IllegalArgumentException();
            }
        }
        if(lengthB > lengthA && lengthB > lengthC){

            if(!(lengthC + lengthA >lengthB)){
                throw new IllegalArgumentException();
            }
        }
        if(lengthC > lengthA && lengthC > lengthB){

            if(!(lengthB + lengthA >lengthC)){
                throw new IllegalArgumentException();
            }
        }

        this.a = new Point(a.getX(), a.getY());
        this.b = new Point(b.getX(), b.getY());
        this.c = new Point(c.getX(), c.getY());
    }

    public double area() {
        double area = 0.0;

        double lengthA = Math.sqrt(Math.pow((c.getX() - b.getX()),2) + (Math.pow((c.getY() - b.getY()),2)));
        double lengthB = Math.sqrt(Math.pow((a.getX() - c.getX()),2) + (Math.pow((a.getY() - c.getY()),2)));
        double lengthC = Math.sqrt(Math.pow((b.getX() - a.getX()),2) + (Math.pow((b.getY() - a.getY()),2)));

        double semiperimeter = (double)1/2*(lengthA+lengthB+lengthC);
        area = Math.sqrt(semiperimeter*(semiperimeter - lengthA)*(semiperimeter - lengthB)*(semiperimeter - lengthC));

        return area;
    }

    public Point centroid(){
        double x;
        double y;

        x = (a.getX() + b.getX() + c.getX())/3;
        y = (a.getY() + b.getY() + c.getY())/3;
        Point centroid = new Point(x,y);
        return centroid;
    }

}
