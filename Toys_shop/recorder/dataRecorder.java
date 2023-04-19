package recorder;

import java.util.List;


public interface dataRecorder {
    List<String> readAllLines(Integer fileNameIndex);
    void saveAllLines(String lines, Integer fileNameIndex);
}
