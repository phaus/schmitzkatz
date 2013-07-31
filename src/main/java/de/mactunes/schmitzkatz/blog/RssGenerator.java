/**
 * RssGenerator 31.07.2013
 *
 * @author Philipp Haussleiter
 *
 */
package de.mactunes.schmitzkatz.blog;

import de.mactunes.schmitzkatz.BlogProperties;
import de.mactunes.schmitzkatz.blog.posts.BlogPost;
import java.io.File;
import java.text.SimpleDateFormat;

public class RssGenerator implements Generator {

    private BlogProperties blogProperties;
    private final static String RSS_FEED = BlogPost.GENERATED_PATH + File.separator + "index.xml";
    private static final String SERIALIZED_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat(SERIALIZED_DATE_FORMAT);

    public RssGenerator(BlogProperties blogProperties) {
        this.blogProperties = blogProperties;
    }

    public void generate() {
    }

    private String getRssHeader() {
        StringBuilder sb = new StringBuilder();

        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<rss version=\"2.0\"\n"
                + "	xmlns:content=\"http://purl.org/rss/1.0/modules/content/\"\n"
                + "	xmlns:wfw=\"http://wellformedweb.org/CommentAPI/\"\n"
                + "	xmlns:dc=\"http://purl.org/dc/elements/1.1/\"\n"
                + "	xmlns:atom=\"http://www.w3.org/2005/Atom\"\n"
                + "	xmlns:sy=\"http://purl.org/rss/1.0/modules/syndication/\"\n"
                + "	xmlns:slash=\"http://purl.org/rss/1.0/modules/slash/\"\n"
                + "	>\n"
                + "\n"
                + "<channel>\n"
                + "	<title>")
                .append(blogProperties.getProperty("title"))
                .append("</title>\n"
                + "	<atom:link href=\"")
                .append(blogProperties.getProperty("url"))
                .append("/feed/\" rel=\"self\" type=\"application/rss+xml\" />\n"
                + "	<link>")
                .append(blogProperties.getProperty("url"))
                .append("</link>\n"
                + "	<description>")
                .append(blogProperties.getProperty("description"))
                .append("</description>\n"
                + "	<lastBuildDate>")
                .append(blogProperties.getRFC822Date())
                .append("</lastBuildDate>\n"
                + "	<language>")
                .append(blogProperties.getProperty("language"))
                .append("</language>\n"
                + "	<sy:updatePeriod>hourly</sy:updatePeriod>\n"
                + "	<sy:updateFrequency>1</sy:updateFrequency>\n"
                + "	<generator>schmitzkatz</generator>");
        return sb.toString();
    }

    private String getRssFooter() {
        StringBuilder sb = new StringBuilder();
        sb.append("</channel>\n"
                + "</rss>");
        return sb.toString();
    }
}
