package blog;

import blog.pojo.CreateBlogPostRequest;
import blog.pojo.CreateBlogPostResponse;
import blog.pojo.GetAllBlogPostsRequest;
import blog.pojo.GetAllBlogPostsResponse;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class BlogControllerImpl implements BlogController {


    @Override
    public GetAllBlogPostsResponse getAllPosts(GetAllBlogPostsRequest request) {
        try {
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("/Users/lamad/workspace/functionalarchitecturekata/src/main/resources/post.json"));

            PureFunctionHolder pureFunctionHolder = new PureFunctionHolder();
            //pure function call
            return pureFunctionHolder.getAllTransformedPost(jsonArray, request);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CreateBlogPostResponse createPost(CreateBlogPostRequest request) {
        return null;
    }
}
