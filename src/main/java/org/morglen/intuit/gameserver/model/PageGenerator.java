package org.morglen.intuit.gameserver.model;


import java.io.IOException;
import java.util.Objects;

/**
 * Created by SEkaterina on 05.10.2016.
 */
public class PageGenerator implements Appendable, CharSequence {

    private StringBuilder builder;
    static final Integer DEFAULTSIZE = 16;

    public PageGenerator() {
        this(DEFAULTSIZE);
    }

    public PageGenerator(Integer size) {
        setBuilder(new StringBuilder(size));
    }


    public StringBuilder getBuilder() {
        return builder;
    }

    protected void setBuilder(StringBuilder builder) {
        this.builder = builder;
    }

    public Appendable append(CharSequence csq) throws IOException {
        builder.append(csq);
        return this;
    }

    public Appendable append(CharSequence csq, int start, int end) throws IOException {
        builder.append(csq, start, end);
        return this;
    }

    public Appendable append(char c) throws IOException {
        builder.append(c);
        return this;
    }


    public int length() {
        return builder.length();
    }

    public char charAt(int index) {
        return builder.charAt(index);
    }

    public CharSequence subSequence(int start, int end) {
        return builder.subSequence(start, end);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o.getClass() != PageGenerator.class)) return false;
        PageGenerator that = (PageGenerator) o;
        return Objects.equals(getBuilder(), that.getBuilder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBuilder());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" +
                "builder=" + builder +
                ']';
    }
}
