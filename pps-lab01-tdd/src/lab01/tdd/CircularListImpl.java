package lab01.tdd;

import lab01.tdd.CircularList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class CircularListImpl implements CircularList {
    private final List<Integer> list = new ArrayList<>();
    private int index = 0;
    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    private Optional<Integer> getElementAtIndex(){
        return list.isEmpty() ? Optional.empty() : Optional.of(list.get(index));
    }

    @Override
    public Optional<Integer> next() {
        Optional<Integer> next = getElementAtIndex();
        index = list.isEmpty() ? 0 : (index+1) % list.size();
        return next;
    }

    @Override
    public Optional<Integer> previous() {
        index = list.isEmpty() ? 0 : index-1 < 0 ? list.size()-1 : index-1;
        return getElementAtIndex();
    }

    @Override
    public void reset() {
        index = 0;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        for(int i = 0; i < list.size(); i++){
            Optional<Integer> next = next();
            if(next.isPresent() && strategy.apply(next.get())){
                return next;
            }
        }
        return Optional.empty();
    }
}
