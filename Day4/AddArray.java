import java.util.*;
class AddArray{
public static void main(String[]args){
System.out.println("Enter the no.of.elements");
Scanner scan=new Scanner(System.in);
int size=scan.nextInt();
int a[]=new int[size];
System.out.println("Enter the elements");
for(int i=0;i<size;i++){
a[i]=scan.nextInt();
}
int sum=0;
for(int i=0;i<a.length;i++)
sum+=a[i];
System.out.println(sum);
}
}