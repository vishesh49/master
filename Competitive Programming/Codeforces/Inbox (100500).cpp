#include<bits/stdc++.h>
using namespace std;
int main() {
	// your code goes here
	long long k,n,ans=0;
	long long a[1005],temp[1005];
	cin>>n;
	for(int i=0;i<n;i++)
	{
		cin>>a[i];
	}
	for(int i=0;i<n;i++)
		temp[i]=0;
	int test=0;
	if(a[0]==1)
	{
		temp[0]=1;
		test=1;
	}
	else
	{
		temp[0]=0;
	}
	for(int i=1;i<n;i++)
	{
		
		if(test==0 && a[i]==1)
		{
			temp[i]=a[i];
			test=1;
		}
		else if(a[i-1]==1 && a[i]==1)
			temp[i]=1;
		else if(a[i]==1)
			temp[i]=2;
		else 
			temp[i]=0;
	}
	for(int i=0;i<n;i++)
	{
		ans=ans+temp[i];
	}
	cout<<ans<<endl;
	return 0;
}
