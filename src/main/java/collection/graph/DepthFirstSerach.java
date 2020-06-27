package collection.graph;

/**
 * 图的深度优先搜索算法
 *
 * @author chenxin
 */
public class DepthFirstSerach {
    private boolean[] marked;
    private int count;

    public DepthFirstSerach(Graph graph, int s) {
        marked = new boolean[graph.V()];
        dfs(graph, s);
    }

    private void dfs(Graph graph, int s) {
        marked[s] = true;
        count++;
        if (!marked[s]) {
            for (int m : graph.adj(s)) {
                if (!marked[m]) {
                    dfs(graph, m);
                }
            }
        }
    }

    public boolean marked(int m) {
        return marked[m];
    }

    public int count() {
        return count;
    }
}
