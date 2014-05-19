package ru.kirkazan.itis.battle.v1;

import org.junit.Assert;
import org.junit.Test;
import ru.kirkazan.itis.battle.v1.TopStrings;

import java.util.*;

/**
 * @author ser
 * @since 07.05.14 15:24
 */
public class TopStringsTest {


    @Test
    public void testOutput() {
        Iterator<String> input = Arrays.asList(
                "a", "b", "c", "a", "b", "c", "d", "e", "f", "a", "b", "c", "a", "b", "c", "d", "e", "f",
                "a", "b", "c", "a", "b", "c", "d", "e", "f", "a", "b", "c", "a", "b", "c", "d", "e", "f",
                "g", "j", "k", "h", "k", "m", "m", "m", "m", "g", "j", "k", "h", "k", "l", "m", "n", "o",
                "a", "b", "c", "a", "b", "c", "d", "e", "f", "a", "b", "c", "a", "b", "c", "d", "e", "f",
                "a", "b", "c", "a", "b", "c", "d", "e", "f", "a", "b", "c", "a", "b", "c", "d", "e", "f",
                "g", "j", "k", "h", "k", "l", "m", "n", "o", "g", "j", "k", "h", "k", "l", "m", "n", "o",
                "a", "b", "c", "a", "b", "c", "d", "e", "f", "a", "b", "c", "a", "b", "c", "d", "e", "f",
                "a", "b", "c", "a", "b", "c", "d", "e", "f", "a", "b", "c", "a", "b", "c", "d", "e", "f",
                "g", "j", "k", "h", "k", "l", "m", "n", "o", "j", "j", "k", "h", "k", "l", "m", "n", "o",
                "p", "q", "r", "s", "t", "u", "w", "v", "x", "y", "z"
        ).iterator();

        Set<String> expected = new HashSet<>(Arrays.asList("a","b","c","k","e","d","f","h","j","m"));

        Set<String> actual = TopStrings.getTop10(input);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSmallInput() {
        Iterator<String> input = Arrays.asList(
                "a", "b", "c", "a", "b", "c", "d", "e", "f", "a", "b", "c", "a", "b", "c", "d", "e", "f"
            ).iterator();

        Set<String> expected = new HashSet<>(Arrays.asList("a","b","c","e","d","f"));

        Set<String> actual = TopStrings.getTop10(input);
        Assert.assertEquals(expected, actual);

    }

}
