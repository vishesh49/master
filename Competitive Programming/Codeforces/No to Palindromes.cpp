#include <iostream>
using namespace std;

int main() {
	// your code goes here
	int n,p;
	cin>>n>>p;
	string s;
	cin>>s;
	s = '#'+s;
	char px = 'a' - 1 + p;
	for(int i=n;i>=1;i--)
	{
		for(int j=s[i]+1;j<=px;j++)
		{
			if (i > 1 && j == s[i-1]) 
				continue;
            if (i > 2 && j == s[i-2]) 
            	continue;
            s[i] = j;
             for (int k = i + 1; k <= n ; k ++)
             {
              	for (char q = 'a' ; q <= px; q ++)
              	{
                  if (k > 1 && q == s[k-1]) 
                  	continue;
                  if (k > 2 && q == s[k-2]) 
                  	continue;
                  s[k] = q;
                  break;
              	}
             }
             for (int l =1; l <= n ;l ++)
             	cout << s[l];
             cout<<endl;
             return 0;
		}
	}
	cout<<"NO"<<endl;
	return 0;
}
