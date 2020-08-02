package view.leftPanelPackage;

import model.BoundedRangeModel2DocumentAdapter;
import view.JLabelTextComponent;

import javax.swing.*;
import java.awt.*;
import java.text.MessageFormat;

public class GameStatusPanel extends JPanel {

    JLabelTextComponent generationLabel = new JLabelTextComponent();
    JLabelTextComponent aliveLabel = new JLabelTextComponent();
    BoundedRangeModel generationLabelModel = new DefaultBoundedRangeModel();
    BoundedRangeModel aliveLabelModel = new DefaultBoundedRangeModel();
    private static final String GENERATION_FORMAT = "Generation # {0}";
    private static final String ALIVE_FORMAT = "Alive: {0}";

    public GameStatusPanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setBorder(BorderFactory.createEmptyBorder(10,10,10,0));

        generationLabel.setName("GenerationLabel");
        aliveLabel.setName("AliveLabel");

        BoundedRangeModel2DocumentAdapter boundedGenerationRangeAdapter = new BoundedRangeModel2DocumentAdapter(generationLabel.getDocument(), new MessageFormat(GENERATION_FORMAT));
        boundedGenerationRangeAdapter.bind(generationLabelModel);

        BoundedRangeModel2DocumentAdapter boundedAliveRangeAdapter = new BoundedRangeModel2DocumentAdapter(aliveLabel.getDocument(), new MessageFormat(ALIVE_FORMAT));
        boundedAliveRangeAdapter.bind(aliveLabelModel);

        add(generationLabel);
        add(aliveLabel);
    }

    public BoundedRangeModel getAliveLabelModel() {
        return aliveLabelModel;
    }

    public BoundedRangeModel getGenerationLabelModel() {
        return generationLabelModel;
    }
}
