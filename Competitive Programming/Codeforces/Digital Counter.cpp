#include <iostream>
using namespace std;

int main() {
	// your code goes here
	
	char x;
	cin>>x;
	char y;
	cin>>y;
	
	int a=0;
	int b=0;
	
	if(x=='0')
	{
		a=2;
	}
	else if(x=='1')
	{
		a=7;
	}
	else if(x=='2')
	{
		a=2;
	}
	else if(x=='3')
	{
		a=3;
	}
	else if(x=='4')
	{
		a=3;
	}
	else if(x=='5')
	{
		a=4;
	}
	else if(x=='6')
	{
		a=2;
	}
	else if(x=='7')
	{
		a=5;
	}
	else if(x=='8')
	{
		a=1;
	}
	else if(x=='9')
	{
		a=2;
	}
	
	
	if(y=='0')
	{
		b=2;
	}
	else if(y=='1')
	{
		b=7;
	}
	else if(y=='2')
	{
		b=2;
	}
	else if(y=='3')
	{
		b=3;
	}
	else if(y=='4')
	{
		b=3;
	}
	else if(y=='5')
	{
		b=4;
	}
	else if(y=='6')
	{
		b=2;
	}
	else if(y=='7')
	{
		b=5;
	}
	else if(y=='8')
	{
		b=1;
	}
	else if(y=='9')
	{
		b=2;
	}
	
	int ans = a*b;
	cout<<ans<<endl;
	return 0;
}
