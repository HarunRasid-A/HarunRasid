import java.util.*;
class NoofOddTerms{
public static void main(String[]args){
System.out.println("Enter the number of terms");
Scanner scan=new Scanner(System.in);
int a=scan.nextInt();
Findsol fs=new Findsol();
fs.find(a);
}
}
class Findsol{
void find(int a){
int sum=0;
for(int i=1;i<=a*2;i++){
if(i%2!=0){
System.out.println(i);
sum+=i;
}
}
System.out.println("The addition of "+a+" odd numbers is:"+sum);

}
}


