package br.com.alura.leilao.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

public enum DayUtil {
    MONDAY(1,0),
    TUESDAY(2,0),
    WEDNESDAY(3,0),
    THURSDAY(4,0),
    FRIDAY(5,0),
    SATURDAY(6,2),
    SUNDAY(7,1);

    private Integer id;
    private Integer day;

    DayUtil(Integer id, Integer day) {
        this.id = id;
        this.day = day;
    }

    public static LocalDate getDayUtil(LocalDate date){
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return date.plusDays(forDay(dayOfWeek.getValue()).day);
    }

    private static DayUtil forDay(int day){
        return  Arrays.stream(DayUtil.values())
                .filter(d -> d.id.equals(day))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Day not found: "+ day));
    }
}
