import com.sun.javafx.font.FontConstants;
import java.util.*;
public class BalancedParenthesis {
    
    static boolean isMatch(char a, char b)
    {
        if( (a == '{' && b == '}' ) || (a == '[' && b == ']' ) || (a == '(' && b == ')' ))
            return true;
        return false;
    }
    
    static boolean isvalid(String str)
    {
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if(ch == '{' || ch == '(' || ch == '[')
                s.push(ch);
            else{
                if(s.isEmpty()) //string such as, eg : ){} , )(
                    return false;
                if(isMatch(s.peek(), ch))
                    s.pop();
                else
                    return false;
            }
        }
        return (s.isEmpty() == true);
    }
    public static void main(String[] args) {
        String str = "[[({()})]]";
        System.out.println(" is balanced : "+isvalid(str));
        str = "}[]";
        System.out.println(" is balanced : "+isvalid(str));
        
    }
}
