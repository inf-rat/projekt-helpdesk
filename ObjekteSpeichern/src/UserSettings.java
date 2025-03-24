import java.io.Serializable;
import java.util.ArrayList;

public class UserSettings implements Serializable {
    // Attribute
    private String userName;
    private ArrayList<Integer> wrongAnswers;

    // Konstruktor
    public UserSettings(String userName) {
        this.userName = userName;
        this.wrongAnswers = new ArrayList<>();
    }

    // Methoden
    public String getUserName() {
        return userName;
    }

    public void addWrongAnswer(int answerID) {
        wrongAnswers.add(answerID);
    }

    @Override
    public String toString() {
        return "Username: " + getUserName()
                + "\nFalsche Antworten: " + wrongAnswers.toString();
    }
}