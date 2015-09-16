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
int getint(char *s)
{
	int i, n = 0;
	for(i=0;s[i];i++)
	{
		if(!isdigit(s[i])) return -1;
		n = n*10+s[i]-'0';
	}
	return n;
}

int main()
{
	char str[100], *p;
	int t, i, a[3];
	scanf("%d", &t);
	for(gets(str); t; t--)
	{
		gets(str);
		gets(str);
		i = 0;
		p = strtok(str," +=");
		while(p)
		{
			a[i++] = getint(p);
			p = strtok(0," +=");
		}
		if(a[0]==-1) printf("%d + %d = %d\n",a[2]-a[1], a[1], a[2]);
		else if(a[1]==-1) printf("%d + %d = %d\n",a[0], a[2]-a[0], a[2]);
		else printf("%d + %d = %d\n",a[0], a[1], a[0]+a[1]);
	}
	return 0;
}
