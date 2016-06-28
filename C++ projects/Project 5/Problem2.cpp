#include<iostream>
#include<string>
#include<map>
#include<vector>
#include<fstream>
using namespace std;

vector<string> insert(vector<string> vec, string s){
	if (vec.empty()){
		vec.push_back(s);
		return vec;
	}
	vector<string>::iterator k = vec.begin();
	for (int i = 0; i < (int)vec.size(); i++){
		if (k[i].compare(s) > 0){
			vector<string>* temp = new vector < string >;
			for (int j = 0; j < (int)vec.size(); j++){
				if (j == i){
					temp->push_back(s);
					temp->push_back(k[j]);
				}
				else{
					temp->push_back(k[j]);
				}
			}
			return *temp;
		}
	}
	vec.push_back(s);
	return vec;
}

void Problem2(){
	map<string, vector<string>> college;
	ifstream in;
	ofstream out;
	in.open("input.txt");
	out.open("output.txt");
	string state = "";
	string uni = "";
	vector<string> states;

	while (!in.eof()){
		getline(in, state, ';');
		getline(in, uni);
		if (college.count(state) == 0){
			college[state] = vector < string > { uni };
		}
		else{
			college[state] = insert(college[state], uni);
		}
		if (find(states.begin(), states.end(), state) == states.end()){
			states = insert(states, state);
		}
	}

	vector<string>::iterator v = states.begin();
	for (int i = 0; i < (int)college.size(); i++){
		for (int k = 0; k < (int)college[v[i]].size(); k++){
			out << v[i] << " ; " << college[v[i]][k] << endl;
		}
	}
	in.close();
	out.close();
}