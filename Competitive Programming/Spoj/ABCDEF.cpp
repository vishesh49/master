#include <bits/stdc++.h>
using namespace std;


int res1[1000005];
int res2[1000005];
int cnt1[1000005];
int cnt2[1000005];

int main() {
	// your code goes here
	int n;
	cin>>n;
	int s[n];
	for(int i=0;i<n;i++)
	{
		cin>>s[i];
	}
	int x=0;
	for(int a=0;a<n;a++)
	{
		for(int b=0;b<n;b++)
		{
			for(int c=0;c<n;c++)
			{
				res1[x++] = s[a]*s[b]+s[c];
			}
		}
	}
	sort(res1,res1+x);
	int y=0;
	for(int d=0;d<n;d++)
	{
		for(int e=0;e<n;e++)
		{
			for(int f=0;f<n;f++)
			{
				if(s[d]!=0)
				res2[y++] = s[d]*(s[e]+s[f]);
			}
		}
	}
	sort(res2,res2+y);
	
	int k=1,m=1;
	cnt1[0]=1;cnt2[0]=1;
	for(int i=1;i<x;i++)
	{
		if(res1[i]!=res1[k-1])
		{
			res1[k]=res1[i];
			cnt1[k]=1;
			k++;
		}
		else
		{
			cnt1[k-1]++;
		}
	}
	
	for(int i=1;i<y;i++)
	{
		if(res2[i]!=res2[m-1])
		{
			res2[m]=res2[i];
			cnt2[m]=1;
			m++;
		}
		else
		{
			cnt2[m-1]++;
		}
	}
	
	
	long long ans = 0;
	for(int i=0,j=0;i<k && j<m;)
	{
		if(res1[i]<res2[j])
		{
			i++;
		}
		else if(res1[i]>res2[j])
		{
			j++;
		}
		else
		{
			ans += (long long)(cnt1[i]*cnt2[j]);
			i++;
			j++;
		}
	}
	
	cout<<ans<<"\n";
	
	return 0;
	
}
