#include<stdio.h>
#include<map>
#include<string.h>
#include<iostream>
using namespace std;
map<char,int>mp;
map<char,int>::iterator it;
int main()
{
	char s[201];
	char v;
	int t,sum,i,j,x;
	scanf("%d",&t);
	while(t!=0)
	{
		scanf("%200s",&s);
		mp.clear();
		sum=0;
		for(i=0;s[i]!='\0';i++)
		{
			mp[s[i]]++;
		}
		for(it=mp.begin();it!=mp.end();it++)
        {
			if(it->second==0)
				continue;
			else if(it->second==1)
				sum++;
			else if(it->second%2==0)
				sum+=it->second/2;
			else
				sum+=it->second/2+1;
		}
		t--;
		printf("%d\n",sum);
	}
	return 0;
}
