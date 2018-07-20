package br.com.jonathaspacifico.starwarsapi.domain;

/**
 *
 * @author Jonathas
 * @param <T>
 */
public class SwapiResult<T> {

    private int count;
    private String next;
    private String previous;
    protected T[] results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }
}
