package com.deux.duohaeduo.enums;

public enum GameModes {

    NORMAL(490L, "빠른 대전"),
    RANKED_SOLO(420L, "솔랭"),
    RANKED_FLEX(440L, "자유 5:5 랭크"),
    ARAM(450L, "칼바람"),
    PICK_URF(1900L, "U.R.F."),
    RANDOM_URF(900L, "U.R.F."),
    ONE_FOR_ALL_CHAMPION(1020L, "단일 챔피언");

    private final Long id;
    private final String gameMode;

    GameModes(Long id, String gameMode) {
        this.id = id;
        this.gameMode = gameMode;
    }

    public Long getId() {
        return id;
    }

    public String getGameMode() {
        return gameMode;
    }

    public static String findById(Long id) {
        for (GameModes gameModes : values()) {
            if (gameModes.getId().equals(id)) {
                return gameModes.getGameMode();
            }
        }
        return null;
    }

}
