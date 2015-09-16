#include <iostream>
#include <stdio.h>
using namespace std;

int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t--)
	{
		long long ans=0;
		int n,k;
		cin>>n>>k;
		string a;
		cin>>a;
		/*for(int i=0;i<n;i++)
			cout<<a[i]<<"-";*/
		for(int i=0;i<n-k;i++)
		{
			long long temp=1;
			for(int j=0;j<k;j++)
			{
				temp = temp*(a[i+j]-'0');
			}
			if(temp>ans)
			{
				ans=temp;
			}
		}
		cout<<ans<<endl;
		
	}
	return 0;
}
