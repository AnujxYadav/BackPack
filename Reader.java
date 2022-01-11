import java.io.*;
import java.util.*;

class Reader{
    
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    static String nextline() throws IOException {
        return reader.readLine();
    }


    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TO DO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextint() throws IOException {
        return Integer.parseInt( next() );
    }
    
    static long nextlong() throws IOException {
        return Long.parseLong( next() );
    }
    
    static double nextdouble() throws IOException {
        return Double.parseDouble( next() );
    }

    static float nextfloat() throws IOException {
        return Float.parseFloat( next() );
    }

    static Boolean nextboolean() throws IOException {
        return Boolean.parseBoolean( next() );
    }
    
}
