import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ScrapeIt {
    public String url;
    public Document doc;
    public Element pageElements;
    ArrayList<String> hyperLinks;

    // instantiate the rss feed to be scraped
    public ScrapeIt() throws FileNotFoundException {}

    // GET rss feed
    public Document getDoc(String url) throws IOException {
        return Jsoup.connect(url).get();
    }

    public ArrayList<String> scrapeDoc(Document doc) {
        // html selector
        Elements pageElements = doc.select("item");

        // create the arraylist for the scraped data
        ArrayList<String> hyperLinks = new ArrayList<>();

        // add scraped data to arraylist
        for(Element e:pageElements) {
            hyperLinks.add("------");
            hyperLinks.add("Date: " + e.select("pubDate").text());
            hyperLinks.add("Title: " + e.select("title").text());
            hyperLinks.add("Address: " + e.select("link").text());
        }

        return hyperLinks;
    }

    public ArrayList<String> doItAll(String url) throws IOException {
        // does all the above ^^
        this.doc = getDoc(url);
        return scrapeDoc(this.doc);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public Element getPageElements() {
        return pageElements;
    }

    public void setPageElements(Element pageElements) {
        this.pageElements = pageElements;
    }

    public ArrayList<String> getHyperLinks() {
        return hyperLinks;
    }

    public void setHyperLinks(ArrayList<String> hyperLinks) {
        this.hyperLinks = hyperLinks;
    }
}
