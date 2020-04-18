package blog;

import blog.pojo.CreateBlogPostRequest;
import blog.pojo.CreateBlogPostResponse;
import blog.pojo.GetAllBlogPostsRequest;
import blog.pojo.GetAllBlogPostsResponse;

public interface BlogController {
    /**
     * Returns list of all blog post titles for request.userId if the request.userId is a valid user in the user.json file
     *
     * @param request
     *
     * @return GetAllBlogPostsResponse with request.userId, all of the user's blog post titles, Status.OK and empty message if request.userId exists in user.json file
     * @return GetAllBlogPostsResponse with request.userId, empty list of titles, Status.ERROR and message="User does not exist" if request.userId does not exist in user.json file
     */
    GetAllBlogPostsResponse getAllPosts(GetAllBlogPostsRequest request);

    /**
     * Appends the new blog post to the post.json file if the request.userId is a valid user in the user.json file
     *
     * @param request
     *
     * @return CreateBlogPostResponse with request.userId, Status.OK, and empty message if request.userId exists in user.json file
     * @return CreateBlogPostResponse with request.userId, Status.ERROR, and message="User does not exist" if request.userId does not exist in user.json file
     */
    CreateBlogPostResponse createPost(CreateBlogPostRequest request);
}