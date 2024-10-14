import java.util.Scanner;
public class Book
{
  public String name;
  public String author;
  public int  price;
  public int num_pages;
  public Book(String name,String author,int price,int num_pages)
  {
    this.name = name;
    this.author = author;
    this.price = price;
    this.num_pages = num_pages;
  }
  public void getdetails(Scanner scanner)
  {
      System.out.println("enter the book name: ");
      name = scanner.nextLine();
      System.out.println("enter the author: ");
      author = scanner.nextLine();
      System.out.println("enter the price: ");
      price = scanner.nextInt();
      scanner.nextLine();
      System.out.println("enter the number of pages : ");
      num_pages = scanner.nextInt();
      scanner.nextLine();
  }
  public void showdetails()
  {
    System.out.println(this);
  }
  public String toString()
  {
      return 
        "Book name: " + this.name + "\n" +
        "Author name: " + this.author + "\n" +
        "Price: " + this.price + "\n" +
        "Number of pages: " +this.num_pages + "\n";
   }
}