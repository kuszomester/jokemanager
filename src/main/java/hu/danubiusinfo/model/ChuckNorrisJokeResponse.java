package hu.danubiusinfo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.util.Objects;

/**
 * ChuckNorrisJokeResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-08-21T16:03:39.600Z[GMT]")


public class ChuckNorrisJokeResponse {
    @JsonProperty("url")
    private String url = null;

    @JsonProperty("createdAt")
    private OffsetDateTime createdAt = null;

    @JsonProperty("content")
    private String content = null;

    public ChuckNorrisJokeResponse url(String url) {
        this.url = url;
        return this;
    }

    /**
     * Get url
     *
     * @return url
     **/
    @ApiModelProperty(example = "https://api.chucknorris.io/jokes/-NBlNyx1TUyW_8lGoOkvOw", value = "")

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ChuckNorrisJokeResponse createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get createdAt
     *
     * @return createdAt
     **/
    @ApiModelProperty(example = "2018-03-20T09:12:28Z", value = "")

    @Valid
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ChuckNorrisJokeResponse content(String content) {
        this.content = content;
        return this;
    }

    /**
     * Get content
     *
     * @return content
     **/
    @ApiModelProperty(example = "Chuck Norris invented cranberries by uprooting a cherry tree and throwing it into a farm pond. ", value = "")

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChuckNorrisJokeResponse chuckNorrisJokeResponse = (ChuckNorrisJokeResponse) o;
        return Objects.equals(this.url, chuckNorrisJokeResponse.url) &&
                Objects.equals(this.createdAt, chuckNorrisJokeResponse.createdAt) &&
                Objects.equals(this.content, chuckNorrisJokeResponse.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, createdAt, content);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ChuckNorrisJokeResponse {\n");

        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
