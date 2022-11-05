import java.util.*;
class OPDManagment
{
	public static void main(String[]args)
	{
		Services obj=new Services();
		obj.doService();
	}
}
class UserInfo
{
	 Scanner scan=new Scanner(System.in);
	int u=3; //u defines no.of.users.
	int id[]=new int[u];
	String PatientName[]=new String[u];
	int count=0;
	int val=-1;
	static int ids=99;
	void signUp()
	{
		if(count!=u)
		{
			id[count]=++ids;
		System.out.println("The Patient ID:"+id[count]);
		System.out.println("Enter the Patient Name");
		PatientName[count]=scan.next();
		++count;
		}
	}
	int signIn()
	{
        System.out.println("Enter the Patient Id");
		int pid=scan.nextInt();
		System.out.println("Enter the Patient Name");
		String pname=scan.next();
		for(int i=0;i<u;i++)
		{
			if(pid==id[i] && pname.equals(PatientName[i]))
			{
				System.out.println("Account Found");
				System.out.println("Patient name:"+PatientName[i]);
				val=i;
				break;
			}
		}
		if(val!=-1)
		  return val;
	    else
		  return -1;
		
	}
	
}
class Services extends UserInfo
{
	int Intime[]=new int[u];
	int Outtime[]=new int[u];
	int TimebyDoc[]=new int[u];
	int WaitingTime[]=new int[u];
	int profestime=10;
	int pharmacy=5;
	void doService()
	{
		int usop=0;
		
		do
		{	
		System.out.println("Enter the option as 1.SignUp 2.SignIn 3.PatientInfo 4.Exit");
	     usop=scan.nextInt();
		switch(usop)
		{
			case 1:
			signUp();
			break;
			case 2:
			int value=signIn();
			if(value!=-1)
			{
				timeMangement(value);
				
			}
			else
			{
				System.out.println("No Account Found");
			}
			break;
			case 3:
			PrintInfo();
			break;
		}	
		}while(usop!=4);
	}
	void timeMangement(int index)
	{
		System.out.println("Enter the InTime in int");
		Intime[index]=scan.nextInt();
		System.out.println("Enter the OutTime in int");
		Outtime[index]=scan.nextInt();
		System.out.println("Enter the Time Taken By the Doctor in int");
		TimebyDoc[index]=scan.nextInt();
		int value=Math.abs(Intime[index]-Outtime[index]);
		value-=profestime+pharmacy+TimebyDoc[index];
		WaitingTime[index]=value;
		if(WaitingTime[index]>0)
		{
			System.out.println("Sorry,By OPD Hospital Managment.");
		}
	}
	void PrintInfo()
	{
		System.out.println("PatientId\tPatientName\tInTime\tOutTime\tTimebyDoc\tTotalWaitingTime");
		for(int i=0;i<u;i++)
		{
			if(id[i]!=0)
				System.out.println(id[i]+"\t\t"+PatientName[i]+"\t\t"+Intime[i]+"\t"+Outtime[i]+"\t    "+TimebyDoc[i]+"\t\t\t"+WaitingTime[i]);
		}
	}
	
}















