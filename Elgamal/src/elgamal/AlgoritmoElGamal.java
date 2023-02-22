package elgamal;

/**
 * Autor: Jefferson Alquinga
 */

import java.math.BigInteger;
import java.util.Random;
import java.util.StringTokenizer;

class AlgoritmoElGamal {

    // Declaración de variables de instancia
    private BigInteger p, g, a, A, y1, y2;

    // Constructor por defecto que inicializa los valores de p, g y a
    public AlgoritmoElGamal() {
        p = new BigInteger("14893003337626352152463254152616458181260144281");
        g = new BigInteger("4893003337626352152463254152616458181260144281");
        a = new BigInteger("438900337326351225463351152616458181260144193");
    }

    // Método que cifra un mensaje dado
    public String bigEncrypt(String message) {
        byte[] b = message.getBytes();
        BigInteger[][] cipher = new BigInteger[b.length][2];
        StringBuffer sb = new StringBuffer();
        
        // Cifra cada byte del mensaje utilizando el método de cifrado ElGamal y guarda los resultados en un arreglo de BigInteger
        for (int i = 0; i < b.length; i++) {
            encrypt(new BigInteger(b[i] + ""));
            cipher[i][0] = y1;
            cipher[i][1] = y2;
        }
        
        // Convierte los resultados de cifrado en una cadena de texto con formato
        for (int i = 0; i < b.length; i++) {
            sb.append("(");
            sb.append(cipher[i][0]);
            sb.append(",");
            sb.append(cipher[i][1]);
            sb.append(")\n");
        }
        return (new String(sb));
    }

    // Método que descifra un mensaje cifrado
    public String bigDecrypt(String c) {
        StringTokenizer st = new StringTokenizer(c, "(),\n");
        BigInteger[] temp = new BigInteger[2];
        StringBuffer plain = new StringBuffer();
        
        // Descifra cada par de valores de cifrado utilizando el método de descifrado ElGamal y construye la cadena de texto original
        while (st.hasMoreTokens()) {
            temp[0] = new BigInteger(st.nextToken());
            temp[1] = new BigInteger(st.nextToken());
            plain.append((char) (decrypt(temp)).intValue());
        }
        return new String(plain);
    }    
    
    // Método que devuelve un número primo aleatorio menor que n
    public BigInteger randomPrimeBigInteger(BigInteger n) {
        Random rnd = new Random();
        int maxNumBitLength = n.bitLength();
        BigInteger aRandomBigInt;
        do {
            aRandomBigInt = new BigInteger(maxNumBitLength, rnd);
        } while (aRandomBigInt.compareTo(n) > 0 && aRandomBigInt.isProbablePrime(1)); 
        return aRandomBigInt;
    }

    // Métodos getters y setters para las variables de instancia a
    public BigInteger getA() {
        return a;
    }

    public void setA(BigInteger a) {
        this.a = a;
    }

    public BigInteger geta() {
        return a;
    }

    public void seta(BigInteger a) {
        this.a = a;
    }
    
    // Método que cifra un valor m utilizando el método de cifrado ElGamal

    public void encrypt(BigInteger m) {
        BigInteger b = randomPrimeBigInteger(new BigInteger("29996224275833"));
        A = g.modPow(a, p);
        y1 = g.modPow(b, p);
        y2 = m.xor(A.modPow(b, p));

    }
    public BigInteger decrypt(BigInteger[] b) {
        return b[1].xor(b[0].modPow(a, p));
    }
    
    
}
