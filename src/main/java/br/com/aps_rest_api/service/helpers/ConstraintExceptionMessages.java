package br.com.aps_rest_api.service.helpers;

public class ConstraintExceptionMessages {

    public static String getConstraintExceptionMessage(String constraintName){
        final TipoConstraint tipoConstraint = TipoConstraint.fromString(constraintName);
        switch(tipoConstraint){
            case USUARIO_USERNAME:
                return "Usuário já cadastrado";
            case CLIENTE_EMAIL:
                return "E-mail já cadastrado";
            case CATEGORIA_DESCR:
                return "Categoria já cadastrada";
            default:
                return "Violação de contraint: "+constraintName;
        }
    }

}
