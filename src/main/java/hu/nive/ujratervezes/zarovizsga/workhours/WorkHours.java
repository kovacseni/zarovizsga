package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkHours {

    public String minWork(String file) {
        Path path = Path.of(file);
        try (BufferedReader br = Files.newBufferedReader(path)) {

            return findMinWork(br);

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    private String findMinWork(BufferedReader br) throws IOException {
        int min = Integer.MAX_VALUE;
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            String[] temp = line.split(",");
            int work = Integer.parseInt(temp[1]);
            if (work < min) {
                min = work;
                result = new StringBuilder();
                result.append(temp[0]).append(": ").append(temp[2]);
            }
        }
        return result.toString();
    }
}
