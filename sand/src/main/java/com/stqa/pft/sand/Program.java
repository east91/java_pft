package com.stqa.pft.sand;

import java.awt.*;

import static java.lang.Math.sqrt;

public class Program {


  public static void main(String[] args) {


    Square s = new Square(5);
    System.out.println("Square of square " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4,6);
    System.out.println("Square of rectangle " + r.a + " and " + r.b + " = " + r.area());

    Point p1 = new Point(10, 20);
    Point p2 = new Point(30, 40);
    System.out.println(p2.distance(p1));

    System.out.println("Distance between point 1 [" + p1.x + "," + p1.y + "] and point 2 [" + p2.x + ", " + p2.y + "] equals " + p1.distance(p2));
  }


}

