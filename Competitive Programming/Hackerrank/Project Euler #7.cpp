#include <iostream>
#include <stdlib.h>
#include <stdio.h>
using namespace std;

#define limit 200000
int main() {
	// your code goes here
	unsigned long long int i,j;
    int primes[limit+5];

    for (i=2;i<limit;i++)
        primes[i]=1;

    for (i=2;i<limit;i++)
        if (primes[i])
            for (j=i;i*j<limit;j++)
                primes[i*j]=0;

	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		int i;
		for(i=2;i<limit;i++)
		{
			if(primes[i]==1)
			{
				n--;
			}
			if(n==0)
			{
				break;
			}
		}
		cout<<i<<endl;
	}

	return 0;
}
