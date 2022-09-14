import java.util.*;
class FloydsTriangle{
public static void main(String[]args){
Scanner scan=new Scanner(System.in);
System.out.println("Enter the no.of.rows");
int n=scan.nextInt();
int count=1;
for(int i=0;i<=n;i++){
for(int j=0;j<i;j++){
System.out.print(count+" ");
++count;
}
System.out.println();
}
}
} 