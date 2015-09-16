#include<iostream>
 
using namespace std;
bool func(long long x)
{
	return (x != 0) && ((x & (x - 1)) == 0);
}
int main()
{
	long long n;
	cin>>n;
	if(func(n))
	cout<<"TAK";
	else
	cout<<"NIE";
}
