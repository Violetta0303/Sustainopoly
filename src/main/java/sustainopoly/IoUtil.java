package sustainopoly;

import java.io.*;

/**
 * IO Util
 */
public class IoUtil {

    public static void save2File(Object object, String path) {
        ObjectOutputStream oos = null;
        try  {
            oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(object);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static Object readFromFile(String path) {
        ObjectInputStream ois = null;
        try  {
            ois = new ObjectInputStream(new FileInputStream(path));
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                if (ois!=null){
                    ois.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
