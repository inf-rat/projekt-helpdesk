import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class FileOperations {
    public static void saveUserSettings(UserSettings settings, String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(settings);
            out.close();
            fileOut.close();
            System.out.println("Settings von " + settings.getUserName()
                    + " in der Datei " + filename + " gespeichert.");
        } catch (IOException i) {
            System.out.println("Fehler beim Speichern: " + i.getMessage());
        }
    }

    public static UserSettings loadUserSettings(String filename) {
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            UserSettings settings = (UserSettings) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Settings von " + settings.getUserName()
                    + " aus der Datei " + filename + " wiederhergestellt.");
            return settings;
        } catch (IOException i) {
            System.out.println("Fehler beim Laden: " + i.getMessage());
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Klasse UserSettings nicht gefunden.");
            return null;
        }
    }


    public static void main(String[] args) {
        UserSettings horst = new UserSettings("Horst");
        horst.addWrongAnswer(13);
        horst.addWrongAnswer(42);
        System.out.println(horst);

//        saveUserSettings(horst, "horst.ser");
//        UserSettings restoredHorst = loadUserSettings("horst.ser");
//        System.out.println(restoredHorst);
    }
}
