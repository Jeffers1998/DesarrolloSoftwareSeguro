package encodedecodemd5;

import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;

/**
 * Esta clase proporciona métodos para encriptar y desencriptar cadenas de texto
 * usando MD5 como algoritmo de hash para generar una clave de cifrado.
 */
public class Main {

    /**
     * Este método encripta una cadena de texto usando MD5 como algoritmo de hash
     * para generar una clave de cifrado.
     *
     * @param secretKey la clave secreta que se usará para encriptar la cadena.
     * @param cadena la cadena que se va a encriptar.
     * @return la cadena encriptada.
     */
    public static String ecnode(String secretKey, String cadena) {
        String encriptacion = "";
        try {
            // Se crea una instancia del algoritmo de hash MD5
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            // Se calcula el hash de la clave secreta y se convierte a un arreglo de bytes
            byte[] llavePassword = md5.digest(secretKey.getBytes("utf-8"));
            // Se copian los primeros 24 bytes del hash de la clave secreta para usarlos como clave de cifrado
            byte[] BytesKey = Arrays.copyOf(llavePassword, 24);
            // Se crea una instancia de la clave de cifrado
            SecretKey key = new SecretKeySpec(BytesKey, "DESede");
            // Se crea una instancia del cifrador DESede en modo cifrado
            Cipher cifrado = Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE, key);
            // Se convierte la cadena de texto a un arreglo de bytes
            byte[] plainTextBytes = cadena.getBytes("utf-8");
            // Se cifra la cadena de texto
            byte[] buf = cifrado.doFinal(plainTextBytes);
            // Se convierte el arreglo de bytes cifrado a una cadena en formato Base64
            byte[] base64Bytes = Base64.encodeBase64(buf);
            encriptacion = new String(base64Bytes);
        } catch (Exception ex) {
            // Si ocurre una excepción, se muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "Algo salió mal");
        }
        return encriptacion;
    }

    /**
     * Este método desencripta una cadena de texto que ha sido encriptada con el
     * método ecnode().
     *
     * @param secretKey la clave secreta que se usó para encriptar la cadena original.
     * @param cadenaEncriptada la cadena encriptada que se va a desencriptar.
     * @return la cadena desencriptada.
     */

            
            public static String deecnode(String secretKey, String cadenaEncriptada) {
    String desencriptacion = "";
    try {
        // Decodifica la cadena encriptada utilizando Base64 y la convierte en bytes
        byte[] message = Base64.decodeBase64(cadenaEncriptada.getBytes("utf-8"));
        
        // Calcula el hash MD5 de la clave secreta y lo convierte en una clave de 24 bytes
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] digestOfPassword = md5.digest(secretKey.getBytes("utf-8"));
        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        
        // Crea una instancia de la clave secreta utilizando la clave de 24 bytes y el algoritmo DESede
        SecretKey key = new SecretKeySpec(keyBytes, "DESede");
        
        // Crea una instancia del cifrado DESede en modo descifrado (DECRIPT_MODE)
        Cipher decipher = Cipher.getInstance("DESede");
        decipher.init(Cipher.DECRYPT_MODE, key);
        
        // Descifra el mensaje utilizando el cifrado DESede y lo convierte de bytes a una cadena de texto
        byte[] plainText = decipher.doFinal(message);
        desencriptacion = new String(plainText, "UTF-8");

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Algo salió mal");
    }
    return desencriptacion;
}

public static void main(String[] args) {
    // Clave secreta para encriptar y desencriptar el mensaje
    String secretKey = "claveencriptar";
    
    // Mensaje a encriptar
    String cadenaAEncriptar = "Este es un mensaje secreto";
    System.out.println("Cadena a encriptar: " + cadenaAEncriptar);
    
    // Encripta el mensaje utilizando la función ecnode y lo imprime en consola
    String cadenaEncriptada = ecnode(secretKey, cadenaAEncriptar);
    System.out.println("Cadena encriptada con MD5: " + cadenaEncriptada); 
    
    // Desencripta la cadena encriptada utilizando la función deecnode y lo imprime en consola
    String cadenaDesencriptada = deecnode(secretKey, cadenaEncriptada);
    System.out.println("Cadena desencriptada: " + cadenaDesencriptada); 
}
}    