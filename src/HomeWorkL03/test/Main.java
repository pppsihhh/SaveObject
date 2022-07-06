package HomeWorkL03.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class Main {
    public static void main(String[] args) {
        Sample s = new Sample(23, 34, true, false, "Save", "Not save", 'y', 'n');
        System.out.println(s);
        File file = new File("Save.bin");

        try {
            FileOutputStream fos = new FileOutputStream(file);

            try {
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                SaveAndRead ss = new SaveAndRead();
                ss.save(s, oos);
            } catch (Throwable var11) {
                try {
                    fos.close();
                } catch (Throwable var10) {
                    var11.addSuppressed(var10);
                }

                throw var11;
            }

            fos.close();
        } catch (Exception var12) {
            var12.printStackTrace();
        }

        Sample s2 = new Sample();

        try {
            FileInputStream fis = new FileInputStream(file);

            try {
                ObjectInputStream ois = new ObjectInputStream(fis);
                s2 = (Sample)(new SaveAndRead()).read(ois);
            } catch (Throwable var8) {
                try {
                    fis.close();
                } catch (Throwable var7) {
                    var8.addSuppressed(var7);
                }

                throw var8;
            }

            fis.close();
        } catch (Exception var9) {
            var9.printStackTrace();
        }

        System.out.println(s2);
    }
}
