#include <iostream>
#include <vector>
#include <algorithm>
#include <stdio.h>
#include <string.h>

using namespace std;
vector < int > V[10001];

int vis[10010],dist[10010],k;
void dfs(int v,int n)
  {
            
            vis[v]=1;
            dist[v]=n;
            for(int u=0;u<V[v].size();u++)
             if(!vis[V[v][u]])
               dfs(V[v][u],n+1);
   
 }

int main() {
	// your code goes here
	int n,x,y;
	cin>>n;
	for(int i=0;i<n;i++)
	{
		cin>>x>>y;
		V[x-1].push_back(y-1);
		V[y-1].push_back(x-1);
	}
	dist[0]=0;
    dfs(0,0);
	int node=0;
    for(int i=0;i<n;i++)
        if(dist[i]>dist[node])
            node=i;
                     
    memset(vis,0,sizeof(vis)); 
               
           
    dfs(node,0);
                  
    sort(dist,dist+n);
    cout<<dist[n-1]<<endl;
                  
	return 0;
}
