#include <iostream>
using namespace std;

int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t--)
	{
		unsigned long long n,n1;
		cin>>n;
		n--;
		
		unsigned long long count=0,ans=0;
		count = n/3;
		ans+= (count)*(3+count*3)/2;
		count = n/5;
		ans += (count)*(5+count*5)/2;
		count = n/15;
		ans -= (count)*(15+count*15)/2;
		
		cout<<ans<<endl;
		
	}
	return 0;
}
