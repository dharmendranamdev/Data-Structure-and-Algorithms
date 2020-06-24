#include <stdio.h>
 
const int ARRAY_SIZE = 5;    
 
int main ()
{
   
   int a[] = {5, 10, 20, 40, 80};  
   int i, *p[ARRAY_SIZE]; 
 
   for ( i = 0; i < ARRAY_SIZE; i++)
   {
      /* for indices 1 through 5, set a pointer to 
         point to a corresponding integer:                */
      p[i] = &a[i];    
   }

   for ( i = 0; i < ARRAY_SIZE; i++)
   {
      /* print the values of the integers pointed to 
         by the pointers:                                  */
      printf("array_of_integers[%d] = %d\n", i, *p[i] );
   }

   return 0;
}