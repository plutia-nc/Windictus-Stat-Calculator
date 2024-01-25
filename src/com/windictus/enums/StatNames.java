package com.windictus.enums;

public enum StatNames {
    ATT("Attack Damage (either ATT or M.ATT)"),
    SPD("Attack Speed"),
    BAL("Balance"),
    ADDMG("Additional Damage"),
    CRIT("Critical Rate"),
    CDMG("Critical Damage");

    private final String description;

    StatNames(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
