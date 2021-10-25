package datastructure.stack;
/*
We aim to implement rudimentary undo & redo.

        You will be provided a set of actions to perform. Once all actions are performed you will return the current state the system should be in after all actions in actions are performed.

        We will be operating on characters and the "state" of the system will be a string that we are building.

        These are the actions possible:
        INSERT: Inserts a single character to the end of the string
        DELETE: Removes the last character in the string
        UNDO: Reverses the most recent action
        REDO: Redoes the most recent action undone

Your inputs will only be single characters. There are only 4 input actions as enumerated above.

        Example 1:
        Input:
        INSERT 'a'
        INSERT 'b'

        Output: "ab"*/

import java.util.Stack;

class UndoRedoEditor {

    public String performEditorActions(String[][] actions) {

        //Creating a string builder as datastructure.strings are immutable in java
        StringBuilder sb = new StringBuilder();

        Stack<Action> undo = new Stack<>(); // Track the most recent actions that we want to undo
        Stack<Action> redo = new Stack<>();

        //Iterate through all the actions
        for (String[] a : actions) {
            switch (a[0]) {
                //Clear the redo stack in case of insert and delete
                case "INSERT":
                    performInsertChar(a[1].charAt(0), undo, sb);
                    redo.clear();

                    break;

                case "DELETE":
                    performDeleteChar(undo, sb);
                    redo.clear();

                    break;
                //Case of undo
                //Perform it on top action of undo stack and pop the stack
                case "UNDO":
                    if (undo.size() != 0) {
                        Action undoAction = undo.pop();

                        if (undoAction.type == ActionType.INSERT) {
                            performInsertChar(undoAction.character, redo, sb);
                        } else if (undoAction.type == ActionType.DELETE) {
                            performDeleteChar(redo, sb);
                        }
                    }

                    break;

                //Case of redo
                //Perform it on top action of Redo Stack and pop the stack
                case "REDO":
                    if (redo.size() != 0) {
                        Action redoAction = redo.pop();

                        if (redoAction.type == ActionType.INSERT) {
                            performInsertChar(redoAction.character, undo, sb);
                        } else if (redoAction.type == ActionType.DELETE) {
                            performDeleteChar(undo, sb);
                        }
                    }

                    break;
            }
        }

        return sb.toString();
    }

    //Function to perform Insert char on the string builder
    private void performInsertChar(Character c, Stack<Action> destinationStack, StringBuilder sb) {
        sb.append(c);

        Action oppositeAction = new Action(ActionType.DELETE);
        destinationStack.push(oppositeAction);
    }

    //Perform Delete char on the string builder
    private void performDeleteChar(Stack<Action> destinationStack, StringBuilder sb) {
        int indexToRemove = sb.length() - 1;
        if (indexToRemove != -1) {
            char character = sb.charAt(indexToRemove);

            sb.deleteCharAt(indexToRemove);

            Action oppositeAction = new Action(character, ActionType.INSERT);
            destinationStack.push(oppositeAction);
        }
    }

    //Class Action for defining Action type and char
    private class Action {
        Character character;
        ActionType type;

        public Action(Character character, ActionType type) {
            this.character = character;
            this.type = type;
        }

        public Action(ActionType type) {
            this(null, type);
        }
    }

    //enum is an abstract data type
    private enum ActionType {
        INSERT, // Insert the character
        DELETE, // Delete the most recently added character
        UNDO, // Undo the most recent action
        REDO // Redo the most recent undo
    }
}