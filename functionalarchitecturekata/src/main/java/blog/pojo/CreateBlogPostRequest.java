package blog.pojo;

import com.openpojo.business.BusinessIdentity;
import com.openpojo.business.annotation.BusinessKey;

public class CreateBlogPostRequest {
    @BusinessKey
    private final long userId;
    @BusinessKey
    private final String title;

    public CreateBlogPostRequest(final long userId, final String title) {
        this.userId = userId;
        this.title = title;
    }

    public long getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
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
