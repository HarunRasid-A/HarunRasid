import java.util.*;
class Irctc
{
	public static void main(String[]args)
	{
		Scanner scan=new Scanner(System.in);
		int a=0;
		do
		{
		System.out.println("Enter the option as 1.AvailableTicket 2.BookTicket 3.CancelTicket 4.BookedTicket  5.Exit");
		 a=scan.nextInt();
		switch(a)
		{
			case 1:
		    AvailableTicket At=new AvailableTicket();
			At.showDetails();
			break;
			case 2:
				BookTicket Bt=new BookTicket();
			Bt.BookTickets();
			break;
			case 3:
			Ctickect Bdt=new Ctickect();
			Bdt.showDetails();
			break;
			case 4:
			BookedTicket Bdt1=new BookedTicket();
			Bdt1.showTicket();
			break;
		}
		}while(a!=5);
	}
}
class passengerDetails
{
       Scanner scan=new Scanner(System.in);
	 static   int upper=2;
	 static  int lower=2;
	 static int middle=2;
	 static int totalseat=6;
	 static int Rac=2;
	 static  int wl=2;
		static int Pnr[]=new int[15];
		static String Name[]=new String[15];
		static int Age[]=new int[15];
	    static int Seatno[]=new int[15];
	    static String Gender[]=new String[15];
		static int Fare[]=new int[15];
		static String Berth[]=new String[15];
		static int erac=2;
		static int ewl=2;
	
}
class BookTicket extends passengerDetails
{
	 static  int pvalue=1;
	 static  int pnr=1;
	 static int count=0;
	 static int seno=1;
	static BookTicket obj=new BookTicket();
	
	void BookTickets()
	{
	    System.out.println("Enter how many ticket you want to book");
		int n=scan.nextInt();
		if(n+seno<=11)
		{
			for(int i=0;i<n;i++)
		{
			
			Pnr[count]=pvalue;
			System.out.println("Enter the Passenger Name");
			String na=scan.next();
			Name[count]=na;
			System.out.println("Enter the Passenger Age");
		    int ag=scan.nextInt();
			Age[count]=ag;
			if(ag>5)
			Seatno[count]=seno++;
		   else 
			   Seatno[count]=0;
			System.out.println("Enter the Passenger Gender");
			String gen=scan.next();
			Gender[count]=gen;
			if(ag>5)
				Fare[count]=400;
			else
				Fare[count]=200;
			
			if(seno>7 && seno<=9)
			{
			Berth[count]="RAC";
			--Rac;
			--erac;
			}
		    else if(seno>9 && seno<=11)
			{
            Berth[count]="WL";
			Seatno[count]=0;
			--wl;
			--ewl;
			}
			boolean check=false;
			if(totalseat>0)
			{
			if(ag>=60)
			{
			 check=lower!=0?true:false;
			if(check==true)
			{
				Berth[count]="Lower";
				--lower;
				--totalseat;
			}
			else
			{
			System.out.println("No Lower Available");
             obj.berthPreference(count);			 
			}
			}
			else
			{
			if(ag>5)
			{
			obj.berthPreference(count);
			}
			else
				Berth[count]="no Berth";
			}
			}
			++count;
		}
		++pvalue;
		System.out.println("Ticket Booked Sucessfully");
		}
		else
			System.out.println("No ticket available pls check the no of tickets");
	}
	void berthPreference(int count)
	{
		System.out.println("Enter the Berth Preference as 1.Lower 2.Middle 3.Upper ");
			int pref=scan.nextInt();
			--totalseat;
			switch(pref)
			{
				case 1:
				obj.lowerBerth(count);
				break;
				case 2:
				obj.middleBerth(count);
				break;
				case 3:
				obj.upperBerth(count);
				break;
				
			}
	}
	void lowerBerth(int count)
	{
		if(lower!=0)
		{
			Berth[count]="Lower";
          --lower;
		}
		else
			obj.upperBerth(count);
	}
     	void upperBerth(int count)
	{
		if(upper!=0)
		{
			Berth[count]="Upper";
		--upper;
		}
		else
			obj.middleBerth(count);
	}	
    void middleBerth(int count)
	{
		if(middle!=0)
		{
			Berth[count]="Middle";
		--middle;
		}
		else
			obj.lowerBerth(count);
	}
}

class BookedTicket extends passengerDetails
{
	void showTicket()
	{
		System.out.print("Pnr\tName\tAge\tSeatno\tGender\tFare\tBerth\n");
		for(int i=0;i<Name.length;i++)
		{	
		if(Fare[i]!=0 && Gender[i]!="null")
		{
		System.out.print(Pnr[i]+"\t"+Name[i]+"\t"+Age[i]+"\t"+Seatno[i]+"\t"+Gender[i]+"\t"+Fare[i]+"\t"+Berth[i]+"\n");
        }
		}
	}
}

class AvailableTicket extends passengerDetails
{
	void showDetails()
	{
		System.out.println("No of Lower Available :"+lower);
		System.out.println("No of middle Available:"+middle);
		System.out.println("No of upper Available :"+upper);
		System.out.println("No of RAC Available   :"+erac);
		System.out.println("No of WL Available    :"+ewl);
	 
	}
}
class Ctickect extends passengerDetails
{
	static Scanner sc=new Scanner(System.in);
	static void showDetails()
	{
		System.out.println("Welcome to the Cancellation Portal");
	    System.out.println("Enter the Seat no to cancel");
		int cs=sc.nextInt();
		int Index=getIndex(cs);
		if(Age[Index]>5)
		{
		if(Rac<=3)
		{  
			int Index2=getsIndex("RAC");
			changeElement(Index,Index2);
			int Index3=interswap(Index2);
			++Rac;
			if(wl<=2)
			{
				String m="WL";
				int Index4=getsIndex(m);
				changeElement(Index3,Index4);
				interswap(Index4);
				++wl;
			}
		}
		else
			delint(Index);
		}
		else
			delint(Index);
		
	}
	static int getIndex(int cs)
	{
		int c=0;
		for(int i=0;i<Seatno.length;i++)
		{
			if(Seatno[i]==cs)
			{
				c=i;
				break;
			}
		}
		return c;
	}
	static int getsIndex(String s)
	{
		int d=0;
		for(int i=0;i<Seatno.length;i++)
		{
			if(Berth[i]==s)
			{
				d=i;
				break;
			}
			else
				d=0;
		}
		return d;
	}
	static void changeElement(int n,int n1)
	{
		Name[n]=Name[n1];
		Age[n]=Age[n1];
		Gender[n]=Gender[n1];
		Fare[n]=Fare[n1];
		Name[n1]="null";
		Age[n1]=0;
		Gender[n1]="null";
	    Fare[n1]=0;
	}
	static int interswap(int Ind)
	{
		Fare[Ind]=400;
		
		String temp=Name[Ind];
		Name[Ind]=Name[Ind+1];
		Name[Ind+1]=temp;
		
		int temp1=Age[Ind];
		Age[Ind]=Age[Ind+1];
		Age[Ind+1]=temp1;
		
		String temp2=Gender[Ind];
		Gender[Ind]=Gender[Ind+1];
		Gender[Ind+1]=temp;
		
		return Ind+1;
	}
	static void delint(int n1)
	{
		Name[n1]="null";
		Age[n1]=0;
		Gender[n1]="null";
	    Fare[n1]=0;

	}
}



