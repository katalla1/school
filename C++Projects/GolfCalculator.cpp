//Karim Atalla
//CS 839 
// Project 1


#include <iostream>
#include <string>
#include <fstream>
#include <iomanip>
#include <Windows.h>
#include <cctype>
using namespace std;

class screendraw
{

private:
	HANDLE screen;

public:
	string a;
	screendraw()

	{
		screen = GetStdHandle(STD_OUTPUT_HANDLE);
	}

	screendraw(HANDLE s)
	{
		screen = s;
	}

	void placeCurser(int, int);

	void drawline(int, int, int, char);

	void drawstring(int, int, string);

	void drawstring(string);

	void cleartop()
	{
		drawline(2, 1, 79, ' ');
	}
	
	void clearbox()
	{
		for (int i = 4; i < 25; i++)
		{
			placeCurser(i, 1);
				for (int a = 0; a < 80; a++)
				{
					drawchar(' ');
				}
		}
	}

	void drawchar(char a)
	{
		cout << a;
	}

};
void screendraw::drawstring(string a)
{
	cout << a;
}

void screendraw::placeCurser(int row, int col)
{
	COORD pos;
	pos.Y = row;
	pos.X = col;
	SetConsoleCursorPosition(screen, pos);
}
void screendraw::drawstring(int a, int b, string word)
{
	placeCurser(a, b);
	drawstring(word);
}


void screendraw::drawline(int r, int c, int width, char A)
{
	placeCurser(r, c);

	for (int line = 0; line < width; line++)
		drawchar(A);

}

class handicap
{
private:

public:
	screendraw xd;
	string input;
	char choice;
	int scor[20];
	char peekchar;
	int i = 0;
	int sorted[20];
	int h;
	int sum;
	int temp;
	bool swap;
	char getinput(int a, int b)
	{
		xd.placeCurser(a, b);

		cin >> input;

		choice = toupper(input[0]);

		return choice;
	}
	string getname(int a, int b)
	{
		string first;
		xd.placeCurser(a, b);

		cin >> first;

		return first;
	}
	void getscores()
	{
		while (i < 20)
		{
			cin >> scor[i];
			i++;

			peekchar = cin.peek();

			while (peekchar == ' ')
			{
				peekchar = cin.get();
				peekchar = cin.peek();
			}
			if (peekchar == '\n')
				break;

		}
		

	}
	int calc( int n, int f, int D[])
	{
		for (int i = 0; i < n; i++)
			sorted[i] = D[i];

		do
		{
			swap = false;
			for (int count = 0; count < (n - 1); count++)
			{
				if (sorted[count] > sorted[count + 1])
				{
					temp = sorted[count];
					sorted[count] = sorted[count + 1];
					sorted[count + 1] = temp;
					swap = true;
				}
			}

		} while (swap);

			
		for (int u = 0; u < f; u++)
			sum += (sorted[u] - 72);

		h = (sum / f) * 0.96;
		return h;
	}
	int araycount(int A[])
	{
		for (int a = 0; a < 20; a++)
		{
			if (A[a] == 0)
				return a;
			
			
		}

		return 20;
	}


};

int main()
{
	screendraw sd;
	int araycount1, araycount2, araycount3, free;
	int z = 0;
	int scores[20] = { 0 };
	int tempscore[20] = { 0 };
	string name, name1;
	int handicaps;
	handicap gh;
	char choice;
	ifstream saved;
	ofstream saved1;
	sd.drawstring(1, 27, "Simple Golf Handicapper");
	sd.drawline(3, 1, 80, '-');
	sd.drawline(26, 1, 80, '*');
	sd.drawstring(27, 1, "| Name | Add | Update | Clear | List | Help | Save | Quit |");
	sd.drawstring(28, 1, "Command: ");
	
	choice = gh.getinput(28, 10);

	while (choice != 'Q')
	{
		switch (choice)
		{
		case 'N':	sd.clearbox();
			sd.cleartop();
			name = gh.getname(28, 10);
			name1 = name;
			name += ".txt";
			saved.open(name.c_str());
			if (saved)
			{
				for (int i = 0; i < 20; i++)

					saved >> scores[i];
				break;
			}
			else
			{
				saved1.open(name.c_str());
			}
			//get name and create file to write to
		case 'C':	sd.clearbox();
			sd.cleartop();
			scores[20] = 0;
			name = " ";
			//clear all scores and name
			break;

		case 'A':	sd.clearbox();
			sd.cleartop();
			sd.placeCurser(28, 10);
					gh.getscores();
					for (int j = 0; j < 20; j++)
					{
						scores[j] = gh.scor[j];
					}
					araycount1 = gh.araycount(gh.scor);//added
					free = 20 - araycount1;
					araycount2 = gh.araycount(scores);//already saved if any
					
					for (int i = araycount2 - free; i < araycount2; free--)
					{
						tempscore[z] = scores[araycount2 - free];
						z++;
					}
					free = 20 - araycount1;
					for (int x = (free - 1); x < 20; x++)
					{
						int m = 0;
						tempscore[x] = gh.scor[m];
						m++;
					}
					for (int j = 0; j < 20; j++)
					{
						scores[j] = tempscore[j];
					}
					
					

			//add scores into the scores array
			break;
		case 'U':	sd.clearbox();
			sd.cleartop();
			araycount3 = gh.araycount(scores);
			if (araycount3 < 5)
				handicaps = 0;
			else if (araycount3 == 5 || araycount3 == 6)
				handicaps = gh.calc(araycount3, 1, scores);
			else if (araycount3 == 7 || araycount3 == 8)
				handicaps = gh.calc(araycount3, 2, scores);
			else if (araycount3 == 9 || araycount3 == 10)
				handicaps = gh.calc(araycount3, 3, scores);
			else if (araycount3 == 11 || araycount3 == 12)
				handicaps = gh.calc(araycount3, 4, scores);
			else if (araycount3 == 13 || araycount3 == 14)
				handicaps = gh.calc(araycount3, 5, scores);
			else if (araycount3 == 15 || araycount3 == 16)
				handicaps = gh.calc(araycount3, 6, scores);
			else if (araycount3 == 17)
				handicaps = gh.calc(araycount3, 7, scores);
			else if (araycount3 == 18)
				handicaps = gh.calc(araycount3, 8, scores);
			else if (araycount3 == 19)
				handicaps = gh.calc(araycount3, 9, scores);
				
				//calculate handicap
			break;
		
		case 'L':   sd.clearbox();
			sd.cleartop();
			sd.placeCurser(2, 1);
			cout << "User: " << name1 << "             Rounds; " << araycount3 << "                  Handicap: " << handicaps;
			sd.placeCurser(4, 1);
			cout << "Round       Score";
			for (int i = 0; i < araycount3; i++)
			{
				sd.placeCurser(4 + i, 1);
				cout << i + 1 << "     " << scores[i];
			}

			// list scores and ones used for calc
			break;

		case 'H':   sd.clearbox();
			sd.cleartop();
			sd.drawstring(4, 1, "Commands:\n Name <user>     Followed by the name of the user data(if any) to be loaded\n Add<#>          Followed by one or more scores to be added to the data\n Update          Recalculate the handicap and update history\n Clear		clears all data and handicap and update history\n list		Lists all recorded scores and handicap history\n Help		This help\n Save		Saves the current user data and exits the application\n Quit		Exits that application without saving any data\n\n Only the first character of the command is required at the prompt\n Arguments in <> may be entered immediately after command or when prompted"); 
			//display help menu
			break;

		case 'S':	sd.clearbox();
			sd.cleartop();
			saved1.open(name.c_str());
			for (int i = 0; i < 20; i++)

				saved1 << scores[i];

			saved1.close();
			
			//save file
			break;
		}

				sd.drawline(28, 10, 72, ' ');
				choice = gh.getinput(28, 10);
				saved.close();
				saved1.close();
	}
	

	return 0;
}