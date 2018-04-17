package iterator;

import java.util.Stack;

public class PreorderIterator<T extends IsIterable> extends Iterator<T> {

    T _t;
    Stack<Iterator> _stack;

    public PreorderIterator(T t) {
        this._stack = new Stack<>();
        this._t = t;
    }

    @Override
    public void first() {
        _stack.add(_t.createIterator());
    }

    @Override
    public void next() {
        Iterator iter = ((T) _stack.peek().currentItem()).createIterator();
        iter.first();
        _stack.push(iter);

        while (!_stack.isEmpty() && iter.isDone()) {
            _stack.pop();
            if (!_stack.isEmpty() && !_stack.peek().isDone()) {
                _stack.peek().next();
                if (!_stack.peek().isDone()) {
                    break;
                }
            }
        }
    }

    @Override
    public boolean isDone() {
        return _stack.isEmpty();
    }

    @Override
    public T currentItem() {
        return (T) _stack.peek().currentItem();
    }

}
