#include <iostream>
using namespace std;
int k[2001][2001];

int max(int a,int b)
{ 
	if(a>b) 
		return a; 
	else 
		return b;
}

int main() {
	// your code goes here
	
	int s,n;
	cin>>s>>n;
	int w[n],v[n];
	for(int i=0;i<n;i++)
	{
		cin>>w[i]>>v[i];
	}
	
	for(int i=1;i<=n;i++)
	{
		for(int j=0;j<=s;j++)
		{
			if(i==0 || j==0)
				k[i][j] = 0;
			else if(w[i-1] <=j)
			{
				k[i][j] = max(v[i-1]+k[i-1][j-w[i-1]],k[i-1][j]);
			}
			else
				k[i][j] = k[i-1][j];
		}
	}
	cout<<k[n][s];
	
	return 0;
}
