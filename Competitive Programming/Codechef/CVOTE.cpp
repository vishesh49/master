#include<string>
#include<stdio.h>
#include<map>
#include<string.h>
#include<iostream>
using namespace std;
map<string,string>mp1;
map<string,int>mp2;
map<string,int>mp3;
map<string,int>::iterator it,it1,it2;
int main()
{
    int n,m,i,j,k;
        char s1[100],s2[100];
        char ans1[100],ans2[100];
        while(scanf("%d %d",&n,&m)!=EOF)
        {
         mp1.clear();
                 mp2.clear();
                 mp3.clear();
         while(n--)
                 {
                         scanf("%s %s",s1,s2);
                         mp1[s1]=s2;
                 }
                 while(m--)
                 {
                         scanf("%s",s1);
                         mp2[s1]++;
                         mp3[mp1[s1]]++;
             // mp3[s1]++;
                 }
                 //strcpy(char_str,string_str.c_str());
           int mmax=0;
                 for(it=mp2.begin();it!=mp2.end();it++)
                 {
                         if(it->second>mmax) {mmax=it->second;strcpy(ans1,it->first.c_str());}
                 }
                 mmax=0;
                                 for(it=mp3.begin();it!=mp3.end();it++)
                 {
                         if(it->second>mmax) {mmax=it->second;strcpy(ans2,it->first.c_str());}
                 }
                         printf("%s\n%s\n",ans2,ans1);
                //      cout<<ans1<<ans2<<endl;
        }
        return 0;
}
