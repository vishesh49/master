#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	// your code goes here
	int n,m;
	cin>>n>>m;
	int ans = 0;
	int count=0;
	if(2*n <= m)
	{
		ans = n;
	}
	else if(n/2 >= m)
	{
		ans = min(n/2,m);
	}
	else
	{
		while(n>0 && m>0)
		{
			while(n<=m && n>0 && m>1)
			{
				n--;
				m-=2;
				ans++;
			}
			while(n>=m && n>1 && m>0)
			{
				n-=2;
				m--;
				ans++;
			}
			if(n==1 && m==1)
			{
				n--;
				m--;
			}
		}
	}
	cout<<ans<<"\n";
	return 0;
}
