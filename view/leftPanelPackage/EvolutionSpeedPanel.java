package view.leftPanelPackage;

import model.BoundedRangeModel2DocumentAdapter;
import view.JLabelTextComponent;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.Document;
import java.awt.*;
import java.text.MessageFormat;

public class EvolutionSpeedPanel extends JPanel {
    private static final int MIN_LOAD_SPEED_TICK_MS = 250;
    private static final int MAX_LOAD_SPEED_MS = 5000;
    private static final int INITIAL_LOAD_SPEED_MS = 1000;

    private BoundedRangeModel evolutionSpeedModel = new DefaultBoundedRangeModel();
    private static final String SIMULATION_SPEED_FORMAT = "{0} mc";

    JSlider slider = new JSlider();

    public EvolutionSpeedPanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setBorder(BorderFactory.createEmptyBorder(10,0,10,0));

        evolutionSpeedModel.setMinimum(MIN_LOAD_SPEED_TICK_MS);
        evolutionSpeedModel.setMaximum(MAX_LOAD_SPEED_MS);
        evolutionSpeedModel.setValue(INITIAL_LOAD_SPEED_MS);
        evolutionSpeedModel.setExtent(0);

        slider.setMinorTickSpacing(MIN_LOAD_SPEED_TICK_MS);
        slider.setSnapToTicks(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setModel(evolutionSpeedModel);

        add(slider);

        JLabelTextComponent selectedLoadSpeed = new JLabelTextComponent();
        selectedLoadSpeed.setFont(new Font("Tahoma", Font.PLAIN, 12));
        MessageFormat speedLabelFormat = new MessageFormat(SIMULATION_SPEED_FORMAT);
        Document loadSpeedDocument = selectedLoadSpeed.getDocument();
        BoundedRangeModel2DocumentAdapter boundedRangeAdapter = new BoundedRangeModel2DocumentAdapter(
                loadSpeedDocument, speedLabelFormat);
        boundedRangeAdapter.bind(evolutionSpeedModel);

        add(selectedLoadSpeed);

        /*slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                selectedLoadSpeed.setText(messageFormat​.format(new Object[]{evolutionSpeedModel.getValue()}));
            }
        });*/

    }

    public BoundedRangeModel getEvolutionSpeedModel() {
        return evolutionSpeedModel;
    }
}
