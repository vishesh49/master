#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

bool wayToSort(int i, int j) { return i > j; }

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int t;
    cin>>t;
    while(t--)
    {
        int n,k;
        cin>>n>>k;
        int a[1005], b[1005];
        for(int i=0;i<n;i++)
        {
            cin>>a[i];  
        }
        for(int i=0;i<n;i++)
        {
            cin>>b[i];  
        }        
        sort(a,a+n);
        sort(b,b+n, wayToSort);
        int flag=1;
        for(int i=0;i<n;i++)
        {
            if(a[i]+b[i]<k)
            {
                flag=0;
                break;
            }
        }
        if(flag==0)
        {
            cout<<"NO\n";  
        }
        else
        {
            cout<<"YES\n";
        }
    }
    
    
    
    return 0;
}

