import java.io.IOException;
import java.util.Date;

/**
 * @author XuYiPeng
 * @Description <描述>
 * @date 2021/12/10
 */
public class test {

    public static void main(String[] args) throws IOException {

        String test = "1234567";
        char[] chars = test.toCharArray();
        String value = String.valueOf(chars, 3, 0);
        System.out.println(value);
    }

    public static class yu {
        private Date dateTime;

        public Date getDateTime() {
            return dateTime;
        }

        public void setDateTime(Date dateTime) {
            this.dateTime = dateTime;
        }
    }
}
