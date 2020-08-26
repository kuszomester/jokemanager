package hu.danubiusinfo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.threeten.bp.OffsetDateTime;

@AllArgsConstructor
@Getter
public class Joke {
    private final Long id;
    private final String content;
    private final OffsetDateTime createdAt;

}
