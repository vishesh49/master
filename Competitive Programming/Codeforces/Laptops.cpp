#include <stdio.h>
#include <iostream>
using namespace std;
int main() {
	int t,n,x,y,flag;
	int a[100005];
	for(int i=0;i<100005;i++)
		a[i]=-1;
	scanf("%d",&n);
	for(int i=0;i<n;i++)
	{
		scanf("%d%d",&x,&y);
		a[x]=y;
	}
	flag=1;
	for(int i=1;i<n;i++)
	{
		if(a[i]!=-1)
		if(a[i]>a[i+1])
		{
			flag=0;
		}
	}
	if(flag==1)
		printf("Poor Alex\n");
	else
		printf("Happy Alex\n");
	return 0;
}
