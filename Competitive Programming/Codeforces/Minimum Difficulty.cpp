#include <iostream>
using namespace std;

int main() {
	// your code goes here
	int n;
	cin>>n;
	int a[200];
	for(int i=0;i<n;i++)
	{
		cin>>a[i];
	}
	int min=50000;
	int max=-1,x;
	for(int i=0;i<n-1;i++)
	{
		x= a[i+1]-a[i];
		if(x>max)
		{
			max=x;
		}
	}
	for(int i=1;i<n-1;i++)
	{
		int d = a[i+1]-a[i-1];
		
		if(d<min)
		{
			min=d;
		}
	}
	if(min<max)
	{
		min=max;
	}
	cout<<min<<endl;
	return 0;
}
