package caching;

import com.medium.caching.Demo;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class MapCachingTest {

    @Test
    public void testHashMapGarbageCollector() {
        Map<Demo, String> map = new HashMap<>();

        Demo key = new Demo("Dummy data");
        map.put(key, "Value Example");

        key = null;
        System.gc();

        assertThat(map.size()).isEqualTo(1);

    }


    /**
     * @throws InterruptedException
     *
     * This class is intended primarily for use with key objects whose equals methods test for object identity using
     * the == operator. Once such a key is discarded it can never be recreated, so it is impossible to do a lookup of
     * that key in a WeakHashMap at some later time and be surprised that its entry has been removed. This class will
     * work perfectly well with key objects whose equals methods are not based upon object identity, such as String
     * instances. With such recreatable key objects, however, the automatic removal of WeakHashMap entries whose keys
     * have been discarded may prove to be confusing.
     *
     *
     */
    @Test
    public void testWeekHashMapGarbageCollector() throws InterruptedException {
        Map<Demo, String> map = new WeakHashMap<>();

        Demo key = new Demo("Dummy data");
        map.put(key, "Value Example");

        key = null;
        System.gc();

        assertThat(map.toString()).isEqualTo("{}");
    }

}

