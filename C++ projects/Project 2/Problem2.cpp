#include<iostream>
#include<string>
#include <cstdlib>
#include <ctime>
using namespace std;

void problem2(){
	srand((unsigned int)time(NULL));
	int rannum = rand() % 101;
	int guess;
	bool correct = false;

	cout << "Please enter a value between 0 - 100 inclusive: ";
	while (correct == false){
		cin >> guess;
		if (guess < 0 || guess > 100){
			cout << "Invalid range, try again: ";
		}
		else if (guess > rannum){
			cout << "Too large, try again: ";
		}
		else if (guess < rannum){
			cout << "Too small, try again: ";
		}
		else
		{
			correct = true;
		}
	}
	cout << "That's correct! The number is " << rannum << "." << endl;
	return;
}