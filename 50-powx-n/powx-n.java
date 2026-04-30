// class Solution {
//     public double myPow(double x, int n) {
//         if(x==0||){
//             return 0 ;
//         }
//         int half= myPow(x, n/2);
//         if(n%2=0){
//             return (half*half);
//         }
//         else{
//             return (x*half*half);
//         }
        
//     }
// }


class Solution {
    public double myPow(double x, int n) {
        // base case
        if(n==0){
            return 1.0;
        }
        long N = n;
        if(N<0){
            x=1/x;
            N=-N;
        }

        // recusrsive relation
        double half= myPow(x,(int)(N/2));
        if(n%2==0){
            return half*half;
        }
        else{
            return x*half*half;
        }
    }
}