//Decorator(175).ConcreteDecoratorA
package glyph;

import compositor.Cursor;
import window.Window;

public class Border extends Embellishment
{

	private int padding = 5;
	private int maxHeight;
	private int maxWidth;

	public Border(Glyph glyph)
	{
		super(glyph);
	}

	public Border(Glyph glyph, int padding)
	{
		super(glyph);
		this.padding = padding;
	}

	@Override
	public void setSize(Window window)
	{
		super.setSize(window);
		super.getBounds().setWidth(getGlyph().getBounds().getWidth() + padding * 2);
		super.getBounds().setHeight(getGlyph().getBounds().getHeight() + padding * 2);
		shiftGlyphAndAllChildren(getGlyph());
	}

	@Override
	public void setPosition(Cursor cursor)
	{
		super.setPosition(cursor);
	}

	@Override
	public void draw(Window window)
	{
		super.draw(window);
		int x1 = super.getBounds().getX();
		int y1 = super.getBounds().getY();
		int x2 = super.getBounds().getX() + super.getBounds().getWidth();
		int y2 = super.getBounds().getY() + super.getBounds().getHeight();

		window.addBorder(x1, y1, x2, y2, padding);
	}

	private boolean areGlyphsInColumn(Cursor cursor)
	{
		return super.getBounds().getX() == cursor.getX();
	}

	private void shiftGlyphAndAllChildren(Glyph glyph)
	{
		glyph.getBounds().setX(glyph.getBounds().getX() + padding);
		glyph.getBounds().setY(glyph.getBounds().getY() + padding);
		int i = 0;
		while (true)
		{
			try
			{
				Glyph child = glyph.getChild(i);
				child.getBounds().setX(child.getBounds().getX() + padding);
				child.getBounds().setY(child.getBounds().getY() + padding);
				i++;
			}
			catch (Exception ex)
			{
				break;
			}
		}
	}
}
