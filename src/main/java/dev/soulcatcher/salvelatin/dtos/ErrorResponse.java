package dev.soulcatcher.salvelatin.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private int statusCode;
    private List<String> message;
    private LocalDateTime timestamp = LocalDateTime.now();

    public ErrorResponse(int statusCode, List<String> message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
