package com.deux.duohaeduo.enums;

public enum SummonerSpells {

    SUMMONER_BARRIER("SummonerBarrier", 21L),
    SUMMONER_BOOST("SummonerBoost", 1L),
    SUMMONER_CHERRY_FLASH("SummonerCherryFlash", 2202L),
    SUMMONER_CHERRY_HOLD("SummonerCherryHold", 2201L),
    SUMMONER_DOT("SummonerDot", 14L),
    SUMMONER_EXHAUST("SummonerExhaust", 3L),
    SUMMONER_FLASH("SummonerFlash", 4L),
    SUMMONER_HASTE("SummonerHaste", 6L),
    SUMMONER_HEAL("SummonerHeal", 7L),
    SUMMONER_MANA("SummonerMana", 13L),
    SUMMONER_PORO_RECALL("SummonerPoroRecall", 30L),
    SUMMONER_PORO_THROW("SummonerPoroThrow", 31L),
    SUMMONER_SMITE("SummonerSmite", 11L),
    SUMMONER_SNOW_URF_SNOWBALL_MARK("SummonerSnowURFSnowball_Mark", 39L),
    SUMMONER_SNOWBALL("SummonerSnowball", 32L),
    SUMMONER_TELEPORT("SummonerTeleport", 12L),
    SUMMONER_ULT_BOOK_PLACEHOLDER("Summoner_UltBookPlaceholder", 54L),
    SUMMONER_ULT_BOOK_SMITE_PLACEHOLDER("Summoner_UltBookSmitePlaceholder", 55L);

    private final String id;
    private final Long key;

    SummonerSpells(String id, Long key) {
        this.id = id;
        this.key = key;
    }

    public String getId() {
        return id;
    }

    public Long getKey() {
        return key;
    }

    public static String findByKey(Long key) {
        for (SummonerSpells spell : values()) {
            if (spell.getKey().equals(key)) {
                return spell.id;
            }
        }
        return null;
    }

}
