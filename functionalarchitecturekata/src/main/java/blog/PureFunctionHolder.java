package blog;

import blog.pojo.GetAllBlogPostsRequest;
import blog.pojo.GetAllBlogPostsResponse;
import blog.pojo.Status;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PureFunctionHolder {

    public GetAllBlogPostsResponse getAllTransformedPost(JSONArray jsonArray, GetAllBlogPostsRequest request) {
        List<JSONObject> collect =
                filterPostByUserId(jsonArray, request);

        if (collect.isEmpty()) {
            return new GetAllBlogPostsResponse(Status.ERROR, request.getUserId(), Collections.emptyList());
        }
        List<String> collect1 = collectAllTitles(collect);

        return new GetAllBlogPostsResponse(Status.OK, request.getUserId(), collect1);
    }

    private List<JSONObject> filterPostByUserId(JSONArray jsonArray, GetAllBlogPostsRequest request) {
        return (List<JSONObject>) jsonArray
                .stream()
                .map(item -> (JSONObject) item)
                .filter(item -> filterByUser((JSONObject) item, request))
                //.map(item -> transformToPostResponse((JSONObject) item))
                .collect(Collectors.toList());
    }

    private List<String> collectAllTitles(List<JSONObject> collect) {
        return collect
                .stream()
                .map(item -> transformToString((JSONObject) item))
                .collect(Collectors.toList());
    }

    private boolean filterByUser(JSONObject item, GetAllBlogPostsRequest request) {
        long userId = (long) item.get("userId");
        return userId == request.getUserId();
    }

    private String transformToString(JSONObject item) {
        return (String) item.get("title");
    }
}

//Dependency
//Mutation
