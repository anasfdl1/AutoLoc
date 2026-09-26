package tn.esprit.autoloc.domain;

public enum ModePaiement {

    CARTE(1),
    ESPECES(2),
    VIREMENT(3);

    private final int code;

    ModePaiement(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ModePaiement fromCode(int code) {
        for (ModePaiement mode : ModePaiement.values()) {
            if (mode.getCode() == code) {
                return mode;
            }
        }

        throw new IllegalArgumentException("Code inconnu : " + code);
    }
}