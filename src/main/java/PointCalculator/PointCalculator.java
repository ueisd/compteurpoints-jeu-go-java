package PointCalculator;

import Board.Board;
import Board.Intersection;
import Player.Color;
import PointCalculator.Fetcher.EncircledAreaValidator.TakableValidator;
import PointCalculator.Fetcher.EncircledAreaValidator.TakableValidatorNaive;
import PointCalculator.PlayersStats.PlayersScoreStats;
import PointCalculator.visitor.EncircledAreaVisitor;
import PointCalculator.visitor.PointCalculatorVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PointCalculator {

    private Board b;
    List<EncircledArea> rootsAreas;
    List<EncircledArea> calculatedRoorAreas = new ArrayList<EncircledArea>();
    private EncircledAreaVisitor pointCalculatorVisitor;
    private TakableValidator takableRootValidator;
    private PlayersScoreStats playersScoreStats = new PlayersScoreStats();

    public PointCalculator(Board b,
                           List<EncircledArea> rootsAreas,
                           TakableValidator takableRootValidator,
                           TakableValidator takableChildValidator
    ) {
        this.b = b;
        this.rootsAreas = rootsAreas;
        this.takableRootValidator = takableRootValidator;
        this.pointCalculatorVisitor = new PointCalculatorVisitor(takableChildValidator, playersScoreStats);
    }

    public PlayersScoreStats calculatePlayersScore() {
        addChildZonePointsToPlayersPoints(rootsAreas);

        List<Intersection> noMansIntersectionCloud = getIntersectionsCloudNotPossesedByEncircling();
        int nbCaseNoires   = countColorInIntersectionList(Color.Black, noMansIntersectionCloud);
        int nbCaseBlanches = countColorInIntersectionList(Color.White, noMansIntersectionCloud);
        playersScoreStats.addPlayerPoints(Color.Black, nbCaseNoires);
        playersScoreStats.addPlayerPoints(Color.White, nbCaseBlanches);
        return this.playersScoreStats;
    }

    private int countColorInIntersectionList(Color color, List<Intersection> list) {
        return (int) list.stream().filter(intersection -> {
            Optional<Color> optPlayerColor = intersection.getOccupation();
            if(!optPlayerColor.isPresent()) return false;
            return optPlayerColor.get() == color;
        }).count();
    }

    private List<Intersection> getIntersectionsCloudNotPossesedByEncircling() {
        List<Intersection> notOwnedArea = b.getAllIntersections();
        for(EncircledArea area : calculatedRoorAreas) {
            notOwnedArea.removeAll(area.getFullBorder());
            notOwnedArea.removeAll(area.getFullContent());
        }
        return notOwnedArea;
    }

    private void addChildZonePointsToPlayersPoints(List<EncircledArea> rootsAreas) {
        for(EncircledArea area: rootsAreas) {
            if(!takableRootValidator.isValid(area)) {
                pointCalculatorVisitor.visit(area);
                calculatedRoorAreas.add(area);
            }
        }
    }

}