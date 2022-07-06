//Karim Atalla
//Lab 3
//CS 839-1661

#include<iostream>
#include<iomanip>
#include<cctype>



using namespace std;

double getjudgescore(int judgenum);
double calcscore(double s1, double s2, double s3, double s4, double s5);
void findlowest(double &s1, double &s2, double &s3, double &s4, double &s5);
void findhighest(double &s1, double &s2, double &s3, double &s4, double &s5);

int main()
{
	cout << fixed << showpoint << setprecision(1);// this will make the output round the number to one decimal point.

	double score1, score2, score3, score4, score5, finalscore;

	cout << "Star Search score calculator 3000 " << endl;
	cout << "********************************* " << endl;

	score1 = getjudgescore(1);
	score2 = getjudgescore(2);
	score3 = getjudgescore(3);
	score4 = getjudgescore(4);
	score5 = getjudgescore(5);

	finalscore = calcscore(score1, score2, score3, score4, score5);
	cout << "---------------------------------" << endl;
	cout << "The Contestants final score is: " << finalscore << endl;
	
	return 0;
}

double getjudgescore(int judgenum)
{
	double judgescore;
	cout << "Judge " << judgenum << " please enter a score :";
	cin >> judgescore;
	
	while (judgescore < 0 || judgescore > 10)
	{
		cin.clear();
		cin.ignore(100, '\n');
		cout << "Please enter a valid score between 0.0 and 10.0 :";
		cin >> judgescore;
	}
	cin.ignore(100, '\n');
	return judgescore;

}

double calcscore(double s1, double s2, double s3, double s4, double s5)
{
	double average;

	findlowest(s1, s2, s3, s4, s5);

	findhighest(s1, s2, s3, s4, s5);

	average = (s1 + s2 + s3 + s4 + s5) / 3.0 ;
	return average;
}

void findlowest(double &s1, double &s2, double &s3, double &s4, double &s5)
{
	double temp;
	if (s2 < s1)
	{
		temp = s1;
		s1 = s2;
		s2 = temp;
	}
	if (s3 < s1)
	{
		temp = s1;
		s1 = s3;
		s3 = temp;
	}
	if (s4 < s1)
	{
		temp = s1;
		s1 = s4;
		s4 = temp;
	}
	if (s5 < s1)
	{
		temp = s1;
		s1 = s5;
		s5 = temp;
	}
	s1 = 0;
	
}

void findhighest(double &s1, double &s2, double &s3, double &s4, double &s5)
{
	double temp;
	if (s4 > s5)
	{
		temp = s4;
		s4 = s5;
		s5 = temp;
	}
	if (s3 > s5)
	{
		temp = s3;
		s3 = s5;
		s5 = temp;
	}
	if (s2 > s5)
	{
		temp = s2;
		s2 = s5;
		s5 = temp;
	}
	s5 = 0;
}