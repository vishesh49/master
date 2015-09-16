#include <iostream>
#include <stdio.h>
using namespace std;

int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t--)
	{
		unsigned long long int n;
		cin>>n;
		unsigned long long int ans = (n*(n+1)*(2*n+1))/6;
		unsigned long long int ans2= (n*(n+1))/2;
		unsigned long long int ans3= ans2*ans2;
		unsigned long long int ans4= ans3-ans;
		printf("%llu\n",ans4);
	}
	return 0;
}
