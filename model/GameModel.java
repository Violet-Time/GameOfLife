package model;

import javax.swing.text.AbstractDocument;
import javax.swing.text.Element;

public class GameModel extends AbstractDocument {
    protected GameModel(Content data) {
        super(data);
    }

    @Override
    public Element getDefaultRootElement() {
        return null;
    }

    @Override
    public Element getParagraphElement(int i) {
        return null;
    }
}
