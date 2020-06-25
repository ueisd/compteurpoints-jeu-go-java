import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        /*List<String> listOfString=new ArrayList<String>();
        for(int i=1;i<=2; i++){
            System.out.print("Input name, age, address, city: ");
            String data= s.nextLine();
            listOfString.add(data);
        }
        for(String data:listOfString){
            String[] splitData= data.split("\\s+");
            for(int i=0;i<splitData.length;i++){
                System.out.print(splitData[i] + "\n");
            }
        }*/

        int boardSize = 9;

        GameController gc = new GameController(
                boardSize,
                new GameConsole(new Scanner(System.in),
                new PositionDeserializer(boardSize))
        );
        gc.startGame();
    }
}
