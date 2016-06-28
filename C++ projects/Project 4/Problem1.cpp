#include<iostream>
#include<string>
#include "listTemp.h"
using namespace std;

void Problem1(){
	cout << "Problem 1:" << endl;
	list<int> p = list<int>();
	cout << "created empty list" << endl;
	cout << "List should be empty: " << p.empty() << endl;
	p.insert(9);
	cout << "'9' entered. First(should be 9): " << p.first() << ". Last(should be 9): " << p.last() << endl;
	p.insert(8);
	p.insert(7);
	cout << "'8' and '7' entered. First(should be 9): " << p.first() << ". Last(should be 7): " << p.last() << endl;
	cout << "Element at index 1 should be 8: " << p.at(1) << endl;
	p.remove(2);
	cout << "Removed '7'. Last(Should be 8): " << p.last() << endl;
	try{
		p.at(2);
	}
	catch(InvalidIndexException e){
		cout << "Attempted to access index 2. Exception thrown" << endl;
	}
	list<int> q = list<int>();
	try{
		q.first();
	}
	catch(EmptyListException e){
		cout << "Attempted to access first in empty list. Exception thrown" << endl;
	}
	try{
		q.last();
	}
	catch (EmptyListException e){
		cout << "Attempted to access last in empty list. Exception thrown" << endl;
	}
	try{
		q.remove(1);
	}
	catch (InvalidIndexException e){
		cout << "Attempted to remove index 1 in empty list. Exception Thrown" << endl;
	}
	p.insert(1);
	p.insert(2);
	p.insert(3);
	p.insert(4);
	p.insert(5);
	p.insert(6);
	p.insert(7);
	p.insert(8);
	try{
		p.insert(10);
	}
	catch (FullListException e){
		cout << "Attempted to add to full list. Exception thrown" << endl;
	}
}