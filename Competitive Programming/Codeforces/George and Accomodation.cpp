#include <stdio.h>
#include <iostream>
using namespace std;
int main(void) {
	// your code goes here
	int n;
	cin>>n;
	int count=0;
	while(n--)
	{
		int p,q;
		cin>>p>>q;
		if(q-p>=2)
		{
			count++;
		}
	}
	cout<<count<<endl;
	
	return 0;
}
