import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) throws ParseException {
        String source = "2020/12/23";
        if (Pattern.matches("^\\d{4}[-]\\d{1,2}[-]\\d{1,2}$", source)) {
            //匹配yyyy-MM-dd
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(dateFormat.parse(source));
        } else if (Pattern.matches("^\\d{4}[/]\\d{1,2}[/]\\d{1,2}$", source)) {
            //匹配yyyy/MM/dd
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            System.out.println(dateFormat.parse(source));
        } else {
            System.out.println("不支持此类型:" + source);
        }
    }
}
