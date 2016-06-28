
#include "Animal.h"
using namespace std;

class Dog : public Animal{
public:
	Dog(string name, int weight, int numOfLegs, int numOfClaws);
	int getClaws();
	void setClaws(int claws);
	virtual string getSound();
	virtual string getDescription();
private:
	int numOfClaws;
};


class Fish : public Animal{
public:
	Fish(string name, int weight, int numOfLegs, int numOfScales);
	int getScales();
	void setScales(int scales);
	virtual string getSound();
	virtual string getDescription();
private:
	int numOfScales;
};

class Chicken : public Animal{
public:
	Chicken(string name, int weight, int numOfLegs, int numOfBeaks);
	int getBeaks();
	void setBeaks(int beaks);
	virtual string getSound();
	virtual string getDescription();
private:
	int numOfBeaks;
};

class Spider : public Animal{
public:
	Spider(string name, int weight, int numOfLegs, bool isVenomous);
	bool getVenom();
	void setVenom(bool venom);
	virtual string getSound();
	virtual string getDescription();
private:
	bool isVenomous;
};