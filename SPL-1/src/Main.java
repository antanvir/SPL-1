
package forspl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args)throws FileNotFoundException{
        String tokens[] = {"int ","double ","float ","char ","boolean ","String "};
        
        Scanner in = new Scanner(new File("D:\\Users\\My-PC\\Documents\\NetBeansProjects\\ForSPL\\ReadMe.txt"));
        String str;
        
        VarNameCollector obj1 = new VarNameCollector();
        LocalVariableOfMethods obj2 = new LocalVariableOfMethods();
        
        while(in.hasNextLine()){
            str = in.nextLine();
            //System.out.println(str);
            //VarNameCollector obj = new VarNameCollector();
            
            for(int i=0; i<tokens.length; i++){
                
                if(str.contains(tokens[i])){
                    VarNameCollector obj = new VarNameCollector();
                    obj.PushInRespectiveStack(str,i);
                }
                
            }
        }
        obj1.PrintVariables();
        
    }
}
