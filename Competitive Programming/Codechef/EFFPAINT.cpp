// 0.27 Points 
#include <iostream>
 
using namespace std;
 
int main()
{
    int n,i,j,k,c=0,d=0,buff=0;
    cin>>n;
    char a[n][n];
    char piece[2501];
    int x[2501][4];
    int countx=0,countp=0;
    for(i=0;i<n;i++)
    {
        c=0;
                d=0;
        for(j=0;j<n;j++)
        {
            cin>>a[i][j];
            if(a[i][j]=='B')
            {
                c++;
            }
            else
            {
                                d++;
                        }
                }
                        if(c>d)
                        {
                                buff++;
                                x[countx][0]=i;
                                x[countx][1]=0;
                                x[countx][2]=i;
                                x[countx][3]=n-1;
                                countx++;
                                piece[countp++]='F';
                                //cout<<i<<" "<<0<<" "<<i<<" "<<n-1<<" "<<"F\n";
                                for(k=0;k<n;k++)
                    {
                                 if(a[i][k]=='W')
                                 {
                                                buff++;
                                                x[countx][0]=i;
                                                x[countx][1]=k;
                                                x[countx][2]=i;
                                                x[countx][3]=k;
                                                countx++;
                                                piece[countp++]='W';
                                    //cout<<i<<" "<<k<<" "<<i<<" "<<k<<" "<<"W\n";
                                 }
                    }
                        }
                        else
                        {
                                for(k=0;k<n;k++)
                        {
                                if(a[i][k]=='B')
                                {
                                                buff++;
                                                x[countx][0]=i;
                                                x[countx][1]=k;
                                                x[countx][2]=i;
                                                x[countx][3]=k;
                                                countx++;
                                                piece[countp++]='B';
                                //cout<<i<<" "<<k<<" "<<i<<" "<<k<<" "<<"B\n";
                                }
                        }
                        }
        
    }
    cout<<buff<<"\n";
    for(i=0;i<countx;i++)
    {
        for(j=0;j<4;j++)
        {
           cout<<x[i][j]<<" ";
        }
        cout<<piece[i]<<"\n";
    }
    return 0;
}
