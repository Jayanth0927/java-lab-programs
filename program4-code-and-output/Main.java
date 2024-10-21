import java.util.Scanner;
class Main
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    System.out.println("enter the sides of rectangle: ");
    double x = in.nextDouble();
    double y = in.nextDouble();
    Rectangle r1 = new Rectangle(x,y);
    r1.printarea();
    System.out.println("enter the sides of triangle: ");
    double a = in.nextDouble();
    double b = in.nextDouble();
    Triangle t1 = new Triangle(a,b);
    t1.printarea();
    System.out.println("enter the radius of circle : ");
    double radius = in.nextDouble();
    Circle c1 = new Circle(radius);
    c1.printarea();
    System.out.println("END OF PROGRAM");
    in.close();
  }
}