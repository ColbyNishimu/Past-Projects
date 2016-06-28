#ifndef Animal_H
#define Animal_H
class Animal{
public:
	Animal(std::string name, int weight, int numOfLegs);
	std::string getName();
	void setName(std::string name);
	int getWeight();
	void setWeight(int weight);
	int getLegs();
	void setLegs(int legs);
	virtual std::string getSound() = 0;
	virtual std::string getDescription() = 0;
private:
	std::string name;
	int weight;
	int numOfLegs;
	std::string sound;
	std::string description;
};
Animal::Animal(std::string name, int weight, int legs){
	this->name = name;
	this->weight = weight;
	numOfLegs = legs;
}

std::string Animal::getName(){
	return this->name;
}

void Animal::setName(std::string name){
	this->name = name;
}

int Animal::getWeight(){
	return this->weight;
}

void Animal::setWeight(int weight){
	this->weight = weight;
}

int Animal::getLegs(){
	return this->numOfLegs;
}

void Animal::setLegs(int legs){
	this->numOfLegs = legs;
}

#endif