/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Microsoft Windows
 */
public class DataSudoku {

    private static int[][] saveValue;
    private static int[][] saveIndex;
    private static int[][] board;
    private static float level = 0;
    private static String time;
    private static String check;
    private static String fileRecord = "Champion.txt";
    private static String fileStatus = "Status.txt";
    private static String Easy;
    private static String Medium;
    private static String Diff;
    private static String SDiff;

    public DataSudoku() {
        saveValue = null;
        saveIndex = null;
        board = null;
    }

    public static void deleteFile() {
        File file = new File("Status.txt");
        if (file.delete()) {
            System.out.println(file.getName() + " is deleted!");
        } else {
            System.out.println("Delete operation is failed.");
        }
    }

    // Ghi file
    public static void writeFile(int[][] temp) {
        try {
            BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileStatus, true), "UTF8"));
            bf.write(level + "");
            bf.newLine();
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp.length; j++) {
                    bf.write(temp[i][j] + " ");
                }

                bf.newLine();
            }
            bf.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataSudoku.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataSudoku.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void writeStatus(String time, String check) {
        try {
            BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileStatus, true), "UTF8"));
            bf.write(time);
            bf.newLine();
            bf.write(check);
            bf.newLine();
            bf.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataSudoku.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataSudoku.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void writeGui(String[][] time) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("Champion.txt");
            BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileRecord), "UTF8"));
            for (int i = 0; i < 4; i++) {
                String str = time[i][0] + "," + time[i][1];
                bf.write(str);
                bf.newLine();
            }
            bf.close();
            fileWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataSudoku.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataSudoku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Đọc file
    public static float readFile() {

        float length = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileStatus), "UTF8"));
            time = br.readLine();
            check = br.readLine();
            //Lấy ra độ dài mảng
            length = Float.parseFloat(br.readLine());

            board = new int[(int) length][(int) length];
            if (saveValue == null || saveIndex == null) {
                saveValue = new int[(int) length][(int) length];
                saveIndex = new int[(int) length][(int) length];
            }
            String line;

            //Lấy ra mảng saveValue
            for (int j = 0; j < (int) length; j++) {
                line = br.readLine();

                String[] item = line.split(" ");

                for (int i = 0; i < (int) length; i++) {

                    saveValue[j][i] = Integer.parseInt(item[i]);

                }

            }
            br.readLine();

            //Lấy ra mảng board
            for (int j = 0; j < (int) length; j++) {
                line = br.readLine();

                String[] item = line.split(" ");

                for (int i = 0; i < (int) length; i++) {
                    board[j][i] = Integer.parseInt(item[i]);
                }

            }
            br.readLine();

            //Lấy ra mảng saveIndex
            for (int j = 0; j < (int) length; j++) {
                line = br.readLine();

                String[] item = line.split(" ");

                for (int i = 0; i < (int) length; i++) {
                    saveIndex[j][i] = Integer.parseInt(item[i]);
                }

            }
            br.close();
        } catch (FileNotFoundException ex) {
            File file = new File("Status.txt");

        } catch (IOException ex) {
            Logger.getLogger(DataSudoku.class.getName()).log(Level.SEVERE, null, ex);
        }

        return length;
    }

    public static boolean readGui() {
        Easy = null;
        Medium = null;
        Diff = null;
        SDiff = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileRecord), "UTF8"));

            Easy = br.readLine();
            Medium = br.readLine();
            Diff = br.readLine();
            SDiff = br.readLine();
            br.close();
        } catch (FileNotFoundException ex) {
            File file = new File("Status.txt");

        } catch (IOException ex) {
            Logger.getLogger(DataSudoku.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (Easy == null) {
            return false;
        }
        return true;
    }

    public static int[][] getSaveValue() {
        return saveValue;
    }

    public static int[][] getSaveIndex() {
        return saveIndex;
    }

    public static String getTime() {
        return time;
    }

    public static String getCheck() {
        return check;
    }

    public static String getEasy() {
        return Easy;
    }

    public static String getMedium() {
        return Medium;
    }

    public static String getDiff() {
        return Diff;
    }

    public static String getSDiff() {
        return SDiff;
    }

    public static int[][] getBoard() {
        return board;
    }

    public static void setLevel(float level) {
        DataSudoku.level = level;

        saveValue = new int[(int) level][(int) level];
        saveIndex = new int[(int) level][(int) level];
        board = new int[(int) level][(int) level];
    }

}
