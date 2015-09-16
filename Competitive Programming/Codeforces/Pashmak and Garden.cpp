#include <iostream>
#include <stdio.h>      /* printf */
#include <stdlib.h>
using namespace std;

int main() {
	// your code goes here
	int x1,x2,y1,y2;
	cin>>x1>>y1>>x2>>y2;
	int side = 0,x3,y3;
	if(x1==x2)
	{
		side = abs(y2-y1);
		x3 = x1+side;
		cout<<x3<<" "<<y1<<" "<<x3<<" "<<y2<<endl;
		
	}
	else if(y1==y2)
	{
		side = abs(x2-x1);
		y3 = y1+side;
		cout<<x1<<" "<<y3<<" "<<x2<<" "<<y3<<endl;
		
	}
	else if(abs(x1-x2) == abs(y1-y2))
	{
		cout<<x1<<" "<<y2<<" "<<x2<<" "<<y1<<endl;
	}
	else
	{
		cout<<"-1"<<endl;
	}
	
	return 0;
}
