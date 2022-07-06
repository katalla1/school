//Karim Atalla
//CS 839 
// Project 2A


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
	int choice;
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

	void drawstring(int, int, string, int);

	void drawstring(string);

	void drawchar(char a)
	{
		cout << a;
	}

	void drawint(int a)
	{
		cout << a;
	}

	void clearbox()
	{
		for (int i = 3; i < 16; i++)
		{
			drawline(i, 1, 125, ' ');
		}
	}

	void clearline()
	{
		drawline(28, 1, 120, ' ');
	}
	int getchoice(int a, int b)
	{
		placeCurser(a, b);
		drawstring(a, b, "       ");
		placeCurser(a, b);
		cin >> choice;
		while (choice < 1 || choice > 9)
		{
			drawstring(a, b, "       ");
			placeCurser(a, b);
			cin >> choice;
		}
		return choice;
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

void screendraw::drawstring(int a, int b, string word, int c)
{
	placeCurser(a, b);
	drawstring(word);
	placeCurser(a, b + 14);
	drawint(c);


}



void screendraw::drawline(int r, int c, int width, char A)
{
	placeCurser(r, c);

	for (int line = 0; line < (width - 1); line++)
		drawchar(A);

}

struct info
{
	int year;
	string years;
	string winnercity;
	string winnername;
	string losercity;
	string losername;
};





class series
{
private:

public:
	info raw[150];
	string value;
	string teamname;
	string cityname;
	string seperate1;
	string seperate2;
	string inputname;
	screendraw draw;
	bool match[150];
	bool match2[150];
	int count = 0;
	string listw[150];
	string listl[150];
	string listc[150];
	int wincount[150];
	int losscount[150];
	int citycount[150];
	int decade;

	series()
	{
		for (int i = 0; i < 150; i++)
		{
			raw[i].year = 0;
			raw[i].years = "0";
			raw[i].winnername = " ";
			raw[i].winnercity = " ";
			raw[i].losername = " ";
			raw[i].losercity = " ";
			match[i] = false;
			match2[i] = false;
			listw[i] = " ";
			listl[i] = " ";
			listc[i] = " ";
			wincount[i] = 0;
			losscount[i] = 0;
			citycount[i] = 0;
		}
	}
	void getdata()
	{
		

		ifstream file;
		file.open("world_series_data.csv");


		

		while (file.good())
		{
			while (file.eof() == false)
			{
				getline(file, value, ',');
				raw[count].years = value;
				getline(file, value, ',');
				raw[count].winnername = value;
				getline(file, value, '\n');
				raw[count].losername = value;
				count++;
			}
			count--;
			for (int i = 1; i < count; i++)
			{
				raw[i].year = stoi(raw[i].years);

			}

		}
		file.close();
		


		for (int i = 1; i < count; i++)
		{
			teamname = "";
			cityname = "";

			size_t where = 0;

			seperate1 = raw[i].winnername;

			char carray[100];

			strcpy(carray, seperate1.c_str());

			while (carray[where] > ' ')
			{
				cityname += carray[where];
				where++;
			}
			if (cityname == "Los" || cityname == "New" || cityname == "St." || cityname == "San" || cityname == "Kansas")
			{
				cityname += ' ';
				where++;
				while (carray[where] > ' ')
				{
					cityname += carray[where];
					where++;
				}
			}
			where++;
			while (carray[where] > ' ')
			{
				teamname += carray[where];
				where++;
			}
			if (teamname == "White" || teamname == "Red" || teamname == "Blue")
			{
				teamname += ' ';
				where++;
				while (carray[where] > ' ')
				{
					teamname += carray[where];
					where++;
				}

			}

			raw[i].winnername = teamname;
			raw[i].winnercity = cityname;

		}

		for (int i = 1; i < count; i++)
		{
			teamname = "";
			cityname = "";

			size_t where = 0;

			seperate2 = raw[i].losername;

			char carray[100];

			strcpy(carray, seperate2.c_str());

			while (carray[where] > ' ')
			{
				cityname += carray[where];
				where++;
			}
			if (cityname == "Los" || cityname == "New" || cityname == "St." || cityname == "San" || cityname == "Kansas" || cityname == "Tampa")
			{
				cityname += ' ';
				where++;
				while (carray[where] > ' ')
				{
					cityname += carray[where];
					where++;
				}
			}
			where++;
			while (carray[where] > ' ')
			{
				teamname += carray[where];
				where++;
			}
			if (teamname == "White" || teamname == "Red" || teamname == "Blue")
			{
				teamname += ' ';
				where++;
				while (carray[where] > ' ')
				{
					teamname += carray[where];
					where++;
				}

			}
			raw[i].losername = teamname;
			raw[i].losercity = cityname;

		}
	}





	void calcwinners()
	{
		//winptr = list of all winners
		//wincount[] = array to store wins
		string *winptr;
		winptr = new string[150];
		int temp1;
		string temp2;
		for (int i = 0; i < 150; i++)
		{
			wincount[i] = 0;
		}
		
		for (int i = 1; i < count; i++)
		{
			winptr[i] = raw[i].winnername;
		}
		int counter3 = count;
		for (int i = 0; i < counter3; i++)
			for (int j = i + 1; j < counter3;)
			{
				if (winptr[i] == winptr[j])
				{
					for (int k = j; k < counter3 - 1; k++)
						winptr[k] = winptr[k + 1];

					counter3--;
				}
				else
				{
					j++;
				}
				

			}
		for (int i = 0; i < counter3; i++)
		{
			for (int j = 1; j < count; j++)
			{
				if (winptr[i] == raw[j].winnername)
				{
					wincount[i] += 1;
				}
			}
		}
		// now sort wincount and parrallel winptr to it
		bool swap ;
		
			for (int i = 1; i < counter3; i++)
			{
				swap = false;
				for (int j = 1; j < counter3 - i; j++)
				{
					if (wincount[j] < wincount[j + 1])
					{
						temp1 = wincount[j];
						wincount[j] = wincount[j + 1];
						wincount[j + 1] = temp1;
						temp2 = winptr[j];
						winptr[j] = winptr[j + 1];
						winptr[j + 1] = temp2;
						swap = true;
					}
				}
				if (swap == false)
					break;
			}
			int x = 3;
			int y = 2;
			for (int i = 1; i < counter3; i++)
			{
				draw.drawstring(x, y, winptr[i], wincount[i]);
				x++;
				if (x > 15)
				{
					y = 19;
					x = 3;
				}
			}
		delete[] winptr;
	}
	void calclosers()
	{

		//lossptr = list of all losers
		//loscount[] = array to store losses
		string *lossptr;
		lossptr = new string[150];
		int temp1;
		string temp2;
		for (int i = 0; i < 150; i++)
		{
			losscount[i] = 0;
		}

		for (int i = 1; i < count; i++)
		{
			lossptr[i] = raw[i].losername;
		}
		int counter4 = count;
		for (int i = 0; i < counter4; i++)
			for (int j = i + 1; j < counter4;)
			{
				if (lossptr[i] == lossptr[j])
				{
					for (int k = j; k < counter4 - 1; k++)
						lossptr[k] = lossptr[k + 1];

					counter4--;
				}
				else
				{
					j++;
				}


			}
		for (int i = 0; i < counter4; i++)
		{
			for (int j = 1; j < count; j++)
			{
				if (lossptr[i] == raw[j].losername)
				{
					losscount[i] += 1;
				}
			}
		}
		// now sort wincount and parrallel winptr to it
		bool swap;

		for (int i = 1; i < counter4; i++)
		{
			swap = false;
			for (int j = 1; j < counter4 - i; j++)
			{
				if (losscount[j] > losscount[j + 1])
				{
					temp1 = losscount[j];
					losscount[j] = losscount[j + 1];
					losscount[j + 1] = temp1;
					temp2 = lossptr[j];
					lossptr[j] = lossptr[j + 1];
					lossptr[j + 1] = temp2;
					swap = true;
				}
			}
			if (swap == false)
				break;
		}
		int x = 3;
		int y = 2;
		for (int i = 1; i < counter4; i++)
		{
			draw.drawstring(x, y, lossptr[i], losscount[i]);
			x++;
			if (x > 15)
			{
				y += 16;
				x = 3;
			}
		}
		delete[] lossptr;


	}
	
	void calcneverwon()
	{
		int x = 3;
		int y = 2;
		
		for (int i = 1; i < count ; i++)
		{
			int z = 1;
			while (z < count )
			{
				if (raw[i].losername == raw[z].winnername)
				{
					match[i] = false;
					break;
				
				}
				if (raw[i].losername != raw[z].winnername)
				{
					match[i] = true;
					
				}
				z++;
			}
		}
		int counter = 0;
		for (int i = 1; i < count; i++)
		{
			if (match[i] == true)

			{
				
				listl[counter] = raw[i].losername;
				counter++;
			
			}
		}
		for(int i = 0; i < counter; i++)
			for (int j = i + 1; j < counter;)
			{
				if (listl[i] == listl[j])
				{
					for (int k = j; k < counter - 1; k++)
						listl[k] = listl[k + 1];

					counter--;
				}
				else
				{
					j++;
				}
			}
		for (int i = 0; i < counter; i++)
		{
			draw.drawstring(x, y, listl[i]);
			x++;
		}
	}
	void calcneverlost()
	{
		int x = 3;
		int y = 2;

		for (int i = 1; i < count; i++)
		{
			int o = 1;
			while (o < count)
			{
				if (raw[i].winnername == raw[o].losername)
				{
					match2[i] = false;
					break;

				}
				if (raw[i].winnername != raw[o].losername)
				{
					match2[i] = true;

				}
				o++;
			}
		}
		
		int counter2 = 0;
		for (int i = 1; i < count; i++)
		{
			if (match2[i] == true)

			{

				listw[counter2] = raw[i].winnername;
				counter2++;
				
			}
		}
		
		
		for (int i = 0; i < counter2; i++)
			for (int j = i + 1; j < counter2;)
			{
				if (listw[i] == listw[j])
				{
					for (int k = j; k < counter2 - 1; k++)
						listw[k] = listw[k + 1];

					counter2--;
				}
				else
				{
					j++;
				}
			}
		for (int i = 0; i < counter2; i++)
		{
			draw.drawstring(x, y, listw[i]);
			x++;
		}
	}
	void calcplayed()
	{
		int x = 3;
		int y = 2;
		int z = 9;
		int t = 22;

		draw.drawstring(28, 2, "Enter team name: ");
		cin.ignore();
		getline(cin, inputname);

		draw.drawstring(x, y, "Year");
		draw.drawstring(x, z, "Winner");
		draw.drawstring(x, t, "Loser");
		x++;
		for (int i = 1; i < count; i++)
		{		
			if (x > 15)
			{
				x = 3;
				y += 31;
				z += 31;
				t += 31;
				draw.drawstring(x, y, "Year");
				draw.drawstring(x, z, "Winner");
				draw.drawstring(x, t, "Loser");
				x++;

			}
			
			if ((inputname == raw[i].winnername) || (inputname == raw[i].losername))
			{
				draw.drawstring(x, y, raw[i].years);
				draw.drawstring(x, z, raw[i].winnername);
				draw.drawstring(x, t, raw[i].losername);
				x++;
			}
		}

	}
	void calcdecade()
	{
		int x = 3;
		int y = 2;
		int z = 9;
		int t = 22;
		int decade2;
		draw.drawstring(28, 2, "Enter a decade (eg: 1960): ");
		cin >> decade;
		decade2 = decade;

		for (int i = 1; i < count; i++)
		{		
			while (raw[i].year > decade2)
			{
				decade2++;
			}
			
			if (decade2 == raw[i].year)
			{
				draw.drawstring(x, y, raw[i].years);
				draw.drawstring(x, z, raw[i].winnername);
				draw.drawstring(x, t, raw[i].losername);
				x++;
				decade2++;

			}
			
			if (decade2 > (decade + 9))
			{
				break;
			}

		}
	}
	int calccity()
	{
		for (int i = 0; i < 150; i++)
		{
			citycount[i] = 0;
		}
		for (int i = 1; i < count; i++)
		{
			listc[(i - 1)] = raw[i].winnercity;
		}
		int counter5 = count;

		for (int i = 0; i < counter5; i++)
			for (int j = i + 1; j < counter5;)
			{
				if (listc[i] == listc[j])
				{
					for (int k = j; k < counter5 - 1; k++)
						listc[k] = listc[k + 1];

					counter5--;
				}
				else
				{
					j++;
				}
			}
		counter5--;
		//listc is now the short list of winning cities
		//citycount will count wins for said city
		for (int i = 0; i < counter5; i++)
		{
			for (int j = 1; j < count; j++)
			{
				if (listc[i] == raw[j].winnercity)
				{
					citycount[i] += 1;
				}
			}
		}
		
		return counter5;
	}
	void outputcity()
	{
		int counter5 = calccity();
		
		
		bool swap2;
		int temp3;
		string temp4;
		for (int i = 1; i < counter5; i++)
		{
			swap2 = false;
			for (int j = 0; j < counter5 - i; j++)
			{
				if (citycount[j] < citycount[j + 1])
				{
					temp3 = citycount[j];
					citycount[j] = citycount[j + 1];
					citycount[j + 1] = temp3;
					temp4 = listc[j];
					listc[j] = listc[j + 1];
					listc[j + 1] = temp4;
					swap2 = true;
				}
			}
			if (swap2 == false)
				break;

		}

		int x = 3;
		int y = 2;
		
		
		draw.drawstring(x, y, "City");
		draw.drawstring(x, (y + 13), "Wins");
		x++;

		for (int i = 0; i < counter5 ; i++)
		{
			
			draw.drawstring(x, y , listc[i], citycount[i]);
			x++;
			if (x > 14)
			{
				x = 3;
				y += 31;
				draw.drawstring(x, y, "City");
				draw.drawstring(x, (y + 13), "Wins");
				x++;
			}
			
		}

	}
	void calccitymulti()
	{
		
		
		int counter5 = calccity();

		
		bool swap3;
		int temp4;
		string temp5;
		for (int i = 1; i < counter5; i++)
		{
			swap3 = false;
			for (int j = 0; j < counter5 - i; j++)
			{
				if (listc[j][0] > listc[j + 1][0])
				{
					temp4 = citycount[j];
					citycount[j] = citycount[j + 1];
					citycount[j + 1] = temp4;
					temp5 = listc[j];
					listc[j] = listc[j + 1];
					listc[j + 1] = temp5;
					swap3 = true;
				}
			}
			if (swap3 == false)
				break;

		}
		// lisctc is winner cities in alphabetical order based on first char, citycount has ammount of wins for said city
		// use count above 2 for multi wins and check to see if more than one team

		int x = 3;
		int y = 2;
		draw.drawstring(x, y, "City         Team 1       Wins   Team 2       Wins   Team 3       Wins");
		x++;
		for(int i = 0; i < counter5; i++)
			{
			string team1 = "nothing", team2 = "nothing", team3 = "nothing";
			int count1 = 0, count2 = 0, count3 = 0;
			
			if (citycount[i] > 1)
			{
				
				for (int j = 1; j < count; j++)
				{
					if (raw[j].winnercity == listc[i])
					{
						if (team1 == raw[j].winnername)
						{
							count1++;
						}
						if (team2 == raw[j].winnername)
						{
							count2++;
						}
						if (team3 == raw[j].winnername)
						{
							count3++;
						}


						if (team1 == "nothing")
						{
							team1 = raw[j].winnername;
							count1++;
						}

						if ((count1 > 0) && (team2 == "nothing") && (team1 != raw[j].winnername))
						{
							team2 = raw[j].winnername;
							count2++;
						}
						if ((count2 > 0) && (team3 == "nothing") && (team1 != raw[j].winnername) && (team2 != raw[j].winnername))
						{
							team3 = raw[j].winnername;
							count3++;
						}
					}
				}
				
				if (count1 > 0 && count2 > 0 && count3 == 0)
				{
					//draw 2 teams
					
						draw.drawstring(x, y, listc[i]);
						draw.drawstring(x, y + 13, team1, count1);
						draw.drawstring(x, (y + 33), team2, count2);
				
					x++;
				}
				if (count1 > 0 && count2 > 0 && count3 > 0)
					//draw 3 teams
				{
					draw.drawstring(x, y, listc[i]);
					draw.drawstring(x, y + 13, team1, count1);
					draw.drawstring(x, (y + 33), team2, count2);
					draw.drawstring(x, (y + 53), team3, count3);
					
					x++;
					
				}

			}
			
			}
	}
};

int main()
{
	// i googled this to make the console window bigger
	HWND console = GetConsoleWindow();
	RECT r;
	GetWindowRect(console, &r);
	MoveWindow(console, r.left, r.top, 800, 400, TRUE);
	//googled code 
	
	screendraw sd;
	int choice;
	series s1;

	s1.getdata();// get input from file

	sd.drawstring(1, 25, "World Series");
	sd.drawline(2, 1, 125, '*');
	sd.drawline(16, 1, 125, '*');
	sd.drawstring(17, 2, "1: Displays teams that have won the World Series");
	sd.drawstring(18, 2, "2: Displays teams that lost the World Series");
	sd.drawstring(19, 2, "3: Displays teams that have played the World Series and never won");
	sd.drawstring(20, 2, "4: Displays teams that have played the World Series and never lost");
	sd.drawstring(21, 2, "5: Displays years played for a team");
	sd.drawstring(22, 2, "6: Displays decade results");
	sd.drawstring(23, 2, "7: Displays cities that have won");
	sd.drawstring(24, 2, "8: Displays cities with wins from multiple teams");
	sd.drawstring(25, 2, "9: Quit Program");
	sd.drawline(26, 1, 125, '*');
	sd.drawstring(27, 2, "Enter a Choice: ");
	choice = sd.getchoice(27, 18);

	while (choice != 9)
	{
		switch (choice)
		{
		case 1:sd.clearbox();
			sd.clearline();
			s1.calcwinners();
				break;
		case 2:sd.clearbox();
			sd.clearline();
			s1.calclosers();	
			break;
		case 3: sd.clearbox();
			sd.clearline();
			s1.calcneverwon();
			break;
		case 4:sd.clearbox();
			sd.clearline();
			s1.calcneverlost();
			break;
		case 5: sd.clearbox();
			sd.clearline();
			s1.calcplayed();

			break;
		case 6: sd.clearbox();
			sd.clearline();
			s1.calcdecade();
			break;

		case 7:sd.clearbox();
			sd.clearline();
			s1.outputcity();
			break;

		case 8:sd.clearbox();
			sd.clearline();
			s1.calccitymulti();
			break;

		}

		choice = sd.getchoice(27, 18);
	}
	sd.clearline();
	sd.drawstring(28, 2, "Goodbye\n");

	return 0;
}