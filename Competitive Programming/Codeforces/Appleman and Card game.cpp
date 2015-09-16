#include <iostream>
#include <algorithm>
#include <string>
using namespace std;
int main() {
	long long a[26];
	string inp;
	long long n,k;
	cin>>n>>k;
	cin>>inp;
	for(int i=0;i<26;i++)
	{
		a[i]=0;
	}
	for(int i=0;i<inp.length();i++)
	{
		int te = inp[i]-'A';
		a[te]++;
	}
	sort(a,a+26);
	long long ans=0;
	for(int i=25;i>=0;i--)
	{
		if(k<=a[i])
		{
			ans += k*k;
			k=0;
		}
		else 
		{
			ans += a[i]*a[i];
			k = k-a[i];
		}
		
	}
	cout<<ans<<endl;
	return 0;
}
