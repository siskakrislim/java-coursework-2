//Name: Siska Kristanti Lim
//Student number: 170281939
import java.io.*;
import java.util.ArrayList;

public class SerializationUtil {
 
     public static ArrayList<DatedMatchResult> deserialize(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<DatedMatchResult> clubs = null;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        clubs = (ArrayList<DatedMatchResult>) in.readObject(); //casting to a parameterized type (in this case ArrayList<DatedMatchResult>. DatedMatchResult is the parameterized type) will always result in an unchecked warning from the compiler.
        in.close();
        return clubs;
    }
     
    public static void serialize(File file, ArrayList<DatedMatchResult> result) throws FileNotFoundException, IOException, ClassNotFoundException {
    	result = null;
    	ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
    	out.writeObject(result);
    	out.close();
    }
    
    private SerializationUtil() {
    }

}
