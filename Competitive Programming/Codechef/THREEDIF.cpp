#include<iostream>
#include<cstdio>
#include<algorithm>
 
using namespace std;
 
#define MOD 1000000007LL
 
int main()
{
    int test;
    cin>>test;
    while(test--) {
        long long ar[3];
        cin>>ar[0]>>ar[1]>>ar[2];
        sort(&ar[0],&ar[3]);
        long long ans = (((((ar[0])%MOD)*((ar[1]-1)%MOD))%MOD)*((ar[2]-2)%MOD))%MOD;
        ans = (ans+MOD)%MOD;
        cout<<ans<<endl;
    }
}
