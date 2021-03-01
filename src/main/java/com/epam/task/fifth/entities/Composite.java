package com.epam.task.fifth.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Composite implements Component {

    private final List<Component> components;

    public Composite() {
        this.components = new ArrayList<>();
    }

    public Composite(List<Component> components) {
        this.components = components;
    }

    public List<Component> getComponents() {
        return Collections.unmodifiableList(components);
    }

    public Component getChild(int index) {
        return components.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Composite)) {
            return false;
        }

        Composite composite = (Composite) o;

        return components.equals(composite.components);
    }

    @Override
    public int hashCode() {
        return components.hashCode();
    }
}
