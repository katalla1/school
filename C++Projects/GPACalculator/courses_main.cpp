#include "courses.h"

int main() 
{
	int selection, size = 0;
	courses* mainarray[10] = { NULL };
	
	do{
		selection = menu(); 
		switch (selection)
		{
		case 1: size = courses::addcourses(mainarray, size);
			break;
		case 2:	courses::editcourses(mainarray, size);
			break;
		case 3: courses::searchcourses(mainarray, size); 
			break;
		case 4: courses::listcourses(mainarray, size);              
			break;
		case 5: courses::calcgpa(mainarray, size);   //display gpa							  needs work************
			break;
		case 6: size = courses::deletecourses(mainarray, size);					
			break;
		}
	} while (selection != 7);

	size = courses::deletecourses(mainarray, size);
	cout << endl;
	
	return 0;
}