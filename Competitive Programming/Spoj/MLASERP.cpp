#include <iostream>
#include <bits/stdc++.h>
using namespace std;
int w,h,mi=-1,mj=-1;
char a[101][101];
int v[101][101];


struct node 
{
	int x,y,d,cost;
	
	node()
	{
		x=0;y=0;d=0;cost=0;
	}
	node(int x1,int y1,int cost1,int d1)
	{
		x=x1;
		y=y1;
		d=d1;
		cost=cost1;
	}
};


bool valid(node temp)
{
    if(temp.x>=0 && temp.x<h && temp.y>=0 && temp.y<w && a[temp.x][temp.y]!='*')
        return true;
    return false;
}

int main() {
	// your code goes here
	
	cin>>w>>h;
	for(int i=0;i<101;i++)
	{
		for(int j=0;j<101;j++)
		{
			v[i][j]=0x3f3f3f3f;
		}
	}
	int flag=0;
	for(int i=0;i<h;i++)
	{
		for(int j=0;j<w;j++)
		{
			cin>>a[i][j];
			if(a[i][j]=='C' && flag==0)
			{
				mi= i;
				mj= j;
				flag=1;
			}
			else if(a[i][j]=='C')
			{
				a[i][j]='D';
			}
		}
	}
	
	
	queue <node> q;
	node temp;
	temp.x=mi;
	temp.y=mj;
	temp.d=0;
	temp.cost=-1;
	int direction =0;
	q.push(temp);
	//v[mi][mj]=1;
	int min=0x3f3f3f3f;
	while(!q.empty())
	{
		node t=q.front();
		q.pop();
		int x= t.x;
		int y=t.y;
		int d=t.d;
		int co = t.cost;
		
		
		if(!valid(t))
			continue;
			
		if(a[x][y]=='D' && min>co)
		{
			min=co;
			continue;
		}
		
		if(t.cost <= v[t.x][t.y])
            v[t.x][t.y]=t.cost;
        else
            continue;
		
		if(d==0)
        {
            q.push( node(x-1,y,co+1,1) );
            q.push( node(x,y+1,co+1,2) );
            q.push( node(x+1,y,co+1,3) );
            q.push( node(x,y-1,co+1,4) );
        }
        else if(d==1)
        {
            q.push( node(x-1,y,co,1) );
            q.push( node(x,y-1,co+1,4) );
            q.push( node(x,y+1,co+1,2) );
        }
        else if(d==2)
        {
            q.push( node(x-1,y,co+1,1) );
            q.push( node(x,y+1,co,2) );
            q.push( node(x+1,y,co+1,3) );
        }
        else if(d==3)
        {
            q.push( node(x,y+1,co+1,2) );
            q.push( node(x+1,y,co,3) );
            q.push( node(x,y-1,co+1,4) );
        }
        else if(d==4)
        {
            q.push( node(x+1,y,co+1,3) );
            q.push( node(x,y-1,co,4) );
            q.push( node(x-1,y,co+1,1) );
        }
		
		
		
	}
	cout<<min<<endl;
	return 0;
}
