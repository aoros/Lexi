package visitor;

import glyph.Character;
import glyph.Column;
import glyph.Embellishment;
import glyph.Glyph;
import glyph.Rectangle;
import glyph.Row;
import java.util.ArrayList;
import java.util.List;

// Visitor(331).ConcreteVisitor
public class WordsVisitor implements GlyphVisitor {

    List<String> words = new ArrayList<>();
    String currentWord = "";

    @Override
    public void visit(Glyph e) {
        if (!"".equals(currentWord)) {
            words.add(currentWord);
            currentWord = "";
        }
    }

    @Override
    public void visit(Character e) {
        if (isTerminatingChar(e.getChar())) {
            words.add(currentWord);
            currentWord = "";
        } else {
            currentWord += e.getChar();
        }
    }

    @Override
    public void visit(Rectangle e) {
        if (!"".equals(currentWord)) {
            words.add(currentWord);
            currentWord = "";
        }
    }

    @Override
    public void visit(Row e) {
        if (!"".equals(currentWord)) {
            words.add(currentWord);
            currentWord = "";
        }
    }

    @Override
    public void visit(Column e) {
        if (!"".equals(currentWord)) {
            words.add(currentWord);
            currentWord = "";
        }
    }

    @Override
    public void visit(Embellishment e) {
        if (!"".equals(currentWord)) {
            words.add(currentWord);
            currentWord = "";
        }
    }

    @Override
    public String toString() {
        if (!"".equals(currentWord)) {
            words.add(currentWord);
            currentWord = "";
        }
        return words.toString();
    }

    private boolean isTerminatingChar(char c) {
        switch (c) {
            case ' ':
                return true;
            case '.':
                return true;
            case '!':
                return true;
            case '?':
                return true;
            case ',':
                return true;
            default:
                return false;
        }
    }
}
