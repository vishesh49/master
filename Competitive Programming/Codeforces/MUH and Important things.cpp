#include <iostream>
#include <iostream>
#include <algorithm>
#include <vector>
#include<bits/stdc++.h>

using namespace std;

int main() {
	// your code goes here
	long long int n;
	cin>>n;
	vector<pair<long long,long long> >v(n);
  	for(int i=0;i<n;i++)
  	{
  		cin>>v[i].first;
  		v[i].second=i+1;
  	}
  	sort(v.begin(),v.end());
  	vector<pair<long long ,long long> >a1(n);
  	vector<pair<long long,long long> >a2(n);
  	vector<pair<long long ,long long> >a3(n);

  	a1=v;
  	for(int i=0;i<n-1;i++)
  	{
  		if(v[i].first==v[i+1].first)
  		{
  			swap(v[i],v[i+1]);
  			a2=v;
  			for(int j=i+1;j<n-1;j++)
  			{
  		   		if(v[j].first==v[j+1].first)
  		   		{
  		   	  		swap(v[j],v[j+1]);
  		   	  		a3=v;
  		      		cout<<"YES\n";
  		      		for(int k=0;k<n;k++)
  		      		{
  		      			cout<<a1[k].second<<' ';
  		      		}
  		      		 cout<<'\n';
  		      		for(int k=0;k<n;k++)
  		      		{
  		      			cout<<a2[k].second<<' ';
  		      		}
  		      		 cout<<'\n';
  		      		for(int k=0;k<n;k++)
  		      		{
  		      			cout<<a3[k].second<<' ';
  		      		}
  		      		 cout<<'\n';
  		      		return 0;
  		   		}
  			}
  		}
  	}
  	cout<<"NO";



	return 0;
}

