#include<iostream>
#include<algorithm>
using namespace std;
int a[110];
int main()
{
  	    int t, n, val, dif;
		int ans,min,max;
        cin >> t;
        while(t--)
        {
                ans = 0;
                dif = 0;
                cin >> n; 
                for(int i=0;i<n;i++)
                {
                        cin >> val;
                        a[i] = val;
                }
        while(1)
        {
                sort(a,a+n);
                min=a[0];
                max=a[n-1];
                if(min == max)
                        break;
                dif = max - min;
                ans = ans + dif;
                for(int i=0;i<n-1;i++)
                {
                        a[i] = a[i] + dif;
                }
        }
        cout << ans << endl;
        }
}
