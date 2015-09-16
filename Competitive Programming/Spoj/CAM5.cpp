#include <bits/stdc++.h>
using namespace std;

int vis[100005];
vector<int> v[100005];

void dfs(int a)
{
	//cout<<a<<" In function\n"; 
	
	if(vis[a]==0)
	{
		vis[a]=1;
		for(int i=0;i<v[a].size();i++)
		{
			if(vis[v[a].at(i)]==0)
			{
				dfs(v[a].at(i));
			}
		}
	}
}


int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		for(int i=0;i<n;i++)
		{
			vis[i]=0;
		}
		int e;
		cin>>e;
		
		for(int i=0;i<e;i++)
		{
			int x,y;
			cin>>x>>y;
			v[x].push_back(y);
			v[y].push_back(x);
			
		}
//		for(int j=0;j<n;j++)
//	{
//		cout<<"Links to "<<j<<" : ";
//		for(int i=0;i<v[j].size();i++)
//		{
//			cout<<v[j].at(i)<<" ";
//		}
//		cout<<endl;
//	}
		
		int count=0;
		if(e==0)
		{
			cout<<n<<"\n";
		}
		else
		{
			for(int i=0;i<n;i++)
			{
				if(vis[i]==0)
				{
					count++;
					dfs(i);
				}
			}
			cout<<count<<"\n";
		}
		for(int i=0;i<n;i++)
		{
			v[i].clear();
		}
		
	}
	
	
	return 0;
}
