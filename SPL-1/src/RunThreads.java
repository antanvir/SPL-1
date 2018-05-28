/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forspl;

/**
 *
 * @author My-PC
 */
public class RunThreads  {
    
    public static void main(String args[]){  
        Main t1=new Main();  
        AnotherMain t2=new AnotherMain();  
  
        t1.start();  
        t2.start();  
    }  
    
}
