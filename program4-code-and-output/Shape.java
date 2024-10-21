abstract class Shape
{ 
  double x,y;
  abstract void printarea();
}
class Rectangle extends Shape
{
  Rectangle(double a,double b)
  {
    this.x = a;
    this.y = b;
  }
  void printarea()
  {
    double area = x*y;
    System.out.println("area of rectangle = " + area);
  }
}
class Triangle extends Shape
{
  Triangle(double a,double b)
  {
    this.x = a;
    this.y = b;
  }
  void printarea()
  {
    double area = (x*y)/2;
    System.out.println("area of triangle = " + area);
  }
}
class Circle extends Shape
{
  Circle(double radius)
  {
    this.x = radius;
  }
  void printarea()
  {
    double area = 3.1416*x*x;
    System.out.println("area of circle = " + area);
  }
}