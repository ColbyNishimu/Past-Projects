#include<iostream>
#include<string>
using namespace std;

void printnums(int n){
	if (n < 0){
		return;
	}
	else{
		cout << n << " ";
		printnums(n - 1);
	}
}

void printnumsreverse(int n){
	if (n < 0){
		return;
	}
	else{
		printnumsreverse(n - 1);
		cout << n << " ";
	}
}

int power(int base, int exponent){
	if (exponent == 0){
		return 1;
	}
	else{
		return base * power(base, exponent - 1);
	}
}

bool isPrime(int num, int divisor){
	if (divisor == 1){
		return true;
	}
	else if (num % divisor == 0){
		return false;
	}
	else{
		return isPrime(num, divisor - 1);
	}
}

void problem3(){
	int printnum;
	int base;
	int exponent;
	int prime;


	cout << "Please enter a positive number: ";
	cin >> printnum;
	printnums(printnum);
	cout << endl;
	printnumsreverse(printnum);
	cout << endl;
	cout << "Please enter a base: ";
	cin >> base;
	cout << "Please enter an exponent: ";
	cin >> exponent;
	cout << power(base, exponent) << endl;
	cout << "Please enter a postive number: ";
	cin >> prime;
	if (isPrime(prime, 2) == true){
		cout << prime << " is a prime number." << endl;
	}
	else{
		cout << prime << " is not a prime number." << endl;
	}
	return;
}