package Exercises.week1.JavaBasics1.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack();

        System.out.println("*********** The size in the beginning ***********");
        System.out.println(s.getSize());

        s.push(22);
        s.push(23);

        System.out.println("*********** The size after push  ***********");
        System.out.println(s.getSize());

        int i = s.pop();

        System.out.println("*********** The size after pop  ***********");
        System.out.println(s.getSize());

        System.out.println("the poped item is : " + i + " and the top item is : " + s.top());



        Stack<String> strStack = new Stack();

        System.out.println("*********** The size in the beginning ***********");
        System.out.println(strStack.getSize());

        strStack.push("omar");
        strStack.push("NYRO");

        System.out.println("*********** The size after push  ***********");
        System.out.println(strStack.getSize());

        String str = strStack.pop();

        System.out.println("*********** The size after pop  ***********");
        System.out.println(strStack.getSize());

        System.out.println("the poped item is : " + str + " and the top item is : " + strStack.top());


    }
}
