package blog.pojo;

import com.openpojo.business.BusinessIdentity;
import com.openpojo.business.annotation.BusinessKey;

public class CreateBlogPostResponse {
    @BusinessKey
    private final Status status;
    @BusinessKey
    private final String message;
    @BusinessKey
    private final long userId;

    public CreateBlogPostResponse(final Status status, final long userId) {
        this.status = status;
        this.userId = userId;
        this.message = "";
    }

    public CreateBlogPostResponse(final Status status, final String message, final long userId) {
        this.status = status;
        this.message = message;
        this.userId = userId;
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
