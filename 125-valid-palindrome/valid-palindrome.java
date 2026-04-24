// class Solution {
//     public boolean isPalindrome(String s) {
//         s= s.toLowerCase().replaceAll("[a-z0-9]","");
//         char [] arr= s.toCharArray();
//         check(arr,0,arr.length-1);
//         String reverse =  new String(arr);
//         return s.equals(reverse);

       
//         }

//         public void check(char[] s, int i, int j){
//             if(i>=j) return;
//             char temp= s[i];
//             s[i]=s[j];
//             s[j]=temp;
//             check(s,i + 1,j - 1);
//         }
// }





class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        char[] arr = s.toCharArray();
        check(arr, 0, arr.length - 1);

        String reverse = new String(arr);
        return s.equals(reverse);
    }

    public void check(char[] s, int i, int j) {
        if (i >= j) return;

        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;

        check(s, i + 1, j - 1);
    }
}




    



