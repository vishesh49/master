#include <stdio.h>
#include <stdlib.h>


#define limit 1000000 /*size of integers array*/


int primes[limit+1];
	long long ans[limit+1];
	
int main(){
    unsigned long long int i,j;
    for (i=2;i<=limit;i++)
        primes[i]=1;

    for (i=2;i<=limit;i++)
        if (primes[i])
            for (j=i;i*j<limit;j++)
                primes[i*j]=0;

	ans[0]=0;
	ans[1]=0;
    for (i=2;i<=limit;i++)
    {    
    	if (primes[i])
    	{
    		ans[i]=ans[i-1]+i;
    	}
    	else
    	{
    		ans[i]= ans[i-1];
    	}
    }
    int t;
    scanf("%d",&t);
    while(t--)
    {
    	int n;
    	scanf("%d",&n);
    	printf("%lld\n",ans[n]);
    }
            
	return 0;
}
