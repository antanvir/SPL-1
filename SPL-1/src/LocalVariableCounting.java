
package forspl;
import forspl.BarChart;

import java.util.Stack;
import java.util.regex.Pattern;

public class LocalVariableCounting {
    
    //public boolean flagMain = false;
    public static int counter =0,countInt=0, countDouble=0, countFloat=0, countChar=0, countBoolean=0, countString=0;
    static String tokens[] = {"int ","double ","float ","char ","boolean ","String "};
    static Stack<String>stackInt = new Stack<String>();
    static Stack<String> stackDouble = new Stack<>();
    static Stack<String> stackFloat = new Stack<>();
    static Stack<String> stackChar = new Stack<>();
    static Stack<String> stackBoolean = new Stack<>();
    static Stack<String> stackString = new Stack<>();
    
    static Stack <Character> stack = new Stack<>();
    
            
    
    public void CheckPointOfMethods(String str){
        
        if(str.contains("}") && !stack.empty()){
            stack.pop();
        }
        
        
        if(!stack.empty()){
            for(int i=0; i<tokens.length; i++){
                if(str.contains(tokens[i])){
                    
                   switch(i){
                        case 0:             
                            stackInt.push(str);
                            ExtractVariablesAndCount(stackInt,i);
                            break;
                        case 1:   
                            stackDouble.push(str);
                            ExtractVariablesAndCount(stackDouble,i);
                            break;
                        case 2:

                            stackFloat.push(str);
                            ExtractVariablesAndCount(stackFloat,i);
                            break;
                        case 3:
                            stackChar.push(str);
                            ExtractVariablesAndCount(stackChar,i);
                            break;
                        case 4:
                            stackBoolean.push(str);
                            ExtractVariablesAndCount(stackBoolean,i);
                            break;
                        case 5:
                            stackString.push(str);
                            ExtractVariablesAndCount(stackString,i);
                            break;
                    }
                }
            }
            
            
        }
       
        if(str.contains("{")){
            counter++;
            if(counter>=2) stack.push('}');
        }
        
    }
    
    
    public void ExtractVariablesAndCount(Stack<String> stack, int i){
        
        int tokenPosition, semicolonPosition, assignOperatorPos, commaPosition;
        int quoteStart, quoteEnd;
        String substr; 
        
        String str = stack.pop();
        
        tokenPosition= str.indexOf(tokens[i]);
        
        if(tokenPosition>0){
            
            substr = str.substring(0,tokenPosition);
            if(substr.contains("(")){
                substr = substr.replace('(', ' ');
                str = str.replace(')', ' ');
            }
            str = str.replaceFirst(substr, "");
            tokenPosition= str.indexOf(tokens[i]);
            
        }
        
        semicolonPosition = str.indexOf(";");
        assignOperatorPos = str.indexOf("=");
        commaPosition = str.indexOf(",");
        
        if(assignOperatorPos!=-1 && commaPosition==-1)
           str = str.substring(tokenPosition, assignOperatorPos);
        else str = str.substring(tokenPosition, semicolonPosition);
        
        
        String toBeNulled="";
        while(str.contains("\"")){
            if(str.contains("\"")) toBeNulled = "\"";
            else if(str.contains("'")) toBeNulled = "'";
            
            quoteStart = str.indexOf(toBeNulled);
            str = str.replaceFirst(toBeNulled, "");
            quoteEnd = str.indexOf(toBeNulled);
                
            substr = str.substring(quoteStart,quoteEnd+1);
            str = str.replace(substr, "");
        }
        
        /*while(str.contains("'")){
                
            quoteStart = str.indexOf("'");
            str = str.replaceFirst("'", "");
            quoteEnd = str.indexOf("'");
                
            substr = str.substring(quoteStart,quoteEnd+1);
            str = str.replace(substr, "");
        }*/
        
        String arr[];
        arr = str.split("[ ,=]+");
            
        for(int j=1; j<arr.length; j++){
            String variable = arr[j];
            variable = variable.trim();
            String pattern = "[ \\d* | ([0-9]\\.[0-9]*) ]+";
            
            if(Pattern.matches(pattern,variable) ) continue;
            stack.push(variable);
            
            switch(i){
                case 0:
                    countInt++;
                    break;
                case 1:
                    countDouble++;
                    break;
                case 2:
                    countFloat++;
                    break;
                case 3:
                    countChar++;
                    break;
                case 4:
                    countBoolean++;
                    break;
                case 5:
                    countString++;
                    break;
            }
            BarChart bar = new BarChart("","");
            bar.setVisible(false);
            BarChart.main(new String[]{});
            
        }
        
    }
    
    
    
    void PrintVariables(){
        
        System.out.println("\n======================================================================\n");
        
        for(int i=0; i<6; i++){
            
            Stack<String> stack = null ;
            switch(i){
                case 0:
                    stack = stackInt;
                    System.out.println("\n==== INTEGER VARIABLES [LOCAL] ====\n");
                    System.out.println("Total local variables :\t" + countInt + "\n");
                    break;
                case 1:
                    stack = stackDouble;
                    System.out.println("\n==== DOUBLE VARIABLES [LOCAL] ====\n");
                    System.out.println("Total local variables :\t" + countDouble + "\n");
                    break;
                case 2:
                    stack = stackFloat;
                    System.out.println("\n==== FLOAT VARIABLES [LOCAL] ====\n");
                    System.out.println("Total local variables :\t" + countFloat + "\n");
                    break;
                case 3:
                    stack = stackChar;
                    System.out.println("\n==== CHAR VARIABLES [LOCAL] ====\n");
                    System.out.println("Total local variables :\t" + countChar + "\n");
                    break;
                case 4:
                    stack = stackBoolean;
                    System.out.println("\n==== BOOLEAN VARIABLES [LOCAL] ====\n");
                    System.out.println("Total local variables :\t" + countBoolean + "\n");
                    break;
                case 5:
                    stack = stackString;
                    System.out.println("\n==== STRING VARIABLES [LOCAL] ====\n");
                    System.out.println("Total local variables :\t" + countString + "\n");
                    break;
            }
            if(!stack.empty()) {
  
                for(String item: stack){
                    System.out.println(item);
                }
                
            }
            System.out.println();
            
        }
        System.out.println("\n======================================================================\n");
        
    }

    static class java {

        public java() {
        }
    }
    
}
