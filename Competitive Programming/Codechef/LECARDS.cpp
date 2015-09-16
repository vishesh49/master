 #include<stdio.h>
using namespace std;
 
 
int main()
{     int c[1001][1001];
int a[1000],t,sum=0;
for(int i=0;i<=1000;i++)
   {
       c[0][i]=0;
       c[i][0]=1;
   }
 
for(int i=1;i<=1000;i++)
 for(int j=1;j<=i;j++)
    c[i][j]=(c[i-1][j-1]+c[i-1][j])%1000000007;
    
scanf("%d",&t);
while(t--){int n;
     sum=0;
        scanf("%d",&n);
for(int i=0;i<n;i++)
 scanf("%d",&a[i]);
 
 for(int i=(n/2)+1;i<=n;i++)
 {
     sum+=c[n][i];
         sum=sum%1000000007;
 }
 printf("%d\n",sum);
}return 0;
}
