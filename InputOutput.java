
package checkagency;
import java.io.*;
public interface InputOutput {
   
    public void ReadProperty(String fileName ) throws FileNotFoundException ;
    public void saveIntoFile(String fileName) throws IOException , WrongTypeException;
}
