#include <bits/stdc++.h>
using namespace std;

int main() {
	// your code goes here
	int white=0;
	int black=0;
	for(int i=0;i<8;i++)
	{
		for(int j=0;j<8;j++)
		{
			char x;
			cin>>x;
			if(x=='q')
			{
				black += 9;
			}
			else if(x=='r')
			{
				black += 5;
			}
			else if(x=='b')
			{
				black += 3;
			}
			else if(x=='n')
			{
				black+= 3;
			}
			else if(x=='p')
			{
				black += 1;
			}
			else if(x=='k')
			{
				
			}
			else if(x=='Q')
			{
				white += 9;
			}
			else if(x=='R')
			{
				white += 5;
			}
			else if(x=='B')
			{
				white += 3;
			}
			else if(x=='N')
			{
				white+= 3;
			}
			else if(x=='P')
			{
				white += 1;
			}
			else if(x=='K')
			{
				
			}
		}
	}
	if(white>black)
	{
		cout<<"White\n";
	}
	else if(white<black)
	{
		cout<<"Black\n";
	}
	else
	{
		cout<<"Draw\n";
	}
	
	
	return 0;
}
