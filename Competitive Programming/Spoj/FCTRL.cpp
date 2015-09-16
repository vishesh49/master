#include<stdio.h>
#define size 10000
 
int main()
{
    int n,t;
    char buff[size];
    unsigned int count=0;
    int block_read=0;
    int is_first = 0;
    int j,k;
    t = 0;
    scanf("%d",&n);
 
    while (count<n)
    {
        block_read =fread(buff,1,size,stdin);
        for (j=0;j<block_read;j++)
        {
            if (buff[j]=='\n')
            {
                if (is_first)
                {
                    count++;
                    /* write logic here */
                    // t is the value
                    int ret = 0;
                    for(k=5;k<=t;k=k*5)
                        ret+= (t/k);
                    printf("%d\n",ret);
                    /* end */
                    t = 0;
                }
                else
                    is_first=1;
            }
            else
            {
                t = t*10 + (buff[j] - '0');
            }
        }
    }
    return 0;
 
}
 

