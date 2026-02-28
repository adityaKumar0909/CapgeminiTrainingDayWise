import java.util.*;

public class assessment {
    //Q.2 stack with O(1) Min & Max
    static class SmartStack {
        private final Stack<Long> stack;
        private Long min;
        private Long max;

        public SmartStack() {
            stack = new Stack<>();
        }

        public void push(int val) {
            long x = (long) val;
            if (stack.isEmpty()) {
                stack.push(x);
                min = x;
                max = x;
                return;
            }

            if (x < min) {
                stack.push(2 * x - min);
                min = x;
            } else if (x > max) {
                stack.push(2 * x - max);
                max = x;
            } else {
                stack.push(x);
            }
        }

        public void pop() {
            if (stack.isEmpty()) return;
            long top = stack.pop();

            if (top < min) {
                min = 2 * min - top;
            } else if (top > max) {
                max = 2 * max - top;
            }

            if (stack.isEmpty()) {
                min = null;
                max = null;
            }
        }

        public int top() {
            long top = stack.peek();
            if (top < min) return min.intValue();
            if (top > max) return max.intValue();
            return (int) top;
        }

        public int getMin() {
            return min.intValue();
        }

        public int getMax() {
            return max.intValue();
        }
    }

    //Q.3 DecodeString
    static StringBuilder funct(int num, String content) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            result.append(content);
        }
        return result;
    }

    static void decodeString(String str) {
        Stack<StringBuilder> stk = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ']') {
                StringBuilder content = new StringBuilder();
                while (!stk.empty() && !stk.peek().toString().equals("[")) {
                    content.insert(0, stk.pop());
                }

                stk.pop();

                if (!stk.isEmpty()) {
                    int num = Integer.parseInt(stk.pop().toString());

                    StringBuilder repeated = funct(num, content.toString());
                    stk.push(repeated);
                }
            } else {
                stk.push(new StringBuilder(String.valueOf(ch)));
            }
        }

        StringBuilder answer = new StringBuilder();
        while (!stk.empty()) {
            answer.insert(0, stk.pop());
        }
        System.out.println(answer);
    }

    //Q6. Implementing stack with two queues
    class MyStack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public void push(int x) {
            q2.add(x);

            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }

            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public int pop() {
            if (q1.isEmpty()) return -1;
            return q1.remove();
        }

        public int top() {
            if (q1.isEmpty()) return -1;
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }

    //Q9. Sorting stacks
    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();

        sortStack(stack);

        sortedInsert(stack, top);
    }

    private static void sortedInsert(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }
        int top = stack.pop();
        sortedInsert(stack, element);
        stack.push(top);
    }

    //Q.4. Largest Rectangle
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = heights[i];
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                int width = j - i + 1;
                int area = minHeight * width;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    //Q.5. Celebrity Problem
    public int findCelebrity(int[][] M, int n) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            stk.push(i);
        }

        while (stk.size() > 1) {
            int a = stk.pop();
            int b = stk.pop();

            if (M[a][b] == 1) {
                stk.push(b);
            } else {
                stk.push(a);
            }
        }

        int potential = stk.pop();

        for (int i = 0; i < n; i++) {
            if (i != potential) {
                if (M[potential][i] == 1 || M[i][potential] == 0) {
                    return -1;
                }
            }
        }

        return potential;
    }

    //Q.7. Remove invalid parenthesis
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stk = new Stack<>();
        boolean[] invalid = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stk.push(i);
            } else if (ch == ')') {
                if (stk.isEmpty()) {
                    invalid[i] = true;
                } else {
                    stk.pop();
                }
            }
        }

        while (!stk.isEmpty()) {
            invalid[stk.pop()] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!invalid[i]) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    //Q.10.
    public static void simulateJVMStack(String[] events) {
        Stack<String> callStack = new Stack<>();

        for (String event : events) {
            System.out.println("Event: " + event);

            if (event.equalsIgnoreCase("return")) {
                if (!callStack.isEmpty()) {
                    String returnedFrom = callStack.pop();
                    System.out.println(" Popping: " + returnedFrom + " finished execution.");
                } else {
                    System.out.println("Error: Stack Underflow (Nothing left to return from).");
                }
            } else {
                callStack.push(event);
                System.out.println(" Pushing: " + event + " is now the active frame.");
            }

            System.out.print("Current Stack Trace: ");
            if (callStack.isEmpty()) {
                System.out.println("[EMPTY]");
            } else {
                for (int i = callStack.size() - 1; i >= 0; i--) {
                    System.out.print("[" + callStack.get(i) + "] ");
                }
                System.out.println();
            }
        }
    }

    //Q.8
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stk.isEmpty() && prices[stk.peek()] <= prices[i]) {
                stk.pop();
            }


            if (stk.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stk.peek();
            }

            stk.push(i);
        }
        return span;
    }
    //Q.1

    private Stack<Integer> historyStack = new Stack<>();
    private Integer currentResult = null;

    private int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return -1;
    }

    public void evaluate(String expression) {
        try {
            if (currentResult != null) {
                historyStack.push(currentResult);
            }

            List<String> postfix = convertToPostfix(expression);

            currentResult = calculatePostfix(postfix);
            System.out.println("Result: " + currentResult);
        } catch (Exception e) {
            System.out.println("Error: Invalid Expression");
        }
    }

    public void undo() {
        if (historyStack.isEmpty()) {
            currentResult = null;
            System.out.println("Nothing to undo. Stack is empty.");
        } else {
            currentResult = historyStack.pop();
            System.out.println("Undo successful. Current Result: " + currentResult);
        }
    }

    private List<String> convertToPostfix(String exp) {
        List<String> result = new ArrayList<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder num = new StringBuilder();
                while (i < exp.length() && Character.isDigit(exp.charAt(i))) {
                    num.append(exp.charAt(i++));
                }
                i--;
                result.add(num.toString());
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') result.add(String.valueOf(stack.pop()));
                stack.pop();
            } else if (precedence(c) > 0) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    result.add(String.valueOf(stack.pop()));
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) result.add(String.valueOf(stack.pop()));
        return result;
    }

    private int calculatePostfix(List<String> postfix) {
        Stack<Integer> stack = new Stack<>();
        for (String s : postfix) {
            if (s.matches("\\d+")) stack.push(Integer.parseInt(s));
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (s.charAt(0)) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    static void main(String[] args) {
        //Q2.
        SmartStack stk = new SmartStack();
        stk.push(10);
        stk.push(20);
        stk.push(30);
        System.out.println(stk.getMax());
        System.out.println(stk.getMin());
        //Q3.Decode Nested Encoded String
        decodeString("3[a2[b]]");
        decodeString("10[a]2[bc]");


    }
}
