#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;



int main() 
{
    long long n, k; 
    cin >> n >> k;
    vector<int> prices;
    for(int i = 0; i < n; i++)
    {
        int p;
        cin >> p;
        prices.push_back(p);
    }
    
    long long answer = 0;
    long long sum = 0;
    // Write the code for computing the final answer using n,k,prices
    
    sort(prices.begin(),prices.end());
    for(int i=0;i<prices.size();i++)
    {
        if(sum+prices.at(i)<=k)
        {
            sum += prices.at(i);
            answer++;
        }
        else
        {
            break;    
        }
    }
    
    
    cout << answer << endl;
    
    return 0;
}

