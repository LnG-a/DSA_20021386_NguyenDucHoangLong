public class JavaStringReverse {
    static public boolean palindrome(String a){
        if (a==null) return true;
        for (int i=0;i<=a.length()/2;i++){
            if (a.charAt(i)!=a.charAt(a.length()-i)) return false;
        }
        return true;
    }
}
