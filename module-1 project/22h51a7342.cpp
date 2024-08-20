#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
#include<bits/stdc++.h>


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int n;
    cin>>n;
    int id[n],balance[n];
    int user_index[101]={0};
        for(int i=0;i<n;i++){
            cin>>id[i]>>balance[i];
            user_index[id[i]]=i;
        }
    int t;
    cin>>t;
    string res[t];
    for(int i=0;i<t;i++){
        int from_user,to_user,amount;
        cin>>from_user>>to_user>>amount;
        int from_index = user_index[from_user];
        int to_index = user_index[to_user];
        if(balance[from_index]>=amount){
            balance[from_index]-=amount;
            balance[to_index]+=amount;
            res[i]="Success";
        }
        else{
            res[i]="Failure";
        }
    }
    for(int i=0;i<t;i++){
        cout<<res[i]<<endl;
    }   
    for(int i=0;i<n-1;i++){
        for(int j=i+1;j<n;j++){
            if(balance[i]>balance[j] || (balance[i]==balance[j]  && id[i]>id[j])){
                swap(balance[i],balance[j]);
                swap(id[i],id[j]);
            }
        }
    }
    cout<<"\n";
    for(int i=0;i<n;i++){
        cout<<id[i]<<" "<<balance[i]<<endl;
    }
    return 0;
}
