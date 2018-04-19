package iterator;

// Iterator(257).Iterator
public abstract class Iterator<T> {

    public abstract void first();

    public abstract void next();

    public abstract boolean isDone();

    public abstract T currentItem();
}
