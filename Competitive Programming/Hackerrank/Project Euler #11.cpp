#include <stdio.h>

int main(void) {
	// your code goes here
	int a[22][22];
	int i,j;
	for(i=0;i<=21;i++)
	{
		for(j=0;j<=21;j++)
		{
			if(i==0 || j==0 || i==21 || j==21)
				a[i][j]=0;
			else
			
			scanf("%d",&a[i][j]);
		}
	}
	
	long long ans=0;
	for(i=1;i<=20;i++)
	{
		for(j=1;j<=20;j++)
		{
			if((i+1)<=20 && (i+2)<=20 &&(i+3)<=20)
			{
				if(a[i+1][j]+a[i+2][j]+a[i+3][j]+a[i][j]>ans)
				{
					ans = a[i+1][j]*a[i+2][j]*a[i+3][j]*a[i][j];
				}
			}
			
			
			if((i-1)>=0 && (i-2)>=0 &&(i-3)>=0)
			{
				if(a[i-1][j]*a[i-2][j]*a[i-3][j]*a[i][j]>ans)
				{
					ans = a[i-1][j]*a[i-2][j]*a[i-3][j]*a[i][j];
				}
			}
			if((j-1)>=0 && (j-2)>=0 &&(j-3)>=0)
			{
				if(a[i][j-1]*a[i][j-2]*a[i][j-3]*a[i][j]>ans)
				{
					ans = a[i][j-1]*a[i][j-2]*a[i][j-3]*a[i][j];
				}
			}
			
			if((j+1)<=20 && (j+2)<=20 &&(j+3)<=20)
			{
				if(a[i][j+1]*a[i][j+2]*a[i][j+3]*a[i][j]>ans)
				{
					ans = a[i][j+1]*a[i][j+2]*a[i][j+3]*a[i][j];
				}
			}
			if((i-1)>=0 && (i-2)>=0 &&(i-3)>=0 && (j-1)>=0 && (j-2)>=0&& (j-3)>=0)
			{
				if(a[i-1][j-1]*a[i-2][j-2]*a[i-3][j-3]*a[i][j-3]>ans)
				{
					ans = a[i-1][j-1]*a[i-2][j-2]*a[i-3][j-3]*a[i][j];
				}
			}
			if((i+1)<=20 && (i+2)<=20 &&(i+3)<=20 && (j-1)>=0 && (j-2)>=0&& (j-3)>=0)
			{
				if(a[i+1][j-1]*a[i+2][j-2]*a[i+3][j-3]*a[i][j]>ans)
				{
					ans = a[i+1][j-1]*a[i+2][j-2]*a[i+3][j-3]*a[i][j];
				}
			}
			if((i-1)>=0 && (i-2)>=0 &&(i-3)>=0 && (j+1)<=20 && (j+2)<=20&& (j+3)<=20)
			{
				if(a[i-1][j+1]*a[i-2][j+2]*a[i-3][j+3]*a[i][j]>ans)
				{
					ans = a[i-1][j+1]*a[i-2][j+2]*a[i-3][j+3]*a[i][j];
				}
			}
			if((i+1)<=20 && (i+2)<=20 &&(i+3)<=20  &&(j+1)<=20 && (j+2)<=20&& (j+3)<=20)
			{
				if(a[i+1][j+1]*a[i+2][j+2]*a[i+3][j+3]*a[i][j]>ans)
				{
					ans = a[i+1][j+1]*a[i+2][j+2]*a[i+3][j+3]*a[i][j];
				}
			}
		}
	}
	printf("%lld",ans);
	
	return 0;
}

