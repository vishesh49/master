#include <iostream>
using namespace std;

int main() {
	// your code goes here
	int n;
	cin>>n;
	char s[101];
	for(int i=0;i<n;i++)
	{
		cin>>s[i];
	}
	int i=0,count=0;
	while(i<n&&s[i]=='1')
	{
		count++;
		i++;
		}
		
	if(count==n)
	{
		count=count-1;
	}
	cout<<count+1<<"\n";
	return 0;
}
