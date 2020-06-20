import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {
    private final Integer size;
    private final List<Intersection> intersections;

    public Board(Integer size) {
        this.size = size;
        intersections = initIntersections();
    }

    private List<Intersection> initIntersections() {
        return IntStream.range(0, size)
                .mapToObj(i -> IntStream.range(0, size)
                    .mapToObj(j -> new Position(i,j))
                    .map(Intersection::new))
                .flatMap(Function.identity())
                .collect(Collectors.toList());
    }

    private Intersection getIntersection(Position p) {
        return intersections.stream()
                .filter(i -> i.hasPosition(p))
                .findAny()
                .orElse(null);
    }

    private boolean intersectionHasLiberty(Intersection i) {
        return false;
    }

    public Result putStone(PlayerColor c, Position p) {
        return null;
    }

    public void resetAllKo() {

    }

    public void removeDeadStone() {

    }

    public Integer calculateScore(PlayerColor c) {
        return 0;
    }

    @Override
    public String toString() {
        return "Board";
    }
}
