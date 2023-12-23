/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Nhatthang
 */
public class MyUtil {

    private static final Scanner sc = new Scanner(System.in);

    public static LocalDate parseToDate(String str, String dateFormat) {
        return LocalDate.parse(str, DateTimeFormatter.ofPattern(dateFormat));
    }

    public static String dateToString(LocalDate d, String dateFormat) {
        return DateTimeFormatter.ofPattern(dateFormat).format(d);
    }

    public static LocalDateTime parseToDateTime(String str, String dateTimeFormat) {
        return LocalDateTime.parse(str, DateTimeFormatter.ofPattern(dateTimeFormat));
    }

    public static String dateTimeToString(LocalDateTime d, String dateTimeFormat) {
        return DateTimeFormatter.ofPattern(dateTimeFormat).format(d);
    }

    public static String inputAString(String mess) {
        System.out.print(mess);
        return sc.nextLine();
    }

    public static LocalDate inputDate(String mess, String err, String format) {
        do {
            String date = inputAString(mess);
            try {
                return parseToDate(date, format);
            } catch (DateTimeParseException dtpE) {
                System.err.println(err);
            }
        } while (true);
    }

    public static double inputADouble(String mess, String err, double low) {
        do {
            try {
                double x = Double.parseDouble(inputAString(mess));
                if (x < low) {
                    throw new NumberFormatException();
                }
                return x;
            } catch (NumberFormatException nfE) {
                System.err.println(err);
            }
        } while (true);
    }

    public static int inputAInteger(String mess, String err, double low) {
        do {
            try {
                int x = Integer.parseInt(inputAString(mess));
                if (x < low) {
                    throw new NumberFormatException();
                }
                return x;
            } catch (NumberFormatException nfE) {
                System.err.println(err);
            }
        } while (true);
    }

    public static String inputAString(String mess, String err) {
        do {
            System.out.print(mess);
            String x = sc.nextLine();
            if (x.isEmpty()) {
                System.err.println(err);
            } else {
                return x;
            }
        } while (true);
    }

    public static int inputAnInteger(String mess) {
        do {
            try {
                return Integer.parseInt(inputAString(mess));
            } catch (NumberFormatException nfE) {
                return -1;
            }
        } while (true);
    }

    public static <T> void writeToFile(String pathFile, T object) throws IOException {
        File f = new File(pathFile);
        try (FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(object);
        }
    }

    public static <T> T readFromFile(String pathFile) throws IOException, ClassNotFoundException {
        T object = null;
        File f = new File(pathFile);
        try (FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            object = (T) ois.readObject();
        }
        return object;
    }

    public static <E> void displayArrayList(ArrayList<E> arrList, String header, String mess, String nullMess) {
        if (arrList == null) {
            System.err.println(nullMess);
        } else {
            System.out.println(mess);
            System.out.println(header);
            for (E e : arrList) {
                System.out.println(e);
            }
        }
    }

    public static boolean selectYesNo(String mess, String err, String yes, String no) {
        do {
            String x = inputAString(mess);
            if (x.equals(yes)) {
                return true;
            } else if (x.equals(no)) {
                return false;
            } else {
                System.err.println(err);
            }
        } while (true);
    }
}
