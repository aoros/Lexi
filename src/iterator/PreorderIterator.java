package iterator;

import glyph.Glyph;
import java.util.Stack;

public class PreorderIterator extends Iterator {

    Glyph _glyph;
    Stack<Iterator> _stack;

    public PreorderIterator(Glyph glyph) {
        this._stack = new Stack<>();
        this._glyph = glyph;
    }

    @Override
    public void first() {
        _stack.add(_glyph.createIterator());
    }

    @Override
    public void next() {
        Iterator iter = _stack.peek().currentItem().createIterator();
        iter.first();
        _stack.push(iter);

        while (!_stack.isEmpty() && iter.isDone()) {
            _stack.pop();
            if (!_stack.isEmpty() && !_stack.peek().isDone()) {
                _stack.peek().next();
                if (!_stack.peek().isDone())
                    break;
            }
        }
    }

    @Override
    public boolean isDone() {
        return _stack.isEmpty();
    }

    @Override
    public Glyph currentItem() {
        return _stack.peek().currentItem();
    }

}
