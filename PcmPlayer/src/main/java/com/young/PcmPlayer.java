package com.young;

import javax.sound.sampled.*;
import java.io.FileInputStream;
import java.io.IOException;

public class PcmPlayer {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        if (args.length == 0) {
            args = new String[1];
            args[0] = "PcmPlayer/src/main/resources/20230717140509_test_1.pcm";//文件路径
        }
        try {
            FileInputStream fis = new FileInputStream(args[0]);
            AudioFormat.Encoding encoding = new AudioFormat.Encoding("PCM_SIGNED");
            AudioFormat format = new AudioFormat(encoding, 8000, 16, 1, 2, 8000, false);//编码格式，采样率，每个样本的位数，声道，帧长（字节），帧数，是否按big-endian字节顺序存储
            SourceDataLine auline = null;
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            try {
                auline = (SourceDataLine) AudioSystem.getLine(info);
                auline.open(format);
            } catch (LineUnavailableException e) {
                e.printStackTrace();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            auline.start();
            byte[] b = new byte[256];
            try {
                while (fis.read(b) > 0) {
                    auline.write(b, 0, b.length);
                    System.out.println(1);
                }
                auline.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}