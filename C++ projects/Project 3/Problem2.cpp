#include<iostream>
#include<string>
#include <ctime>
#include "length.h"
using namespace std;

void Problem2(){
	srand((unsigned int)time(NULL));
	int randArray[4][6];
	int rowSum;
	int totalSum = 0;
	int max = 0;
	string row = "";

	for (int i = 0; i < 4; i++){
		rowSum = 0;
		for (int j = 0; j < 6; j++){
			int temp = rand() % 26;
			randArray[i][j] = temp;
			rowSum = rowSum + temp;
			totalSum = totalSum + temp;
			cout << temp << "\t";
		}
		if (rowSum > max){
			max = rowSum;
		}
		cout << "| sum: " << rowSum << endl;
	}
	cout << "Max Row = " << max << endl;
	cout << "Number of elements = " << getLength(randArray, 4) << endl;
	cout << "Total Sum = " << totalSum << endl;
}
