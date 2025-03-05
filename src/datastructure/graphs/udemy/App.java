package datastructure.graphs.udemy;

import datastructure.graphs.udemy.bfs.BFS;
import datastructure.graphs.udemy.bfs.Vertex;
import datastructure.graphs.udemy.webcrawler.WebCrawlerBFS;

public class App {
    public static void main(String[] args) {
        BFS bfs = new BFS();
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");

        a.addNeighbour(b);
        a.addNeighbour(f);
        a.addNeighbour(g);

        b.addNeighbour(a);
        b.addNeighbour(c);
        b.addNeighbour(d);

        c.addNeighbour(b);

        d.addNeighbour(b);
        d.addNeighbour(e);

        f.addNeighbour(a);

        g.addNeighbour(a);
        g.addNeighbour(h);

        h.addNeighbour(g);

        bfs.traverse(a);

        WebCrawlerBFS webCrawlerBFS = new WebCrawlerBFS();
        webCrawlerBFS.discoveredWeb("https://www.google.com/");
    }

}
