import java.util.*;
class MaxMin{
public static void main(String[]args){
MaxMin mx=new MaxMin();//object creation for the class MaxMin
System.out.println("Enter the no.of.elements");
Scanner scan=new Scanner(System.in);
int n=scan.nextInt();
int a[]=new int[n];
for(int i=0;i<n;i++){
a[i]=scan.nextInt();
}
mx.smlar(a);
}
void smlar(int a[]){//A function to find small and larger value
for(int i=0;i<a.length;i++){
for(int j=0;j<a.length;j++){
if(a[i]<a[j]){
int temp=a[i];
a[i]=a[j];
a[j]=temp;
}
}
}
System.out.println("Smaller Value is:"+a[0]);
System.out.println("Larger Value is:"+a[a.length-1]);
}
}