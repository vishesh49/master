#include <iostream>
using namespace std;

int main() {
	// your code goes here
	int n;
	cin>>n;
	int a[n+1];
	for(int i=0;i<=n;i++)
		a[i]=0;
	int p,x;
	cin>>p;
	for(int i=0;i<p;i++)
	{
		cin>>x;
		a[x]=1;
	}
	int q,y;
	cin>>q;
	for(int i=0;i<q;i++)
	{
		cin>>y;
		a[y]=1;
	}
	int flag=1;
	for(int i=1;i<=n;i++)
	{
		if(a[i]==1)
			continue;
		else if(a[i]!=1)
		{
			flag=0;
		}
	}
	if(flag==0)
	{
		cout<<"Oh, my keyboard!";
	}
	else
	{
		cout<<"I become the guy.";;
	}
	
	return 0;
}
