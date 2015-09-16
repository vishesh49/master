#include<iostream>
#include<cstdio>
#include<cstdlib>
#define M 1000000007
using namespace std;
long long matrix_multiply(long long a[][2],long long b[][2],long long c[][2])
{
    for(int i=0;i<2;i++)
    {
        for(int j=0;j<2;j++)
        {
            c[i][j]=0;
            for(int k=0;k<2;k++)
            {
                c[i][j]=(c[i][j]+(a[i][k]*b[k][j])%M)%1000000007;
            }
        }
    }
}
long long fast_multiply(long long a[][2],long long n,long long c[][2])
{
    if(n==1)
    {
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<2;j++)
                c[i][j]=a[i][j];
        }
    }
    else if(n%2==0)
    {
        long long temp[2][2];
        fast_multiply(a,n/2,temp);
        matrix_multiply(temp,temp,c);
    }
    else
    {
        long long temp[2][2],temp1[2][2];
        fast_multiply(a,(n-1)/2,temp);
        matrix_multiply(temp,temp,temp1);
        matrix_multiply(a,temp1,c);
    }
}
long long number(long long a)
{
        long long temp=0;
        while(a)
        {
            if(a%2)temp++;
            a/=2;
        }
        return temp;
}
 
int main()
{
    int t,n,g;
    long long a[2][2],c[2][2],ans;
    scanf("%d",&t);
    while(t--)
    {
        a[0][0]=1;
        a[0][1]=1;
        a[1][0]=1;
        a[1][1]=0;
        scanf("%d",&n);
        scanf("%d",&g);
        fast_multiply(a,n,c);
        ans=c[0][0];
        if(number(ans)==g)cout<<"CORRECT";
        else cout<<"INCORRECT";
        cout<<endl;
    }
 
}
