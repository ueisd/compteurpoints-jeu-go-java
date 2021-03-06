package PointCalculator.EncircledArea.Fetcher;

import Board.Board;
import Board.Builder.BoardBuilder;
import Board.Builder.BoardBuilderForTests;
import Board.Builder.BoardBuilderFromBoardRepresentation;
import PointCalculator.EncircledArea.EncircledArea;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EncircledAreaImplemFlatListFetcherTest {

    final static int taille = 9;

    /* LÉGENDE
     *  1. Blanc:   ●
     *  2. Noir:    ○
     */

    @Test
    void fetchFlatListNoStickyFromBoard_CasBasiqueZoneCount() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-●-●-●-+-+-+\n" +
                "+-+-●-+-+-●-+-+-+\n" +
                "+-+-●-+-+-+-●-+-+\n" +
                "+-+-+-●-●-●-+-+-+\n" +
                "+-+-+-○-+-+-+-+-+\n" +
                "●-+-+-+-+-+-+-+-+\n" +
                "●-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFlatListFetcher fetcher = new EncircledAreaFlatListFetcher(b);
        List<EncircledArea> areas = fetcher.fetchFlatListFromBoard();
        assertEquals(1, areas.size());
    }

    @Test
    void fetchFlatListNoStickyFromBoard_CasBasique2ZoneCount() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-●-●-●-+-+-+\n" +
                "+-+-●-+-+-●-+-+-+\n" +
                "+-+-●-+-+-+-●-+-+\n" +
                "+-+-+-●-●-●-+-+-+\n" +
                "+-+-+-○-○-○-+-+-+\n" +
                "●-+-+-○-+-○-+-+-+\n" +
                "●-+-+-○-○-○-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFlatListFetcher fetcher = new EncircledAreaFlatListFetcher(b);
        List<EncircledArea> areas = fetcher.fetchFlatListFromBoard();
        assertEquals(2, areas.size());
    }

    @Test
    void fetchFlatListNoStickyFromBoard_CasBasique2ZoneCount4() {
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
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFlatListFetcher fetcher = new EncircledAreaFlatListFetcher(b);
        List<EncircledArea> areas = fetcher.fetchFlatListFromBoard();
        assertEquals(3, areas.size());
    }

    @Test
    void fetchFlatListNoStickyFromBoard_CasBasique2ZoneCount5() {
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
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFlatListFetcher fetcher = new EncircledAreaFlatListFetcher(b);
        List<EncircledArea> areas = fetcher.fetchFlatListFromBoard();
        assertEquals(5, areas.size());
    }

    @Test
    void fetchFlatListNoStickyFromBoard_CasBasique3ZoneCount() {
        String representation =
                "+-+-○-+-+-○-+-+-+\n" +
                "+-+-○-○-○-○-+-+-+\n" +
                "+-+-●-●-●-●-+-+-+\n" +
                "+-+-●-+-+-●-+-+-+\n" +
                "+-+-●-●-●-●-+-+-+\n" +
                "+-+-+-+-+-+-+-●-●\n" +
                "+-+-+-○-○-○-●-+-+\n" +
                "●-+-+-○-+-○-●-+-+\n" +
                "●-+-+-○-○-○-●-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFlatListFetcher fetcher = new EncircledAreaFlatListFetcher(b);
        List<EncircledArea> areas = fetcher.fetchFlatListFromBoard();
        assertEquals(4, areas.size());
    }

    @Test
    void fetchFlatListNoStickyFromBoard_CasBasique4ZoneCount() {
        String representation =
                "+-+-○-+-+-○-+-+-+-+-+-+-+\n" +
                "+-+-○-○-○-○-+-+-+-+-+-+-+\n" +
                "+-+-●-●-●-●-+-+-+-+-+-+-+\n" +
                "+-+-●-+-+-●-+-+-+-+-+-+-+\n" +
                "+-+-●-●-●-●-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-○-○-○-●-●-●-+-+-+-+\n" +
                "+-+-+-○-+-○-●-+-●-+-+-+-+\n" +
                "+-+-+-○-○-○-●-●-●-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-●-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-●-●-+-+-+-+-+-+\n" +
                "+-+-+-+-+-●-+-●-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, 13);
        EncircledAreaFlatListFetcher fetcher = new EncircledAreaFlatListFetcher(b);
        List<EncircledArea> areas = fetcher.fetchFlatListFromBoard();
        assertEquals(5, areas.size());
    }

    @Test
    void fetchFlatListNoStickyFromBoard_CasBasique5ZoneCount() {
        String representation =
                "+-+-○-+-+-○-+-+-+-+-+-+-+-+-+\n" +
                "+-+-○-○-○-○-+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-●-●-●-+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-+-+-●-+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-●-●-●-+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-○-○-○-●-●-●-+-+-+-+-+-+\n" +
                "+-+-●-○-+-○-●-+-●-+-+-+-+-+-+\n" +
                "+-+-●-○-○-○-●-●-●-+-+-+-+-+-+\n" +
                "+-+-●-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-+-+-●-+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-+-+-●-●-+-+-+-+-+-+-+-+\n" +
                "+-+-●-+-+-●-+-●-+-+-+-+-+-+-+\n" +
                "+-+-●-+-+-●-+-●-+-+-+-+-+-+-+\n" +
                "+-+-●-+-+-●-+-●-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, 15);
        EncircledAreaFlatListFetcher fetcher = new EncircledAreaFlatListFetcher(b);
        List<EncircledArea> areas = fetcher.fetchFlatListFromBoard();
        assertEquals(5, areas.size());
    }

    @Test
    void fetchFlatListNoStickyFromBoard_CasBasique6ZoneCount() {
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
        Board b = BoardBuilderForTests.buildBoard(representation, 15);
        EncircledAreaFlatListFetcher fetcher = new EncircledAreaFlatListFetcher(b);
        List<EncircledArea> areas = fetcher.fetchFlatListFromBoard();
        assertEquals(5, areas.size());
    }

    @Test
    void fetchFlatListNoStickyFromBoard_CasBasique7ZoneCount() {
        String representation =
                "+-+-○-+-+-○-+-+-+-+-+-+-+-+-+\n" +
                "+-+-○-○-○-○-+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-●-●-●-+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-+-+-●-+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-●-●-+-+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-●-●-●-●-+-+-+-+-+\n" +
                "+-+-●-●-●-●-●-+-+-+-●-+-+-+-+\n" +
                "+-+-●-○-○-○-●-●-●-+-●-+-+-+-+\n" +
                "+-+-●-○-+-○-●-+-●-+-●-+-+-+-+\n" +
                "+-+-●-○-○-○-●-●-●-+-●-+-+-+-+\n" +
                "+-+-●-+-+-+-+-+-+-+-●-+-+-+-+\n" +
                "+-+-●-●-●-●-●-●-●-●-●-+-+-+-+\n" +
                "+-+-●-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-+-+-+-+-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, 15);
        EncircledAreaFlatListFetcher fetcher = new EncircledAreaFlatListFetcher(b);
        List<EncircledArea> areas = fetcher.fetchFlatListFromBoard();
        assertEquals(5, areas.size());
    }

    @Test
    void fetchFlatListNoStickyFromBoard_CasConcentrique() {
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
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFlatListFetcher fetcher = new EncircledAreaFlatListFetcher(b);
        List<EncircledArea> areas = fetcher.fetchFlatListFromBoard();
        assertEquals(6, areas.size());
    }

    @Test
    void fetchFlatListNoStickyFromBoard_CasConcentriqueFreres() {
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
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFlatListFetcher fetcher = new EncircledAreaFlatListFetcher(b);
        List<EncircledArea> areas = fetcher.fetchFlatListFromBoard();
        assertEquals(4, areas.size());

    }

    @Test
    void fetchFlatListNoStickyFromBoard_Cas2LinesBrother() {
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
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFlatListFetcher fetcher = new EncircledAreaFlatListFetcher(b);
        List<EncircledArea> areas = fetcher.fetchFlatListFromBoard();
        assertEquals(2, areas.size());

    }

    @Test
    void fetchFlatListNoStickyFromBoard_CasNoMansLand() {
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
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFlatListFetcher fetcher = new EncircledAreaFlatListFetcher(b);
        List<EncircledArea> areas = fetcher.fetchFlatListFromBoard();
        assertEquals(2, areas.size());
    }

    @Test
    void fetchFlatListNoStickyFromBoard_CasNoMansLand2() {
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
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFlatListFetcher fetcher = new EncircledAreaFlatListFetcher(b);
        List<EncircledArea> areas = fetcher.fetchFlatListFromBoard();
        assertEquals(2, areas.size());
    }

    @Test
    void fetchFlatListNoStickyFromBoard_CasNoMansLand2extend() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "○-○-○-○-○-○-○-○-○\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "●-●-●-●-●-●-●-●-●\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFlatListFetcher fetcher = new EncircledAreaFlatListFetcher(b);
        List<EncircledArea> areas = fetcher.fetchFlatListFromBoard();
        assertEquals(2, areas.size());
    }

    @Test
    void fetchFlatListNoStickyFromBoard_CasBandeNotMidle() {
        String representation =
                "+-+-+-+-○-+-●-+-+\n" +
                "+-+-+-+-○-+-●-+-+\n" +
                "+-+-+-+-○-+-●-+-+\n" +
                "+-+-+-+-○-+-●-+-+\n" +
                "+-+-+-+-○-+-●-+-+\n" +
                "+-+-+-+-○-+-●-+-+\n" +
                "+-+-+-+-○-+-●-+-+\n" +
                "+-+-+-+-○-+-●-+-+\n" +
                "+-+-+-+-○-+-●-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFlatListFetcher fetcher = new EncircledAreaFlatListFetcher(b);
        List<EncircledArea> areas = fetcher.fetchFlatListFromBoard();
        assertEquals(1, areas.size());
    }

}