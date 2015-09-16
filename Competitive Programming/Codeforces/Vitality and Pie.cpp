#include <iostream>
#include <vector>
#include <queue>
#include <stdio.h>
#include <cstdio>
#include <utility>
#include <map>
#include <math.h>
#include <string.h>
#include <cstring>

using namespace std;

int main()
{
    int n;
    cin>>n;
    int ans=n-1;
    char s[1000006];
    cin>>s;
    int len = strlen(s);
    int arr[26];
    for(int i=0;i<26;i++)
    {
    	arr[i]=0;
    }
    for(int i=0;i<len;i++)
    {
    	if(s[i]>='a' && s[i]<='z')
    	{
    		int x = s[i]-'a';
    		arr[x]++;
    	}
    	else
    	{
    		int y = s[i]-'A';
    		if(arr[y]>0)
    		{
    			ans--;
    			arr[y]--;
    		}

    	}
    /*	for(int j=0;j<26;j++)
    	{
    		cout<<arr[j];
    	}
    	cout<<"\n";*/
    }
    cout<<ans<<"\n";
    return 0;
}
