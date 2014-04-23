package com.ldbc.driver.workloads.ldbc.socnet.interactive;

import com.ldbc.driver.Operation;

import java.util.Arrays;
import java.util.Date;

public class LdbcUpdate6AddPost extends Operation<Object> {
    private final long postId;
    private final String imageFile;
    private final Date creationDate;
    private final String locationIp;
    private final String browserUsed;
    private final String language;
    private final String content;
    private final int length; // <--- why is this needed? it wasn't in the previous old schema
    private final long authorPersonId;
    private final long forumId;
    private final long countryId; // <--- country ID?
    private final long[] tagIds;

    public LdbcUpdate6AddPost(long postId,
                              String imageFile,
                              Date creationDate,
                              String locationIp,
                              String browserUsed,
                              String language,
                              String content,
                              int length,
                              long authorPersonId,
                              long forumId,
                              long countryId,
                              long[] tagIds) {
        this.postId = postId;
        this.imageFile = imageFile;
        this.creationDate = creationDate;
        this.locationIp = locationIp;
        this.browserUsed = browserUsed;
        this.language = language;
        this.content = content;
        this.length = length;
        this.authorPersonId = authorPersonId;
        this.forumId = forumId;
        this.countryId = countryId;
        this.tagIds = tagIds;
    }

    public long postId() {
        return postId;
    }

    public String imageFile() {
        return imageFile;
    }

    public Date creationDate() {
        return creationDate;
    }

    public String locationIp() {
        return locationIp;
    }

    public String browserUsed() {
        return browserUsed;
    }

    public String language() {
        return language;
    }

    public String content() {
        return content;
    }

    public int length() {
        return length;
    }

    public long authorPersonId() {
        return authorPersonId;
    }

    public long forumId() {
        return forumId;
    }

    public long countryId() {
        return countryId;
    }

    public long[] tagIds() {
        return tagIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LdbcUpdate6AddPost that = (LdbcUpdate6AddPost) o;

        if (authorPersonId != that.authorPersonId) return false;
        if (countryId != that.countryId) return false;
        if (forumId != that.forumId) return false;
        if (length != that.length) return false;
        if (postId != that.postId) return false;
        if (browserUsed != null ? !browserUsed.equals(that.browserUsed) : that.browserUsed != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (imageFile != null ? !imageFile.equals(that.imageFile) : that.imageFile != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        if (locationIp != null ? !locationIp.equals(that.locationIp) : that.locationIp != null) return false;
        if (!Arrays.equals(tagIds, that.tagIds)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (postId ^ (postId >>> 32));
        result = 31 * result + (imageFile != null ? imageFile.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (locationIp != null ? locationIp.hashCode() : 0);
        result = 31 * result + (browserUsed != null ? browserUsed.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + length;
        result = 31 * result + (int) (authorPersonId ^ (authorPersonId >>> 32));
        result = 31 * result + (int) (forumId ^ (forumId >>> 32));
        result = 31 * result + (int) (countryId ^ (countryId >>> 32));
        result = 31 * result + (tagIds != null ? Arrays.hashCode(tagIds) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LdbcUpdate6AddPost{" +
                "postId=" + postId +
                ", imageFile='" + imageFile + '\'' +
                ", creationDate=" + creationDate +
                ", locationIp='" + locationIp + '\'' +
                ", browserUsed='" + browserUsed + '\'' +
                ", language='" + language + '\'' +
                ", content='" + content + '\'' +
                ", length=" + length +
                ", authorPersonId=" + authorPersonId +
                ", forumId=" + forumId +
                ", countryId=" + countryId +
                ", tagIds=" + Arrays.toString(tagIds) +
                '}';
    }
}
