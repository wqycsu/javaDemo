package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {
	public static void main(String args[]){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		System.out.println(format.format(date));
	}
	
}
