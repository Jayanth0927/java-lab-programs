import java.util.Scanner;
public class Main
{
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    int n;
    System.out.println("enter how many books");
    n = scanner.nextInt();
    scanner.nextLine();
    Book[] books = new Book[n];
    for(int i=0;i<n;i++)
    {
        books[i] = new Book(" "," ",0,0);
        System.out.println("enter the details for the book " + (i+1));
        books[i].getdetails(scanner);
    }
    System.out.println("here is your book details: ");
      for(int i=0;i<n;i++)
     {
       books[i].showdetails();
     }
       scanner.close();
  }
}