package datastructure.graphs.udemy.webcrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawlerBFS {

    private Queue<String> queue; // Contains url
    private List<String> discoveredWebsiteLinks; // visited urls

    public WebCrawlerBFS(){
        this.queue = new LinkedList<>();
        this.discoveredWebsiteLinks = new ArrayList<>();
    }

    public void discoveredWeb(String root){
        this.queue.add(root);
        this.discoveredWebsiteLinks.add(root); // visited

        while (!queue.isEmpty()){
            String v = this.queue.remove();
            String rawHtml = readUrl(v);
            String regexp = "https://(\\w+\\.)*(\\w+)";

            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(rawHtml);

            while (matcher.find()){
                String w = matcher.group();
                if (!discoveredWebsiteLinks.contains(w)){
                    discoveredWebsiteLinks.add(w);
                    System.out.println("Website found = "+ w);
                    queue.add(w);
                }
            }
        }
    }

    private String readUrl(String v) {
        StringBuilder rawHtml = new StringBuilder("");
        try {
            URL url = new URL(v);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = "";
            while ((line = reader.readLine()) != null){
                rawHtml.append(line);
            }
            reader.close();
        }catch (Exception e){
            System.out.println("Problem while crawling the website " + e.getMessage());
        }
        return rawHtml.toString();
    }
}
