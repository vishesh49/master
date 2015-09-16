#include <bits/stdc++.h>
using namespace std;

int main() {
	// your code goes here
	long long a,b;
	cin>>a>>b;
	long long count=0;
	
	if(a<b)
	{
		long long temp = a;
		a=b;
		b=temp;
	}
	
	if(a>b && b!=0)
	{
		count = a/b;
		a = a%b;
	}
	if(b>a && a!=0)
	{
		count += b/a;
		b = b%a;
	}
	while(a!=0 && b!=0)
	{
		if(a>b)
		{
			a = a-b;
		}
		else
		{
			b = b-a;
		}
		count++;
	}
	cout<<count<<"\n";
	
	return 0;
}
