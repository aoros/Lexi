package visitor;

import glyph.Character;
import glyph.Column;
import glyph.Embellishment;
import glyph.Glyph;
import glyph.Rectangle;
import glyph.Row;

// Visitor(331).Visitor
public interface GlyphVisitor {

    void visit(Glyph e);

    void visit(Character e);

    void visit(Rectangle e);

    void visit(Row e);

    void visit(Column e);

    void visit(Embellishment e);
}
