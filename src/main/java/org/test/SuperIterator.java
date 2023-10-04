package org.test;

import java.util.*;

/**
 * Класс, который принимает на вход список итераторов и позволяет получать из них элементы в порядке возрастания
 */
public class SuperIterator implements Iterator<Integer> {

    private final List<Integer> iteratorList;
    private int position;

    public SuperIterator(Iterator<Integer>[] iterators) {
        iteratorList = new ArrayList<>();
        Arrays.stream(iterators)
                .filter(Objects::nonNull)
                .forEach(x -> x.forEachRemaining(iteratorList::add));
        Collections.sort(iteratorList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasNext() {
        return position < iteratorList.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer next() {
        return iteratorList.get(position++);
    }
}
