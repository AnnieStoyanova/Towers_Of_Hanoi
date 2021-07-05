#include <iostream>
#include <stack>

using namespace std;

char moveDisk(stack<int>& first, stack<int>& second)
{
    if (second.empty()) 
    {
        second.push(first.top());
        first.pop();
        return 'n';
    }
    else if (first.empty()) 
    {
        first.push(second.top());
        second.pop();
        return 'r';
    }
    else
    {
        if (second.top() > first.top()) 
        {
            second.push(first.top());
            first.pop();
            return 'n';
        }
        else 
        {
            first.push(second.top());
            second.pop();
            return 'r';
        }
    }
}

int printMessage(int disk, char place, char toGo)
{
    cout << "Moving disk " << disk << " from";
    if (place == 'l') cout << " left ";
    else if (place == 'm') cout << " middle ";
    else if (place == 'r') cout << " right ";
    cout << "peg to";
    if (toGo == 'l') cout << " left ";
    else if (toGo == 'm') cout << " middle ";
    else if (toGo == 'r') cout << " right ";
    cout << "peg.\n";
    return 0;
}

int printPeg(stack<int>& peg)
{
    while (!(peg.empty()))
    {
        cout << "DISK_" << peg.top() << endl;
        peg.pop();
    }
    return 0;
}

int towersOfHanoi(int n, stack<int>& left, stack<int>& middle, stack<int>& right)
{
    const int MOVES = pow(2, n) - 1;
    char l = 'l';
    char m = 'm';
    char r = 'r';

    if (!(n & 1))// if number of disks is even   
    {
        char tmp = m; 
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
                printMessage(right.top(), l, r);
            else
                printMessage(left.top(), r, l);
        }
        else if (i % 3 == 2)
        {
            result = moveDisk(left, middle);
            if (result == 'n')
                printMessage(middle.top(), l, m);
            else
                printMessage(left.top(), m, l);
        }
        else 
        {
            result = moveDisk(middle, right);
            if (result == 'n')
                printMessage(right.top(), m, r);
            else
                printMessage(middle.top(), r, m);
        }
    }

    cout << "\nFinal state of right peg:\n";
    if (!(n & 1)) printPeg(middle);
    else printPeg(right);
     
    return 0;
}

int main()
{
    stack<int> left, middle, right;
    int n;
    cout <<"--------------Towers of Hanoi puzzle < introduced 1883 >--------------\n\n\n";
    cout << "Please enter number of disks to be moved: ";
    cin >> n;
    while (n <= 0)
    {
        cout << "Invalid value of number of disks!\n";
        cout << "Number must be greater than zero.\n";
        cout << "Please enter a valid number of disks: ";
        cin >> n;
    }
    cout << "\n\nSteps performed:\n\n";
    if (!(n & 1)) // if number of disks is even
        towersOfHanoi(n, left, right, middle);
    else
        towersOfHanoi(n, left, middle, right);
    return 0;
}