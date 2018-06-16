import javafx.collections.FXCollections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LevelsN {
        public static ObservableList<levels> getLevellist() {
            levels level1 = new levels("KZ", "Qazaqstan");
            levels level2 = new levels("RU", "Russian");
            levels level3 = new levels("ENG", "England");

            ObservableList<levels> list //
                    = FXCollections.observableArrayList(level1, level2, level3);

            return list;
        }
}
