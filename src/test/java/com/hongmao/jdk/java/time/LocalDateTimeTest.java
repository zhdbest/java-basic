package com.hongmao.jdk.java.time;

import org.junit.Test;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalQueries;

/**
 * @author zhaohaodong
 * @version 1.0. Added Time:2020/11/23 19:45
 */
public class LocalDateTimeTest {

    @Test
    public void testNow() {
        // 使用默认时区、默认时钟
        System.out.println("默认时区：" + LocalDateTime.now());
        // 指定时区
        System.out.println("上海时间：" + LocalDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("CTT"))));
        System.out.println("巴黎时间：" + LocalDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("ECT"))));
        System.out.println("芝加哥时间：" + LocalDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("CST"))));
        // 指定时钟，UTC：协调世界时，又称世界统一时间、世界标准时间、国际协调时间
        System.out.println("UTC：" + LocalDateTime.now(Clock.systemUTC()));
    }

    @Test
    public void testOf() {
        // 设置：年、月（Month）、日、时、分
        System.out.println(LocalDateTime.of(2012, Month.AUGUST, 1, 9, 0));
        // 设置：年、月（Month）、日、时、分、秒
        System.out.println(LocalDateTime.of(2012, Month.AUGUST, 1, 9, 0, 1));
        // 设置：年、月（Month）、日、时、分、秒、纳秒
        System.out.println(LocalDateTime.of(2012, Month.AUGUST, 1, 9, 0, 1, 1));

        // 设置：年、月（int）、日、时、分
        System.out.println(LocalDateTime.of(2018, 9, 1, 9, 0));
        // 设置：年、月（int）、日、时、分、秒
        System.out.println(LocalDateTime.of(2018, 9, 1, 9, 0, 1));
        // 设置：年、月（int）、日、时、分、秒、纳秒
        System.out.println(LocalDateTime.of(2018, 9, 1, 9, 0, 1, 1));

        // 设置：日期、时间
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
    }

    @Test
    public void testOfInstant() {
        // Epoch 是一个特定的时刻即：1970-01-01T00:00:00，转换为上海时区的话即：1970-01-01T08:00:00
        System.out.println(LocalDateTime.ofInstant(Instant.EPOCH, ZoneId.of(ZoneId.SHORT_IDS.get("CTT"))));
        // 获取当前时刻在上海时区的时间
        System.out.println(LocalDateTime.ofInstant(Instant.now(), ZoneId.of(ZoneId.SHORT_IDS.get("CTT"))));
    }

    @Test
    public void testOfEpochSecond() {
        // 秒数为5、纳秒数为1，偏移量为0秒
        System.out.println(LocalDateTime.ofEpochSecond(5, 1, ZoneOffset.UTC));
        // 秒数为5、纳秒数为1，偏移量为8秒
        System.out.println(LocalDateTime.ofEpochSecond(5, 1, ZoneOffset.ofTotalSeconds(8)));
    }

    @Test
    public void testFrom() {
        // 参数为一个 LocalDateTime
        System.out.println(LocalDateTime.from(LocalDateTime.of(2020, 5, 6, 12, 22, 6)));
        // 参数为一个 ZonedDateTime
        System.out.println(LocalDateTime.from(ZonedDateTime.now()));
    }

    @Test
    public void testParse() {
        // 使用默认格式
        System.out.println(LocalDateTime.parse("2020-01-01T12:12:12"));
        // 指定格式
        DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(DateTimeFormatter.ISO_LOCAL_DATE)
                .appendLiteral(" ")
                .append(DateTimeFormatter.ISO_LOCAL_TIME)
                .toFormatter();
        System.out.println(LocalDateTime.parse("2020-01-01 12:12:12", dateTimeFormatter));
    }

    @Test
    public void testIsSupportedForField() {
        // 测试LocalDateTime是否支持“年份”字段
        System.out.println(LocalDateTime.now().isSupported(ChronoField.YEAR));
        System.out.println(LocalDateTime.now().get(ChronoField.YEAR));
        System.out.println(LocalDateTime.now().range(ChronoField.YEAR));

        // 测试LocalDateTime是否支持“月份”字段
        System.out.println(LocalDateTime.now().isSupported(ChronoField.MONTH_OF_YEAR));
        System.out.println(LocalDateTime.now().get(ChronoField.MONTH_OF_YEAR));
        System.out.println(LocalDateTime.now().range(ChronoField.MONTH_OF_YEAR));

        // 测试LocalDateTime是否支持“与UTC/Greenwich的偏移量”字段
        System.out.println(LocalDateTime.now().isSupported(ChronoField.OFFSET_SECONDS));
        System.out.println(LocalDateTime.now().get(ChronoField.OFFSET_SECONDS));
        System.out.println(LocalDateTime.now().range(ChronoField.OFFSET_SECONDS));
    }

    @Test
    public void testIsSupportedForUnit() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        // 判断是否支持单位“天”
        System.out.println(now.isSupported(ChronoUnit.DAYS));
        // 加5天
        System.out.println(now.plus(5, ChronoUnit.DAYS));
        // 加2小时
        System.out.println(now.minus(2, ChronoUnit.HOURS));

        System.out.println(now.isSupported(ChronoUnit.FOREVER));
        System.out.println(now.plus(5, ChronoUnit.FOREVER));
    }

    @Test
    public void testRange() {
        LocalDateTime now = LocalDateTime.now();
        // 一年内的月份
        System.out.println(now.range(ChronoField.MONTH_OF_YEAR));
        // 一天内的小时数
        System.out.println(now.range(ChronoField.HOUR_OF_DAY));
        // 一分钟内的秒数
        System.out.println(now.range(ChronoField.SECOND_OF_MINUTE));
        // 一天内的秒数
        System.out.println(now.range(ChronoField.SECOND_OF_DAY));
    }

    @Test
    public void testGet() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        // 一年内的月份
        System.out.println(now.get(ChronoField.MONTH_OF_YEAR));
        // 一天内的小时数
        System.out.println(now.get(ChronoField.HOUR_OF_DAY));
        // 一分钟内的秒数
        System.out.println(now.get(ChronoField.SECOND_OF_MINUTE));
        // 一天内的秒数
        System.out.println(now.get(ChronoField.SECOND_OF_DAY));
    }

    @Test
    public void testGetLong() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        // 一年内的月份
        System.out.println(now.getLong(ChronoField.MONTH_OF_YEAR));
        // 一天内的小时数
        System.out.println(now.getLong(ChronoField.HOUR_OF_DAY));
        // 一分钟内的秒数
        System.out.println(now.getLong(ChronoField.SECOND_OF_MINUTE));
        // 一天内的秒数
        System.out.println(now.getLong(ChronoField.SECOND_OF_DAY));
    }

    @Test
    public void testToLocalDate() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.toLocalDate());
    }

    @Test
    public void testGetYear() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.getYear());
    }

    @Test
    public void testGetMonthValue() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.getMonthValue());
    }

    @Test
    public void testGetMonth() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getMonth());
    }

    @Test
    public void testGetDayOfMonth() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getDayOfMonth());
    }

    @Test
    public void testGetDayOfYear() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getDayOfYear());
    }

    @Test
    public void testGetDayOfWeek() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getDayOfWeek());
    }

    @Test
    public void testToLocalTime() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.toLocalTime());
    }

    @Test
    public void testGetHour() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getHour());
    }

    @Test
    public void testGetMinute() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getMinute());
    }

    @Test
    public void testGetSecond() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getSecond());
    }

    @Test
    public void testGetNano() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getNano());
    }

    @Test
    public void testWithForTemporalAdjuster() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        // 调整日期到：当前LocalDateTime实例所在年份的第一天
        System.out.println(now.with(TemporalAdjusters.firstDayOfYear()));
        // 调整日期到：当前LocalDateTime实例所在月份的第一天
        System.out.println(now.with(TemporalAdjusters.firstDayOfMonth()));
        // 调整日期到：当前LocalDateTime实例所在月份的下个月第一天
        System.out.println(now.with(TemporalAdjusters.firstDayOfNextMonth()));
        // 调整日期到：当前LocalDateTime实例所在月份的下个月10号
        System.out.println(now.with(
                temporal -> temporal.with(ChronoField.DAY_OF_MONTH, 10).plus(1, ChronoUnit.MONTHS)));
        // 调用with方法的LocalDateTime实例不变，每次调用with都是返回一个新的实例
        System.out.println(now);
    }

    @Test
    public void testWithForTemporalField() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        // 调整日期到：当前LocalDateTime实例所在年份的第6个月
        System.out.println(now.with(ChronoField.MONTH_OF_YEAR, 6));
        // 调整日期到：当前LocalDateTime实例所在月份的第1天
        System.out.println(now.with(ChronoField.DAY_OF_MONTH, 1));
    }

    @Test
    public void testWitYear() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.withYear(1994));
    }

    @Test
    public void testWithMonth() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.withMonth(6));
    }

    @Test
    public void testWithAll() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.withYear(2008).withMonth(8).withDayOfMonth(8).withHour(20).withMinute(8).withSecond(8).withNano(8));
        System.out.println(now.withDayOfYear(100));
    }

    @Test
    public void testTruncatedTo() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.truncatedTo(ChronoUnit.HOURS));
        System.out.println(now.truncatedTo(ChronoUnit.MINUTES));
        System.out.println(now.truncatedTo(ChronoUnit.SECONDS));
        System.out.println(now.truncatedTo(ChronoUnit.MONTHS));
    }

    @Test
    public void testPlusWithTemporalAmount() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        // 加1周
        System.out.println(now.plus(Period.ofWeeks(1)));
        // 加5小时
        System.out.println(now.plus(Duration.ofHours(5)));
    }

    @Test
    public void testPlusWithUnit() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        // 加1周
        System.out.println(now.plus(1, ChronoUnit.WEEKS));
        // 加5小时
        System.out.println(now.plus(5, ChronoUnit.HOURS));
    }

    @Test
    public void testPlusAll() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        // 加1年
        System.out.println(now.plusYears(1));
        // 加1月
        System.out.println(now.plusMonths(1));
        // 加1周
        System.out.println(now.plusWeeks(1));
        // 加1天
        System.out.println(now.plusDays(1));
        // 加1小时
        System.out.println(now.plusHours(1));
        // 加1分钟
        System.out.println(now.plusMinutes(1));
        // 加1秒
        System.out.println(now.plusSeconds(1));
        // 加1纳秒
        System.out.println(now.plusNanos(1));
    }

    @Test
    public void testMinusWithTemporalAmount() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        // 减1周
        System.out.println(now.minus(Period.ofWeeks(1)));
        // 减5小时
        System.out.println(now.minus(Duration.ofHours(5)));
    }

    @Test
    public void testMinusWithUnit() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        // 减1周
        System.out.println(now.minus(1, ChronoUnit.WEEKS));
        // 减5小时
        System.out.println(now.minus(5, ChronoUnit.HOURS));
    }

    @Test
    public void testMinusAll() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        // 减1年
        System.out.println(now.minusYears(1));
        // 减1月
        System.out.println(now.minusMonths(1));
        // 减1周
        System.out.println(now.minusWeeks(1));
        // 减1天
        System.out.println(now.minusDays(1));
        // 减1小时
        System.out.println(now.minusHours(1));
        // 减1分钟
        System.out.println(now.minusMinutes(1));
        // 减1秒
        System.out.println(now.minusSeconds(1));
        // 减1纳秒
        System.out.println(now.minusNanos(1));
    }

    @Test
    public void testQuery() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        // 查询当前实例的日期
        System.out.println(now.query(TemporalQueries.localDate()));
        // 查询当前实例的时间
        System.out.println(now.query(TemporalQueries.localTime()));
        // 查询当前实例的年（此处只为举例，实际这样使用是多此一举）
        System.out.println((Integer) now.query(temporal -> temporal.get(ChronoField.YEAR)));
    }

    @Test
    public void testAdjustInto() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前日期时间：" + now);

        LocalDateTime firstDayOfMonth = now.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("本月第一天：" + firstDayOfMonth);

        // 将firstDayOfMonth调整为now的日期、时间
        System.out.println("调整为now：" + now.adjustInto(firstDayOfMonth));
        // 可以看出，原firstDayOfMonth并没有变化，说明adjustInto方法是返回一个新实例，而并不是在原实例上修改。
        System.out.println(now);
        System.out.println(firstDayOfMonth);

        // adjustInto方法与with方法类似，但调用顺序相反。相较之下，更推荐使用with方法
        System.out.println(now.adjustInto(firstDayOfMonth).equals(firstDayOfMonth.with(now)));
        System.out.println(now.adjustInto(firstDayOfMonth).equals(now.with(firstDayOfMonth)));
    }

    @Test
    public void testUntil() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime firstDayOfMonth = now.with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime firstDayOfNextMonth = now.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("当前时间距离本月1号的天数：" + now.until(firstDayOfMonth, ChronoUnit.DAYS));
        System.out.println("当前时间距离本月1号的小时数：" + now.until(firstDayOfMonth, ChronoUnit.HOURS));
        System.out.println("当前时间距离下月1号的天数：" + now.until(firstDayOfNextMonth, ChronoUnit.DAYS));
        System.out.println("当前时间距离下月1号的小时数：" + now.until(firstDayOfNextMonth, ChronoUnit.HOURS));
    }

    @Test
    public void testFormat() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.format(DateTimeFormatter.ISO_DATE));
        System.out.println(now.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        // 自定义格式
        DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(DateTimeFormatter.ISO_LOCAL_DATE)
                .appendLiteral(" ")
                .append(DateTimeFormatter.ISO_LOCAL_TIME)
                .toFormatter();
        System.out.println(now.format(dateTimeFormatter));
    }

    @Test
    public void testAtOffset() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.atOffset(ZoneOffset.UTC));
        System.out.println(now.atOffset(ZoneOffset.ofHours(5)));
    }

    @Test
    public void testAtZone() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.atZone(ZoneId.of(ZoneId.SHORT_IDS.get("CTT"))));
        System.out.println(now.atZone(ZoneId.of(ZoneId.SHORT_IDS.get("ECT"))));
    }

    @Test
    public void testCompareTo() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        // 日期不同，底层调用的是LocalDate的compare方法，会按照年、月、日的顺序进行判断，一旦差值不为0则返回当前计算出的差值
        LocalDateTime firstDayOfMonth = now.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(now.compareTo(firstDayOfMonth));
        System.out.println(firstDayOfMonth.compareTo(firstDayOfMonth));
        System.out.println(firstDayOfMonth.compareTo(now));

        // 日期相同、时间不同，日期相同时会继续比较时间，调用LocalTime的compare方法，会按照时、分、秒的顺序进行判断，但是此处与
        // LocalDate的compare方法略有出入，其不会返回具体的差值，而是“小于”返回-1、“等于”返回0，“大于”返回1
        LocalDateTime fiveMinutesAgo = now.minusMinutes(5);
        System.out.println(now.compareTo(fiveMinutesAgo));
        System.out.println(fiveMinutesAgo.compareTo(now));
    }

    @Test
    public void testIsAfter() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime firstDayOfMonth = now.with(TemporalAdjusters.firstDayOfMonth());

        System.out.println(now.isAfter(firstDayOfMonth));
        System.out.println(firstDayOfMonth.isAfter(firstDayOfMonth));
        System.out.println(firstDayOfMonth.isAfter(now));
    }

    @Test
    public void testIsBefore() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime firstDayOfMonth = now.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(now.isBefore(firstDayOfMonth));
        System.out.println(firstDayOfMonth.isBefore(firstDayOfMonth));
        System.out.println(firstDayOfMonth.isBefore(now));
    }

    @Test
    public void testIsEquals() {
        LocalDateTime now1 = LocalDateTime.now();
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now1.equals(now2));
        System.out.println(now1.isEqual(now2));
    }
}
