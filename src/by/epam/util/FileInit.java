package by.epam.util;

import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class FileInit {

    private static final Logger LOGGER = Logger.getLogger(FileInit.class);
    private String clientName;
    private ArrayList<String> names = new ArrayList<>();

    public String readName(String pathName) {

            try {
                FileReader fileReaderName = new FileReader(pathName);
                BufferedReader readerName = new BufferedReader(fileReaderName);
                String findText;
                while ((findText = readerName.readLine()) != null) {

                    clientName = findText;
                    names.add(clientName);
                }


            } catch (FileNotFoundException e) {
                LOGGER.error("File was not founded", e);
            } catch (IOException e) {
                LOGGER.error("IException was founded", e);
            }

            Random random = new Random();
            int i = random.nextInt(8);



        return  names.get(i);

    }
}
