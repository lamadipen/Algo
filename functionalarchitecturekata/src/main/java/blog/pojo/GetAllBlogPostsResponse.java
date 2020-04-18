package blog.pojo;

import com.google.common.collect.Lists;
import com.openpojo.business.BusinessIdentity;
import com.openpojo.business.annotation.BusinessKey;

import java.util.List;

public class GetAllBlogPostsResponse {
    @BusinessKey
    private final Status status;
    @BusinessKey
    private final String message;
    @BusinessKey
    private final long userId;
    @BusinessKey
    private final List<String> titles;

    public GetAllBlogPostsResponse(final Status status, final long userId, final List<String> titles) {
        this.status = status;
        this.userId = userId;
        this.titles = titles;
        this.message = "";
    }

    public GetAllBlogPostsResponse(final Status status, final long userId, final String message) {
        this.status = status;
        this.message = message;
        this.userId = userId;
        titles = Lists.newArrayList();
    }

    public Status getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public long getUserId() {
        return userId;
    }

    public List<String> getTitles() {
        return titles;
    }

    @Override
    public int hashCode() {
        return BusinessIdentity.getHashCode(this);
    }

    @Override
    public boolean equals(final Object obj) {
        return BusinessIdentity.areEqual(obj, this);
    }

    @Override
    public String toString() {
        return BusinessIdentity.toString(this);
    }
}
