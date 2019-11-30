package progressBar;

import javafx.scene.control.ProgressBar;

import java.io.*;

public class ReaderRunnable implements Runnable {
    File file;
    ProgressBar progressBar;

    public ReaderRunnable(File file, ProgressBar progressBar) {
        this.file = file;
        this.progressBar = progressBar;
    }

    @Override
    public void run() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            int realFileLenght = 145;
            double jedenZnakToProcent = 100.0 / realFileLenght;
            int fileLength = 0;
            while ((line = bufferedReader.readLine()) != null){
                fileLength+=line.length();
                double progress = fileLength * jedenZnakToProcent;
                progressBar.setProgress(progress/100);
                System.out.println(line);
                Thread.sleep(200);
            }
            System.out.println("Zakończono odczyt");
            System.out.println("Plik ma długość: "+fileLength);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
