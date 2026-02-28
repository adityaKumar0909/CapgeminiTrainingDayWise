import java.util.Scanner;
import java.util.Stack;

public class validParanthesis {
    static void main(String[] args) {
        String str;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string to check:");
        str = sc.nextLine();
        boolean isValid = Validate(str);
        System.out.println("is Valid ? : "+ isValid);
    }

    private static boolean Validate(String str) {
        Stack< Character > stk = new Stack<>();
        int size = str.length();

        for (int i = 0; i < size; i++) {
            char ch = str.charAt(i);

            if(!stk.empty() && ((ch==']' && stk.peek() == '[') || (ch=='}' && stk.peek() == '{') || (ch==')' && stk.peek() == '('))){
                stk.pop();
            }
            else
                stk.push(ch);

        }

        if(stk.empty()){
            return true;
        }

        return false;
    }
}
