// C++ implementation of brute
// https://www.geeksforgeeks.org/total-numbers-no-repeated-digits-range/
/*
Total numbers with no repeated digits in a range
Given a range L, R find total such numbers in the given range such that they have no repeated digits.
For example:
12 has no repeated digit.
22 has repeated digit.
102, 194 and 213 have no repeated digit.
212, 171 and 4004 have repeated digits.

Examples:

Input : 10 12
Output : 2
Explanation : In the given range
10 and 12 have no repeated digit
where as 11 has repeated digit.

Input : 1 100
Output : 90
*/
#include <bits/stdc++.h>
#include<sstream>
using namespace std;

void repeated_digit(int L,int R)
{
    int flag,count = 0;
	for(int i = L; i <= R; i++)
    {
        flag = 1;
        //------Conversion : int to String-----------
        stringstream ss;
        ss<<i;
        string str;
        ss>>str;
        //-----------
        for(int j = 0; j < str.length(); j++)
        {
                char c  = str[j];
                for(int k = j + 1;  k < str.length(); k++)
                {
                    if(str[k] == c)
                    {
                        flag = 0;
                        break;
                    }
                }
                if(flag == 0)
                {
                    break;
                }
        }
        if(flag == 1)
        {
            ++count;
            //cout<<count<<endl;
        }

    }
    cout<<count;
}


int main()
{
	int L,R;
	cout<<"Enter L and R : ";
	cin>>L>>R;
	repeated_digit(L, R);
	return 0;
}
