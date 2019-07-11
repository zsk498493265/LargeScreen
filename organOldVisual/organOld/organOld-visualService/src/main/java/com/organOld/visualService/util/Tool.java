package com.organOld.visualService.util;


import com.organOld.outService.constant.ValueConstant;

import java.util.Calendar;
import java.util.Date;

public class Tool {
    public static Date getNowDate1(){
        Date nowDate = new Date();
        Calendar cal=Calendar.getInstance();
        cal.setTime(nowDate);

        cal.set(Calendar.MONTH,cal.get(Calendar.MONTH )-2);
        cal.set(Calendar.DAY_OF_MONTH,1);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    public static Date getNowDate2(){
        Date nowDate = new Date();
        Calendar cal=Calendar.getInstance();
        cal.setTime(nowDate);
        cal.set(Calendar.MONTH,cal.get(Calendar.MONTH )-1);
        cal.set(Calendar.DAY_OF_MONTH,1);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    public static Date getNowDate3(){
        Date nowDate = new Date();
        Calendar cal=Calendar.getInstance();
        cal.setTime(nowDate);
        cal.set(Calendar.MONTH,cal.get(Calendar.MONTH ));
        cal.set(Calendar.DAY_OF_MONTH,1);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    public static Date getNowDate4(){
        Date nowDate = new Date();
        Calendar cal=Calendar.getInstance();
        cal.setTime(nowDate);
        cal.set(Calendar.DAY_OF_MONTH,1);
        if(cal.get(Calendar.MONTH )==12)
            cal.set(Calendar.MONTH,1);
        else cal.set(Calendar.MONTH,cal.get(Calendar.MONTH )+1);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    public static Date getNowDate5(){
        Date nowDate = new Date();
        Calendar cal=Calendar.getInstance();
        cal.setTime(nowDate);
        cal.set(Calendar.DAY_OF_MONTH,1);
        if(cal.get(Calendar.MONTH )==12)
            cal.set(Calendar.MONTH,2);
        else cal.set(Calendar.MONTH,cal.get(Calendar.MONTH )+2);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    public static String getNowYearAndMonth(){
        Date nowDate = new Date();
        Calendar cal=Calendar.getInstance();
        cal.setTime(nowDate);
        cal.set(Calendar.DAY_OF_MONTH,1);
        String result=cal.get(Calendar.YEAR )+"-0"+cal.get(Calendar.MONTH );

        return result;
    }
    public static int birthdayToAge(Date birthday){
        Date date=new Date();
        return calculateTwoDateYears(date,birthday);
    }
    public static Date AgeTobirthday(int age){
        if(age==0){
            return null;
        }
        Date nowDate = new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR)-age);


//        calendar.set(Calendar.HOUR_OF_DAY,0);
//        calendar.set(Calendar.MINUTE,0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
    public static int calculateTwoDateYears(Date time, Date birthday){
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        if (cal.before(birthday)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthday);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        //只比较 年  不比较月
//        if (monthNow <= monthBirth) {
//            if (monthNow == monthBirth) {
//                if (dayOfMonthNow < dayOfMonthBirth) age--;
//            }else{
//                age--;
//            }
//        }
        return age;
    }
    public static Integer ReturnTendence(Integer size,double factor){
       Integer one = 1;
        double temp =size * (factor * ValueConstant.Oldman_Inreasement + Long.parseLong(one.toString()));
        temp = Math.ceil(temp);
        Integer tendence = (new Double(temp)).intValue();
        return tendence;
    }
    public static Integer ReturnTendence1(Integer size,double factor){
        double temp =size * (factor * ValueConstant.Oldman_Inreasement * 20 * 0.9   + 1) ;
        temp = Math.ceil(temp);
        Integer tendence = (new Double(temp)).intValue();
        return tendence;
    }
    public  static Integer ReturnTendence2(Integer size,double factor){
        double temp =size * (factor * ValueConstant.Oldman_Inreasement * 20 * 0.7  + 1)  ;
        temp = Math.ceil(temp);
        Integer tendence = (new Double(temp)).intValue();
        return tendence;
    }

    public  static Integer ReturnTendence3(Integer size,double factor){
        double temp =size * (factor * ValueConstant.Oldman_Inreasement * 20 * 0.5  + 1) ;
        temp = Math.ceil(temp);
        Integer tendence = (new Double(temp)).intValue();
        return tendence;
    }


}
