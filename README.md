### Towers_Of_Hanoi

## Documentation by Anna Stoyanova

# Content:
1. The task
2. Analysis of the task’s problem and description of possible solutions
3. Description of the solution approach used
4. Complexity of the algorithm

# TOWERS OF HANOI
In the Towers of Hanoi problem there are three pegs (posts) and n disks of different sizes. Each disk has a hole in the middle so that it can fit on any peg. At the beginning of the game, all n disks are all on the first peg, arranged such that the largest is on the bottom, and the smallest is on the top (so the first peg looks like a tower). The goal of the game is to end up with all disks on the third peg, in the same order, that is, smallest on top, and increasing order towards the bottom. But, there are some restrictions to how the disks are moved (which make the problem non-trivial): (1) The only allowed type of move is to grab one disk from the top of one peg and drop it on another peg. That is, you cannot grab several disks at one time. (2) A larger disk can never lie above a smaller disk, on any post. The legend says that the world will end when a group of monks, somewhere in a temple, will finish this task with 64 golden disks on three diamond pegs.

# ANALYSIS AND DESCRIPTION

The mathematical game can be solved recursively or iteratively. 
The three pegs are named as following left, middle and right.
Iterative solution can be implemented first by checking if number of disks is even or odd. If it is even, then we have to switch the values of right and middle peg. There are many possible solutions. Here with the help of functions and stacks the puzzle is solved. 
The recursive algorithm for solving the problem is based on the principle of moving many disks by reducing the count. A large number of disks can be moved correctly by moving one of them and then bringing the problem back to the case, where the other disks are being moved by the rules, described before. For example if we already have the solution for moving three disks, and the given input is the number four, we will move one disk and the task is reduced to the previous one. 
#DESCRIPTION OF THE SOLUTION APPROACH USED
The problem is solved iteratively and recursively.

* Iterative solution

The iterative solution is achieved with the help of four functions and three stacks, representing the three pegs, which are named left, middle and right. First method implements moving a disk between two pegs. It has two parameters. Both of them are stacks of integers, called by a reference (in cpp), for changes to be made directly on the stacks, not on their copies. There are four cases: first or second peg to be empty (without any disks on them) or the disk on the top of the first or the second to be larger than the top of the other respectively. Following the rules the disk is moved according to the case. This function is of type char, because except to move disk legally also it does one more important thing. It returns a character that gives information if we are in the case where a disk is moved from the first peg or from the second one (depending which peg holds the larger disk). This matters when the result (performed step) is being printed. That function returns the character ‘n’, assumed as normal – disk is moved from the first to the second peg. And the character ‘r’  –  assumed as reversed – disk is moved from the second to the first peg. 
Another function is implemented that is responsible for printing the step that has to be performed. It simply takes three parameters. First is an integer, representing which disk is moved, second and third are characters – representing from which peg to which peg the movement has been made. 
One extra function is realized to print the state of a peg. It has one parameter stack of integers, given by a reference, for not use extra memory by making a copy of the given stack. 
The most important function for solving the problem takes four parameters – an integer, representing the number of disks, and three stacks of integers, respectively left, middle and right. Moves that has to be moved are calculated by the power of 2 to n minus one. In this type of solution is important to check whether the number of disks is even or odd. That matters, because when it is even, middle and right peg are being exchanged for to save some needless moves. This change is made only on the names of the pegs. Iteratively from 1 to the moves, calculated before, every time where the iteration can be divided to three (number of pegs) has remainder of 1, a movement between left and right peg is made. If the iteration divided by three gives has a remainder of 2, disk is moved from left to middle. Finally if iteration can be divided by three without remainder, the movement is between middle and right peg. 
In the main function first is made a validation of the input, then a check if it is even or odd. If even the function is called with swapped places of its arguments of middle and right peg.

* Recursive solution 

The recursion principle is implemented by the help of a function (or method (in java)), that calls itself with a change in the number of disks. The function has four parameters: first is an integer that represents the number of disks, second, third and fourth are constant arrays of characters (Strings in java). The three pegs are named left, middle and right. The aim is to move all of the disks correctly (following the described rules) from the left peg to the right one. Three of the parameters represent the names of the three pegs. It’s being assumed that all of the disks are arranged on the left peg. 
The bottom of the recursion is reached when number of disks is equal to one. Before reaching this step, the function is called with number of disks, decreased by one and the same parameters as above. This means that some of the disks can be moved legally to the right peg, but there are cases, where the middle peg should be used as a temporary holder. Without this middle peg the puzzle can’t be solved. This is the reason why the function is called again, this time with change in the order of its parameters. The places of destination and the temporary helping holder are exchanged. In the main function is made a validation of the input and then the function is called. 
	COMPLEXITY OF THE ALGORITHM
In both iterative and recursive solution complexity of the algorithm is calculated by the iterations that have to be made. According to the above calculation complexity is
 O=2^n-1
If we have to compare the recursive and iterative solution by their speed in execution, the iterative solution is faster, because the set of local variables and parameters used by the function are newly created each time the function calls itself and are stored at the top of the stack. On the other hand recursion definitely reduces the size of the code. 
In conclusion we may say that recursions are easy to write and read, but their performance, considered by time and memory utilization rate, is not good enough as compared to iteration.

