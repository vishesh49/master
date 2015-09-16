#include <bits/stdc++.h>
using namespace std;

long long a[1000005];

long long func(int n,long long ans)
{
	/*for(int i=1;i<13;i++)
	{
		cout<<a[i]<<" ";
	}
	cout<<"\n";*/
	if(n==0)
	{
		return 0;
	}
	else if(n==1)
	{
		return 1;
	}
	else if(n<1000005 && a[n]!=-1)
	{
		return a[n];
	}
	else
	{
		long long temp=0;
		temp += func(n/2,ans);
		temp += func(n/3,ans);
		temp += func(n/4,ans);
		
		ans += max(temp,(long long)n);
		if(n<1000005)
		{
			a[n] = ans;
			return a[n];
		}
		else
		{
			return ans;
		}
		
	}
}


int main() {
	// your code goes here
	
	int n;
	long long ans =0;
	for(int i=0;i<1000005;i++)
	{
		a[i]=-1;
	}
	
	while(cin>>n){
        cout<<func(n,ans)<<endl;
    }
	
	
	
	
	return 0;
}
