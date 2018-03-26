package classes;

public class SymmetricStringAnalyzer {
	private String s; 
	public SymmetricStringAnalyzer(String s) {
		this.s = s; 
	}
	
	/**
	 * Determines if the string s is symmetric
	 * @return true if it is; false, otherwise. 
	 */
	public boolean isValidContent() { 
		// ADD MISSING CODE
		SLLStack<Character> stack = new SLLStack<Character>();
		if(s.isEmpty()) return true;
		for (int i=0; i < s.length(); i++) { 
	        char c = s.charAt(i); 
	        if (Character.isLetter(c)){ 				//Character is a letter
	        	if (Character.isUpperCase(c))
		              stack.push(c);					//Uppercase letter is pushed to stack
		        else { 									//Must be a lower case letter 
		        	if (stack.isEmpty())					
		        		return false; 
		            else {								//Lowercase letter and stack is not empty 
		            	char t = stack.pop(); 			 //Find the top letter entered to the stack
		            	if (t != Character.toUpperCase(c))		//This letter must be the same as the one we have
		            		return false; 
		            }
		        }   
	        }
	         else 
	        	 return false; 
	        
	    } 
		return stack.isEmpty();

	}
	
	public String toString() { 
		return s; 
	}

	public String parenthesizedExpression() 
	throws StringIsNotSymmetricException 
	{
		// ADD MISSING CODE
		
		if(!this.isValidContent()) throw new StringIsNotSymmetricException("String is not Symmetric");
		String result = "";
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(Character.isUpperCase(c))
				result += "< " + c + " ";
			else
				result += c + " > ";
		}
		
		return result;  // need to change if necessary....
	}

}
