package dsekercioglu.mega.rMove.movetree.nodes.modify.condition;

import dsekercioglu.mega.core.GuessFactor;
import dsekercioglu.mega.rMove.info.WaveData;
import dsekercioglu.mega.rMove.movetree.nodes.Node;

import java.util.ArrayList;
import java.util.List;

public class ConditionalOutNode extends Node {


    private final Node NODE;
    private final double LOWER_THRESHOLD;
    private final double UPPER_THRESHOLD;

    public ConditionalOutNode(Node node, double lowerThreshold, double upperThreshold) {
        NODE = node;
        LOWER_THRESHOLD = lowerThreshold;
        UPPER_THRESHOLD = upperThreshold;
    }

    @Override
    public List<GuessFactor> getGuessFactors(WaveData battleInfo) {
        if (battleInfo.getEnemyWeightedHitrate() >= LOWER_THRESHOLD && battleInfo.getEnemyWeightedHitrate() <= UPPER_THRESHOLD) {
            return NODE.getGuessFactors(battleInfo);
        }
        List<GuessFactor> empty = new ArrayList<>();
        return empty;
    }

    @Override
    public void addData(WaveData battleInfo, GuessFactor guessFactor, boolean real) {
        NODE.addData(battleInfo, guessFactor, real);
    }

    @Override
    public String toString() {
        return getName() + ":(" + NODE.toString() + ")";
    }

}
