
package forspl;


import static forspl.VarNameCollector.stackInt;
import java.util.Stack;
import java.util.regex.Pattern;

public class VarNameCollector {
    
    static String tokens[] = {"int ","double ","float ","char ","boolean ","String "};
    //static Stack<String> listInt,listDouble,listFloat,listChar,listBoolean,listString =new Stack<String>();
    //static Stack<String> stackInt,stackDouble,stackFloat,stackChar,stackBoolean,stackString =new Stack <>();
    //static Stack<String> stackInt,stackDouble,stackFloat,stackChar,stackBoolean,stackString;
    static Stack<String>stackInt = new Stack<String>();
    static Stack<String>  stackDouble = new Stack<>();
    static Stack<String> stackFloat = new Stack<>();
    static Stack<String>    stackChar = new Stack<>();
    static Stack<String>    stackBoolean = new Stack<>();
    static Stack<String>    stackString = new Stack<>();
    
    public void PushInRespectiveStack(String str,int i){
        
         
        switch(i){
            case 0:
                //stackInt = new Stack<>();
                stackInt.push(str);
                ExtractVariable(stackInt,i);
                break;
            case 1:
                //stackDouble = new Stack<>();
                stackDouble.push(str);
                ExtractVariable(stackDouble,i);
                break;
            case 2:
                //stackFloat = new Stack<>();
                stackFloat.push(str);
                ExtractVariable(stackFloat,i);
                break;
            case 3:
                //stackChar = new Stack<>();
                stackChar.push(str);
                ExtractVariable(stackChar,i);
                break;
            case 4:
                //stackBoolean = new Stack<>();
                stackBoolean.push(str);
                ExtractVariable(stackBoolean,i);
                break;
            case 5:
                //stackString = new Stack<>();
                stackString.push(str);
                ExtractVariable(stackString,i);
                break;
        }
        
    }
    
    
    public void ExtractVariable(Stack<String> stack, int i){
        
        int tokenPosition, semicolonPosition, assignOperatorPos, commaPosition;
        String str = stack.pop();
        
        tokenPosition= str.indexOf(tokens[i]);
        
        if(tokenPosition>0){
            String substr = str.substring(0,tokenPosition);
            str = str.replaceAll(substr, " ");
            tokenPosition= str.indexOf(tokens[i]);
        }
        semicolonPosition = str.indexOf(";");
        assignOperatorPos = str.indexOf("=");
        commaPosition = str.indexOf(",");
        
        if(semicolonPosition==-1){
            
            if(str.contains("(")){
                int leftBracketPos, rightBracketPos;
                leftBracketPos = str.indexOf("(");
                rightBracketPos = str.indexOf(")");
                str = str.substring(leftBracketPos+1, rightBracketPos);
            }
            
            String arr[];
            arr = str.split("[ ,]+");
            for (String token : tokens) {
                for (int j = 0; j<arr.length; j++) {
                    if (arr[j].equals(token)) {
                        String variable = arr[j+1]; 
                        j++;
                        variable = variable.trim();
                        stack.push(variable);
                    }
                }
            }
            
        }
        else{
            
            if(assignOperatorPos!=-1 && commaPosition==-1)
                str = str.substring(tokenPosition, assignOperatorPos);
            else str = str.substring(tokenPosition, semicolonPosition);
            String arr[];
            arr = str.split("[ ,=]+");
            
            for(int j=1; j<arr.length; j++){
                String variable = arr[j];
                variable = variable.trim();
                if(Pattern.matches("\\d",variable)) continue;
                stack.push(variable);
            }
            
        }
    }
    
    
    void PrintVariables(){
        
        for(int i=0; i<6; i++){
            
            Stack<String> stack = null ;
            switch(i){
                case 0:
                    stack = stackInt;
                    System.out.println("\n====Integer Variables====\n");
                    break;
                case 1:
                    stack = stackDouble;
                    System.out.println("\n====Double Variables====\n");
                    break;
                case 2:
                    stack = stackFloat;
                    System.out.println("\n====Float Variables====\n");
                    break;
                case 3:
                    stack = stackChar;
                    System.out.println("\n====Char Variables====\n");
                    break;
                case 4:
                    stack = stackBoolean;
                    System.out.println("\n====Boolean Variables====\n");
                    break;
                case 5:
                    stack = stackString;
                    System.out.println("\n====String Variables====\n");
                    break;
            }
            if(!stack.empty()) {
  
                for(String item: stack){
                    System.out.println(item);
                }
                
            }
            System.out.println();
            
        }
        
        
    }
    
}
