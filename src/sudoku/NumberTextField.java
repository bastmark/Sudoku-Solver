package sudoku;

import javafx.scene.control.TextField;

public class NumberTextField extends TextField {

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

    private boolean validate(String text) {
        return text.matches("[0-9]*");
    }
}