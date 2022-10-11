import java.util.*;
class Library
{
	
    public static void main(String[]args)
	{
	   Scanner scan=new Scanner(System.in);
	   int n=0;
	 do{  
	   System.out.println("1.Enter for Admin 2.Enter for User 3.Exit");
	   n=scan.nextInt();
	   switch(n){
	   case 1:
	   Admin obj=new Admin();
	   obj.AdminPortal();
	   break;
	   case 2:
	   User ob=new User();
	   ob.UserPortal();
	   
	   break;
	   }	
	 }while(n!=3);
    }
}
class Login
{
	String username;
	String password;
	Scanner scan=new Scanner(System.in);
    Login()
	{
    }
    Login(int a)
	{
	username="admin";
	password="admin007";
    }
    void signup()
	{
       System.out.println("!!!Welcome to the Signup Portal!!!");
       System.out.println("Enter the username");
       username=scan.next();
       boolean a=true;
       while(a)
	   {
         System.out.println("Enter the password");
         password=scan.next();
         if(password.length()>=8)
	         a=false;
         else
	        System.out.println("The password must be contain atleast 8 character");
       }
    }
    boolean signin()
    {
         System.out.println("Welcome to the Signin Portal");
	     int nt=3;
		 boolean ch=true;
         while(nt!=0)
        {
           System.out.println("Enter the username");
           String uname=scan.next();
           System.out.println("Enter the password");
           String upass=scan.next();
            if(username.equals(uname)&&password.equals(upass))
     	        {
                   System.out.println("Login Successfull :)");
                   ch=true;
				   nt=0;
				   
                }
            else
		        {
	               System.out.println("Invalid password are no account found");
                   System.out.println("Only "+(nt--)+" atempt left");
                   ch=false;   
				}
        }	
		return ch;
    }
}
class Admin extends Login
{
	Admin(){
	super(1);
	}
	
	static String BookTitle[]=new String[50];
    static int Bookprice[]=new int[50];
    static int Bookcount[]=new int[50];	
		Scanner scan=new Scanner(System.in);
	//Admin obj=new Admin();
	int count=0;
	void AdminPortal(){
		Admin obj=new Admin();
	boolean a=signin();
	if(a==true)
	{
     boolean s=true;
	 while(s)
	 {
	System.out.println("Enter 1.Book Detatils 2.Add 3.Update 4.Delete 5.Exit");
    int aoption=scan.nextInt();
    switch(aoption)
	{
      case 1:
		obj.BookDetatils();
		break;
		case 2:
		obj.AddBooks();
		break;
		case 3:
		obj.UpdateDetatils();
		break;
		case 4:
		obj.Delete();
		break;
		case 5:
		s=false;
	}	
	}
	}
	}
	void BookDetatils()
	{
		System.out.println("S.no\tBookTitle\tPrice\tcount");
		for(int i=0;i<Bookprice.length;i++){
		if(Bookprice[i]!=0){
		System.out.print(i+"\t"+BookTitle[i]+"\t"+Bookprice[i]+"\t"+Bookcount[i]);
		 System.out.println();
		  }
		} 
     }
	void AddBooks()
	{
		System.out.println("Enter how many books you want to add");
	 int op=scan.nextInt();
	 for(int i=0;i<op;i++)
	 {
		 System.out.println(i+":Enter the Book Title");
		 BookTitle[count]=scan.next();
		 System.out.println("Enter the Book Price");
		 Bookprice[count]=scan.nextInt();
		 System.out.println("Enter the Book Count");
		 Bookcount[count]=scan.nextInt();
		 ++count;
	 }
	}
	void UpdateDetatils()
	{
		System.out.println("Enter option to update 1.BookTitle 2.Bookprice 3.Bookcount");
		int n=scan.nextInt();
		 System.out.println("Enter the Book Serial no to update");
		 int bsno=scan.nextInt();
		 switch(n){
		 case 1:
		 System.out.println("Enter the Book title for s.no:"+bsno);
		 BookTitle[bsno]=scan.next();
		 break;
		 case 2:
		 System.out.println("Enter the Book Price for s.no:"+bsno);
		 Bookprice[bsno]=scan.nextInt();
		 break;
		 case 3:
		 System.out.println("Enter the Book Count for s.no:"+bsno);
		 Bookcount[bsno]=scan.nextInt();
		 break;
		 }
		  
	}
	void Delete()
	{
	  System.out.println("Enter the serial no to Delete");
	  int del=scan.nextInt();
	  BookTitle[del]="null";
	  Bookprice[del]=0;
	  Bookcount[del]=0;
	  count-=1;
	  for(int i=del;i<Bookprice.length-1;i++)
	  {
		  String temp=BookTitle[i];
		  BookTitle[i]=BookTitle[i+1];
		  BookTitle[i+1]=temp;
	  
		  int tempo=Bookprice[i];
		  Bookprice[i]=Bookprice[i+1];
		  Bookprice[i+1]=tempo;
	  
		  int temps=Bookcount[i];
		  Bookcount[i]=Bookcount[i+1];
		  Bookcount[i+1]=temps;
	  }
	  
	}   	
}
class User extends Admin
{
	Login obj=new Login();
	int n=0;
	void UserPortal()
	{
		boolean b=true;
		do
		{
	System.out.println("Enter 1.Signup 2.Signin 3.Exit");
     n=scan.nextInt();
	boolean s=true;
	
    switch(n)
	{
		case 1:
		obj.signup();
		boolean a=obj.signin();
		if(a==true)
		{
			while(s)
			{
			System.out.println("Enter 1.BookDetatils 2.Read 3.Buy 4.Exit");
			int op=scan.nextInt();
			switch(op)
			{
			 case 1:
			 Admin obj=new Admin();
			 BookDetatils();
			 break;
			 case 2:
			 System.out.println("Enter the Book Serial no:");
			 int sno=scan.nextInt();
			 System.out.println(BookTitle[sno]);
			 String k="Hello viewers i m the author of this book and i m sure that this book is going to change your life.\nYour attitude,the way of thinking so before starting our journey i would like to give you a disclaimar";
			 System.out.println(k);
			 break;
			 case 3:
			 System.out.println("Enter the Serial no to Buy a Book");
			 int bbook=scan.nextInt();
			 Bookcount[bbook]-=1;
			 System.out.println("Congratulation the book titled "+BookTitle[bbook]+" purchased successfully");
			 case 4:
			 s=false;
			 
			}
		}
		}
		break;
		case 2:
		obj.signin();
		break;
	}	
		}while(n!=3);
	}
}
