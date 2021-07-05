import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Stack;
import java.util.Collections;


public class TowersOfHanoi {

    private static Stack<Integer> left = new Stack<>();
    private static Stack<Integer> middle = new Stack<>();
    private static Stack<Integer> right = new Stack<>();
    private static int MOVES;


    public static void main(String[] args)
    {
        System.out.println("--------------Towers of Hanoi puzzle < introduced 1883 >--------------");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the desired number of disks: ");
        int n = scanner.nextInt();
        while (n <= 0)
        {
            System.out.println("Invalid value of number of disks!%n");
            System.out.println("Number must be greater than zero.&n");
            System.out.println("Please enter a valid number of disks: ");
            n = scanner.nextInt();
        }
        System.out.println();
        System.out.println();
        System.out.println("Steps performed:");
        if (n%2 == 0) // if number of disks is even
            towersOfHanoi(n, left, right, middle);
        else
            towersOfHanoi(n, left, middle, right);
    }


    static char moveDisk (Stack<Integer> first, Stack<Integer> second)
    {
        if (second.empty())
        {
            second.push(first.peek());
            first.pop();
            return 'n';
        }
        else if (first.empty())
        {
            first.push(second.peek());
            second.pop();
            return 'r';
        }
        else
        {
            if (second.peek() > first.peek())
            {
                second.push(first.peek());
                first.pop();
                return 'n';
            }
            else
            {
                first.push(second.peek());
                second.pop();
                return 'r';
            }
        }
    }


    static int printMessage(int disk, char place, char toGo)
    {
        System.out.print("Moving disk " + disk + " from");
        if (place == 'l') System.out.print( " left ");
        else if (place == 'm') System.out.print( " middle ");
        else if (place == 'r') System.out.print( " right ");
        System.out.print("peg to");
        if (toGo == 'l') System.out.print( " left ");
        else if (toGo == 'm') System.out.print( " middle ");
        else if (toGo == 'r') System.out.print( " right ");
        System.out.println( "peg.");
        return 0;
    }

    static int printPeg(Stack<Integer> peg)
    {
        while (!(peg.empty()))
        {
            System.out.println("DISK_" + peg.peek());
            peg.pop();
        }
        return 0;
    }

       static int towersOfHanoi(int n, Stack<Integer> left, Stack<Integer> middle, Stack<Integer> right)
    {
        int MOVES = (int)(Math.pow(2, n) - 1);
        char l = 'l';
        char m = 'm';
        char r = 'r';

        if (n%2 == 0)// if number of disks is even
        {
            char tmp = m;  // to print correct
            m = r;
            r = tmp;
        }

        for (int i = n; i >= 1; i--) left.push(i);

        char result;

        for (int i = 1; i <= MOVES; i++)
        {
            if (i % 3 == 1)
            {
                result = moveDisk(left, right);
                if (result == 'n')
                    printMessage(right.peek(), l, r);
                else
                    printMessage(left.peek(), r, l);
            }
            else if (i % 3 == 2)
            {
                result = moveDisk(left, middle);
                if (result == 'n')
                    printMessage(middle.peek(), l, m);
                else
                    printMessage(left.peek(), m, l);
            }
            else
            {
                result = moveDisk(middle, right);
                if (result == 'n')
                    printMessage(right.peek(), m, r);
                else
                    printMessage(middle.peek(), r, m);
            }
        }
        System.out.println();
        System.out.println("Final state of right peg:");
        if (n%2 == 0) printPeg(middle);
        else printPeg(right);
        return 0;
    }
}