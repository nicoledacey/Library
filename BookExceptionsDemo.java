import java.util.Scanner;
import java.util.InputMismatchException;
public class BookExceptionsDemo
{
public static void main(String[] args)
{
Scanner keyboard = new Scanner(System.in);
String title = "";
String author = "";
int pages = 0;
String category = "";
boolean read = false;
double cost = 0;
int n = 0;
boolean validN = false, validTitle = false, validAuthor = false, validPages = false,
validRead  = false, validCost = false;
Book[] arrayOfBooks;

do
{
try
{
System.out.println("Please enter the number of books in your library: ");
n = keyboard.nextInt();
if(n < 0)
{
throw new ArraySizeException("Invalid number of books, must be >= 0, try again");
}//end if
validN = true;
}//end
catch(InputMismatchException ime)
{
System.out.println("Invalid input type.");
System.out.println(ime.getMessage());
keyboard.nextLine();//flush
}//end catch

catch(ArraySizeException ase)
{
System.out.println(ase.getMessage());
}//end catch

}while(!validN);
keyboard.nextLine();//flush
//create the array
arrayOfBooks = new Book[n];

//get the user input for each book

for(int i = 0; i < n; ++i)
{
//get title information
do
{
try
{
System.out.println("Please enter the title:");
title = keyboard.nextLine();
title = title.trim();
if(!(title.length() >= 0))
{
throw new TitleException("Invalid title must be at least one printable character, try again.");
}//end if
validTitle = true;
}//end try
catch(TitleException te)
{
System.out.println(te.getMessage());
}//end catch
}while(!validTitle);

do
{
try
{
System.out.println("Please enter the author:");
author = keyboard.nextLine();
author = author.trim();
if(!(author.length() >= 0))
{
throw new AuthorException("Invalid author must be at least one printable character, try again.");
}//end if
validAuthor = true;
}//end try
catch(AuthorException ae)
{
System.out.println(ae.getMessage());
}//end catch
}while(!validAuthor);

do
{
try
{
System.out.println("Please enter the number of pages:");
pages = keyboard.nextInt();
if(validPages = false)
{
throw new PageException("Invalid page number must be at least one page, try again.");
}//end if
validPages = true;
}//end try
catch(InputMismatchException ime)
{
System.out.println("Invalid input type.");
System.out.println(ime.getMessage());
keyboard.nextLine();//flush

}//end catch

catch(PageException pe)
{
System.out.println(pe.getMessage());
}//end catch

}while(!(pages > 0));
keyboard.nextLine();//flush


do
{
try
{
System.out.println("Please enter if the book has been read, true or false:");
read = keyboard.nextBoolean();
validRead  = true;
}//end try
catch(InputMismatchException ime)
{
System.out.println("Invalid input type.");
System.out.println(ime.getMessage());
keyboard.nextLine();//flush
}//end catch
}while(!validRead);


do
{
try
{
System.out.println("Please enter the cost: ");
cost = keyboard.nextDouble();
if(validCost = false)
{
throw new CostException("Invalid cost, try again");
}//end if
validCost = true;
}//end
catch(InputMismatchException ime)
{
System.out.println("Invalid input type.");
System.out.println(ime.getMessage());
keyboard.nextLine();//flush
}//end catch

catch(CostException ce)
{
System.out.println(ce.getMessage());
}//end catch

}while(!(cost >= 0));
keyboard.nextLine();//flush


//create the book and save in the array
arrayOfBooks[i]= new Book(title, author, pages, "Fiction", read, cost);

System.out.println("Book added to the library! ");
//System.out.println(arrayOfBooks[i].toString());
keyboard.nextLine();//flush
}//end for

for(int i = 0; i < arrayOfBooks.length; ++i)
{
System.out.println(arrayOfBooks[i].toString());
}//end for

}//end main


}//end class