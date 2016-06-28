#include<iostream>
#include<string>
#include<vector>
#include "StudentInfo.h"
using namespace std;

vector<StudentInfo*> insert(vector<StudentInfo*> vec, StudentInfo* s){
	if (vec.empty()){
		vec.push_back(s);
		return vec;
	}
	vector<StudentInfo*>::iterator k = vec.begin();
	for (int i = 0; i < (int)vec.size(); i++){
		if (k[i]->getName().compare(s->getName()) > 0){
			vector<StudentInfo*>* temp = new vector < StudentInfo* >;
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

void Problem1(){
	vector<StudentInfo*>* v = new vector<StudentInfo*>;
	StudentInfo* s1 = new StudentInfo("Steven", 'A');
	StudentInfo* s2 = new StudentInfo("Emily", 'B');
	StudentInfo* s3 = new StudentInfo("George", 'C');
	StudentInfo* s4 = new StudentInfo("Craig", 'D');
	cout << "names added: Steven, Emily, George, Craig" << endl;
	*v = insert(*v, s1);
	*v = insert(*v, s2);
	*v = insert(*v, s3);
	*v = insert(*v, s4);
	cout << "vector created. Printing out in vector's order:" << endl;
	vector<StudentInfo*>::iterator p = v->begin();
	for (int i = 0; i < (int)v->size(); i++){
		cout << p[i]->getName() << endl;
	}
}