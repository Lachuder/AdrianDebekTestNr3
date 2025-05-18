package Zadanie02;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Runner02 {

    public static void main(String[] args) {

        /**
         * NIESTETY WYNIK JEST ZABURZONY Z POWODU ZMIANY KOMPUTERA I PRZENIESIENIA DANYCH
         *
         *           TUESDAY=418
         *           THURSDAY=13
         *           SUNDAY=28
         *           FRIDAY=5
         *           SATURDAY=37
         *           MONDAY=3
         *           WEDNESDAY=40
         *
         * */


        List<File> myJavaFiles = new ArrayList<>();
        findJavaFiles(new File("C:/Users/Adriano_Diag/IdeaProjects"), myJavaFiles);
        for (File myJavaFile : myJavaFiles) {
            System.out.println(getCreationDayOfWeekFromFile(myJavaFile));
        }

        myJavaFiles.stream()
                .map(f -> getCreationDayOfWeekFromFile(f))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .forEach(System.out::println);

    }

    static DayOfWeek getCreationDayOfWeekFromFile(File file) {
        DayOfWeek dayOfWeek = null;
        try {
            BasicFileAttributes fileAttributes = Files.readAttributes(Paths.get(file.getAbsolutePath()), BasicFileAttributes.class);
            FileTime fileTime = fileAttributes.creationTime();
            LocalDateTime localDateTime = LocalDateTime.ofInstant(fileTime.toInstant(), ZoneId.systemDefault());
            dayOfWeek = localDateTime.getDayOfWeek();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dayOfWeek;
    }

    static void findJavaFiles(File directory, List<File> list) {
        if (!directory.isDirectory()) {
            throw new RuntimeException("Wskazany plik nie jest folderem");
        }
        File[] array = directory.listFiles();
        for (File f : array) {
            if (f.isDirectory()) {
                findJavaFiles(f, list);
            } else if (f.getName().endsWith(".java")) {
                list.add(f);
            }
        }
    }

}
