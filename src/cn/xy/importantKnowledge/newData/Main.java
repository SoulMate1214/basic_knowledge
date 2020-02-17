package cn.xy.importantKnowledge.newData;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        LocalTime localTime = LocalTime.now();
        System.out.println("现在时间："+localTime);// 现在时间：23:00:49.476
        System.out.println("=============  localTime常用方法  =============");
        main.localTime();
        System.out.println("=============  localDateTime常用方法  =============");
        main.localDateTime();
    }
    public void localTime(){
        LocalDate today = LocalDate.now();
        System.out.println("今天⽇期：" + today);// 今天⽇期：2019-11-07
        //获取年，⽉，⽇，周⼏
        System.out.println("现在是哪年:"+today.getYear());// 现在是哪年:2019
        System.out.println("现在是哪⽉(英文):"+today.getMonth());// 现在是哪⽉(英文):NOVEMBER
        System.out.println("现在是哪⽉(数字):"+today.getMonthValue());// 现在是哪⽉(数字):11
        System.out.println("现在是⼏号:"+today.getDayOfMonth());// 现在是⼏号:7
        System.out.println("现在是周⼏:"+today.getDayOfWeek());// 现在是周⼏:THURSDAY
        //加减年份,  加后返回的对象才是修改的，旧的依然是旧的
        LocalDate changeDate =  today.plusYears(1);
        System.out.println("加后是哪年:"+changeDate.getYear());// 加后是哪年:2020
        System.out.println("旧的是哪年:"+today.getYear());// 旧的是哪年:2019
        //日期比较
        System.out.println("isAfter:"+changeDate.isAfter(today));// isAfter:true
      /*
        //getYear() int 获取当前⽇期的年份
        //getMonth() Month 获取当前⽇期的⽉份对象
        //getMonthValue() int 获取当前⽇期是第⼏⽉
        //getDayOfWeek() DayOfWeek 表示该对象表示的⽇期是星期⼏
        //getDayOfMonth() int 表示该对象表示的⽇期是这个⽉第⼏天
        //getDayOfYear() int 表示该对象表示的⽇期是今年第⼏天
        //withYear(int year) LocalDate 修改当前对象的年份
        //withMonth(int month) LocalDate 修改当前对象的⽉份
        //withDayOfMonth(int dayOfMonth) LocalDate 修改当前对象在当⽉的⽇期
        //plusYears(long yearsToAdd) LocalDate 当前对象增加指定的年份数
        //plusMonths(long monthsToAdd) LocalDate 当前对象增加指定的⽉份数
        //plusWeeks(long weeksToAdd) LocalDate 当前对象增加指定的周数
        //plusDays(long daysToAdd) LocalDate 当前对象增加指定的天数
        //minusYears(long yearsToSubtract) LocalDate 当前对象减去指定的年数
        //minusMonths(long monthsToSubtract) LocalDate 当前对象减去注定的⽉数
        //minusWeeks(long weeksToSubtract) LocalDate 当前对象减去指定的周数
        //minusDays(long daysToSubtract) LocalDate 当前对象减去指定的天数
        //compareTo(ChronoLocalDate other) int ⽐较当前对象和other对象在时间上的⼤⼩，返回值如果为正，则当前对象时间较晚，
        //isBefore(ChronoLocalDate other) boolean ⽐较当前对象⽇期是否在other对象⽇期之前
        //isAfter(ChronoLocalDate other) boolean ⽐较当前对象⽇期是否在other对象⽇期之后
        //isEqual(ChronoLocalDate other) boolean ⽐较两个⽇期对象是否相等
     */
    }

    public void localDateTime(){
        // DateTimeFormatter是线程安全的SimpleDateFormat
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);// 2019-11-07T23:12:29.056
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String ldtStr = dtf.format(ldt);
        System.out.println(ldtStr);// 2019-11-07 23:12:29
        // 获取指定的⽇期时间对象
        LocalDateTime ldt2 = LocalDateTime.of(2020, 11, 11, 8, 20, 30);
        System.out.println(ldt2);// 2020-11-11T08:20:30
        // 计算⽇期时间差 java.time.Duration
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);// 2019-11-07T23:12:29.070
        LocalDateTime changeDate = LocalDateTime.of(2020,10,1,10,40,30);
        System.out.println(changeDate);// 2020-10-01T10:40:30
        Duration duration = Duration.between( today,changeDate);//第⼆个参数减第⼀个参数
        System.out.println(duration.toDays());//两个时间差的天数
        System.out.println(duration.toHours());//两个时间差的⼩时数
        System.out.println(duration.toMinutes());//两个时间差的分钟数
        System.out.println(duration.toMillis());//两个时间差的毫秒数
        System.out.println(duration.toNanos());//两个时间差的纳秒数
    }
}