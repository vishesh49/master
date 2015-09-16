#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	// your code goes here
	int n,k,s;
	int a[1001]={0};
	cin>>n>>k>>s;
	for(int i=0;i<n;i++)
		cin>>a[i];
	sort(a,a+n);
	int x=k*s;
	for(int i=n-1;i>=0;i--)
	{
		if(x-a[i]>0)
			x-=a[i];
		else
		{	
			cout<<n-i<<endl; 
			return 0;
		}	
	}
	cout<<0<<endl;
	return 0;
}
