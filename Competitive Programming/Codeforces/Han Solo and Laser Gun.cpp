#include <bits/stdc++.h>
using namespace std;

struct node
{
	int vis;
	pair<int,int> p;
};

int main() {
	// your code goes here
	int n,x0,y0;
	cin>>n>>x0>>y0;
	
	vector <node > v;
	int x,y;
	for(int i=0;i<n;i++)
	{
		cin>>x>>y;
		node temp = {1,make_pair(x,y)};
		v.push_back(temp);
	}
	
	int x1,y1;
	int count =0;
	for(int i=0;i<n;i++)
	{
		bool flag = false;
		if(v.at(i).vis==1)
		{
			for(int j=0;j<n;j++)
			{
				if(v.at(j).vis==1 && !flag)
				{
					x1 = v.at(j).p.first;
					y1 = v.at(j).p.second;
					count++;
					flag=true;
					v.at(j).vis=0;
				}
				else if(v.at(j).vis==1 && flag)
				{
					int xt = v.at(j).p.first;
					int yt = v.at(j).p.second;
					if( ((xt-x0)*(y1-y0))==((x1-x0)*(yt-y0)) )
					{
						v.at(j).vis=0;
					}
				}
			}
		}
	}
	cout<<count<<"\n";
	
	 
	return 0;
}
