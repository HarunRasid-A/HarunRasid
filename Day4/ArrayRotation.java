import java.util.*;
class ArrayRotation{
public static void main(String[]args){
System.out.println("Enter the total no.of.elements");
Scanner scan=new Scanner(System.in);
int n=scan.nextInt();
int a[]= new int[n];
System.out.println("Enter the Elements:");
for(int i=0;i<n;i++){
a[i]=scan.nextInt();
}
int size=a.length;
int temp[]=new int[size];
ArrayRotation ar=new ArrayRotation();
ar.Arrayrotate(a,size,temp);
ar.printarray(a,temp);
}
void Arrayrotate(int a[],int size,int temp[]){

temp[0]=a[size-1];           //Mapping the last element to the first element of the temp array
for(int i=0;i<size-1;i++){
temp[i+1]=a[i];              //Mapping the rest of the values in the array
}

}

void printarray(int a[],int temp[]){
for(int i=0;i<a.length;i++){
a[i]=temp[i];
}
System.out.println("The array elements are:");
/*for(int i=0;i<a.length;i++)*/
System.out.println(a);
}
}
