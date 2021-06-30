package com.epam.task.fifth.entities;

import java.util.Objects;

public class Leaf implements Component {
    private final String value;
    private final LeafType type;

    public Leaf(String value, LeafType type) {
        this.value = value;
        this.type = type;
    }

    public static Leaf word(String value) {
        return new Leaf(value, LeafType.WORD);
    }

    public static Leaf expression(String value) {
        return new Leaf(value, LeafType.EXPRESSION);
    }

    public String getValue() {
        return value;
    }

    public LeafType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Leaf)) {
            return false;
        }

        Leaf leaf = (Leaf) o;

        if (!Objects.equals(value, leaf.value)) {
            return false;
        }
        return type == leaf.type;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
