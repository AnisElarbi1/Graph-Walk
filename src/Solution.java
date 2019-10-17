import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	
	 LinkedList<Integer> adj[];
	    String res = "";
	    char lable[] = {'A', 'B', 'C', 'D', 'E', 'A', 'B', 'C', 'D', 'E'};

	    Solution() {
	        adj = new LinkedList[10];
	        for (int i = 0; i < 10; i++) {
	            adj[i] = new LinkedList<>();
	        }
	    }

	    //Ajouter toutes les arêtes de notre graphe
	    void addArete(int src, int dest) {
	        adj[src].add(dest);
	        adj[dest].add(src);
	    }

	    //Vérifier la validité de chaine, et retourner la suite de valeurs si possible
	    boolean verifier(String s, int index) {
	        res = "";
	        res = res + Integer.toString(index);
	        boolean pos;
	        int i;
	        for (i = 1; i < s.length(); i++) {
	            pos = false;
	            for (Integer j : adj[index]) {
	                if (lable[j] == s.charAt(i)) {
	                    index = j;
	                    res += Integer.toString(j);
	                    pos = true;
	                }
	            }
	            if (!pos) {
	                return false;
	            }
	        }
	        return true;
	    }

	    //Décomposer le problème en de sous problèmes selon le premier caractère de chaine.
	    void walk(String s) {
	        switch (s.charAt(0)) {
	            case 'A':
	                if (verifier(s, 0) || verifier(s, 5)) {
	                    System.out.println(res);
	                } else {
	                    System.out.println("-1");
	                }   break;
	            case 'B':
	                if (verifier(s, 1) || verifier(s, 6)) {
	                    System.out.println(res);
	                } else {
	                    System.out.println("-1");
	                }   break;
	            case 'C':
	                if (verifier(s, 2) || verifier(s, 7)) {
	                    System.out.println(res);
	                } else {
	                    System.out.println("-1");
	                }   break;
	            case 'D':
	                if (verifier(s, 3) || verifier(s, 8)) {
	                    System.out.println(res);
	                } else {
	                    System.out.println("-1");
	                }   break;
	            default:
	                if (verifier(s, 4) || verifier(s, 9)) {
	                    System.out.println(res);
	                } else {
	                    System.out.println("-1");
	                }   break;
	        }
	    }

	    public static void main(String[] args) {
	    	Solution g = new Solution();
	    	System.out.println("Entrer la chaine");
	        Scanner sc = new Scanner(System.in);
	        g.addArete(0, 5);
	        g.addArete(0, 4);
	        g.addArete(0, 1);

	        g.addArete(1, 6);
	        g.addArete(1, 2);

	        g.addArete(2, 7);
	        g.addArete(2, 3);

	        g.addArete(3, 8);
	        g.addArete(3, 4);

	        g.addArete(4, 9);

	        g.addArete(5, 8);
	        g.addArete(5, 7);

	        g.addArete(6, 9);
	        g.addArete(6, 8);

	        g.addArete(7, 5);
	        g.addArete(7, 9);

	        String s = sc.next();
	        g.walk(s);

	    }
}
