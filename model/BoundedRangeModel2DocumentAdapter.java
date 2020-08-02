package model;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.text.Format;

public class BoundedRangeModel2DocumentAdapter {

    private ChangeListenerAdapter changeListenerAdapter = new ChangeListenerAdapter();

    private Format format;
    private Document document;
    private BoundedRangeModel boundedRangeModel;

    public BoundedRangeModel2DocumentAdapter(Document document, Format format) {
        this.document = document;
        this.format = format;
    }

    public void bind(BoundedRangeModel boundedRangeModel) {
        if (this.boundedRangeModel != null) {
            this.boundedRangeModel.removeChangeListener(changeListenerAdapter);
        }
        this.boundedRangeModel = boundedRangeModel;
        if (boundedRangeModel != null) {
            boundedRangeModel.addChangeListener(changeListenerAdapter);
            ChangeEvent modelChangedEvent = new ChangeEvent(boundedRangeModel);
            changeListenerAdapter.stateChanged(modelChangedEvent);
        }
    }

    public void unbind() {
        bind(null);
    }

    private class ChangeListenerAdapter implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            BoundedRangeModel boundedRangeModel = (BoundedRangeModel) e
                    .getSource();
            Object[] formatArgs = new Object[] { boundedRangeModel.getValue() };
            String text = format.format(formatArgs);
            try {
                document.remove(0, document.getLength());
                document.insertString(0, text, null);
            } catch (BadLocationException e1) {
            }
        }

    }
}
