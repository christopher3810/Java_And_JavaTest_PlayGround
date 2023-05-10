package com.javafeature.demo.dateandtime;

import java.time.*;

public class DateAndTimeDemo {
    public static void main(String[] args) {
        // 1. Creating different date and time objects
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Current date: " + date);
        System.out.println("Current time: " + time);
        System.out.println("Current date and time: " + dateTime);

        // 2. Manipulating dates
        LocalDate nextWeek = date.plusWeeks(1);
        System.out.println("Date after one week: " + nextWeek);

        // 3. Comparing dates
        boolean isAfter = nextWeek.isAfter(date);
        System.out.println("Is next week's date after current date? : " + isAfter);

        // 4. Creating specific date
        LocalDate independenceDay = LocalDate.of(1945, Month.AUGUST, 15);
        System.out.println("Independence day: " + independenceDay);

        // 5. Parsing and formatting dates
        LocalDate parsedDate = LocalDate.parse("2023-05-25");
        System.out.println("Parsed date: " + parsedDate);

        // 6. Getting the day of the week
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println("Current day of the week: " + dayOfWeek);

        // 7. Working with time zones
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Current date and time in Tokyo: " + zonedDateTime);

        // 8. Working with Instant (a point of time in the timeline)
        Instant instant = Instant.now();
        System.out.println("Current instant: " + instant);

        // 9. Duration between two instants
        Instant oneHourLater = Instant.now().plus(Duration.ofHours(1));
        Duration duration = Duration.between(instant, oneHourLater);
        System.out.println("Duration: " + duration.getSeconds() + " seconds");
    }
}
