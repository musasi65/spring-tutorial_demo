/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etagtest;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author 62552
 */
public class DateSample {
    public static void main(String[] args) throws ParseException{
//        
//        Calendar cal = Calendar.getInstance();        
        
//        System.out.println(cal.getTime()); 
//        cal.add(Calendar.HOUR_OF_DAY, -1);

        
//        System.out.println(cal.getTime());
//        
//        SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
//        String str = sdf.format(cal.getTime());
//        System.out.println(str);
//        
//        Calendar cal2 = Calendar.getInstance();
//        cal2.setTime(sdf.parse(str));
//        System.out.println(cal2.getTime());
        
        
        SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
                String str1="2016-02-02 12:12:10,100";
                String str2="2016-02-02 12:12:12,100";
        Calendar cal1 = Calendar.getInstance();        
        cal1.setTime(sdf.parse(str1));      
                Calendar cal2 = Calendar.getInstance();        
        cal2.setTime(sdf.parse(str2));
      
        long dif=(cal2.getTimeInMillis()-cal1.getTimeInMillis())/1000;

        System.out.println(cal1.getTime());     
        System.out.println(cal2.getTime());
        System.out.println(cal1.after(cal2));
         System.out.println(dif);

    }
}
