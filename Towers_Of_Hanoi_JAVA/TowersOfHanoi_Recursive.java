import java.util.Scanner;


public class TowersOfHanoi_Recursive
{

    public static void main( String args[])
    {
        String left = " left peg";
        String middle = " middle peg";
        String right = " right peg";
        System.out.println("--------------Towers of Hanoi puzzle < introduced 1883 >--------------");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the desired number of disks: ");
        int n = scanner.nextInt();
        while (n <= 0)
        {
            System.out.println("Invalid value of number of disks!");
            System.out.println("Number must be greater than zero.");
            System.out.print("Please enter a valid number of disks: ");
            n = scanner.nextInt();
        }
        System.out.println();
        System.out.println();
        System.out.println("Steps performed:");
        towersOfHanoi(n, left, middle, right);
    }

    static void towersOfHanoi(int n, String left, String middle, String right)
    {
        if(n == 1)
        {
            System.out.println("Moving disk 1 from " + left + " to "+ right);
            return;
        }
        towersOfHanoi(n-1, left, middle,right);
        System.out.println("Moving disk " + n + " from " + left + " to " + right);
        towersOfHanoi(n-1, left, right, middle);
    }
}
