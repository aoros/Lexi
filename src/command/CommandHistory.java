package command;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {

    private static CommandHistory instance;
    private static final List<Command> commands = new ArrayList<>();
    // index is the position where the next command will be placed
    private static int cmdIndex;

    private CommandHistory() {
        cmdIndex = 0;
    }

    public static CommandHistory getInstance() {
        if (instance == null) {
            instance = new CommandHistory();
        }
        return instance;
    }

    public void add(Command command) {
        commands.add(cmdIndex, command.clone());
        cmdIndex++;
        
        removeAnyCommandsAfterIndex();
    }

    public Command getCommandForUndo() {
        if (cmdIndex > 0) {
            cmdIndex--;
            Command c = commands.get(cmdIndex);
            return c;
        }
        return null;
    }

    public Command getCommandForRedo() {
        if (cmdIndex < commands.size()) {
            Command c = commands.get(cmdIndex);
            return c;
        }
        return null;
    }

    private void removeAnyCommandsAfterIndex() {
        while (cmdIndex < commands.size()) {
            commands.remove(cmdIndex);
        }
    }

    @Override
    public String toString() {
        return "CommandHistory{ i="+ cmdIndex + "  " + commands + '}';
    }
}
