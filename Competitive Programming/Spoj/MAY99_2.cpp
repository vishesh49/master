#include<iostream>
#include<cstring>
using namespace std;
int main()
{
    unsigned long long n,t,sum,i,l;
    char a[5]={'m','a','n','k','u'},b[35];
    cin>>t;
    while(t--)
    {
        cin>>n;
        memset(b,'x',35);
        for(i=34;i>=0;i--)
        {
               
                l=(n-1)%5;
                b[i]=a[l];
                n=(n-1)/5;  
                if(!n)break;
        }
        for(i=0;i<35;i++)
        if(b[i]!='x')cout<<b[i];
        cout<<endl;
    }
    return 0;
}
