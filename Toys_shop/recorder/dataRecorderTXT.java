package recorder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class dataRecorderTXT implements dataRecorder {
    private String fileNameToy;
    private String fileNameCastToy;

    public dataRecorderTXT(String fileNameToy, String fileNameCastToy) {
        this.fileNameToy = fileNameToy;
        this.fileNameCastToy = fileNameCastToy;
    }

    @Override
    public void saveAllLines(String lines, Integer fileNameIndex) {
        String fileName = null;
        if (fileNameIndex == 0) {
            fileName = fileNameToy;
        }
        else{
            fileName = fileNameCastToy;
        }
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(lines);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<String> readAllLines(Integer fileNameIndex) {
        String fileName = null;
        if (fileNameIndex == 0) {
            fileName = fileNameToy;
        }
        else{
            fileName = fileNameCastToy;
        }
        List<String> lines = new ArrayList<>();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            if (line != null) {
                lines.add(line);
            }
            while (line != null) {
                line = reader.readLine();
                if (line != null) {
                    lines.add(line);
                }
                fr.close();
            }
        } catch (Exception e) {
        }
        return lines;
    }

}
