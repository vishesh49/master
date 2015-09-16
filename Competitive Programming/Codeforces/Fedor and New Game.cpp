#include <stdio.h>
#include <iostream>
using namespace std;
int main(void) {
	// your code goes here
	int n,m,k;
	cin>>n>>m>>k;
	int a[m+1];
	for(int i=0;i<=m;i++)
	{
		cin>>a[i];
	}
	long long ans=0,ns=0,exor;
	for(int i=0;i<m;i++)
	{
 		ns= 0;
		exor = a[m]^a[i];
		while(exor!=0)
		{
			if(exor%2==1)
				ns++;
			exor/=2;
		}
		if(ns<=k)
			ans++;
 
	}
	cout<<ans<<endl;
	
	return 0;
}
