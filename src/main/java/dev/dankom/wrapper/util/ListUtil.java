package dev.dankom.wrapper.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class ListUtil <T> {
    public List<T> toList(Set<T> in) {
        List<T> out = new ArrayList<>();
        for (T o : in) {
            out.add(o);
        }
        return out;
    }

    public <T> List<T> toList(Collection<T> in) {
        List<T> out = new ArrayList<>();
        for (T o : in) {
            out.add(o);
        }
        return out;
    }

    public List<T> toList(T[] in) {
        List<T> out = new ArrayList<>();
        for (T o : in) {
            out.add(o);
        }
        return out;
    }
}
