package com.geely.design.pattern.structural.flyweight;

import java.util.Date;

public class SpecificTime {
    public static void main ( String[] args ) {

        System.out.print(SpecificTime(new Date(23), new Date(22), new Date(5)));
    }

    public static boolean SpecificTime ( Date time, Date startTime, Date endTime ) {

        //if the endTime before the startTime, refer the endTime means the next day;

        if (endTime.before(startTime)) endTime.setTime(endTime.getTime() + 24);

        if (time.before(startTime)) return false;

        if (time.after(endTime)) return false;

        return true;

    }
}
