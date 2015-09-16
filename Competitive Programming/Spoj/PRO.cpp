#include <bits/stdc++.h>
#include <iostream>
using namespace std;


int main() {
	// your code goes here
	
	multiset <int> m;
	
	multiset<int>::iterator b;
	multiset<int>::iterator e;
	int t;
	cin>>t;
	int x,n;
	unsigned long long ans=0;
	while(t--)
	{
		cin>>n;
		while(n--)
		{
			cin>>x;
			m.insert(x);
		
		}
		
		
		
		b=m.begin();
		e=m.end();
		e--;
		
		ans+= *e-*b;
			
		m.erase(b);
		m.erase(e);
		
		
	}
	
	cout<<ans<<endl;
	return 0;
}
