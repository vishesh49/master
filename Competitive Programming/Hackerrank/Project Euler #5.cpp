#include <iostream>
using namespace std;

int pow(int b,int p)
{
	int ans=1;
	while(p--)
	{
		ans *= b;
	}
	return ans;
}

int main() {
	// your code goes here
	int t;
	cin>>t;
	int primes[12]= {2,3,5,7,11,13,17,19,23,29,31,37};
	int factors[40];
	while(t--)
	{
		int n;
		cin>>n;
		for(int i=0;i<40;i++)
			factors[i]=0;
	 	for(int i=2;i<=n;i++)
	 	{
	 		int temp=i;
	 	//	cout<<i<<"--";
	 		for(int j=0;j<12;j++)
	 		{
	 			int count=0;
	 			while(temp%primes[j]==0)
	 			{
	 				count++;
	 				temp= temp/primes[j];
	 			}
	 	//		cout<<count;
	 			if(factors[primes[j]]<count)
	 			{
	 				factors[primes[j]]=count;
	 			}
	 		}
	 	//	cout<<endl;
	 	}
	 /*	for(int i=0;i<40;i++)
	 	{
	 		cout<<factors[i]<<"-";
	 	}*/
	 	long long ans =1;
	 	for(int i=2;i<40;i++)
	 	{
	 		if(factors[i]>0)
	 		{
	 			ans *= pow(i,factors[i]);
	 		//	cout<<pow(i,factors[i])<<endl;
	 		}
	 	}
	 	cout<<ans<<endl;
	}
	return 0;
}
