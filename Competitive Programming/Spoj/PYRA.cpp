#include <iostream>
#include <vector>
#include <string.h>
using namespace std;

int v[10010];
vector<int> graph[10010];
int n,ans=0;

int dfs(int s)
{
	if(v[s]==1)
		return 0;
	v[s]=1;
	if(!graph[s].size())
	{
		ans++;
		return 1;
	}
	
	int c=0;
	for(int i=0;i<graph[s].size();i++)
	{
		if(!v[graph[s][i]])
		{
			c+= dfs(graph[s][i]);
			c++;
		}
	}
	c++;
	ans += c;
	return c;
}


int main() {
	// your code goes here
	
	int t;
	cin>>t;
	while(t--)
	{
		int x,y;
		cin>>n;
		memset(v,0,sizeof(v));
		
		for(int i=0;i<n-1;i++)
		{
			cin>>x>>y;
			graph[x].push_back(y);
			graph[y].push_back(x);
		}
		dfs(0);
		cout<<ans<<endl;
		ans=0;
		for(int i=0;i<n;i++)
		{
			graph[i].clear();
		}
	}
	
	
	return 0;
}
