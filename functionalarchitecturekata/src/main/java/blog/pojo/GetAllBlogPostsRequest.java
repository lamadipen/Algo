package blog.pojo;

import com.openpojo.business.BusinessIdentity;
import com.openpojo.business.annotation.BusinessKey;

public class GetAllBlogPostsRequest {
    @BusinessKey
    private final long userId;

    public GetAllBlogPostsRequest(final long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
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
