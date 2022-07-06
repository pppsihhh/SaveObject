package HomeWorkL03.test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class SaveAndRead {
    public SaveAndRead() {
    }

    public void save(Object o, ObjectOutputStream out) throws IOException {
        String saveData = "";
        Class<?> cc = o.getClass();
        String name = cc.getName();
        saveData = saveData + name + "-";
        Field[] ff = cc.getDeclaredFields();
        Field[] var7 = ff;
        int var8 = ff.length;

        for(int var9 = 0; var9 < var8; ++var9) {
            Field f = var7[var9];
            if (f.isAnnotationPresent(Save.class)) {
                int mod = f.getModifiers();
                if (Modifier.isPrivate(mod)) {
                    f.setAccessible(true);
                }

                saveData = saveData + f.getName() + "=";

                try {
                    if (f.getType() == Integer.TYPE) {
                        saveData = saveData + f.getInt(o) + ":";
                    }

                    if (f.getType() == String.class) {
                        saveData = saveData + (String)f.get(o) + ":";
                    }

                    if (f.getType() == Boolean.TYPE) {
                        saveData = saveData + f.getBoolean(o) + ":";
                    }

                    if (f.getType() == Character.TYPE) {
                        saveData = saveData + f.getChar(o) + ":";
                    }

                    if (f.getType() == Long.TYPE) {
                        saveData = saveData + f.getLong(o);
                    }
                } catch (Exception var13) {
                    var13.printStackTrace();
                }
            }
        }

        out.writeObject(saveData);
    }

    public Object read(ObjectInputStream in) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String s = (String)in.readObject();
        String[] ss = s.split("-");
        Object aa = Class.forName(ss[0]).getConstructor().newInstance();
        Class<?> cl = aa.getClass();
        Field[] fields = cl.getDeclaredFields();
        String[] sss = ss[1].split(":");
        String[] var8 = sss;
        int var9 = sss.length;

        for(int var10 = 0; var10 < var9; ++var10) {
            String s1 = var8[var10];
            String[] s2 = s1.split("=");
            Field[] var13 = fields;
            int var14 = fields.length;

            for(int var15 = 0; var15 < var14; ++var15) {
                Field f = var13[var15];
                if (f.getName().equals(s2[0])) {
                    int mod = f.getModifiers();
                    if (Modifier.isPrivate(mod)) {
                        f.setAccessible(true);
                    }

                    try {
                        if (f.getType() == Integer.TYPE) {
                            f.setInt(aa, Integer.parseInt(s2[1]));
                        }

                        if (f.getType() == String.class) {
                            f.set(aa, s2[1]);
                        }

                        if (f.getType() == Boolean.TYPE) {
                            f.setBoolean(aa, Boolean.parseBoolean(s2[1]));
                        }

                        if (f.getType() == Character.TYPE) {
                            f.setChar(aa, s2[1].charAt(0));
                        }

                        if (f.getType() == Long.TYPE) {
                            f.setLong(aa, Long.parseLong(s2[1]));
                        }
                    } catch (Exception var19) {
                        var19.printStackTrace();
                    }
                }
            }
        }

        return aa;
    }
}
