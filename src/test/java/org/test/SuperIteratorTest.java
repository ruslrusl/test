package org.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Класс для тестирования {@link SuperIterator}
 */
public class SuperIteratorTest {
    @Test
    public void test() {
        // подготовка
        List<Integer> l1 = Arrays.asList(1, 3, 4, 4, 7);
        List<Integer> l2 = Arrays.asList(1, 2, 5, 6, 8);
        List<Integer> l3 = Arrays.asList(1, 4, 9, 10);
        List<Integer> l4 = Collections.emptyList();
        // создание итератора
        SuperIterator si = new SuperIterator(new Iterator[]{l1.iterator(), l2.iterator(), l3.iterator(), null,
                l4.iterator()});
        // проверка
        List<Integer> result = new ArrayList<>();
        while (si.hasNext()) {
            result.add(si.next());
        }
        Assert.assertEquals(Arrays.asList(1, 1, 1, 2, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10), result);
    }
}