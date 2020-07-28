package Board.Builder;

import Board.Board;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BoardBuilderFromBoardRepresentationTest {

    @Test
    void build() {

        BoardBuilder builder = new BoardBuilderFromBoardRepresentation(
                "●-+-+-+-+-+-+-+-●\n" +
                "+-+-+-+-+-+-+-○-+\n" +
                "+-+-+-+-+-+-○-●-+\n" +
                "+-+-+-+-+-○-●-●-○\n" +
                "+-+-+-+-+-+-●-○-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "●-+-+-+-+-+-+-+-●\n");
        Optional<Board> optB = builder.build();
        String result = optB.get().toString();
        String expected = "  A B C D E F G H J\n" +
                "9 ●-+-+-+-+-+-+-+-●\n" +
                "8 +-+-+-+-+-+-+-○-+\n" +
                "7 +-+-+-+-+-+-○-●-+\n" +
                "6 +-+-+-+-+-○-●-●-○\n" +
                "5 +-+-+-+-+-+-●-○-+\n" +
                "4 +-+-+-+-+-+-+-+-+\n" +
                "3 +-+-+-+-+-+-+-+-+\n" +
                "2 +-+-+-+-+-+-+-+-+\n" +
                "1 ●-+-+-+-+-+-+-+-●\n";
        assert(result.equals(expected));
    }
}