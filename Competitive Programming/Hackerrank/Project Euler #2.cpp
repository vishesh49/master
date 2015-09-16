#include <iostream>
#include <math.h>
using namespace std;
long long fib(long long n) 
{
	long long i=1,j=1;
	long long sum = 0;
	while(j<n) 
	{
		if (j % 2 == 0) 
		{
			sum += j;
		}
		j = i + j;
		i = j - i;
	}
	return sum;
}

int main() 
{
	long long t, n, i;
	cin>>t;
	for (i = 0; i < t; i++) 
	{
		cin>>n;
		cout<<fib(n)<<endl;
	}
	return 0;
}
