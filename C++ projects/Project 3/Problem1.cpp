#include<iostream>
#include<string>
#include<vector>
using namespace std;

void Problem1(){
	int listOfScores[100] = { NULL };
	int categories[10] = { 0 };
	int score;
	double total = 0;
	double sum = 0;
	int highest = 0;
	int lowest = 101;

	for(int i = 0; i < 100; i++){
		cout << "Please enter the student"<< "'"<< "s grade between 0 - 100: ";
		if (!(cin >> score)){
			cin.clear();
			cin.ignore(1000, '\n');
			cout << endl;
			break;
		}
		while (score < 0 || score > 100){
			cout << "Error, please re-enter the student"<< "'" << "s grade between 0 - 100: ";
			if (!(cin >> score)){
				cin.clear();
				cin.ignore(1000, '\n');
				cout << endl;
				goto next;
			}
		}
		listOfScores[i] = score;
	}

	next:for (int i = 0; i <= 99; i++){
		if (listOfScores[i] == NULL){
			break;
		}
		else{
			total++;
			sum = sum + listOfScores[i];
			if (listOfScores[i] > highest){
				highest = listOfScores[i];
			}
			if (listOfScores[i] < lowest){
				lowest = listOfScores[i];
			}
			if (listOfScores[i] == 0){
				categories[0]++;
				continue;
			}
			if (listOfScores[i] == 100){
				categories[9]++;
				continue;
			}
			if (listOfScores[i] % 10 != 0){
				categories[((int)listOfScores[i] / 10)]++;
			}
			else{
				categories[((int)listOfScores[i] / 10)-1]++;
			}
		}
	}

	for (int i = 0; i < 9; i++){
		cout << 91 - (i * 10) << " - " << 100 - (i * 10) << "\t|" << string(categories[9-i], '#') << endl;
	}
	cout << "0 - 10\t|" << string(categories[0], '#') << endl;
	cout << "Total Scores: " << total << endl;
	cout << "Highest Score: " << highest << endl;
	cout << "Lowest Score: " << lowest << endl;
	cout << "Average Score: " << sum / total << endl;
}