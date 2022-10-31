import java.util.*;
class TollgateMangment
{
	public static void main(String[]args)
	{
		Tollgate obj=new Tollgate();
		Scanner scan=new Scanner(System.in);
		int n=0;
		do
		{
			System.out.println("Enter the option as 1 for Travel and 2 for TollSummary and 3 for Exit");
			n=scan.nextInt();
			switch(n)
			{
				case 1:
				obj.vechileDetails();
				break;
				case 2:
				obj.printDetails();
				break;
			}
		}while(n!=3);
	}
}
class Tollgate
{
	Scanner scan=new Scanner(System.in);
	String jnname[]={"gt","ur","pg","vn","tm"};
	int car[]=new int[5];
	int bike[]=new int[5];
	int vip[]=new int[5];
	int fare[]=new int[5];
	int pervech=0;
	int frcount=0;
	int bkcount=0;
	
	public void vechileDetails()
	{
		System.out.println("Enter the Start and Ending Index as code");
		System.out.println("Guduvanchery as gt\nUrappakam as ur\nPerungalathur as pg\nVandaloor as vn\nTambaram as tm");
		String start=scan.next();
		String end=scan.next();
		int sindex=searchIndex(start);
		int eindex=searchIndex(end);
		System.out.println("For Bike user press 1 or Car press 0");
		int vechtype=scan.nextInt();
		System.out.println("For Vip user press 1 or normal press 0");
		int vechile=scan.nextInt();
		shortDistance(sindex,eindex,vechtype,vechile);
	}
	public int searchIndex(String s)
	{
		int index=0;
		for(int i=0;i<jnname.length;i++)
		{
			if((jnname[i]).equals(s))
			index=i;
		}
		return index;
	}
	
     protected int fare(int vechtype,int vechile,int cfare,int bfare,int i)
	{
		if(vechtype==0)
		{
			car[i]+=1;
			bike[i]+=0;
			if(vechile==1)
			{
				vip[i]+=1;
				fare[i]+=cfare-(cfare*20)/100;
			}
			else
			{
				vip[i]+=0;
				fare[i]+=cfare;
			}
			return fare[i];
		}
		else
		{
			bike[i]+=1;
			car[i]+=0;
			if(vechile==1)
			{
				vip[i]+=1;
				fare[i]+=bfare-(bfare*20)/100;
			}
			else
			{
				vip[i]+=0;
				fare[i]+=bfare;
			}
			return fare[i];
		}
	}
	protected int travel(int a[],int vechtype,int vechile)
	{
	   int count=0;		
		for(int i=0;i<=a.length-1;i++)
		{
			if(a[i]!=-1)
			{
			switch(a[i])
			{
				case 0:
				count+=guduvanchery(vechtype,vechile);
				break;
				case 1:
				count+=urappakam(vechtype,vechile);
				break;
				case 2:
				count+=perungalathur(vechtype,vechile);
				break;
				case 3:
				count+=vandaloor(vechtype,vechile);
				break;
				case 4:
				count+=tambaram(vechtype,vechile);
				break;
			}
			}
		}
		
		return count;
	}
	public int guduvanchery(int vechtype,int vechile)
	{
		int i=0;
		int cfare=600;
		int bfare=200;
		int amount=fare(vechtype,vechile,cfare,bfare,i);
		return amount;
	}
	public int urappakam(int vechtype,int vechile)
	{
		int i=1;
		int cfare=200;
		int bfare=100;
		int count=fare(vechtype,vechile,cfare,bfare,i);
		return count;
	}
	public int perungalathur(int vechtype,int vechile)
	{
		int i=2;
		int cfare=0;
		int bfare=0;
		int count=fare(vechtype,vechile,cfare,bfare,i);
	    return count;
	}
	public int vandaloor(int vechtype,int vechile)
	{
		int i=3;
		int cfare=500;
		int bfare=300;
		int count=fare(vechtype,vechile,cfare,bfare,i);
	    return count;
	}
	public int tambaram(int vechtype,int vechile)
	{
		int i=4;
		int cfare=800;
		int bfare=450;
		int count=fare(vechtype,vechile,cfare,bfare,i);
	    return count;
	}
	public void shortDistance(int start,int end,int vechtype,int vechile)
	{
		int dis[]={0,1,2,3,4};
		int charges=0;
		int c[]=new int[5];
		front(dis,start,end);
		back(dis,start,end);
		if(frcount<bkcount)
		{
		 c=front(dis,start,end);
	    charges=travel(c,vechtype,vechile);
		
		}
		else 
		{
	     c=back(dis,start,end);
		 charges=travel(c,vechtype,vechile);	  
		}
		System.out.println("\nVechile Summary:\n\nThe shortest distance between "+jnname[start]+" to "+jnname[end]);
		for(int i=0;i<c.length;i++)
		{
			if(c[i]!=-1)
			{
				System.out.print(jnname[c[i]]+" ");
			}
		}
		int ntoll=frcount<bkcount?frcount:bkcount;
		System.out.println("\nThe no.of.tolls passed by the vechile:"+ntoll);
		System.out.println("The Total cost for the vechile is:"+Math.abs(charges-pervech)+"\n");
		pervech=charges;
		
	}
	public int[] front(int a[], int start, int end) {
		int count = 0;
		frcount=0;
		int b[]={-1,-1,-1,-1,-1};
		for (int i = start; i <=end; i++) {
			++frcount;
			b[count++]=i;
		}
		return b;
	}
	int[] back(int a[], int start, int end) {
		int count = 0;
		bkcount=0;
		int c[]={-1,-1,-1,-1,-1};
		for (int i = 0, k = a.length - 1; i < a.length; i++) {

			if (start >= 0) {
				c[count++]=start;
				start--;
				++bkcount;
			}
			if (start < 0) {
				if (k != end) {
					c[count++]=k;
					--k;
					++bkcount;
				} 
				else
					{
					c[count++]=k;
					++bkcount;
					break;
				}
			}
		}
		return c;
	}

	public void printDetails()
	{
		System.out.println("S.no\tJnname\tCars\tBike\tVip\tFare");
		for(int i=0;i<fare.length;i++)
		{
			System.out.println(i+"\t"+jnname[i]+"\t"+car[i]+"\t"+bike[i]+"\t"+vip[i]+"\t"+fare[i]);
		}
	}
}