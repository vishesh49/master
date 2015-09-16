#include <bits/stdc++.h>
using namespace std;

int main() {
	// your code goes here
	map <int,int> m;
	map <int,int> m2;
	int n;
	cin>>n;
	int arr[n];
	int temp;
	for(int i=0;i<n;i++)
	{
		cin>>temp;
		arr[i] = temp;
		m[temp]++;
		m2[temp]++;
	}
	for(int i=0;i<n-1;i++)
	{
		cin>>temp;
		m[temp]--;
	}
	
	for(int i=0;i<n;i++)
	{
		if(m[arr[i]]==1)
		{
			cout<<arr[i]<<"\n";
			m2[arr[i]]--;
			break;
		}
	}
	
	for(int i=0;i<n-2;i++)
	{
		cin>>temp;
		m2[temp]--;
	}
	
	for(int i=0;i<n;i++)
	{
		if(m2[arr[i]]==1)
		{
			cout<<arr[i]<<"\n";
			break;
		}
	}
	
	return 0;
}
