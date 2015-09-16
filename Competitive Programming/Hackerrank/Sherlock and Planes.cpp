#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

struct Point
{
    int x;
    int y;
    int z;
    
};

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int t;
    cin>>t;
    while(t--)
    {
        Point p1,p2,p3,p4;
        Point pq,pr,ps;
        Point c1;
        cin>>p1.x>>p1.y>>p1.z;
        cin>>p2.x>>p2.y>>p2.z;
        cin>>p3.x>>p3.y>>p3.z;
        cin>>p4.x>>p4.y>>p4.z;
        
        pq.x = p1.x - p2.x;
        pq.y = p1.y - p2.y;
        pq.z = p1.z - p2.z;
        
        pr.x = p1.x - p3.x;
        pr.y = p1.y - p3.y;
        pr.z = p1.z - p3.z;
        
        ps.x = p1.x - p4.x;
        ps.y = p1.y - p4.y;
        ps.z = p1.z - p4.z;
        
        c1.x = pq.y*pr.z - pq.z*pr.y;
        c1.y = pq.z*pr.x - pq.x*pr.z;
        c1.z = pq.x*pr.y - pq.y*pr.x;
        
        int c = c1.x*ps.x + c1.y*ps.y + c1.z*ps.z;
        
        if(c==0)
        {
            cout<<"YES\n";
        }
        else
        {
            cout<<"NO\n";
        }        
    }
    
    
    return 0;
}

