#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int mins(int a,int b)
{
	if(a<b)
		return a;
	else
		return b;
}


int max(int a,int b)
{
	if(a>b)
		return a;
	else
		return b;
}

int main() {
	// your code goes here
	int p,q,l,r;
	cin>>p>>q>>l>>r;
	
	int max,min,maxc,minc;
	int a[p+1],b[p+1];
	int c[q+1],d[q+1];
	for(int i=0;i<p;i++)
	{
		cin>>a[i]>>b[i];
		if(min>a[i])
			min=a[i];
		if(max<b[i])
			max=b[i];
	}
	long long ans=0;
	for(int i=0;i<q;i++)
	{
		cin>>c[i]>>d[i];
		if(min<c[i])
			minc=c[i];
		if(max<d[i])
			maxc=d[i];
	}
	for(int i=l;i<=r;i++)
	{
		bool fl=false;
		for(int k=0;k<p && !fl;k++)
		{
			for(int b1=0;b1<q;b1++)
			{
				if(a[k]>c[b1]+i)
				{
					if(a[k]<=d[b1]+i)
					{
						fl=true;
						break;
					}
				}
				else
				{
					if(c[b1]+i<=b[k])
					{
						fl=true;
						break;
					}
				}
			}
		}
		if(fl==true)
			ans++;
	}
	cout<<ans;
	return 0;
}
