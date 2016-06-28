#include<iostream>
#include<string>
using namespace std;

void problem4(){
	int ans1;
	int ans2;
	int ans3;
	int ans4;
	double correct = 0;

	cout << "Welcome to our math quiz program! Please enter the answers to the" << endl;
	cout << "following questions: " << endl;
	cout << "5! = ";
	cin >> ans1;
	cout << "(2^(2^(2^2))) = ";
	cin >> ans2;
	cout << "3*(4+8)/((4*2)/(5-1)) = ";
	cin >> ans3;
	cout << "2+2 = ";
	cin >> ans4;

	if (ans1 == 15){
		correct++;
	}
	if (ans2 == 65536){
		correct++;
	}
	if (ans3 == 18){
		correct++;
	}
	if (ans4 == 4){
		correct++;
	}
	cout << "Number of correct answers: " << correct << endl;
	cout << "Number of incorrect answers: " << 4 - correct << endl;
	cout << "Quiz percentage: " << (correct / 4) * 100 << "%";
	return;
}
