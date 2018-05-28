
package forspl;

import java.awt.AWTEventMulticaster;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main extends Thread{
    
   //public static void main(String[] args)throws FileNotFoundException{
   
    public void run(){
        String tokens[] = {"int ","double ","float ","char ","boolean ","String "};
        
        Scanner in = null;
        try {
            in = new Scanner(new File("D:\\Users\\My-PC\\Documents\\NetBeansProjects\\ForSPL\\ReadIt2.txt"));
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
        //obj2.PrintVariables();
        
        JFrame f=new JFrame();
        //UIManager.put("OptionPane.minimumSize",new Dimension(250,90)); 
        if(JOptionPane.showConfirmDialog(f,"Wish to See Varible Names?")==JOptionPane.YES_OPTION){ 
           
            ShowVariable info =new ShowVariable();
            ShowVariable.main(null);
            
        }  
        
    }

    
}
