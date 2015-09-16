#include <bits/stdc++.h>
#include <iostream>
using namespace std;

int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t--)
	{
		long long int n;
		cin>>n;
		
		long long int x = sqrt(n);
		long long int j=0;
		for(long long int i=x;i>=0;)
		{
			long long temp = i*i+j*j;
			if(j*j>n)
			{
				cout<<"No"<<endl;
				break;
			}
			if(temp==n)
			{
				cout<<"Yes"<<endl;
				break;
			}
			if(temp<n)
			{
				j++;
			}
			else
			{
				i--;
			}
		}
		
	}
	return 0;
}
