package concept;
public class N_M_JavaTutor {
	    static int[] arr;
	    static boolean[] visit;
	    static StringBuilder sb = new StringBuilder();

        	    public static void main(String[] args) {
        	        int N = 4;
        	        int M = 2;

        	        arr = new int[M];
        	        visit = new boolean[N + 1];

        	        dfs(N, M, 0);

        	        System.out.println(sb.toString());
        	    }
        	    static void dfs(int N, int M, int depth) {
        	        if (depth == M) {
            	            for (int val : arr) {
                	                sb.append(val).append(' ');
                	            }
            	            sb.append('\n');
            	            return;
            	        }
        	        for (int i = 1; i <= N; i++) {
                        if (!visit[i]) {
                	                visit[i] = true;
                	                arr[depth] = i;
                	                dfs(N, M, depth + 1);
                	                visit[i] = false;
						}
					}
            }
	}