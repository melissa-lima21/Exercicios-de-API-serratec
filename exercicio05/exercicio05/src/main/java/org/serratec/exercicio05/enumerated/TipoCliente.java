package org.serratec.exercicio05.enumerated;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.serratec.exercicio05.exception.EnumValidationException;

public enum TipoCliente {
    BASICO,
    PREMIUM,
    VIP;

    @JsonCreator
    public static TipoCliente verifica(String value) throws EnumValidationException {
    	
    	if (value == null || value.trim().isEmpty()) { 
            return null; 
        }
    	
        for (TipoCliente c : values()) {
            if ( value.equals(c.name()))  {
                return c;
            }
        }
        
        throw new EnumValidationException("Tipo de Cliente inválido. Escolha entre: Básico, Premium ou VIP.");
           
    }
}
