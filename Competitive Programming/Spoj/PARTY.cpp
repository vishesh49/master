#include <bits/stdc++.h>
using namespace std;

int K[505][2600];
int V[505][2600];
int ans1=0;
int max(int a, int b) { return (a > b)? a : b; }
 
// Returns the maximum value that can be put in a knapsack of capacity W
int knapSack(int W, int wt[], int val[], int n)
{
   int i, w;
   int K[n+1][W+1];
 
   // Build table K[][] in bottom up manner
   for (i = 0; i <= n; i++)
   {
       for (w = 0; w <= W; w++)
       {
           if (i==0 || w==0)
           {
           		K[i][w] = 0;
           		V[i][w] = 0;
           }
           else if (wt[i-1] <= w)
           {
           		//K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
     			if(val[i-1] + K[i-1][w-wt[i-1]]>K[i-1][w])
     			{
     				K[i][w] = val[i-1] + K[i-1][w-wt[i-1]];
     				V[i][w] = 1;
     			}
     			else
     			{
     				K[i][w] = K[i-1][w];
     				V[i][w] = 0;
     			}
           }
           else{
                 K[i][w] = K[i-1][w];
                 V[i][w] = 0;
           }

       }
   }
 		/*for (int i = 0; i <= n; i++)
   		{
       		for (int w = 0; w <= W; w++)
       		{
       			cout<<K[i][w]<<" ";
       		}
       		cout<<endl;
   		}*/
   		
   		
   			int y = W;
		int best;
	
	for(y = W, best = K[n][W]; y; y--)
			if(K[n][y] < best)
				break;
		y++;
		
		for(int i=n;i>=0;i--)
		{
			if(V[i][y]==1)
			{
				ans1 += wt[i-1];
				y = y-wt[i-1];
	//			cout<<y<<" ";
			}
		}
	
	
   return K[n][W];
}
 



int main() {
	// your code goes here
	
	int n,W;
	
	while(cin>>W && cin>>n)
	{
		if(W!=0 && n!=0){
	//	cout<<n<<" "<<W<<"\n";
		for (int i = 0; i <= n; i++)
   		{
       		for (int w = 0; w <= W; w++)
       		{
       			K[i][w] = 0;
       		}
   		}
   		for (int i = 0; i <= n; i++)
   		{
       		for (int w = 0; w <= W; w++)
       		{
       			V[i][w] = 0;
       		}
   		}
   		//cout<<"xx";
		int val[n+1];
		int wt[n+1];
		val[n]=0;
		wt[n]=0;
		for(int i=0;i<n;i++)
		{
			cin>>wt[i];
			cin>>val[i];
		}
	/*		for(int i=0;i<=n;i++)
		{
			cout<<wt[i]<<" ";
			
		}
	*/
		ans1=0;
		//cout<<val[n-1]<<" "<<wt[n-1];
		int ans2 = knapSack(W,wt,val,n);
		cout<<ans1<<" "<<ans2<<"\n";
		}
	}
	
	return 0;
}
