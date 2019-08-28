package modelo.BaseDatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class in {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = new StringTokenizer("");

    public static String next() throws IOException {
        while(!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken().trim().toLowerCase();
    }

    public static int nextInt() throws IOException{
        return Integer.parseInt(next());
    }

    public static String nextLine() throws IOException{
        return br.readLine().trim().toLowerCase();
    }
}
