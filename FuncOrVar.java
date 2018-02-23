package PackOfStaticAnalysis;

import java.util.ArrayList;

public class FuncOrVar {
	
	
	public static boolean varCheck(String word) {
										//if function-> returns true,if variable-> returns false.
		int index = word.indexOf('(');
		int index1 = word.indexOf('=');
		
		/*if(index1!=-1 && index!=-1) {   // case example : sub=func()
			String str= word.substring(index1+1);
			System.out.println(str);
			word.replace(str," ");
			System.out.println(word.trim());
		}
		*/
		if(index!=-1 && index1==-1) return true;    //"(" not found --> means it can be a variable
		else return false;      // "(" appears after function name [e.g. int main() or sub=func() ]
		
	}
	
	public static boolean NewOrOld(String word, ArrayList<String> nameList) {
						/*returns "true" if the variable is new and does not match another
						 otherwise false*/
		
		for(String name:nameList) {
			if(word.equals(name))return false;
		}
		return true;
	}
	
	
}
