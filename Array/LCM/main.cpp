#include <iostream>

using namespace std;
int LCM(int a,int b)
{
    int big = a>b?a:b;
    //cout<<big;
    int lcm = 1;
    int flag = 0;
    for(int i = 2; i <= big && (a != 1 || b != 1);)
    {
        flag = 0;
        if(a % i == 0 && b % i == 0)
        {
            a = a / i;
            b = b / i;
            lcm = lcm * i;
            flag = 1;
        }
        else
        {
            if(a % i == 0)
            {
                a = a / i;
                lcm = lcm * i;
            }
            if(b % i == 0)
            {
                b = b / i;
                lcm = lcm *  i;
            }
            flag = 1;
        }
        if(flag == 0)
        {
            i++;
        }
    }


    return lcm;
}
int main()
{
    cout << "Hello world!" << endl;
    int a,b;
    cout<<"\nEnter 2 No:";
    cin>>a>>b;
    cout<<"\nLCM : "<<LCM(a,b);
    return 0;
}
