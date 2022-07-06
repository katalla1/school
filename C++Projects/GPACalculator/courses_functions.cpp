#include "courses.h"

//defenitions for class courses go here 
void courses::searchcourses(courses* mainarray[10], int size)
{
	string name;
	bool match = false;
	cout << "Enter a course name to display: ";
	cin >> name;

	for(int i = 0; i < size ; i++)
		if (name == mainarray[i]->title)
		{
			courses::displaycourses(mainarray[i]);
			match = true;
		}
	if(!match)
	{
		cout << "No Matching courses found!\n";
	}
}

void courses::editcourses(courses* mainarray[10], int size)
{
	int input = 0;
	courses::listcourses(mainarray, size);
	cout << "Enter a course to edit:";
	cin >> input;
	courses::getinfo(mainarray[input - 1]);
}

void courses::sortcourses(courses* mainarray[10], int size)
{
	courses* temp;
	bool switched = true;
	
	while (switched)
	{
		switched = false;
		for (int i = 0; i < size - 1; i++)
		{
			if (mainarray[i]->title[0] > mainarray[i + 1]->title[0])
			{ 
				temp = mainarray[i];
				mainarray[i] = mainarray[i + 1];
				mainarray[i + 1] = temp;
				switched = true;
			}

			if (mainarray[i]->title[0] == mainarray[i + 1]->title[0])
			{
				if (mainarray[i]->title[1] > mainarray[i + 1]->title[1])
				{
					temp = mainarray[i];
					mainarray[i] = mainarray[i + 1];
					mainarray[i + 1] = temp;
					switched = true;				}
			}
		}
	}
}
void courses::displaycourses(courses* mainarray)
{
	cout << mainarray->title << " " << mainarray->number << " " << mainarray->grade << endl;
}
void courses::listcourses(courses* mainarray[10], int size)
{
	courses::sortcourses(mainarray, size);
	
	for (int i = 0; i < size; i++)
	{		
		cout << i + 1 << ": " ;
		courses::displaycourses(mainarray[i]); 
	}	
}

int courses::addcourses(courses* mainarray[10], int size)
{
	mainarray[size] = new courses;
	courses::getinfo(mainarray[size]);
	size++;
	return size;
}

 int courses::deletecourses(courses* mainarray[10], int size)
{
	for (int i = 0; i < size; i++)
	{
		delete mainarray[i];
		mainarray[i] = NULL;
	}
	size = 0;
	cout << endl;
	cout << "All courses deleted\n";// deletes all courses
	cout << endl;

	return size;
}
 
 void courses::calcgpa(courses* mainarray[10], int size)
 {
	 cout << fixed << setprecision(2);
	 double gpa = 0.0;
	 int grade = 0, totalunits = 0, totalgradepoints = 0, gradepoints = 0;
	 
	 for (int i = 0; i < size; i++)
	 {
		 grade = 0;
		 totalunits += mainarray[i]->number;
		 if (toupper(mainarray[i]->grade) == 'A')
		 {
			 grade = 4;
		 }
		 if (toupper(mainarray[i]->grade) == 'B')
		 {
			 grade = 3;
		 }
		 if (toupper(mainarray[i]->grade) == 'C')
		 {
			 grade = 2;
		 }
		 if (toupper(mainarray[i]->grade) == 'D')
		 {
			 grade = 1;
		 }
		 if (toupper(mainarray[i]->grade) == 'F')
		 {
			 grade = 0;
		 }
		 gradepoints = grade * (mainarray[i]->number);
		 totalgradepoints += gradepoints;
	 }
	 gpa = double(totalgradepoints) / double(totalunits);
	 if (totalunits == 0)
	 {
		 gpa = 0;
	 }
	 cout << "GPA: " << gpa << endl;
 }
 void courses::getinfo(courses* mainarray)
 {

	 cin.ignore();
	 cout << "Please enter course title:";
	 cin >> mainarray->title;
	 cin.ignore();
	 cout << "Please enter number of units:";
	 cin >> mainarray->number;
	 cin.ignore();
	 cout << "Please enter course grade:";
	 cin >> mainarray->grade;
	 cin.ignore();
	 cout << endl;

 }

 int menu()//menu display
{
	int select = 0;
	
	cout << "1.Add new course\n";
	cout << "2.Edit an existing course\n";
	cout << "3.Display a course\n";
	cout << "4.List all courses\n";
	cout << "5.Display GPA\n";
	cout << "6.Delete all courses\n";
	cout << "7.Quit\n";
	cout << endl;
	cout << "Enter your selection: ";
	cin >> select;
	
	while (select > 7 || select < 1)
	{
		if (cin.fail())
		{
			cin.clear();
			cin.ignore(32767, '\n');
		}
		cout << "Error Please enter a valid selection(1-7)\n";
		cout << "Enter your selection: ";
		cin >> select;
	}
	return select;

}; 