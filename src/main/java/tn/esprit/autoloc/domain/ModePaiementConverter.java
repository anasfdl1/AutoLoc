package tn.esprit.autoloc.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ModePaiementConverter
        implements AttributeConverter<ModePaiement, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ModePaiement modePaiement) {
        if (modePaiement == null) {
            return null;
        }

        return modePaiement.getCode();
    }

    @Override
    public ModePaiement convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return ModePaiement.fromCode(code);
    }
}