package PointCalculator.EncircledArea.Fetcher;

import Board.Board;
import Board.Builder.BoardBuilderForTests;
import Board.Intersection;
import Player.Color;
import PointCalculator.EncircledArea.EncircledArea;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EncircledAreaImplemFetcherTest {

    final static int taille = 9;

    /* LÉGENDE
     *  1. Blanc:   ●
     *  2. Noir:    ○
     */

    @Test
    void getAnneauInterieurCasDeBase() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-●-●-●-+-+-+\n" +
                "+-+-●-+-+-●-+-+-+\n" +
                "+-+-●-+-+-+-●-+-+\n" +
                "+-+-+-●-●-●-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "●-+-+-+-+-+-+-+-+\n" +
                "●-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);

        Intersection i = b.getIntersection(3, 4);
        List<Intersection> anneauContenuNoir  = encircledAreaFetcherImplem.getAnneauInterieur(i, Color.White);
        assertEquals(5, anneauContenuNoir.size());
    }

    @Test
    void getAnneauInterieur_CasContenuSimple() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                        "+-+-+-+-+-+-+-+-+\n" +
                        "+-+-+-+-+-+-+-+-+\n" +
                        "+-+-●-●-●-●-●-●-+\n" +
                        "+-+-●-+-+-+-+-●-+\n" +
                        "+-+-●-+-+-+-+-●-+\n" +
                        "+-+-●-+-○-+-+-●-+\n" +
                        "●-+-●-●-●-●-●-●-+\n" +
                        "●-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);
        Intersection i = b.getIntersection(3, 2);
        List<Intersection> anneauContenuNoir  = encircledAreaFetcherImplem.getAnneauInterieur(i, Color.White);
        assertEquals(12, anneauContenuNoir.size());
    }

    @Test
    void getAnneauInterieur_CasContenu() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-●-●-●-●-●-+\n" +
                "+-+-●-+-○-○-○-●-+\n" +
                "+-+-●-+-○-+-○-●-+\n" +
                "+-+-●-+-○-○-○-●-+\n" +
                "●-+-●-●-●-●-●-●-+\n" +
                "●-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);
        Intersection i = b.getIntersection(3, 2);
        List<Intersection> anneauContenuNoir  = encircledAreaFetcherImplem.getAnneauInterieur(i, Color.White);
        assertEquals(12, anneauContenuNoir.size());
    }

    @Test
    void getAnneauInterieur_CasContenuMoinsNoir() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-●-●-●-●-●-+\n" +
                "+-+-●-+-○-○-○-●-+\n" +
                "+-+-●-+-○-●-○-●-+\n" +
                "+-+-●-+-○-○-○-●-+\n" +
                "●-+-●-●-●-●-●-●-+\n" +
                "●-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);
        Intersection i = b.getIntersection(3, 2);
        List<Intersection> anneauContenuNoir  = encircledAreaFetcherImplem.getAnneauInterieur(i, Color.White);
        assertEquals(11, anneauContenuNoir.size());
    }

    @Test
    void getAnneauInterieur_CasContenuMoinsNoir2() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                "+-●-●-●-●-●-●-●-+\n" +
                "+-●-+-+-+-+-+-●-+\n" +
                "+-●-+-●-●-●-+-●-+\n" +
                "+-●-+-●-+-●-+-●-+\n" +
                "+-●-+-●-●-●-○-●-+\n" +
                "+-●-+-○-○-○-○-●-+\n" +
                "+-●-●-●-●-●-●-●-+\n" +
                "●-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);
        Intersection i = b.getIntersection(2, 2);
        List<Intersection> anneauContenuNoir  = encircledAreaFetcherImplem.getAnneauInterieur(i, Color.White);
        assertEquals(16, anneauContenuNoir.size());
    }

    @Test
    void getAnneauInterieur_CasContenuMoinsNoir3() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                "+-●-●-●-●-●-●-●-+\n" +
                "+-●-+-+-+-+-+-●-+\n" +
                "+-●-+-●-●-●-+-●-+\n" +
                "+-●-+-●-+-●-+-●-+\n" +
                "+-●-+-●-●-●-○-●-+\n" +
                "+-●-○-○-○-○-○-●-+\n" +
                "+-●-●-●-●-●-●-●-+\n" +
                "●-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);
        Intersection i = b.getIntersection(2, 2);
        List<Intersection> anneauContenuNoir  = encircledAreaFetcherImplem.getAnneauInterieur(i, Color.White);
        assertEquals(16, anneauContenuNoir.size());
    }

    @Test
    void getAnneauInterieur_CasBordureNoire() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                "+-○-○-○-○-○-○-○-+\n" +
                "+-○-+-+-+-+-+-○-+\n" +
                "+-○-+-○-○-○-+-○-+\n" +
                "+-○-+-○-+-○-+-○-+\n" +
                "+-○-+-○-○-○-+-○-+\n" +
                "+-○-+-+-●-●-●-○-+\n" +
                "+-○-○-○-○-○-○-○-+\n" +
                "●-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);
        Intersection i = b.getIntersection(2, 2);
        List<Intersection> anneauContenuNoir  = encircledAreaFetcherImplem.getAnneauInterieur(i, Color.Black);
        assertEquals(16, anneauContenuNoir.size());
    }

    @Test
    void fetchColorAreaFromIntersection_CasDeBase() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-●-●-●-+-+-+\n" +
                "+-+-●-+-+-●-+-+-+\n" +
                "+-+-●-+-+-+-●-+-+\n" +
                "+-+-+-●-●-●-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "●-+-+-+-+-+-+-+-+\n" +
                "●-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);

        Intersection i = b.getIntersection(3, 4);
        EncircledArea area = encircledAreaFetcherImplem.fetchColorAreaFromIntersection(i, Color.White);
        assertEquals(11, area.getFullBorder().size(), "Bordure non conforme");
        assertEquals(5, area.getFullContent().size(), "Contenu complet non conforme");
        assertEquals(5, area.getRingContent().size(), "Contenu aneau non conforme");
    }

    @Test
    void  fetchColorAreaFromIntersection_CasContenuMoinsNoir() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-●-●-●-●-●-+\n" +
                "+-+-●-+-○-○-○-●-+\n" +
                "+-+-●-+-○-●-○-●-+\n" +
                "+-+-●-+-○-○-○-●-+\n" +
                "●-+-●-●-●-●-●-●-+\n" +
                "●-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);

        Intersection i = b.getIntersection(3, 4);
        EncircledArea area = encircledAreaFetcherImplem.fetchColorAreaFromIntersection(i, Color.White);
        assertEquals(18, area.getFullBorder().size(), "Bordure non conforme");
        assertEquals(12, area.getFullContent().size(), "Contenu complet non conforme");
        assertEquals(11, area.getRingContent().size(), "Contenu aneau non conforme");
    }

    @Test
    void  fetchColorAreaFromIntersection_CasSousZone() {
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
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);

        Intersection i = b.getIntersection(2, 2);
        EncircledArea area = encircledAreaFetcherImplem.fetchColorAreaFromIntersection(i, Color.White);
        assertEquals(26, area.getFullBorder().size(), "Bordure non conforme");
        assertEquals(30, area.getFullContent().size(), "Contenu complet non conforme");
        assertEquals(18, area.getRingContent().size(), "Contenu aneau non conforme");
    }

    @Test
    void  fetchColorAreaFromIntersection_CasSousZone2() {
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
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);

        Intersection i = b.getIntersection(3, 4);
        EncircledArea area = encircledAreaFetcherImplem.fetchColorAreaFromIntersection(i, Color.White);
        assertEquals(10, area.getFullBorder().size(), "Bordure non conforme");
        assertEquals(2, area.getFullContent().size(), "Contenu complet non conforme");
        assertEquals(2, area.getRingContent().size(), "Contenu aneau non conforme");
    }

    @Test
    void  fetchAreaFromIntersection_CasContenuMoinsNoir() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-●-●-●-●-●-+\n" +
                "+-+-●-+-○-○-○-●-+\n" +
                "+-+-●-+-○-●-○-●-+\n" +
                "+-+-●-+-○-○-○-●-+\n" +
                "●-+-●-●-●-●-●-●-+\n" +
                "●-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);

        Intersection i = b.getIntersection(3, 4);
        Optional<EncircledArea> area = encircledAreaFetcherImplem.fetchAreaFromIntersection(i);
        assertTrue(area.isPresent(), "ereure Areab non présente.");
        assertEquals(18, area.get().getFullBorder().size(), "Bordure non conforme");
        assertEquals(12, area.get().getFullContent().size(), "Contenu complet non conforme");
        assertEquals(3, area.get().getRingContent().size(), "Contenu aneau non conforme");
    }

    @Test
    void  fetchAreaFromIntersection_CasContenuMoinsNoir2() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                        "+-+-+-+-+-+-+-+-+\n" +
                        "+-+-+-+-+-+-+-+-+\n" +
                        "+-+-●-●-●-●-●-●-+\n" +
                        "+-+-●-+-○-○-○-●-+\n" +
                        "+-+-●-+-○-+-○-●-+\n" +
                        "+-+-●-+-○-○-○-●-+\n" +
                        "●-+-●-●-●-●-●-●-+\n" +
                        "●-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);

        Intersection i = b.getIntersection(3, 4);
        Optional<EncircledArea> area = encircledAreaFetcherImplem.fetchAreaFromIntersection(i);
        assertTrue(area.isPresent(), "ereure Areab non présente.");
        assertEquals(18, area.get().getFullBorder().size(), "Bordure non conforme");
        assertEquals(12, area.get().getFullContent().size(), "Contenu complet non conforme");
        assertEquals(3, area.get().getRingContent().size(), "Contenu aneau non conforme");
    }

    @Test
    void  fetchAreaFromIntersection_CasSousZone() {
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
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);

        Intersection i = b.getIntersection(2, 2);
        Optional<EncircledArea> area = encircledAreaFetcherImplem.fetchAreaFromIntersection(i);
        assertTrue(area.isPresent(), "ereure Areab non présente.");
        assertEquals(26, area.get().getFullBorder().size(), "Bordure non conforme");
        assertEquals(30, area.get().getFullContent().size(), "Contenu complet non conforme");
        assertEquals(14, area.get().getRingContent().size(), "Contenu aneau non conforme");
    }

    @Test
    void  fetchAreaFromIntersection_CasSousZone2() {
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
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);

        Intersection i = b.getIntersection(3, 4);
        Optional<EncircledArea> area = encircledAreaFetcherImplem.fetchAreaFromIntersection(i);
        assertTrue(area.isPresent(), "ereure Areab non présente.");
        assertEquals(10, area.get().getFullBorder().size(), "Bordure non conforme");
        assertEquals(2, area.get().getFullContent().size(), "Contenu complet non conforme");
        assertEquals(1, area.get().getRingContent().size(), "Contenu aneau non conforme");
    }

    @Test
    void  fetchFirstAscendantStickyEncercling_CasBasique() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-○-○-○-○-+-+-+\n" +
                "+-○-●-●-●-●-○-+-+\n" +
                "+-○-●-+-+-●-○-+-+\n" +
                "+-○-●-●-●-●-○-+-+\n" +
                "+-+-○-○-○-○-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);

        Intersection i = b.getIntersection(3, 5);

        Optional<EncircledArea> area = encircledAreaFetcherImplem.fetchAreaFromIntersection(i);
        assertTrue(area.isPresent(), "ereure Areab non présente.");
        Optional<EncircledArea> optTopArea = encircledAreaFetcherImplem.fetchFirstAscendantStickyEncercling(area.get(), true);
        assertTrue(optTopArea.isPresent(), "Absence de détection de zone parente");
        EncircledArea topArea = optTopArea.get();
        assertEquals(14, topArea.getFullBorder().size(), "Bordure non conforme");
        assertEquals(12, topArea.getFullContent().size(), "Contenu complet non conforme");
        assertEquals(0, topArea.getRingContent().size(), "Contenu aneau non conforme");
    }

    @Test
    void  fetchFirstAscendantStickyEncercling2_CasBasique() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                        "+-+-○-○-○-○-+-+-+\n" +
                        "+-○-●-●-●-●-○-+-+\n" +
                        "+-○-●-+-+-●-○-○-+\n" +
                        "+-○-●-●-●-●-○-+-+\n" +
                        "+-+-○-○-○-○-+-+-+\n" +
                        "+-+-+-+-○-+-+-+-+\n" +
                        "+-+-+-+-+-+-+-+-+\n" +
                        "+-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);

        Intersection i = b.getIntersection(3, 5);

        Optional<EncircledArea> area = encircledAreaFetcherImplem.fetchAreaFromIntersection(i);
        assertTrue(area.isPresent(), "ereure Areab non présente.");
        Optional<EncircledArea> optTopArea = encircledAreaFetcherImplem.fetchFirstAscendantStickyEncercling(area.get(), true);
        assertTrue(optTopArea.isPresent(), "Absence de détection de zone parente");
        EncircledArea topArea = optTopArea.get();
        assertEquals(16, topArea.getFullBorder().size(), "Bordure non conforme");
        assertEquals(12, topArea.getFullContent().size(), "Contenu complet non conforme");
        assertEquals(0, topArea.getRingContent().size(), "Contenu aneau non conforme");
    }

    @Test
    void  fetchFirstAscendantStickyEncercling3_CasBasique() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-○-○-○-○-+-+-+\n" +
                "+-○-●-●-●-●-○-+-+\n" +
                "+-○-●-+-+-●-○-○-+\n" +
                "+-○-●-●-+-●-○-+-+\n" +
                "+-+-○-○-●-○-+-+-+\n" +
                "+-+-+-+-○-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);

        Intersection i = b.getIntersection(3, 5);

        Optional<EncircledArea> area = encircledAreaFetcherImplem.fetchAreaFromIntersection(i);
        assertTrue(area.isPresent(), "ereure Areab non présente.");
        Optional<EncircledArea> optTopArea = encircledAreaFetcherImplem.fetchFirstAscendantStickyEncercling(area.get(), true);
        assertTrue(optTopArea.isPresent(), "Absence de détection de zone parente");
        EncircledArea topArea = optTopArea.get();
        assertEquals(15, topArea.getFullBorder().size(), "Bordure non conforme");
        assertEquals(13, topArea.getFullContent().size(), "Contenu complet non conforme");
        assertEquals(0, topArea.getRingContent().size(), "Contenu aneau non conforme");
    }




    @Test
    void  fetchTopStickyEncirler_CasBasique() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-○-○-○-○-+-+-+\n" +
                "+-○-●-●-●-●-○-+-+\n" +
                "+-○-●-+-+-●-○-+-+\n" +
                "+-○-●-●-●-●-○-+-+\n" +
                "+-+-○-○-○-○-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);

        Intersection i = b.getIntersection(3, 5);

        Optional<EncircledArea> area = encircledAreaFetcherImplem.fetchAreaFromIntersection(i);
        assertTrue(area.isPresent(), "ereure Areab non présente.");
        EncircledArea topArea = encircledAreaFetcherImplem.fetchTopStickyEncirler(area.get());
        assertEquals(14, topArea.getFullBorder().size(), "Bordure non conforme");
        assertEquals(12, topArea.getFullContent().size(), "Contenu complet non conforme");
        assertEquals(0, topArea.getRingContent().size(), "Contenu aneau non conforme");
    }

    @Test
    void  fetchTopStickyEncirler_CasBasique2() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-○-○-○-○-+-+-+\n" +
                "+-○-●-●-●-●-○-+-+\n" +
                "+-○-●-+-+-●-○-○-+\n" +
                "+-○-●-●-●-●-○-+-+\n" +
                "+-+-○-○-○-○-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);

        Intersection i = b.getIntersection(3, 5);

        Optional<EncircledArea> area = encircledAreaFetcherImplem.fetchAreaFromIntersection(i);
        assertTrue(area.isPresent(), "ereure Areab non présente.");
        EncircledArea topArea = encircledAreaFetcherImplem.fetchTopStickyEncirler(area.get());
        assertEquals(15, topArea.getFullBorder().size(), "Bordure non conforme");
        assertEquals(12, topArea.getFullContent().size(), "Contenu complet non conforme");
        assertEquals(0, topArea.getRingContent().size(), "Contenu aneau non conforme");
    }

    @Test
    void  fetchTopStickyEncirler_CasBasique3() {
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
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);

        Intersection i = b.getIntersection(3, 5);

        Optional<EncircledArea> area = encircledAreaFetcherImplem.fetchAreaFromIntersection(i);
        assertTrue(area.isPresent(), "ereure Areab non présente.");
        EncircledArea topArea = encircledAreaFetcherImplem.fetchTopStickyEncirler(area.get());
        assertEquals(18, topArea.getFullBorder().size(), "Bordure non conforme");
        assertEquals(27, topArea.getFullContent().size(), "Contenu complet non conforme");
        assertEquals(0, topArea.getRingContent().size(), "Contenu aneau non conforme");
    }



    @Test
    void  fetchTopStickyEncirler_CasNonEncerclé() {
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
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);

        Intersection i = b.getIntersection(3, 8);

        Optional<EncircledArea> area = encircledAreaFetcherImplem.fetchAreaFromIntersection(i);
        assertTrue(area.isPresent(), "ereure Areab non présente.");
        EncircledArea topArea = encircledAreaFetcherImplem.fetchTopStickyEncirler(area.get());
        assertEquals(6, topArea.getFullBorder().size(), "Bordure non conforme");
        assertEquals(2, topArea.getFullContent().size(), "Contenu complet non conforme");
        assertEquals(2, topArea.getRingContent().size(), "Contenu aneau non conforme");
    }


    @Test
    void  fetchTopStickyEncirler_CasNoMansLand() {
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
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);

        Intersection i = b.getIntersection(4, 0);

        Optional<EncircledArea> area = encircledAreaFetcherImplem.fetchAreaFromIntersection(i);
        assertTrue(!area.isPresent(), "ereure no mans land ignoré");
    }


    @Test
    void fetchTopStickyEncirledFlatList() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-●-●-●-●-●-+-+\n" +
                "+-+-●-○-○-○-●-+-+\n" +
                "+-+-●-○-+-○-●-+-+\n" +
                "+-+-●-○-○-○-●-+-+\n" +
                "+-+-●-●-●-●-●-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);

        Intersection i = b.getIntersection(4, 4);
        Optional<EncircledArea> optArea = encircledAreaFetcherImplem.fetchAreaFromIntersection(i);
        assertTrue(optArea.isPresent(), "ereure no mans land ignoré");
        EncircledArea area = optArea.get();
        List<EncircledArea> topStickyAreas = encircledAreaFetcherImplem.fetchTopStickyEncirledFlatList(area);
        assertEquals(1, topStickyAreas.size());
    }

    @Test
    void fetchTopStickyEncirledFlatList2() {
        String representation =
                "+-+-+-+-+-+-+-+-+\n" +
                "+-○-○-○-○-○-○-○-+\n" +
                "+-○-●-●-●-●-●-○-+\n" +
                "+-○-●-○-○-○-●-○-+\n" +
                "+-○-●-○-+-○-●-○-+\n" +
                "+-○-●-○-○-○-●-○-+\n" +
                "+-○-●-●-●-●-●-○-+\n" +
                "+-○-○-○-○-○-○-○-+\n" +
                "+-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, taille);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);

        Intersection i = b.getIntersection(4, 4);
        Optional<EncircledArea> optArea = encircledAreaFetcherImplem.fetchAreaFromIntersection(i);
        assertTrue(optArea.isPresent(), "ereure no mans land ignoré");
        EncircledArea area = optArea.get();
        List<EncircledArea> topStickyAreas = encircledAreaFetcherImplem.fetchTopStickyEncirledFlatList(area);
        assertEquals(2, topStickyAreas.size());
    }

    @Test
    void fetchTopStickyEncirledFlatList3() {
        String representation =
                "+-+-+-+-+-+-+-+-+-+-+\n" +
                "+-○-○-○-○-○-○-○-+-+-+\n" +
                "+-○-●-●-●-●-●-○-+-+-+\n" +
                "+-○-●-○-○-○-●-○-+-+-+\n" +
                "+-○-●-○-+-○-●-○-+-+-+\n" +
                "+-○-●-○-○-○-●-○-+-+-+\n" +
                "+-○-●-●-●-●-●-○-+-+-+\n" +
                "+-○-○-●-○-●-○-○-+-+-+\n" +
                "+-○-○-○-●-○-○-○-+-+-+\n" +
                "+-○-○-○-○-○-○-○-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, 11);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);

        Intersection i = b.getIntersection(4, 6);
        Optional<EncircledArea> optArea = encircledAreaFetcherImplem.fetchAreaFromIntersection(i);
        assertTrue(optArea.isPresent(), "ereure no mans land ignoré");
        EncircledArea area = optArea.get();
        List<EncircledArea> topStickyAreas = encircledAreaFetcherImplem.fetchTopStickyEncirledFlatList(area);
        assertEquals(2, topStickyAreas.size());
    }

    @Test
    void fetchTopStickyEncirledFlatList_casGestionDesBorduresDiagonales() {
        String representation =
                "+-+-+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-○-○-○-○-+-+-+-+\n" +
                "+-+-○-●-●-●-○-○-+-+-+\n" +
                "+-○-●-○-○-○-●-○-+-+-+\n" +
                "+-○-●-○-+-○-●-○-+-+-+\n" +
                "+-○-●-○-○-○-●-○-+-+-+\n" +
                "+-+-○-●-●-●-○-+-+-+-+\n" +
                "+-+-○-●-○-●-○-+-+-+-+\n" +
                "+-+-+-○-●-○-+-+-+-+-+\n" +
                "+-+-+-+-○-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+-+-+\n";
        Board b = BoardBuilderForTests.buildBoard(representation, 11);
        EncircledAreaFetcherImplem encircledAreaFetcherImplem = new EncircledAreaFetcherImplem(b);

        Intersection i = b.getIntersection(4, 6);
        Optional<EncircledArea> optArea = encircledAreaFetcherImplem.fetchAreaFromIntersection(i);
        assertTrue(optArea.isPresent(), "ereure no mans land ignoré");
        EncircledArea area = optArea.get();
        List<EncircledArea> topStickyAreas = encircledAreaFetcherImplem.fetchTopStickyEncirledFlatList(area);
        assertEquals(2, topStickyAreas.size());
    }
}