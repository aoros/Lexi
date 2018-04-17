package iterator;

public abstract class Iterator<T> {

    public abstract void first();

    public abstract void next();

    public abstract boolean isDone();

    public abstract T currentItem();
}
