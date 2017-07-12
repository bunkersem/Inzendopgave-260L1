package main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Created by Sem on 09-Jul-17.
 */
public class Core {
    public static <T> ArrayList<T> where(final ArrayList<T> items, final Predicate<T> test) {
        ArrayList<T> result = new ArrayList<>();
        for (T item :
        items) {
            if (test.test(item))
                result.add(item);
        }
        return result;
    }

    public static <T> T first(final ArrayList<T> items, final Predicate<T> test) {
        T t;
        for (T item :
                items) {
            if (test.test(item))
                return item;
        }
        return null;
    }

}