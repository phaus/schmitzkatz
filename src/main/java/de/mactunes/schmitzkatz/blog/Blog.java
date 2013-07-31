/**
 * Blog 31.07.2013
 *
 * @author Philipp Haussleiter
 *
 */
package de.mactunes.schmitzkatz.blog;

import de.mactunes.schmitzkatz.blog.posts.BlogPost;
import java.io.File;
import java.io.FilenameFilter;

public class Blog {

    private static final String DS_STORE = ".DS_Store";

    public static String[] fetchCurrentBlogPostDirectories() {
        File postsDir = new File(BlogPost.POSTS_PATH);
        return postsDir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return dir.isDirectory() && !DS_STORE.equals(name);
            }
        });
    }
}
