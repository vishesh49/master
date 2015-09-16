#include <iostream>
using namespace std;

int main() {
	// your code goes here
	int n,m;
	cin>>n>>m;
	int ans=0;
	while(n>0)
	{
		n--;
		ans++;
		if(ans%m==0)
		{
			n=n+1;
 		}
	}
	cout<<ans<<endl;
	return 0;
}
