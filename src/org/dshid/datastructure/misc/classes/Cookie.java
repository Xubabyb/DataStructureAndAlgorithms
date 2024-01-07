package org.dshid.datastructure.misc.classes;

import java.util.Objects;

public class Cookie implements Comparable<Cookie> {
    private final static String DEFAULT = "default";
    private String color;

    public Cookie(String color) {
        this.setColor(color);
    }

    public String getColor() {
        return color == null ? DEFAULT : color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cookie cookie = (Cookie) o;
        return Objects.equals(color, cookie.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return "Cookie{" + "color='" + color + '\'' + '}';
    }

    @Override
    public int compareTo(Cookie o) {
        return this.color.compareTo(o.color);
    }
}
