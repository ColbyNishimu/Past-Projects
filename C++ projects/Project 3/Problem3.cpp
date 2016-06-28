#include <iostream>
#include <ostream>
#include "hw3stack.h"
using namespace std;

Hw3Stack::Hw3Stack(){
	cout << "Please specify stack capacity: ";
	cin >> capacity;
	size = 0;
	stack = new stackItem[capacity];
}

Hw3Stack::Hw3Stack(Hw3Stack& stack){
	capacity = stack.capacity;
	size = stack.size;
	this->stack = stack.stack;
}

Hw3Stack::~Hw3Stack(){
	if (stack){
		delete[] stack;
	}
}

bool Hw3Stack::isEmpty(){
	if (size == 0){
		return true;
	}
	return false;
}

int Hw3Stack::getSize(){
	return size;
}

int Hw3Stack::getCapacity(){
	return capacity;
}

void Hw3Stack::push(stackItem item){
	stackItem* temp;

	size++;
	stack[size-1] = item;
	if (size == capacity){
		temp = new stackItem[capacity * 2];
		stack = temp;
	}
}

bool Hw3Stack::pop(){
	if (size == 0){
		return false;
	}
	size--;
	return true;
}

stackItem* Hw3Stack::top(){
	if (size == 0){
		return nullptr;
	}
	return &stack[size - 1];
}

void Hw3Stack::printStack(){
	for (int i = 0; i < size; i++){
		cout << stack[i].name << endl;
	}
}

void Problem3(){
	stackItem p = stackItem();
	p.name = "lol";
	stackItem o = stackItem();
	o.name = "nope";

	Hw3Stack first;
	cout << "First test: size = " << first.getSize() << ". expect 0" << endl;
	cout << "First test capacity = " << first.getCapacity() << ". expect User input amount" << endl;

	Hw3Stack second;
	second.push(p);
	second.printStack();
	second.push(o);
	second.printStack();
	second.pop();
	cout << second.top() << endl;
	if (second.isEmpty() == false){
		cout << "stack not empty" << endl;
	}
	cout << "Size = " << second.getSize() << ". expected 1" << endl;
}