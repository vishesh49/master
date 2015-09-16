/* Sample program illustrating input/output */
#include<iostream>
#include<algorithm>
using namespace std;

bool wayToSort(int i, int j) { return i > j; }

int main(void){

 

//Helpers for input and output

   int N, K;
   cin >> N >> K;
   int C[N];
   int F[K];
   for(int i=0;i<K;i++)
   {
       F[i]=0;
   }
   for(int i = 0; i < N; i++){
      cin >> C[i];
   }
   sort(C,C+N,wayToSort);
   int result;
   int counter = 0;
   for(int i=0;i<N;i++)
   {
       result += (F[counter]+1)*C[i];
       F[counter]++;
       counter = (counter+1)%K;
   }
    
    
   cout << result << "\n";
   
   return 0;
}

