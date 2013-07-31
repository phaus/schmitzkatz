package de.mactunes.schmitzkatz;

import java.io.File;
import java.io.InputStream;
import de.mactunes.schmitzkatz.blog.posts.BlogPostCreator;
import de.mactunes.schmitzkatz.blog.BlogGenerator;
import de.mactunes.schmitzkatz.blog.Generator;
import de.mactunes.schmitzkatz.blog.RssGenerator;
import de.mactunes.schmitzkatz.blog.posts.BlogPost;
import java.util.Date;

public class Main {

    public static final String NEW_ARG_STR = "-new";
    public static final String GENERATE_ARG_STR = "-generate";
    private static final String PROPERTIES_PATH = File.separator + "settings.properties";

    public Main() {
    }

    private void printHelp() {
        System.out.println("\n\n\n\nUsage of the Schmitz blog engine:");
        System.out.println("---------------------------------\n\n");

        System.out.println("CREATING A NEW POST");
        System.out.println("java -jar Schmitz.jar -new \"Some new title\"");
        System.out.println("New blog entry is added in a directory called \'some-new-title\' "
                + "inside blog/Posts. Edit index.json inside some-new-title to change the blog post."
                + "Once finished writing the post you can generate the blog.\n\n");

        System.out.println("GENERATING THE BLOG");
        System.out.println("Once you have finished editing your posts you can generate your blog by running:");
        System.out.println("java -jar Schmitz.jar -generate");
        System.out.println("The command copies all files from blog/Templates and injects blog posts where apropriate."
                + "The resulting files are copied to blog/Generated.\n\n\n\n");
    }

    private BlogProperties loadProperties() {
        BlogProperties properties = new BlogProperties();
        InputStream is = this.getClass().getResourceAsStream(PROPERTIES_PATH);

        try {
            // We should autogenerate the settings.properties 
            properties.load(is);
        } catch (Exception ioe) {
            System.out.println("Warning: could not load settings.properties. Make sure it is in the same directory as this JAR.");
        }

        return properties;
    }

    private static void checkFolders() {
        File f;
        String[] folders = {BlogPost.TEMPLATES_PATH, BlogPost.GENERATED_PATH};
        for (String folder : folders) {
            f = new File(folder);
            if (!f.exists()) {
                f.mkdirs();
            }
        }
    }

    public static void main(String[] args) {
        Main app = new Main();
        BlogProperties properties = app.loadProperties();

        if (args.length == 0) {
            app.printHelp();
        } else {
            if (NEW_ARG_STR.equals(args[0])) {
                checkFolders();
                BlogPostCreator postCreator = new BlogPostCreator(properties);
                postCreator.createPost((args.length > 1) ? args[1] : null);
            } else if (GENERATE_ARG_STR.equals(args[0])) {
                Generator generator = new BlogGenerator(properties);
                generator.generate();
                generator = new RssGenerator(properties);
                generator.generate();
            }
        }
    }
}
