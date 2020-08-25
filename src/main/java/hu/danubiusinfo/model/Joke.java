package hu.danubiusinfo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.threeten.bp.OffsetDateTime;

@AllArgsConstructor
@Getter
public class Joke {
    private Long id;
    private String content;
    private OffsetDateTime createdAt;

}
