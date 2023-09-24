package path.learning.math.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class DateAndTime {

	public String date() {
		Date date = new Date();
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date);
	}

	public String time() {
		Date date = new Date();
		DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(date);
	}
}
