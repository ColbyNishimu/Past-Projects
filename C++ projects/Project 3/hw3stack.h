#ifndef hw3stack_H
#define hw3stack_H
#include "stackitem.h"
using namespace std;

class Hw3Stack {
public:
	// Default constructor that prompts the user for the stack
	//capacity, initializes the stack with the capacity, and sets
	// the size to zero.
	Hw3Stack();
	// Copy constructor that takes a current stack and copies the
	// current size, capacity, and stackItems into the current
	// object.
	Hw3Stack(Hw3Stack& stack);
	// Destructor that deletes the stack
	~Hw3Stack();
	// Returns true if there are no items in stack, false otherwise.
	bool isEmpty();
	// Returns the current size of Hw3Stack.
	int getSize();
	// Returns the current capacity of the stack.
	int getCapacity();
	// Adds the stackItem to the stack. If the stack size is equal to
	// the capacity after insertion, copy all of the current
	// stackItems into a new array with double the current capacity
	// and set the current stack array to the new array.
	void push(stackItem item);
	// Removes the top stackItem. Returns true if successful. Returns
	// false otherwise (i.e. if the stack is empty).
	bool pop();
	// Returns a reference to the top stackItem, but does not remove
	// the top stackItem. If empty, you may return nullptr.
	stackItem* top();
	// Prints the stack contents’ names from top to bottom.
	void printStack();
private:
	int capacity; // capacity of the stack
	int size; // current size of the stack
	stackItem* stack; // pointer to the array stack
};
#endif