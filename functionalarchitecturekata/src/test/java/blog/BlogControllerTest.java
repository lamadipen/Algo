package blog;

import blog.pojo.CreateBlogPostRequest;
import blog.pojo.GetAllBlogPostsRequest;
import blog.pojo.GetAllBlogPostsResponse;
import blog.pojo.Status;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class BlogControllerTest {

    @Test
    public void getAllPosts() {
        BlogController blogController = new BlogControllerImpl();
        GetAllBlogPostsRequest request = new GetAllBlogPostsRequest(1);

        GetAllBlogPostsResponse actual = blogController.getAllPosts(request);
        GetAllBlogPostsResponse expected = new GetAllBlogPostsResponse(Status.OK, 1, Arrays.asList("Hey there!", "Life update"));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllPostsError() {
        BlogController blogController = new BlogControllerImpl();
        GetAllBlogPostsRequest request = new GetAllBlogPostsRequest(100);

        GetAllBlogPostsResponse actual = blogController.getAllPosts(request);
        GetAllBlogPostsResponse expected = new GetAllBlogPostsResponse(Status.ERROR, 100, Collections.emptyList());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createPost() {
        BlogController blogController = new BlogControllerImpl();
        CreateBlogPostRequest request = new CreateBlogPostRequest(10,"SomeTitle");

        blogController.createPost(request);
    }
}
