#include <iostream>
#include <cmath>
using namespace std;

int ansa[3001];

int main() {
	// your code goes here
	for(int i=0;i<3000;i++)
	{
		ansa[i]=0;
	}
	for(int i=1;i<1500;i++)
	{
		for(int j=1;j<1500;j++)
		{
			int x= i*i+j*j;
			double te = sqrt(x);
			int te2 = te;
			if(te2==te)
			{
				int gh = i+j+te2;
				if(gh<3001)
				if(i*j*te2>ansa[gh])
				{
					ansa[gh] = i*j*te2;
				}
			}
		}
	}
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		if(ansa[n]==0)
			cout<<"-1\n";
		else
		 	cout<<ansa[n]<<"\n";
	}
	return 0;
}
