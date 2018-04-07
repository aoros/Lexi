package command;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {

    private static CommandHistory instance;
    private static final List<Command> commands = new ArrayList<>();
    private static int cmdIndex;

    private CommandHistory() {
        cmdIndex = 0;
    }

    public static CommandHistory getInstance() {
        return instance != null ? new CommandHistory() : instance;
    }

    public void execute() {
        if (!commands.isEmpty()) {
            Command c = commands.get(cmdIndex);
            c.execute();
            cmdIndex++;
            commands.add(cmdIndex, c.clone());
        }
    }

    public void undo() {
        if (!commands.isEmpty()) {
            Command c = commands.get(cmdIndex);
            c.unexecute();
            cmdIndex--;
        }
    }
}
