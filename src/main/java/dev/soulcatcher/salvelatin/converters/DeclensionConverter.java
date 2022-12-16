package dev.soulcatcher.salvelatin.converters;

import dev.soulcatcher.salvelatin.models.Declension;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class DeclensionConverter implements AttributeConverter<Declension, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Declension declension) {
        return (declension == null) ?
                null :
                declension.getCode();
    }

    @Override
    public Declension convertToEntityAttribute(Integer code) {
        return (code == null) ?
                null :
                Stream.of(Declension.values())
                        .filter(c -> c.getCode() == code)
                        .findFirst()
                        .orElseThrow(IllegalArgumentException::new);
    }
}
