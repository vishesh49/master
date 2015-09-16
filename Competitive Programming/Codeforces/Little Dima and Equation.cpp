#include <iostream>
#include<algorithm>
#include <vector>
using namespace std;
long long pow(int base,long long p)
{
    if(p==0)
        return 1;
    else if(p==1)
        return (long long)base;
    long long ans=pow(base,p/2);
    if(p&1)
        return ans*ans*base;
    else
        return ans*ans;
}
int find(long long n)
{
    int sum=0;
    while(n)
    {
        sum+=n%10;
        n/=10;
    }
    return sum;
}
int main()
{
    long long a,b,c;
    cin>>a>>b>>c;
    long long arr[82];
    for(int i=1;i<82;i++)
        arr[i]=b*pow(i,a)+c;
    vector<long long>v;
    for(int i=1;i<82;i++)
    {
    	if(i==find(arr[i]) && arr[i]>0 && arr[i]<1000000000)
        {
            v.push_back(arr[i]);
        }
    }    
    sort(v.begin(),v.end());
    int sz=v.size();
    cout<<sz<<endl;
    for(int i=0;i<sz;i++)
        cout<<v[i]<<" ";
    return 0;
}
