#ifndef StudentInfo_H
#define	StudentInfo_H
#include <string>
class StudentInfo{
	public:
		StudentInfo(std::string name, char grade);
		std::string getName();
		void setName(std::string newName);
		char getGrade();
		void setGrade(char newGrade);
		~StudentInfo();
//		int nameCompare(StudentInfo s1);
	private:
		std::string name;
		char grade;
};

StudentInfo::StudentInfo(std::string name, char grade){
	this->name = name;
	this->grade = grade;
}

std::string StudentInfo::getName(){
	return this->name;
}

void StudentInfo::setName(std::string newName){
	this->name = newName;
}

char StudentInfo::getGrade(){
	return this->grade;
}

void StudentInfo::setGrade(char newGrade){
	this->grade = newGrade;
}

//int StudentInfo::nameCompare(StudentInfo s1){
//	return ((std::string)tolower(s1->getName()).compare(tolower(this->getName())));
//}
#endif