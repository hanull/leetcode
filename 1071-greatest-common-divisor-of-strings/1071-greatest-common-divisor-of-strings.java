class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // str1, str2 위치를 바꿔서 더한 문자열 a, b가 같지 않은 경우, 최대공약수는 존재하지 않는다.
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        
        int len = gcd(str1.length(), str2.length());
        
        System.out.println(len);
        return str1.substring(0, len);
    }
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}