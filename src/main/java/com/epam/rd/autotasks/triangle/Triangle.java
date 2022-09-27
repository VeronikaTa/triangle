package com.epam.rd.autotasks.triangle;

class Triangle {
   private  Point a;
   private  Point b;
   private  Point c;

    public Triangle(Point a, Point b, Point c){
        if(a == null || b == null || c == null){
            throw new IllegalArgumentException();
        }
        double lengthA = Math.sqrt(Math.pow((c.getX() - b.getX()),2) + (Math.pow((c.getY() - b.getY()),2)));
        double lengthB = Math.sqrt(Math.pow((a.getX() - c.getX()),2) + (Math.pow((a.getY() - c.getY()),2)));
        double lengthC = Math.sqrt(Math.pow((b.getX() - a.getX()),2) + (Math.pow((b.getY() - a.getY()),2)));

        if(!((lengthA + lengthB)>lengthC)){
            throw new IllegalArgumentException();
        }
        Point vectorOne = new Point(b.getX() -  a.getX(), b.getY() - a.getY());
        Point vectorTwo = new Point(c.getX() - a.getX(), c.getY() - a.getY());
        Point vectorThree = new Point(b.getX() - c.getX(), b.getY() - c.getY());
        Point vectorFour = new Point(a.getX() - c.getX(), a.getY() - c.getY());
        Point vectorFive = new Point(a.getX() - b.getX(), a.getY() - b.getY());
        Point vectorSix = new Point(c.getX() - b.getX(), c.getY() - b.getY());


        double cosC = (vectorThree.getX() * vectorFour.getX() + vectorThree.getY()*vectorFour.getY())/(Math.sqrt((Math.pow(vectorThree.getX(),2) + Math.pow(vectorThree.getY(),2)))*Math.sqrt((Math.pow(vectorFour.getX(),2) + Math.pow(vectorFour.getY(),2))));
        double cosA = vectorOne.getX() * vectorTwo.getX() + vectorOne.getY()*vectorTwo.getY()/Math.sqrt((Math.pow(vectorOne.getX(),2) + Math.pow(vectorOne.getY(),2)))*Math.sqrt((Math.pow(vectorTwo.getX(),2) + Math.pow(vectorTwo.getY(),2)));
        double cosB = (vectorFive.getX() * vectorSix.getX() + vectorFive.getY()*vectorSix.getY())/(Math.sqrt((Math.pow(vectorFive.getX(),2) + Math.pow(vectorFive.getY(),2)))*Math.sqrt((Math.pow(vectorSix.getX(),2) + Math.pow(vectorSix.getY(),2))));

        if(cosC == 1.0 || cosA == 1.0 || cosB == 1.0){
            throw new IllegalArgumentException();
        }

        if ((c.getX() - a.getX()) / (b.getX() - a.getX()) == (c.getY() - a.getY()) / (b.getY() - a.getY())){
            throw new IllegalArgumentException();
        }

        this.a = new Point(a.getX(), a.getY());
        this.b = new Point(b.getX(), b.getY());
        this.c = new Point(c.getX(), c.getY());
    }

    public double area() {
        if(this.a == null || this.b == null || this.c == null){
            throw new IllegalArgumentException();
        }
        double area = 0.0;

        double lengthA = Math.sqrt(Math.pow((c.getX() - b.getX()),2) + (Math.pow((c.getY() - b.getY()),2)));
        double lengthB = Math.sqrt(Math.pow((a.getX() - c.getX()),2) + (Math.pow((a.getY() - c.getY()),2)));
        double lengthC = Math.sqrt(Math.pow((b.getX() - a.getX()),2) + (Math.pow((b.getY() - a.getY()),2)));

        double semiperimeter = (double)1/2*(lengthA+lengthB+lengthC);
        area = Math.sqrt(semiperimeter*(semiperimeter - lengthA)*(semiperimeter - lengthB)*(semiperimeter - lengthC));

        return area;
    }

    public Point centroid(){
        if(this.a == null || this.b == null || this.c  == null){
            throw new IllegalArgumentException();
        }
        double x;
        double y;

        x = (a.getX() + b.getX() + c.getX())/3;
        y = (a.getY() + b.getY() + c.getY())/3;
        Point centroid = new Point(x,y);
        return centroid;
    }

}
