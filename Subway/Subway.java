import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

// http://codeforces.com/contest/131/problem/D
public class Main {

    public static void main(String[] Args) {
        new Main().solve();
    }

    Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

    void solve() {
        int n = si();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<Integer>());
        }

        for (int i = 1; i <= n; i++) {
            int a = si(), b = si();
            map.get(a).add(b);
            map.get(b).add(a);
        }
        // find cycle
        for (int i = 1; i <= n; i++) {
            int[] v = new int[n + 1];
            is = false;
            dfsCycle(i, i, i, v);
        }
        // find distance
        int[] visited = new int[n + 1], distance = new int[n + 1];
        bfsDistance(cycle.get(0), visited, distance);
        for (int i = 1; i <= n; i++) 
            System.out.print(distance[i] + " ");

    }

    boolean found = false;

    void bfsDistance(int start, int[] v, int[] d) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        
        while (!q.isEmpty()) {
            int now = q.remove();
            v[now] = 1;
            for (int to : map.get(now)) {
                if (v[to] == 0) {
                    d[to] = d[now] + 1;
                    if (cycle.contains(to)){
                        d[to] = 0;
                    }
                    q.add(to);
                }
            }
        }
    }

    ArrayList<Integer> cycle = new ArrayList<Integer>();
    boolean is = false;

    void dfsCycle(int start, int from, int now, int[] v) {
        v[now] = 1;
        for (int to : map.get(now)) {
            if (to == start && start != from) {
                cycle.add(start);
                is = true;
                return;
            } else if (v[to] == 0) {
                if (is)
                    return;
                else
                    dfsCycle(start, now, to, v);
            }
        }
    }

    static int toi(Object s) {
        return Integer.parseInt(s.toString());
    }

    // ----------------------- Library ------------------------
    static int[] dx_ = { 0, 0, 1, -1 };
    static int[] dy_ = { 1, -1, 0, 0 };

    static int[] dx = { 1, 0, -1, 1, -1, 1, 0, -1 }, dy = { 1, 1, 1, 0, 0, -1,
            -1, -1 };
    static Scanner scan = new Scanner(System.in);
    static int INF = 2147483647;

    // finds GCD of a and b using Euclidian algorithm
    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }

    static List<String> toList(String[] a) {
        return Arrays.asList(a);
    }

    static String[] toArray(List<String> a) {
        String[] o = new String[a.size()];
        a.toArray(o);
        return o;
    }

    static int[] pair(int... a) {
        return a;
    }

    static int si() {
        return scan.nextInt();
    }

    static String ss() {
        return scan.nextLine();
    }

    static int[] sai(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++)
            a[i] = si();

        return a;
    }

    static int[] sai_(int n) {
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = si();

        return a;
    }

    static String[] sas(int n) {
        String[] a = new String[n];
        for (int i = 0; i < a.length; i++)
            a[i] = ss();
        return a;
    }

    static Object[][] _sm1(int r, int c) {
        Object[][] a = new Object[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                a[i][j] = scan.next();
        return a;
    }

    static Object[][] _sm2(int r) {
        Object[][] a = new Object[r][3];
        for (int i = 0; i < r; i++)
            a[i] = new Object[] { ss(), ss(), ss() };
        return a;
    }
}