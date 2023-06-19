import org.apache.commons.lang3.StringUtils;

public class testCharSequence {
    public static void main(String[] args) {
        String a = null;
        String b = "";
        String c = "    ";
        String d = " 777";
        System.out.println(StringUtils.isBlank(a));
        System.out.println(StringUtils.isBlank(b));
        System.out.println(StringUtils.isBlank(c));
        System.out.println(StringUtils.isBlank(d));
    }
}
