package br.com.aps_rest_api.helpers;

public enum TipoConstraint {
    USUARIO_USERNAME("ck_username_unique"),
    CLIENTE_EMAIL("ck_email_unique");

    private final String constraintName;

    TipoConstraint(String constraintName){
        this.constraintName = constraintName;
    }

    public String getConstraintName() {
        return constraintName;
    }
    public static TipoConstraint fromString(String constraintName) {
        for (TipoConstraint tipoConstraint : TipoConstraint.values()) {
            if (tipoConstraint.constraintName.equalsIgnoreCase(constraintName)) {
                return tipoConstraint;
            }
        }
        throw new IllegalArgumentException("No value find for constraint "+constraintName);
    }

}
