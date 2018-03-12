package debug;

import glyph.Glyph;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DebugUtils {

    public static void printLexiTree(Glyph glyph) {
        printLexiTree(glyph, "");
    }

    public static void printLexiTree(Glyph glyph, String prepend) {
        Glyph root = glyph.getRoot();
        Queue<Glyph> queue = new LinkedList<>();
        queue.add(root);
        Map<Glyph, Integer> levelMap = new HashMap<>();

        int level = 0;
        levelMap.put(root, level);
        while (!queue.isEmpty()) {
            level++;
            Glyph g = queue.remove();
            Glyph child;
            try {
                for (int i = 0; (child = g.getChild(i)) != null; i++) {
                    queue.add(child);
                    levelMap.put(child, levelMap.get(g) + 1);
                }
            } catch (Exception ex) {
            }
            System.out.println(prepend + getSpaceString(levelMap.get(g)) + g.toString());
        }
        System.out.println("===================================================");
    }

    private static String getSpaceString(int level) {
        String spaces = "";
        for (int i = 0; i < level; i++) {
            spaces += " ";
        }
        return spaces;
    }

}
