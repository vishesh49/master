#include <iostream>
#include <stdio.h>
#include<queue>
#include <math.h>
#include <stdlib.h>
#include <vector>
#include <algorithm>
#include<iostream>
#include<cstring>
#define inf 1000000000
using namespace std;

int v[195][195];
int a[195][195];

int main() {
	// your code goes here
	int t;
	queue< pair<int,int> >q;
	
	cin>>t;
	while(t--)
	{
		int n,m;
		char x;
		cin>>n>>m;
		
		for(int i=0;i<195;i++)
			for(int j=0;j<195;j++)
			{	a[i][j]=inf;v[i][j]=0;}
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				cin>>x;
				if(x=='1')
				{
					q.push(make_pair(i,j));
					a[i][j]=0;
				}
			}
		}
		int dx[]={1,0,0,-1};
		int dy[]={0,1,-1,0};
		
		while(!q.empty())
		{
			pair<int,int> temp = q.front();
			v[temp.first][temp.second] = 1;
			q.pop();
			
			for(int i=0;i<=3;i++)
			{
				int ax = temp.first + dx[i];
				int ay = temp.second + dy[i];
				
				if(a[ax][ay]!=0)
				{
					if(ax>=0&&ax<n && ay>=0&&ay<m)
					{
						if(v[ax][ay]!=1)
						{
							a[ax][ay] = a[temp.first][temp.second] + 1;
							v[ax][ay] = 1;
							q.push(make_pair(ax,ay));
						}
					}
				}
			}
			
		}
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				cout<<a[i][j]<<" ";
			}
			cout<<endl;
		}

	}
	
	
	return 0;
}
