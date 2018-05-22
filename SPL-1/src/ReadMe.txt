package ReadMe;

import java.util.Scanner;

public class Read {

    Scanner in = new Scanner(System.in);
    
    double PI = 3.1416, e = 2.418182;
    int MAX = 1e9;
    

    public int Add(){
        
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        
        int res = num1+num2;
        
        return res;
    }

    public double CircleArea(double rad){
        
        double area;
        area = PI*rad*rad;

        return area;
    }

    public int Subtraction(int numA,int numB){
        
        int subResult= (numA - numB);
        return subResult;
    }
    

    public static void main(String[] args){  

        int result, numA,numB ;
        String add ="sum is: ";
        String sub = "Subtraction result : ";
        int number=10;
        double AreaOfCircle, radius;  

        result = Add();
        System.out.println( add + result);

        radius = in.nextDouble();
        CircleArea(radius);
        System.out.println( "Circle Area : " + result);

        numA = in.nextInt();
        numB = in.nextInt();
        Subtraction(numA,numB);
    }

}


