#include <bits/stdc++.h>
using namespace std;
typedef long long LL;
//typedef gunner6376 - Vishesh Raimugia;


int main() 
{
	int t;
	vector<int> prime;
	const int limit=1000000;
	char isPrime[limit+5]={0};
	for(int i=2;i<limit;i++)
	if(!isPrime[i]){
		prime.push_back(i);
		for(int j=2*i;j<limit;j+=i)
		 isPrime[j]=1;
	}
	LL n;
	cin>>t;
	while(t--)
    {
		cin>>n;
			
		if(n<limit){
			if(!isPrime[n]){
			 cout<<n<<endl;
			 continue;
			}
		}
		
		for(auto&i:prime){
			while(n%i==0){
				n/=i;
			}
			if(n==1){
				n=i;
				break;
			}
		}
		cout<<n<<endl;
		
		
	}
	return 0;
}
