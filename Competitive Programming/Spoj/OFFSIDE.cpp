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
    int a, d, A[11], D[11], i;
    while(scanf("%d %d", &a, &d)==2 && a + d)
	{
		for(i=0; i<a; i++) scanf("%d", &A[i]);
		for(i=0; i<d; i++) scanf("%d", &D[i]);
		sort(A, A+a);
		sort(D, D+d);
		if(A[0] < D[1]) printf("Y\n");
		else printf("N\n");
	}

}
