#include <bits/stdc++.h>
using namespace std;

int main() {
	// your code goes here
	char s[29];
	cin>>s;
	if(s[0]=='9')
	{
		
	}
	else if(s[0]>='5')
	{
		s[0] = '9' - s[0] + '0';
	}
	for(int i=1;i<strlen(s);i++)
	{
		if(s[i]>='5')
		{
			s[i] = '9' - s[i] + '0';
		}
	}
	for(int i=0;i<strlen(s);i++)
	{
		cout<<s[i];
	}
	cout<<"\n";
	
	return 0;
}
