
#ifndef COURSES_H
#define COURSES_H
#include<iostream>
#include<string>
#include<iomanip>
using namespace std;
int menu();

class courses
{
private:
	
public:
	string title;
	int number;
	char grade;
	courses()
	{
		title = "      ";
		number = 0;
		grade = ' ';
	};
	static int addcourses(courses* mainarray[10], int size);
	
	static int deletecourses(courses* mainarray[10], int size);
	
	static void listcourses(courses* mainarray[10], int size);

	static void sortcourses(courses* mainarray[10], int size);

	static void editcourses(courses* mainarray[10], int size);

	static void getinfo(courses* mainarray);

	static void calcgpa(courses* mainarray[10],int size);

	static void searchcourses(courses* mainarray[10], int size);

	static void displaycourses(courses* mainarray);

	~courses()
	{};
};

#endif