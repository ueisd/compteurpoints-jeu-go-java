package PointCalculator;

import Board.Board;
import Board.Builder.BoardBuilder;
import Board.Builder.BoardBuilderFromBoardRepresentation;
import PointCalculator.EncircledAreaValidator.RootValidator;
import PointCalculator.EncircledAreaValidator.TakableValidatorNaive;
import PointCalculator.Fetcher.StructuratedsRootOfEncircledAreaFetcher;
import PointCalculator.PlayersStats.PlayersScoreStats;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PointCalculatorTest {

    Board buildBoard(String representation, int size) {
        BoardBuilder builder = new BoardBuilderFromBoardRepresentation(representation, size);
        Optional<Board> optB = builder.build();
        assertTrue(optB.isPresent(), "attention erreure d'initialisetion du board");
        return optB.get();
    }

    private PointCalculator generatePointCalculatorFromBoard(Board b) {
        StructuratedsRootOfEncircledAreaFetcher structureFecther = new StructuratedsRootOfEncircledAreaFetcher(
                b, new RootValidator(b)
        );
        List<EncircledArea> rootElements = structureFecther.fetch();
        return new PointCalculator(b, rootElements, new TakableValidatorNaive(),
                new TakableValidatorNaive());
    }

    /* LÉGENDE
     *  1. Blanc:   ●
     *  2. Noir:    ○
     */

    @Test
    void calculateNaive_CasBasique1() {
        String representation =
                "+-○-○-○-○-○-+-+-+\n" +
                "+-○-●-●-●-○-+-●-+\n" +
                "+-○-●-+-●-○-+-+-+\n" +
                "+-○-●-●-●-○-+-●-+\n" +
                "+-○-○-○-○-○-+-+-+\n" +
                "+-+-+-+-+-+-+-●-+\n" +
                "+-●-●-●-●-●-+-+-+\n" +
                "+-●-○-○-○-●-+-○-+\n" +
                "+-●-○-+-○-●-+-+-+\n";
        Board b = buildBoard(representation, 9);
        PointCalculator pointCalculator = generatePointCalculatorFromBoard(b);
        PlayersScoreStats playersScore = pointCalculator.calculatePlayersScore();
        int whitePoints = playersScore.getWhitePoints();
        int blackPoints = playersScore.getBlackPoints();
        
        assertEquals(23, blackPoints, "Problème de décompte de points de noir");
        assertEquals(21, whitePoints, "Problème de décompte de points avec Blanc");
    }

    @Test
    void calculateNaive_CasBasique2() {
        String representation =
                "+-+-○-+-+-○-+-+-+\n" +
                "+-+-○-○-○-○-+-+-+\n" +
                "+-+-●-●-●-●-+-+-+\n" +
                "+-+-●-+-+-●-+-+-+\n" +
                "+-+-●-+-+-+-●-+-+\n" +
                "+-+-+-●-●-●-+-+-+\n" +
                "+-+-+-○-○-○-+-+-+\n" +
                "●-+-+-○-+-○-+-+-+\n" +
                "●-+-+-○-○-○-+-+-+\n";
        Board b = buildBoard(representation, 9);
        PointCalculator pointCalculator = generatePointCalculatorFromBoard(b);
        PlayersScoreStats playersScore = pointCalculator.calculatePlayersScore();
        int whitePoints = playersScore.getWhitePoints();
        int blackPoints = playersScore.getBlackPoints();
        assertEquals(17, blackPoints, "Problème de décompte de points de noir");
        assertEquals(18, whitePoints, "Problème de décompte de points avec Blanc");
    }

    @Test
    void calculateNaive_CasBasique3() {
        String representation =
                "+-+-○-+-+-○-+-+-+\n" +
                "+-+-○-○-○-○-+-+-+\n" +
                "+-+-●-●-●-●-+-+-+\n" +
                "+-+-●-○-○-●-+-+-+\n" +
                "+-+-●-+-+-+-●-+-+\n" +
                "+-+-+-●-●-●-+-+-+\n" +
                "+-+-+-○-○-○-+-+-+\n" +
                "●-+-+-○-+-○-+-+-+\n" +
                "●-+-+-○-○-○-+-+-+\n";
        Board b = buildBoard(representation, 9);
        PointCalculator pointCalculator = generatePointCalculatorFromBoard(b);
        PlayersScoreStats playersScore = pointCalculator.calculatePlayersScore();
        int whitePoints = playersScore.getWhitePoints();
        int blackPoints = playersScore.getBlackPoints();
        assertEquals(17, blackPoints, "Problème de décompte de points de noir");
        assertEquals(18, whitePoints, "Problème de décompte de points avec Blanc");
    }

    @Test
    void calculateNaive_CasBasique4() {
        String representation =
                "+-+-○-+-+-○-+-+-+\n" +
                "+-+-○-○-○-○-+-+-+\n" +
                "+-+-●-●-●-●-+-+-+\n" +
                "+-+-●-+-+-●-+-+-+\n" +
                "+-+-●-+-+-+-●-+-+\n" +
                "+-+-+-●-●-●-+-●-●\n" +
                "+-+-+-○-○-○-●-+-+\n" +
                "●-+-+-○-+-○-●-+-+\n" +
                "●-+-+-○-○-○-●-+-+\n";
        Board b = buildBoard(representation, 9);
        PointCalculator pointCalculator = generatePointCalculatorFromBoard(b);
        PlayersScoreStats playersScore = pointCalculator.calculatePlayersScore();
        int whitePoints = playersScore.getWhitePoints();
        int blackPoints = playersScore.getBlackPoints();
        assertEquals(17, blackPoints, "Problème de décompte de points de noir");
        assertEquals(12+18, whitePoints, "Problème de décompte de points avec Blanc");
    }


    @Test
    void calculateNaive_CasBasique5() {
        String representation =
                "+-+-○-+-+-○-+-+-+-+-+-+-+-+-+\n" +
                "+-+-○-○-○-○-+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-●-●-●-+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-+-+-●-+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-●-●-+-+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-●-●-●-●-+-+-+-+-+\n" +
                "+-+-●-●-●-●-+-+-+-+-●-+-+-+-+\n" +
                "+-+-●-○-○-○-●-●-●-+-●-+-+-+-+\n" +
                "+-+-●-○-+-○-●-+-●-+-●-+-+-+-+\n" +
                "+-+-●-○-○-○-●-●-●-+-●-+-+-+-+\n" +
                "+-+-●-+-+-+-+-+-+-+-●-+-+-+-+\n" +
                "+-+-●-●-●-●-●-●-●-●-●-+-+-+-+\n" +
                "+-+-●-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-+-+-+-+-+-+-+-+-+-+-+-+\n";
        Board b = buildBoard(representation, 15);
        PointCalculator pointCalculator = generatePointCalculatorFromBoard(b);
        PlayersScoreStats playersScore = pointCalculator.calculatePlayersScore();
        int whitePoints = playersScore.getWhitePoints();
        int blackPoints = playersScore.getBlackPoints();
        assertEquals(17, blackPoints, "Problème de décompte de points de noir");
        assertEquals(17+9+8+3+26, whitePoints, "Problème de décompte de points avec Blanc");
    }

    @Test
    void calculateNaive_CasBasique6() {
        String representation =
                "+-+-●-●-●-●-+-+-+\n" +
                "+-●-○-○-○-○-●-+-+\n" +
                "●-○-●-●-●-●-○-●-+\n" +
                "●-○-●-+-+-●-○-○-●\n" +
                "●-○-●-●-●-●-○-●-+\n" +
                "+-●-○-○-○-○-●-+-+\n" +
                "+-+-●-●-●-●-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n";
        Board b = buildBoard(representation, 9);
        PointCalculator pointCalculator = generatePointCalculatorFromBoard(b);
        PlayersScoreStats playersScore = pointCalculator.calculatePlayersScore();
        int whitePoints = playersScore.getWhitePoints();
        int blackPoints = playersScore.getBlackPoints();
        assertEquals(15, blackPoints, "Problème de décompte de points de noir");
        assertEquals(2+10+18+6+3+27, whitePoints, "Problème de décompte de points avec Blanc");
    }

    @Test
    void calculateNaive_CasBasique7() {
        String representation =
                "+-○-○-○-○-○-+-+-+\n" +
                "+-○-●-●-●-○-+-+-+\n" +
                "+-○-●-+-●-○-+-+-+\n" +
                "+-○-●-●-●-○-+-+-+\n" +
                "+-○-○-○-○-○-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-●-●-●-●-●-+-+-+\n" +
                "+-●-○-○-○-●-+-+-+\n" +
                "+-●-○-+-○-●-+-+-+\n";
        Board b = buildBoard(representation, 9);
        PointCalculator pointCalculator = generatePointCalculatorFromBoard(b);
        PlayersScoreStats playersScore = pointCalculator.calculatePlayersScore();
        int whitePoints = playersScore.getWhitePoints();
        int blackPoints = playersScore.getBlackPoints();
        assertEquals(6+16, blackPoints, "Problème de décompte de points de noir");
        assertEquals(1+17, whitePoints, "Problème de décompte de points avec Blanc");
    }

    @Test
    void calculateNaive_CasBasique8() {
        String representation =
                "+-+-+-+-○-●-+-+-+\n" +
                "+-+-+-+-○-●-+-+-+\n" +
                "+-+-+-+-○-●-+-+-+\n" +
                "+-+-+-+-○-●-+-+-+\n" +
                "+-+-+-+-○-●-+-+-+\n" +
                "+-+-+-+-○-●-+-+-+\n" +
                "+-+-+-+-○-●-+-+-+\n" +
                "+-+-+-+-○-●-+-+-+\n" +
                "+-+-+-+-○-●-+-+-+\n";
        Board b = buildBoard(representation, 9);
        PointCalculator pointCalculator = generatePointCalculatorFromBoard(b);
        PlayersScoreStats playersScore = pointCalculator.calculatePlayersScore();
        int whitePoints = playersScore.getWhitePoints();
        int blackPoints = playersScore.getBlackPoints();
        assertEquals(9, blackPoints, "Problème de décompte de points de noir");
        assertEquals(36, whitePoints, "Problème de décompte de points avec Blanc");
    }

    @Test
    void calculateNaive_CasBasique9() {
        String representation =
                "+-+-+-○-+-●-+-+-+\n" +
                "+-+-+-○-+-●-+-+-+\n" +
                "+-+-+-○-+-●-+-+-+\n" +
                "+-+-+-○-+-●-+-+-+\n" +
                "+-+-+-○-+-●-+-+-+\n" +
                "+-+-+-○-+-●-+-+-+\n" +
                "+-+-+-○-+-●-+-+-+\n" +
                "+-+-+-○-+-●-+-+-+\n" +
                "+-+-+-○-+-●-+-+-+\n";
        Board b = buildBoard(representation, 9);
        PointCalculator pointCalculator = generatePointCalculatorFromBoard(b);
        PlayersScoreStats playersScore = pointCalculator.calculatePlayersScore();
        int whitePoints = playersScore.getWhitePoints();
        int blackPoints = playersScore.getBlackPoints();
        assertEquals(36, blackPoints, "Problème de décompte de points de noir");
        assertEquals(36, whitePoints, "Problème de décompte de points avec Blanc");
    }

    @Test
    void calculateNaive_CasBasique10() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "○-○-○-○-○-○-○-○-○\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "●-●-●-●-●-●-●-●-●\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n";
        Board b = buildBoard(representation, 9);
        PointCalculator pointCalculator = generatePointCalculatorFromBoard(b);
        PlayersScoreStats playersScore = pointCalculator.calculatePlayersScore();
        int whitePoints = playersScore.getWhitePoints();
        int blackPoints = playersScore.getBlackPoints();
        assertEquals(36, blackPoints, "Problème de décompte de points de noir");
        assertEquals(36, whitePoints, "Problème de décompte de points avec Blanc");
    }

    @Test
    void calculateNaive_CasBasique11() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                "●-●-●-●-●-●-●-●-+\n" +
                "●-+-+-+-+-+-+-●-+\n" +
                "●-+-●-●-●-●-+-●-+\n" +
                "●-+-●-+-○-●-+-●-+\n" +
                "●-+-●-●-●-●-○-●-+\n" +
                "●-+-+-+-○-○-○-●-+\n" +
                "●-●-●-●-●-●-●-●-+\n" +
                "+-+-+-+-+-+-+-+-+\n";
        Board b = buildBoard(representation, 9);
        PointCalculator pointCalculator = generatePointCalculatorFromBoard(b);
        PlayersScoreStats playersScore = pointCalculator.calculatePlayersScore();
        int whitePoints = playersScore.getWhitePoints();
        int blackPoints = playersScore.getBlackPoints();
        assertEquals(0, blackPoints, "Problème de décompte de points de noir");
        assertEquals(56, whitePoints, "Problème de décompte de points avec Blanc");
    }






























    
    
    
    
     
}