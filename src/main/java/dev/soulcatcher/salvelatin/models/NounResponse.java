package dev.soulcatcher.salvelatin.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NounResponse {
    private UUID nounId;
    private long timestamp = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

    public NounResponse(Noun noun) {
        this.nounId = noun.getNounId();
    }
}
