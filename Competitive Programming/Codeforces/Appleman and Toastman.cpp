#include <iostream>
#include <algorithm>
using namespace std;
long long int arr[300000];
long long int brr[300000];
int main() {
    // your code goes here
    int n; 
    cin>>n;
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    sort(arr, arr+n);
    brr[n-1] = arr[n-1];
    for (int i = n-2; i >= 0; i--)
    {
        brr[i] = brr[i+1] + arr[i];   
    }
    long long ans = 0;
    for (int i = 0; i < n; i++)
    {
        ans += brr[i];
        if (i-1 >= 0) 
            ans += arr[i-1];
    }
    cout<<ans<<endl;
    return 0;
}
