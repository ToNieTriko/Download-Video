package org.example;

import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder proc = new ProcessBuilder("bash", "-c", "curl -L https://github.com/yt-dlp/yt-dlp/releases/latest/download/yt-dlp -o ~/yt-dlp\n" +
                "chmod +x ~/yt-dlp\n");
        Process process = proc.start();
        Scanner en = new Scanner(System.in);
        String path = System.getProperty("user.home") + "/yt-dlp";
        String video;
        String directory;
        String res = "";
        System.out.println("Entre com o link do vídeo: ");
        video = en.nextLine();
        System.out.println("Entre com o diretorio que deseja baixar: ");
        directory = en.nextLine();
        int num = -1;
        while (num < 0 || num >6) {
            System.out.println("1- 2160p \n2- 1440p \n3- 1080p \n4- 720p \n5- 480p \n6- 360p");
            num = en.nextInt();
        }
        switch (num){
            case 1: res = "2160"; break;
            case 2: res = "1440"; break;
            case 3: res = "1080"; break;
            case 4: res = "720"; break;
            case 5: res = "480"; break;
            case 6: res = "360"; break;
        }
        int aux = -1;
        while (aux < 0 || aux >1) {
            System.out.println("1- Mac \n2- Win");
            aux = en.nextInt();
        }
        if (aux ==1) {
            String Command = String.format("\"%s\" -P \"%s\" -f \"best[height<=%s][ext=mp4]\" \"%s\"", path, directory, res, video);

            ProcessBuilder pro = new ProcessBuilder("bash", "-c", Command);
            pro.redirectErrorStream(true);
            Process processo = pro.start();
            processo.waitFor();
            System.out.println("Download concluido");
        }
        else if (aux ==2){
            path = "C:\\yt-dlp\\yt-dlp.exe";
            String Command = String.format("\"%s\" -P \"%s\" -f \"best[height<=%s][ext=mp4]\" \"%s\"", path, directory, res, video);

            ProcessBuilder pro = new ProcessBuilder("cmd.exe", "/c", Command);
            pro.redirectErrorStream(true);
            Process processo = pro.start();
            processo.waitFor();
            System.out.println("Download concluido");
        }

    }
}