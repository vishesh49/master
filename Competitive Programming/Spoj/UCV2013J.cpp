#include<iostream>
#include<cstdio>
#include<algorithm>
#include<vector>
#include<map>
#include<cmath>
#include<cstring>
using namespace std;
 
//end of header files
 
 
//definitions
 
#define MOD 1000000007
#define llu long long unsigned
#define lld long long
#define ld long
 
//end of definitions
 
 
//fast input
 
int scan_d()    {int ip=getchar_unlocked(),ret=0;for(;ip<'0'||ip>'9';ip=getchar_unlocked());for(;ip>='0'&&ip<='9';ip=getchar_unlocked())ret=ret*10+ip-'0';return ret;}
long scan_ld()    {ld ip=getc(stdin),ret=0;for(;ip<'0'||ip>'9';ip=getc(stdin));for(;ip>='0'&&ip<='9';ip=getc(stdin))ret=ret*10+ip-'0';return ret;}
long long scan_lld()    {lld ip=getc(stdin),ret=0;for(;ip<'0'||ip>'9';ip=getc(stdin));for(;ip>='0'&&ip<='9';ip=getc(stdin))ret=ret*10+ip-'0';return ret;}
long long unsigned scan_llu()    {llu ip=getc(stdin),ret=0;for(;ip<'0'||ip>'9';ip=getc(stdin));for(;ip>='0'&&ip<='9';ip=getc(stdin))ret=ret*10+ip-'0';return ret;}
 
//end of fast input
 
//fast output
 
void print_d(int n)     {int i=10;char output_buffer[11];output_buffer[10]='\n';do{output_buffer[--i]=(n%10)+'0';n/=10;}while(n);do{putchar_unlocked(output_buffer[i]);}while(++i<11);}
void print_ld(ld n)     {int i=11;char output_buffer[12];output_buffer[11]='\n';do{output_buffer[--i]=(n%10)+'0';n/=10;}while(n);do{putchar_unlocked(output_buffer[i]);}while(++i<12);}
void print_lld(lld n)     {int i=21;char output_buffer[22];output_buffer[21]='\n';do{output_buffer[--i]=(n%10)+'0';n/=10;}while(n);do{putchar_unlocked(output_buffer[i]);}while(++i<22);}
void print_llu(llu n)     {int i=21;char output_buffer[22];output_buffer[21]='\n';do{output_buffer[--i]=(n%10)+'0';n/=10;}while(n);do{putchar_unlocked(output_buffer[i]);}while(++i<22);}
 
//end of fast output


int main() 
{
    int n,m,answer;
    n = scan_d();
    while(n!=0)
    {
        answer = 0;
        for(int i=1;i<=n;i++)
        {
            m = scan_d();
            if(i>n/2)
            {
                answer+=m;
            }
        }
        printf("%d\n",answer);
        n = scan_d();
    }
    
}
    
