package command;

public class InsertCharacterCommand implements Command {

    @Override
    public void execute() {
    }

    @Override
    public void unexecute() {
    }

    @Override
    public Command clone() {
        Command copy = null;
        try {
            copy = (InsertCharacterCommand) super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return copy;
    }

}
