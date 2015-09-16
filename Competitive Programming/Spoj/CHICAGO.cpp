#include <cstdio>
#include <queue>
#include <vector>
#include <iostream>
using namespace std;
 
#define MAX 100001
#define INF (1<<20)
#define pii pair< int, double >
#define pb(x) push_back(x)
 
struct comp {
    bool operator() (const pii &a, const pii &b) {
        return a.second < b.second;
    }
};
 
 

    priority_queue< pii, vector< pii >, comp > Q;
	vector< pii > G[MAX];

	double D[MAX];
	bool F[MAX]; 

 
int main() {
    int i, u, v,  sz, nodes, edges, starting;
 	double w;
 	
    // create graph
    while(scanf("%d", &nodes)){
    if(nodes==0)
    	return 0;
    scanf("%d", &edges);
    //cout<<nodes<<" "<<edges<<"\n";
    priority_queue< pii, vector< pii >, comp > Q;
	vector< pii > G[MAX];

    for(int i=0;i<=nodes;i++)
    {
    	F[i]=0;
    }
    
    for(i=0; i<edges; i++) {
        scanf("%d %d %lf", &u, &v, &w);
        w = w/100;
        //cout<<w<<" \n";
        G[u].pb(pii(v, w));
        G[v].pb(pii(u, w)); // for undirected
    }
    
   /* 
    for(int i=1;i<=nodes;i++)
    {
    	for(int j=0;j<G[i].size();j++)
    	{
    		cout<<G[i].at(j).first<<" "<<G[i].at(j).second<<" ";
    	}
    	cout<<endl;
    }
    
    */
    
    //scanf("%d", &starting);
 	starting  = 1;
    // initialize distance vector
    for(i=1; i<=nodes; i++) D[i] = 0;
    D[starting] = 1;
    Q.push(pii(starting, 1));
 
    // dijkstra
    while(!Q.empty()) {
        u = Q.top().first;
        Q.pop();
        if(F[u]) continue;
        sz = G[u].size();
        for(i=0; i<sz; i++) {
            v = G[u][i].first;
            w = G[u][i].second;
            if(!F[v] && D[u]*w > D[v]) {
                D[v] = D[u]*w;
                Q.push(pii(v, D[v]));
            }
        }
        F[u] = 1; // done with u
    }
 
    // result
    //for(i=1; i<=nodes; i++) printf("Node %d, min weight = %d\n", i, D[i]);
    double ans = D[nodes] * 100;
    printf("%.6lf percent\n",ans);
    
    
    
    }
    return 0;
}
