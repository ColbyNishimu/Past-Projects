#include<iostream>
#include<string>
#include "Animal.h"
#include "Species.h"
#include "listTemp.h"
using namespace std;

//DOG---------------------------------------------------------------------------------
Dog::Dog(string name, int weight, int legs, int claws) : Animal(name, weight, legs){
	numOfClaws = claws;
}

int Dog::getClaws(){
	return numOfClaws;
}

void Dog::setClaws(int claws){
	numOfClaws = claws;
}

string Dog::getSound(){
	return "Worf Worf";
}
string Dog::getDescription(){
	return "Dog...Name: " + getName() + ". Weight: " + to_string(getWeight()) + ". #Legs: " + to_string(getLegs()) + ". #Claws: " + to_string(getClaws()) + ". Sound: " + getSound();
}

//FISH-------------------------------------------------------------------------------
Fish::Fish(string name, int weight, int legs, int scales) : Animal(name, weight, legs){
	numOfScales = scales;
}

int Fish::getScales(){
	return numOfScales;
}

void Fish::setScales(int scales){
	numOfScales = scales;
}

string Fish::getSound(){
	return "=O....=|";
}
string Fish::getDescription(){
	return "Fish...Name: " + getName() + ". Weight: " + to_string(getWeight()) + ". #Legs: " + to_string(getLegs()) + ". #Scales: " + to_string(getScales()) + ". Sound: " + getSound();
}

//CHICKEN---------------------------------------------------------------------------------
Chicken::Chicken(string name, int weight, int legs, int beaks) : Animal(name, weight, legs){
	numOfBeaks = beaks;
}

int Chicken::getBeaks(){
	return numOfBeaks;
}

void Chicken::setBeaks(int beaks){
	numOfBeaks = beaks;
}

string Chicken::getSound(){
	return "Bawk Bawk";
}
string Chicken::getDescription(){
	return "Chicken...Name: " + getName() + ". Weight: " + to_string(getWeight()) + ". #Legs: " + to_string(getLegs()) + ". #Beaks: " + to_string(getBeaks()) + ". Sound: " + getSound();
}

//SPIDER--------------------------------------------------------------------------------------
Spider::Spider(string name, int weight, int legs, bool venom) : Animal(name, weight, legs){
	isVenomous = venom;
}

bool Spider::getVenom(){
	return isVenomous;
}

void Spider::setVenom(bool venom){
	isVenomous = venom;
}

string Spider::getSound(){
	return "...OOH MY GOSH";
}

string Spider::getDescription(){
	return "Spider...Name: " + getName() + ". Weight: " + to_string(getWeight()) + ". #Legs: " + to_string(getLegs()) + ". IsVenomous: " + to_string(getVenom()) + ". Sound: " + getSound();
}

void Problem2(){
	cout << "Problem 2" << endl;
	list<Animal*>* p = new list<Animal*>;
	Animal* d = new Dog("Fido", 20, 4, 16);
	Animal* f = new Fish("Goldy", 1, 0, 30);
	Animal* c = new Chicken("Little", 8, 2, 1);
	Animal* s = new Spider("Jumper", 1, 8, false);
	p->insert(d);
	p->insert(f);
	p->insert(c);
	p->insert(s);
	cout << p->at(0)->getDescription() << endl;
	cout << p->at(1)->getDescription() << endl;
	cout << p->at(2)->getDescription() << endl;
	cout << p->at(3)->getDescription() << endl;
}