import java.util.Scanner;

public class EmailValidation {
    public static void main(String[] args) {

        Scanner Input = new Scanner(System.in);
        System.out.println("Pleas enter your email address: ");

        String emailInput = Input.nextLine();
        System.out.println(isValidEmail(emailInput));

    }
    public static boolean isAlphanumeric(char a) {
        // return true if char is an english letter or arabic numeral. otherwise false
        boolean isAlpha = (( a >='a' && a <= 'z') || (a >='A' && a <= 'Z') || ( a >= '0' && a <='9'));
        return isAlpha;

    }
    public static boolean isValidPrefixchar (char b) {
        // return true if char can be used in the prefix of a valid email, otherwise false
        boolean isValidChar = (isAlphanumeric (b) || b =='_' || b == '.' || b == '-');
        return isValidChar;
    }
    public static boolean isValidDomainchar(char c) {
        // return true if char can be used as domain, otherwise false
        boolean isValidDomain = (isAlphanumeric(c) || c == '.' || c =='-');
        return isValidDomain;
    }
    public static boolean exactlyOneAt (String s) {
        // return true if the string contains exactly one @, otherwise false
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '@') {

                counter++;
            }
        }
        if (counter != 1) {

            return false;
        }
        return true;

    }
    public static String getPrefix(String s){
        //return a prefix of the given email address
        if ( exactlyOneAt(s)){
            return (s.substring(0,s.indexOf('@')));
        } else {
            return "error";
        }
    }
    public static String getDomain (String t){
        // return a domain of the given email address
        int aLenght = t.length();
        int indexAt = t.indexOf("@") +1;
        return (t.substring(indexAt,aLenght));

    }
    public static boolean isValidPrefix (String r){
        // return true if the prefix correspond to the  given "acceptable prefix format"
        String prefix = getPrefix(r);
        for (int i = 0; i < prefix.length(); i++) {
            if ((isValidPrefixchar(prefix.charAt(i))) == false){
                return false;
            }
        }
        if (prefix.contains("..") || prefix.contains("--")){
            return false;
        }
        if (isAlphanumeric(prefix.charAt(0)) == false || isAlphanumeric(prefix.charAt(prefix.length()-1)) == false ){
            return false;
        }
        return true;
    }
    public static boolean isValidDomain (String n) {
        // return true if the prefix correspond with to the given "acceptable domain format"
        String domain = getDomain(n);
        for (int i = 0; i < domain.length(); i++) {
            if (isValidDomainchar(domain.charAt(i)) == false){
                return false;
            }

        }
        String lastFour = domain.substring(domain.length() -4);
        if (lastFour.contains(".") == false){
            return false;
        }
        if (domain.contains("..") || domain.contains("--")){
            return false;
        }
        return true;
    }
    public static boolean isValidEmail ( String g){
        // return true if the given email is valid, otherwise false
        if ((exactlyOneAt(g) == true) && (isValidPrefix(g) == true) && (isValidDomain(g) == true)) {
            System.out.println("Your email is valid");
            return true;
        } else {
            System.out.println( "Please enter valid email ...");
            return false;
        }
    }
}
