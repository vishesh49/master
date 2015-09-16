#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int n;
    cin>>n;
    vector<int> weights;
    for(int i=1;i<=n;i++)
    {
        int w;
        cin>>w;
        weights.push_back(w);
    }
    int ans = 0;
    sort(weights.begin(),weights.end());
    
   /* for(int i=0;i<n;i++)
    {
    	cout<<weights.at(i)<<" ";
    }
    cout<<endl;*/
    int len = weights.size();
   // cout<<len<<endl;
    for(int i=0;i<len;i++)
    {
        int curr = weights.at(i);
        int j = 1;
    
        while(i+j<len && weights.at(i+j)<= curr+4)
        {
        	//cout<<weights.at(i+j+1);
            j++;  
        }
        i = i + j - 1;
        ans++;
    }
    
    cout<< ans << "\n";
    
    return 0;
}

