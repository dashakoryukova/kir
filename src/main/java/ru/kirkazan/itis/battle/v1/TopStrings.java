package ru.kirkazan.itis.battle.v1;

import java.util.*;

/**
 * @author ser
 * @since 07.05.14 15:24
 */
public class TopStrings {


    public static Set<String> getTop10(final Iterator<String> strings) {

        final HashMap<String, Integer> unsortedmap = new HashMap<String, Integer>();
        String str;
        int val;
        while (strings.hasNext()) {
            if (!unsortedmap.containsKey(str = strings.next())) {
                unsortedmap.put(str, 1);
            } else {
                val = unsortedmap.get(str);
                unsortedmap.remove(str);
                unsortedmap.put(str, val + 1);
            }
        }
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (unsortedmap.get(o1) < unsortedmap.get(o2))
                    return 1;
                else
                    return -1;
            }
        };
        SortedMap<String, Integer> sortedmap = new TreeMap<String, Integer>(c);
        str = "";
        Set<String> myset = unsortedmap.keySet();
        Iterator it = myset.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            sortedmap.put(str, unsortedmap.get(str));
            if (sortedmap.size() > 10) {
                sortedmap.remove(sortedmap.lastKey());
            }
        }
        return sortedmap.keySet();

    }


}
