package ru.kirkazan.itis.battle.v1;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import ru.kirkazan.itis.battle.v1.TopStrings;

import java.util.*;

/**
 * @author ser
 * @since 07.05.14 15:24
 */
public class TopStringsBenchmark {

    @Rule
    public TestRule benchmarkRun = new BenchmarkRule();

    private static  List<String> words = new LinkedList<>();

    @BeforeClass
    public static void prepare() {
        Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("text.txt"));
        while (scanner.hasNext())
            words.add(scanner.next());
    }

    @Test
    @BenchmarkOptions(warmupRounds = 10, benchmarkRounds = 1000, concurrency = 16)
    public void testBigInput() {
        TopStrings.getTop10(words.iterator());
    }

}
