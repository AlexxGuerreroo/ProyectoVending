/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ab.clasesvendingmachine;
import org.apache.commons.lang3.time.DateFormatUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author pikac
 */
public class Fecha extends org.apache.commons.lang3.time.DateUtils {
    
    private static String[] parsePatterns = {
        "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", 
        "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
        "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"
    };

	/**
	  * Obtener el formato de cadena de fecha actual (aaaa-MM-dd)
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}
	
	/**
	  * Obtener el patrón de formato de cadena de fecha actual
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}
	
	/**
	  * Obtener cadena de fecha Formato predeterminado (aaaa-MM-dd) patrón
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}
	
	/**
	  * Obtenga la cadena de fecha y hora y convierta el formato (aaaa-MM-dd HH: mm: ss)
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	  * Formato de fecha
	  * @param fecha fecha
	  * @return El formato de visualización de retorno predeterminado es aaaa-MM-dd HH: mm: ss
	 */
	public static Date dateFormat(Date date){
		if(date==null) date=new Date();
		return dateFormat(date, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	  * Formato de fecha
	  * @param fecha fecha
	  * Formato de visualización del patrón @param
	  * @return devuelve la fecha formateada, o nulo si el formateo falla
	 */
	public static Date dateFormat(Date date,String pattern){
		if (date == null) date=new Date();
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date result = null;
		try {
			result = format.parse(format.format(date));
		} catch (ParseException e) {

		}
		return result;
	}

	/**
	  * Obtener el formato de cadena de tiempo actual (HH: mm: ss)
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	  * Obtener el formato de cadena de fecha y hora actual (aaaa-MM-dd HH: mm: ss)
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	  * Obtener el formato de cadena del año actual (aaaa)
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	  * Obtener el formato de cadena del mes actual (MM)
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	  * Obtener el formato de cadena del día actual (dd)
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	  * Obtener el formato de cadena del día de la semana actual (E) día de la semana
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}
	
	/**
	  * La cadena de fecha se convierte al formato de fecha
	 */
	public static Date parseDate(Object str) {
		if (str == null){
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	  * Convertir a tiempo (día, hora: minuto: segundo. Milisegundo)
	 * @param timeMillis
	 * @return
	 */
    public static String formatDateTime(long timeMillis){
		long day = timeMillis/(24*60*60*1000);
		long hour = (timeMillis/(60*60*1000)-day*24);
		long min = ((timeMillis/(60*1000))-day*24*60-hour*60);
		long s = (timeMillis/1000-day*24*60*60-hour*60*60-min*60);
		long sss = (timeMillis-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
		return (day>0?day+",":"")+hour+":"+min+":"+s+"."+sss;
    }

	/**
	  * Obtener fecha china
	 * @param date
	 * @return
	 */
	public String getChineseWeek(Calendar date) {
		final String dayNames[] = { "el domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "en sábado" };
		int dayOfWeek = date.get(Calendar.DAY_OF_WEEK); 
		return dayNames[dayOfWeek - 1];
	}

	
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static Date parseDate(String value,Class targetType,String... formats) {
        for(String format : formats) {
            try {
                long v = new SimpleDateFormat(format).parse(value).getTime();
                return (Date)targetType.getConstructor(long.class).newInstance(v);
            }catch(ParseException e) {
            }catch(Exception e) {
                throw new RuntimeException(e);
            }
            try {
                return (Date)targetType.getConstructor(String.class).newInstance(value);
            }catch(Exception e) {
            }
        }
        throw new IllegalArgumentException("cannot parse:"+value+" for date by formats:"+Arrays.asList(formats));
    }

    public static boolean isDateType(Class<?> targetType) {
        if(targetType == null) return false;
        return targetType == Date.class || targetType == java.sql.Timestamp.class || targetType == java.sql.Date.class || targetType == java.sql.Time.class;
    }
    
    /**
           * Obtener el mes y día correspondiente según año y mes 
     * @param year
     * @param month
     * @return
     */
    public static int getDaysByYearMonth(int year, int month) {  
        Calendar a = Calendar.getInstance();  
        a.set(Calendar.YEAR, year);  
        a.set(Calendar.MONTH, month - 1);  
        a.set(Calendar.DATE, 1);  
        a.roll(Calendar.DATE, -1);  
        int maxDate = a.get(Calendar.DATE);  
        return maxDate;  
    }  

    /**
           * Obtenga la cantidad de días del mes 
     * @return
     */
    public static int getCurrentMonthDay() {  
        Calendar a = Calendar.getInstance();  
        a.set(Calendar.DATE, 1);  
        a.roll(Calendar.DATE, -1);  
        int maxDate = a.get(Calendar.DATE);  
        return maxDate;  
    }
    
}
