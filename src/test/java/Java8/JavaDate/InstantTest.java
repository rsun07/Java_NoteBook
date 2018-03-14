package Java8.JavaDate;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class InstantTest {
    // Instant : Unix Time (or POSIX time or epoch time).
    // a system for describing a point in time,
    // Universal Time (UTC), Thursday, 1 January 1970,
    // minus the number of leap seconds that have taken place since then.

    @Test
    public void testInstantBasic() {
        // UTC time
        Instant instant = Instant.now();
        System.out.println(instant);

        System.out.println(instant.getEpochSecond());

        // 1970-01-01T00:00:01Z
        System.out.println(Instant.ofEpochSecond(1));

    }

    @Test
    public void testOffset() {
        OffsetDateTime time = Instant.now().atOffset(ZoneOffset.ofHours(8));
        System.out.println(time);
    }

    @Test
    public void testDuration() {
        Instant epochTime = Instant.ofEpochSecond(0);
        Instant now = Instant.now();

        Duration duration = Duration.between(epochTime, now);
        System.out.println(duration);
        System.out.println(duration.toDays());
    }
}
