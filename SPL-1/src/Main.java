package forspl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Thread{
    
   //public static void main(String[] args)throws FileNotFoundException{
    @Override
    public void run(){
        String tokens[] = {"int ","double ","float ","char ","boolean ","String "};
        
        Scanner in = null;
        try {
            in = new Scanner(new File("C:\\Users\\antan\\eclipse-workspace\\ForSpl\\ReadIt.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        String str;
        
        VarNameCollector obj1 = new VarNameCollector();
        LocalVariableCounting obj2 = new LocalVariableCounting();
        
        while(in.hasNextLine()){
            str = in.nextLine();
            //System.out.println(str);
            obj2.CheckPointOfMethods(str);
            for(int i=0; i<tokens.length; i++){
                
                if(str.contains(tokens[i])){
                    obj1.PushInRespectiveStack(str,i);
                }
                
            }
        }
        obj1.PrintVariables();
        obj2.PrintVariables();
    }
}
