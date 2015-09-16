#include <stdio.h>
#include <iostream>
using namespace std;
int main() {
	// your code goes here
	string inp;
	cin>>inp;
	if(inp=="0")cout<<4;
	else 
	{
		int ans=1;
	int t=1;
	unsigned long long num=0;
	//cout<<inp[inp.length()-1]-'0'<<endl;
	if(inp.length()!=1)
	num = (inp[inp.length()-2]-'0')*10 + inp[inp.length()-1]-'0';
else
	num = inp[inp.length()-1]-'0';
	//	cout<<num;


		if(num%4==1)
			ans=(1+2+3+4)%5;
		else if(num%4==2)
			ans=(1+4+9+6)%5;
		else if(num%4==3)
			ans=(1+8+7+4)%5;
		else 
			ans=(1+6+1+6)%5;
		cout<<ans;
	}
	return 0;
}
