#include<iostream>
#include<string>
#include "triangle.h"
#include "rectangle.h"
#include "circle.h"
using namespace std;

void problem1(){
	double base;
	double height;
	int length;
	int width;
	double radius;

	cout << "Please enter the triangle's base: ";
	cin >> base;
	while (base < 0){
		cout << "Please enter a positive value: ";
		cin >> base;
	}
	cout << "Please enter the triangle's height: ";
	cin >> height;
	while (height < 0){
		cout << "Please enter a positive value: ";
		cin >> height;
	}
	cout << "Please enter the rectangles's length: ";
	cin >> length;
	while (length < 0){
		cout << "Please enter a positive value: ";
		cin >> length;
	}
	cout << "Please enter the rectangles's width: ";
	cin >> width;
	while (width < 0){
		cout << "Please enter a positive value: ";
		cin >> width;
	}
	cout << "Please enter the circle's radius: ";
	cin >> radius;
	while (radius < 0){
		cout << "Please enter a positive value: ";
		cin >> radius;
	}
	cout << "Area of triangle is: " << TriArea(base, height) << "." << endl;
	cout << "Area of rectangle is: " << RecArea(length, width) << "." << endl;
	cout << "Area of circle is: " << CirArea(radius) << "." << endl;
	return;
}