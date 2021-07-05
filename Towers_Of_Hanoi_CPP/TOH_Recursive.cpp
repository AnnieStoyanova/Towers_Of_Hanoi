#include <iostream>
using namespace std;

int towersOfHanoi(int n, const char* left, const char* middle, const char* right)
{
	if (n == 1)
	{
		cout << "Moving disk 1 from " << left << " to " << right << endl;
		return 0;
	}
	towersOfHanoi(n - 1, left, middle, right);
	cout << "Moving disk " << n << " from " << left << " to " << right << endl;
	towersOfHanoi(n - 1, left, right, middle);
}

int main()
{
	int n;
	const char left[] = "left peg";
	const char middle[] = "middle peg";
	const char right[] = "right peg";
	cout << "--------------Towers of Hanoi puzzle < introduced 1883 >--------------\n\n\n";
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
	towersOfHanoi(n, left, middle, right);
	return 0;
}