package command;

import java.util.ArrayList;
import java.util.List;

// Prototype(119).Client
public class CommandHistory {

    private static CommandHistory instance;
    private static final List<Command> commands = new ArrayList<>();
    // index is the position where the next command will be placed
    private static int cmdIndex;
    private boolean isRedoCommand = false;

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

        if (!isRedoCommand) {
            removeAnyCommandsAfterIndex();
        }
        isRedoCommand = false;
    }

    public Command getCommandForUndo() {
        if (cmdIndex > 0) {
            cmdIndex--;
            return commands.get(cmdIndex);
        }
        return null;
    }

    public Command getCommandForRedo() {
        if (cmdIndex < commands.size()) {
            isRedoCommand = true;
            return commands.remove(cmdIndex);
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
        return "CommandHistory{ i=" + cmdIndex + "  " + commands + '}';
    }
}
