#include <iostream>
using namespace std;

int main() {
	// your code goes here
	int freq[10]={0}, temp;
  	bool possible=false;
  	int val;
  	int a[6];
  	for(int i=0; i<6; i++)
  	{
    	cin >> temp;
    	a[i]=temp;
    	freq[temp]++;
    	if(freq[temp]==4)
    	{
      		possible=true;
      		val = temp;
    	}
  	}
  	if(!possible){
    	cout << "Alien" << endl;
  	}
  	else
  	{
  	int count=0;
    for(int i=0;i<6;i++)
    {
    	if(a[i]==val && count!=4)
    	{
    		count++;
    		a[i]=-1;
    	}
    }
    int num[2];
    int x=0;
    for(int i=0;i<6;i++)
    {
    	if(a[i]!=-1)
    	{
    		num[x++]=a[i];
    	}
    }
    if(num[0]==num[1])
    {
    	cout<<"Elephant"<<endl;
    }
    else if(num[0]>num[1] || num[1]>num[0])
    {
    	cout<<"Bear"<<endl;
    }
  	}



	return 0;
}
