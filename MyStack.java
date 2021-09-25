import java.util.*;
public class MyStack<AnyType>{
  
    public int size = 0;
    public int topIndex = -1;
    public ArrayList<AnyType>container = new ArrayList<>();

    public int getSize()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void push(AnyType element)
    {
        container.add(++topIndex, element);
        size++;
        
    }
    
    public AnyType pop()
    {
        if(size == 0)
            throw new EmptyStackException();
    
        size--;
        return container.get(topIndex--);
    }

    public AnyType peek()
    {
        if(size == 0)
            throw new EmptyStackException();
       
        return container.get(topIndex);
    }

    public static boolean balanceEachOther(char x, char y)
    {
        /*
        Function to compare the two baraces characters and 
        checking if they are comlementary of each other
        */
        if((x == '{' && y == '}') || (x == '[' && y == ']') || (x == '(' && y == ')'))
            return true;
        return false;
    }

    public static boolean checkBalancedBraces(String s, MyStack<Character>helperStack)
    {
        /*
        Function to check if an expression of braces is balanced or not.
        */
        for(int i = 0; i<s.length(); i++)
        {
            if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[' )
                helperStack.push(s.charAt(i));
            else
            {
                if(helperStack.isEmpty() || !balanceEachOther(helperStack.peek(), s.charAt(i)))
                    return false;
                else
                    helperStack.pop();
               
            }
        }
        
        if(helperStack.getSize() != 0)
            return false;
        return true;
    }
    public static void main(String args[]){

        MyStack<Character>helperStack = new MyStack<>();


        System.out.println("TSETING STACK");
        for(int i = 0; i<10; i++)
        {
            helperStack.push("abcdefghijklmnopqrstwxyz".charAt(i));
            System.out.println("Pushed "+"abcdefghijklmnopqrstwxyz".charAt(i)+" into the stack");
        }

        System.out.println("Top element of the stack is: "+helperStack.peek());
        while(helperStack.getSize() > 0)
            System.out.println("Popping the current top from the stack which is: "+helperStack.pop());


        Scanner s = new Scanner(System.in);
        System.out.println("Enter the braces expression");
        String bracesExpression = s.nextLine();

        boolean isBalanced = checkBalancedBraces(bracesExpression, helperStack);
        System.out.println("The braces expression is balanaced is a "+isBalanced+" statment");

       

       
    
    }

}

