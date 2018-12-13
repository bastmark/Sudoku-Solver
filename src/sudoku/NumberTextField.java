package sudoku;

import javafx.scene.control.TextField;

/**
 * NumberTextField class extending TextField class with more useful methods when dealing with single digits.
 *
 * @author Johannes Bastmark
 * @author Szymon Stypa
 * @author Axel Domell
 *
 * @version 1.0
 * @see <a href="https://github.com/bastmark/Sudoku-solver">Github repository</a>
 */
public class NumberTextField extends TextField {

    /**
     * Replaces NumberTextField.text with text.
     * @param start index
     * @param end index
     * @param text text
     */
    @Override
    public void replaceText(int start, int end, String text) {
        if (validate(text)) {
            super.replaceText(start, end, text);
            if (getText().length() > 1) {
                setText(getText().substring(0, 1));
                positionCaret(1);
            }
        }
    }

    /**
     * Replaces NumberTextField.selection with text.
     * @param text text
     */
    @Override
    public void replaceSelection(String text) {
        if (validate(text)) {
            super.replaceSelection(text);
            if (getText().length() > 1) {
                setText(getText().substring(0, 1));
                positionCaret(1);
            }
        }
    }

    /**
     * Returns boolean. True if and only if text is a number from 0-9.
     * @param text text
     * @return boolean validate
     */
    private boolean validate(String text) {
        return text.matches("[0-9]*");
    }
}