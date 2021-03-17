class Solution {
    public String multiply(String num1, String num2) {
        char [] charNum1 = num1.toCharArray();
        char [] charNum2 = num2.toCharArray();
        int n1 = num1.length();
        int n2 = num2.length();
        char [] result = new char[n1+n2];
        Arrays.fill(result, '0');
        StringBuilder sb = new StringBuilder();
        
        for (int j = n1-1; j>=0;j--){
            for (int i = n2-1; i>=0; i--){
                int product = (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
                int temp = result[i+j+1] - '0' + product;
                result[i+j+1] =  (char)(temp % 10 +'0');
                result[i+j] =   (char)(result[i+j] -'0' + temp /10 + '0'); 
            }
        } 
        boolean seen = false;
        for (char c : result){
            if (c=='0' && !seen){
                continue;
            }  
            sb.append(c);
            seen = true;
         }
        return sb.toString().length()==0? "0": sb.toString();
            
        }
    }
