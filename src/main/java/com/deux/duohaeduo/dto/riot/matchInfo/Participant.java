package com.deux.duohaeduo.dto.riot.matchInfo;

import com.deux.duohaeduo.dto.riot.matchInfo.enums.IndividualPosition;
import com.deux.duohaeduo.dto.riot.matchInfo.enums.Lane;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Participant {

    private long allInPings;
    private long assistMePings;
    private long assists;
    private long baronKills;
    private long basicPings;
    private long bountyLevel;
    private Challenges challenges;
    private long champExperience;
    private long champLevel;
    private long championID;
    private String championName;
    private long championTransform;
    private long commandPings;
    private long consumablesPurchased;
    private long damageDealtToBuildings;
    private long damageDealtToObjectives;
    private long damageDealtToTurrets;
    private long damageSelfMitigated;
    private long dangerPings;
    private long deaths;
    private long detectorWardsPlaced;
    private long doubleKills;
    private long dragonKills;
    private boolean eligibleForProgression;
    private long enemyMissingPings;
    private long enemyVisionPings;
    private boolean firstBloodAssist;
    private boolean firstBloodKill;
    private boolean firstTowerAssist;
    private boolean firstTowerKill;
    private boolean gameEndedInEarlySurrender;
    private boolean gameEndedInSurrender;
    private long getBackPings;
    private long goldEarned;
    private long goldSpent;
    private long holdPings;
    private IndividualPosition individualPosition;
    private long inhibitorKills;
    private long inhibitorTakedowns;
    private long inhibitorsLost;
    private long item0;
    private long item1;
    private long item2;
    private long item3;
    private long item4;
    private long item5;
    private long item6;
    private long itemsPurchased;
    private long killingSprees;
    private long kills;
    private Lane lane;
    private long largestCriticalStrike;
    private long largestKillingSpree;
    private long largestMultiKill;
    private long longestTimeSpentLiving;
    private long magicDamageDealt;
    private long magicDamageDealtToChampions;
    private long magicDamageTaken;
    private Map<String, Long> missions;
    private long needVisionPings;
    private long neutralMinionsKilled;
    private long nexusKills;
    private long nexusLost;
    private long nexusTakedowns;
    private long objectivesStolen;
    private long objectivesStolenAssists;
    private long onMyWayPings;
    private long participantID;
    private long pentaKills;
    private Perks perks;
    private long physicalDamageDealt;
    private long physicalDamageDealtToChampions;
    private long physicalDamageTaken;
    private long placement;
    private long playerAugment1;
    private long playerAugment2;
    private long playerAugment3;
    private long playerAugment4;
    private long playerScore0;
    private long playerScore1;
    private long playerScore10;
    private long playerScore11;
    private long playerScore2;
    private long playerScore3;
    private long playerScore4;
    private long playerScore5;
    private long playerScore6;
    private long playerScore7;
    private long playerScore8;
    private long playerScore9;
    private long playerSubteamID;
    private long profileIcon;
    private long pushPings;
    private String puuid;
    private long quadraKills;
    private String riotIDGameName;
    private String riotIDTagline;
    private String role;
    private long sightWardsBoughtInGame;
    private long spell1Casts;
    private long spell2Casts;
    private long spell3Casts;
    private long spell4Casts;
    private long subteamPlacement;
    private long summoner1Casts;
    private long summoner1ID;
    private long summoner2Casts;
    private long summoner2ID;
    private String summonerID;
    private long summonerLevel;
    private String summonerName;
    private boolean teamEarlySurrendered;
    private long teamID;
    private String teamPosition;
    private long timeCCingOthers;
    private long timePlayed;
    private long totalAllyJungleMinionsKilled;
    private long totalDamageDealt;
    private long totalDamageDealtToChampions;
    private long totalDamageShieldedOnTeammates;
    private long totalDamageTaken;
    private long totalEnemyJungleMinionsKilled;
    private long totalHeal;
    private long totalHealsOnTeammates;
    private long totalMinionsKilled;
    private long totalTimeCCDealt;
    private long totalTimeSpentDead;
    private long totalUnitsHealed;
    private long tripleKills;
    private long trueDamageDealt;
    private long trueDamageDealtToChampions;
    private long trueDamageTaken;
    private long turretKills;
    private long turretTakedowns;
    private long turretsLost;
    private long unrealKills;
    private long visionClearedPings;
    private long visionScore;
    private long visionWardsBoughtInGame;
    private long wardsKilled;
    private long wardsPlaced;
    private boolean win;


    @JsonProperty("allInPings")
    public long getAllInPings() {
        return allInPings;
    }

    @JsonProperty("allInPings")
    public void setAllInPings(long value) {
        this.allInPings = value;
    }

    @JsonProperty("assistMePings")
    public long getAssistMePings() {
        return assistMePings;
    }

    @JsonProperty("assistMePings")
    public void setAssistMePings(long value) {
        this.assistMePings = value;
    }

    @JsonProperty("assists")
    public long getAssists() {
        return assists;
    }

    @JsonProperty("assists")
    public void setAssists(long value) {
        this.assists = value;
    }

    @JsonProperty("baronKills")
    public long getBaronKills() {
        return baronKills;
    }

    @JsonProperty("baronKills")
    public void setBaronKills(long value) {
        this.baronKills = value;
    }

    @JsonProperty("basicPings")
    public long getBasicPings() {
        return basicPings;
    }

    @JsonProperty("basicPings")
    public void setBasicPings(long value) {
        this.basicPings = value;
    }

    @JsonProperty("bountyLevel")
    public long getBountyLevel() {
        return bountyLevel;
    }

    @JsonProperty("bountyLevel")
    public void setBountyLevel(long value) {
        this.bountyLevel = value;
    }

    @JsonProperty("challenges")
    public Challenges getChallenges() {
        return challenges;
    }

    @JsonProperty("challenges")
    public void setChallenges(Challenges value) {
        this.challenges = value;
    }

    @JsonProperty("champExperience")
    public long getChampExperience() {
        return champExperience;
    }

    @JsonProperty("champExperience")
    public void setChampExperience(long value) {
        this.champExperience = value;
    }

    @JsonProperty("champLevel")
    public long getChampLevel() {
        return champLevel;
    }

    @JsonProperty("champLevel")
    public void setChampLevel(long value) {
        this.champLevel = value;
    }

    @JsonProperty("championId")
    public long getChampionID() {
        return championID;
    }

    @JsonProperty("championId")
    public void setChampionID(long value) {
        this.championID = value;
    }

    @JsonProperty("championName")
    public String getChampionName() {
        return championName;
    }

    @JsonProperty("championName")
    public void setChampionName(String value) {
        this.championName = value;
    }

    @JsonProperty("championTransform")
    public long getChampionTransform() {
        return championTransform;
    }

    @JsonProperty("championTransform")
    public void setChampionTransform(long value) {
        this.championTransform = value;
    }

    @JsonProperty("commandPings")
    public long getCommandPings() {
        return commandPings;
    }

    @JsonProperty("commandPings")
    public void setCommandPings(long value) {
        this.commandPings = value;
    }

    @JsonProperty("consumablesPurchased")
    public long getConsumablesPurchased() {
        return consumablesPurchased;
    }

    @JsonProperty("consumablesPurchased")
    public void setConsumablesPurchased(long value) {
        this.consumablesPurchased = value;
    }

    @JsonProperty("damageDealtToBuildings")
    public long getDamageDealtToBuildings() {
        return damageDealtToBuildings;
    }

    @JsonProperty("damageDealtToBuildings")
    public void setDamageDealtToBuildings(long value) {
        this.damageDealtToBuildings = value;
    }

    @JsonProperty("damageDealtToObjectives")
    public long getDamageDealtToObjectives() {
        return damageDealtToObjectives;
    }

    @JsonProperty("damageDealtToObjectives")
    public void setDamageDealtToObjectives(long value) {
        this.damageDealtToObjectives = value;
    }

    @JsonProperty("damageDealtToTurrets")
    public long getDamageDealtToTurrets() {
        return damageDealtToTurrets;
    }

    @JsonProperty("damageDealtToTurrets")
    public void setDamageDealtToTurrets(long value) {
        this.damageDealtToTurrets = value;
    }

    @JsonProperty("damageSelfMitigated")
    public long getDamageSelfMitigated() {
        return damageSelfMitigated;
    }

    @JsonProperty("damageSelfMitigated")
    public void setDamageSelfMitigated(long value) {
        this.damageSelfMitigated = value;
    }

    @JsonProperty("dangerPings")
    public long getDangerPings() {
        return dangerPings;
    }

    @JsonProperty("dangerPings")
    public void setDangerPings(long value) {
        this.dangerPings = value;
    }

    @JsonProperty("deaths")
    public long getDeaths() {
        return deaths;
    }

    @JsonProperty("deaths")
    public void setDeaths(long value) {
        this.deaths = value;
    }

    @JsonProperty("detectorWardsPlaced")
    public long getDetectorWardsPlaced() {
        return detectorWardsPlaced;
    }

    @JsonProperty("detectorWardsPlaced")
    public void setDetectorWardsPlaced(long value) {
        this.detectorWardsPlaced = value;
    }

    @JsonProperty("doubleKills")
    public long getDoubleKills() {
        return doubleKills;
    }

    @JsonProperty("doubleKills")
    public void setDoubleKills(long value) {
        this.doubleKills = value;
    }

    @JsonProperty("dragonKills")
    public long getDragonKills() {
        return dragonKills;
    }

    @JsonProperty("dragonKills")
    public void setDragonKills(long value) {
        this.dragonKills = value;
    }

    @JsonProperty("eligibleForProgression")
    public boolean getEligibleForProgression() {
        return eligibleForProgression;
    }

    @JsonProperty("eligibleForProgression")
    public void setEligibleForProgression(boolean value) {
        this.eligibleForProgression = value;
    }

    @JsonProperty("enemyMissingPings")
    public long getEnemyMissingPings() {
        return enemyMissingPings;
    }

    @JsonProperty("enemyMissingPings")
    public void setEnemyMissingPings(long value) {
        this.enemyMissingPings = value;
    }

    @JsonProperty("enemyVisionPings")
    public long getEnemyVisionPings() {
        return enemyVisionPings;
    }

    @JsonProperty("enemyVisionPings")
    public void setEnemyVisionPings(long value) {
        this.enemyVisionPings = value;
    }

    @JsonProperty("firstBloodAssist")
    public boolean getFirstBloodAssist() {
        return firstBloodAssist;
    }

    @JsonProperty("firstBloodAssist")
    public void setFirstBloodAssist(boolean value) {
        this.firstBloodAssist = value;
    }

    @JsonProperty("firstBloodKill")
    public boolean getFirstBloodKill() {
        return firstBloodKill;
    }

    @JsonProperty("firstBloodKill")
    public void setFirstBloodKill(boolean value) {
        this.firstBloodKill = value;
    }

    @JsonProperty("firstTowerAssist")
    public boolean getFirstTowerAssist() {
        return firstTowerAssist;
    }

    @JsonProperty("firstTowerAssist")
    public void setFirstTowerAssist(boolean value) {
        this.firstTowerAssist = value;
    }

    @JsonProperty("firstTowerKill")
    public boolean getFirstTowerKill() {
        return firstTowerKill;
    }

    @JsonProperty("firstTowerKill")
    public void setFirstTowerKill(boolean value) {
        this.firstTowerKill = value;
    }

    @JsonProperty("gameEndedInEarlySurrender")
    public boolean getGameEndedInEarlySurrender() {
        return gameEndedInEarlySurrender;
    }

    @JsonProperty("gameEndedInEarlySurrender")
    public void setGameEndedInEarlySurrender(boolean value) {
        this.gameEndedInEarlySurrender = value;
    }

    @JsonProperty("gameEndedInSurrender")
    public boolean getGameEndedInSurrender() {
        return gameEndedInSurrender;
    }

    @JsonProperty("gameEndedInSurrender")
    public void setGameEndedInSurrender(boolean value) {
        this.gameEndedInSurrender = value;
    }

    @JsonProperty("getBackPings")
    public long getGetBackPings() {
        return getBackPings;
    }

    @JsonProperty("getBackPings")
    public void setGetBackPings(long value) {
        this.getBackPings = value;
    }

    @JsonProperty("goldEarned")
    public long getGoldEarned() {
        return goldEarned;
    }

    @JsonProperty("goldEarned")
    public void setGoldEarned(long value) {
        this.goldEarned = value;
    }

    @JsonProperty("goldSpent")
    public long getGoldSpent() {
        return goldSpent;
    }

    @JsonProperty("goldSpent")
    public void setGoldSpent(long value) {
        this.goldSpent = value;
    }

    @JsonProperty("holdPings")
    public long getHoldPings() {
        return holdPings;
    }

    @JsonProperty("holdPings")
    public void setHoldPings(long value) {
        this.holdPings = value;
    }

    @JsonProperty("individualPosition")
    public IndividualPosition getIndividualPosition() {
        return individualPosition;
    }

    @JsonProperty("individualPosition")
    public void setIndividualPosition(IndividualPosition value) {
        this.individualPosition = value;
    }

    @JsonProperty("inhibitorKills")
    public long getInhibitorKills() {
        return inhibitorKills;
    }

    @JsonProperty("inhibitorKills")
    public void setInhibitorKills(long value) {
        this.inhibitorKills = value;
    }

    @JsonProperty("inhibitorTakedowns")
    public long getInhibitorTakedowns() {
        return inhibitorTakedowns;
    }

    @JsonProperty("inhibitorTakedowns")
    public void setInhibitorTakedowns(long value) {
        this.inhibitorTakedowns = value;
    }

    @JsonProperty("inhibitorsLost")
    public long getInhibitorsLost() {
        return inhibitorsLost;
    }

    @JsonProperty("inhibitorsLost")
    public void setInhibitorsLost(long value) {
        this.inhibitorsLost = value;
    }

    @JsonProperty("item0")
    public long getItem0() {
        return item0;
    }

    @JsonProperty("item0")
    public void setItem0(long value) {
        this.item0 = value;
    }

    @JsonProperty("item1")
    public long getItem1() {
        return item1;
    }

    @JsonProperty("item1")
    public void setItem1(long value) {
        this.item1 = value;
    }

    @JsonProperty("item2")
    public long getItem2() {
        return item2;
    }

    @JsonProperty("item2")
    public void setItem2(long value) {
        this.item2 = value;
    }

    @JsonProperty("item3")
    public long getItem3() {
        return item3;
    }

    @JsonProperty("item3")
    public void setItem3(long value) {
        this.item3 = value;
    }

    @JsonProperty("item4")
    public long getItem4() {
        return item4;
    }

    @JsonProperty("item4")
    public void setItem4(long value) {
        this.item4 = value;
    }

    @JsonProperty("item5")
    public long getItem5() {
        return item5;
    }

    @JsonProperty("item5")
    public void setItem5(long value) {
        this.item5 = value;
    }

    @JsonProperty("item6")
    public long getItem6() {
        return item6;
    }

    @JsonProperty("item6")
    public void setItem6(long value) {
        this.item6 = value;
    }

    @JsonProperty("itemsPurchased")
    public long getItemsPurchased() {
        return itemsPurchased;
    }

    @JsonProperty("itemsPurchased")
    public void setItemsPurchased(long value) {
        this.itemsPurchased = value;
    }

    @JsonProperty("killingSprees")
    public long getKillingSprees() {
        return killingSprees;
    }

    @JsonProperty("killingSprees")
    public void setKillingSprees(long value) {
        this.killingSprees = value;
    }

    @JsonProperty("kills")
    public long getKills() {
        return kills;
    }

    @JsonProperty("kills")
    public void setKills(long value) {
        this.kills = value;
    }

    @JsonProperty("lane")
    public Lane getLane() {
        return lane;
    }

    @JsonProperty("lane")
    public void setLane(Lane value) {
        this.lane = value;
    }

    @JsonProperty("largestCriticalStrike")
    public long getLargestCriticalStrike() {
        return largestCriticalStrike;
    }

    @JsonProperty("largestCriticalStrike")
    public void setLargestCriticalStrike(long value) {
        this.largestCriticalStrike = value;
    }

    @JsonProperty("largestKillingSpree")
    public long getLargestKillingSpree() {
        return largestKillingSpree;
    }

    @JsonProperty("largestKillingSpree")
    public void setLargestKillingSpree(long value) {
        this.largestKillingSpree = value;
    }

    @JsonProperty("largestMultiKill")
    public long getLargestMultiKill() {
        return largestMultiKill;
    }

    @JsonProperty("largestMultiKill")
    public void setLargestMultiKill(long value) {
        this.largestMultiKill = value;
    }

    @JsonProperty("longestTimeSpentLiving")
    public long getLongestTimeSpentLiving() {
        return longestTimeSpentLiving;
    }

    @JsonProperty("longestTimeSpentLiving")
    public void setLongestTimeSpentLiving(long value) {
        this.longestTimeSpentLiving = value;
    }

    @JsonProperty("magicDamageDealt")
    public long getMagicDamageDealt() {
        return magicDamageDealt;
    }

    @JsonProperty("magicDamageDealt")
    public void setMagicDamageDealt(long value) {
        this.magicDamageDealt = value;
    }

    @JsonProperty("magicDamageDealtToChampions")
    public long getMagicDamageDealtToChampions() {
        return magicDamageDealtToChampions;
    }

    @JsonProperty("magicDamageDealtToChampions")
    public void setMagicDamageDealtToChampions(long value) {
        this.magicDamageDealtToChampions = value;
    }

    @JsonProperty("magicDamageTaken")
    public long getMagicDamageTaken() {
        return magicDamageTaken;
    }

    @JsonProperty("magicDamageTaken")
    public void setMagicDamageTaken(long value) {
        this.magicDamageTaken = value;
    }

    @JsonProperty("missions")
    public Map<String, Long> getMissions() {
        return missions;
    }

    @JsonProperty("missions")
    public void setMissions(Map<String, Long> value) {
        this.missions = value;
    }

    @JsonProperty("needVisionPings")
    public long getNeedVisionPings() {
        return needVisionPings;
    }

    @JsonProperty("needVisionPings")
    public void setNeedVisionPings(long value) {
        this.needVisionPings = value;
    }

    @JsonProperty("neutralMinionsKilled")
    public long getNeutralMinionsKilled() {
        return neutralMinionsKilled;
    }

    @JsonProperty("neutralMinionsKilled")
    public void setNeutralMinionsKilled(long value) {
        this.neutralMinionsKilled = value;
    }

    @JsonProperty("nexusKills")
    public long getNexusKills() {
        return nexusKills;
    }

    @JsonProperty("nexusKills")
    public void setNexusKills(long value) {
        this.nexusKills = value;
    }

    @JsonProperty("nexusLost")
    public long getNexusLost() {
        return nexusLost;
    }

    @JsonProperty("nexusLost")
    public void setNexusLost(long value) {
        this.nexusLost = value;
    }

    @JsonProperty("nexusTakedowns")
    public long getNexusTakedowns() {
        return nexusTakedowns;
    }

    @JsonProperty("nexusTakedowns")
    public void setNexusTakedowns(long value) {
        this.nexusTakedowns = value;
    }

    @JsonProperty("objectivesStolen")
    public long getObjectivesStolen() {
        return objectivesStolen;
    }

    @JsonProperty("objectivesStolen")
    public void setObjectivesStolen(long value) {
        this.objectivesStolen = value;
    }

    @JsonProperty("objectivesStolenAssists")
    public long getObjectivesStolenAssists() {
        return objectivesStolenAssists;
    }

    @JsonProperty("objectivesStolenAssists")
    public void setObjectivesStolenAssists(long value) {
        this.objectivesStolenAssists = value;
    }

    @JsonProperty("onMyWayPings")
    public long getOnMyWayPings() {
        return onMyWayPings;
    }

    @JsonProperty("onMyWayPings")
    public void setOnMyWayPings(long value) {
        this.onMyWayPings = value;
    }

    @JsonProperty("participantId")
    public long getParticipantID() {
        return participantID;
    }

    @JsonProperty("participantId")
    public void setParticipantID(long value) {
        this.participantID = value;
    }

    @JsonProperty("pentaKills")
    public long getPentaKills() {
        return pentaKills;
    }

    @JsonProperty("pentaKills")
    public void setPentaKills(long value) {
        this.pentaKills = value;
    }

    @JsonProperty("perks")
    public Perks getPerks() {
        return perks;
    }

    @JsonProperty("perks")
    public void setPerks(Perks value) {
        this.perks = value;
    }

    @JsonProperty("physicalDamageDealt")
    public long getPhysicalDamageDealt() {
        return physicalDamageDealt;
    }

    @JsonProperty("physicalDamageDealt")
    public void setPhysicalDamageDealt(long value) {
        this.physicalDamageDealt = value;
    }

    @JsonProperty("physicalDamageDealtToChampions")
    public long getPhysicalDamageDealtToChampions() {
        return physicalDamageDealtToChampions;
    }

    @JsonProperty("physicalDamageDealtToChampions")
    public void setPhysicalDamageDealtToChampions(long value) {
        this.physicalDamageDealtToChampions = value;
    }

    @JsonProperty("physicalDamageTaken")
    public long getPhysicalDamageTaken() {
        return physicalDamageTaken;
    }

    @JsonProperty("physicalDamageTaken")
    public void setPhysicalDamageTaken(long value) {
        this.physicalDamageTaken = value;
    }

    @JsonProperty("placement")
    public long getPlacement() {
        return placement;
    }

    @JsonProperty("placement")
    public void setPlacement(long value) {
        this.placement = value;
    }

    @JsonProperty("playerAugment1")
    public long getPlayerAugment1() {
        return playerAugment1;
    }

    @JsonProperty("playerAugment1")
    public void setPlayerAugment1(long value) {
        this.playerAugment1 = value;
    }

    @JsonProperty("playerAugment2")
    public long getPlayerAugment2() {
        return playerAugment2;
    }

    @JsonProperty("playerAugment2")
    public void setPlayerAugment2(long value) {
        this.playerAugment2 = value;
    }

    @JsonProperty("playerAugment3")
    public long getPlayerAugment3() {
        return playerAugment3;
    }

    @JsonProperty("playerAugment3")
    public void setPlayerAugment3(long value) {
        this.playerAugment3 = value;
    }

    @JsonProperty("playerAugment4")
    public long getPlayerAugment4() {
        return playerAugment4;
    }

    @JsonProperty("playerAugment4")
    public void setPlayerAugment4(long value) {
        this.playerAugment4 = value;
    }

    @JsonProperty("playerScore0")
    public long getPlayerScore0() {
        return playerScore0;
    }

    @JsonProperty("playerScore0")
    public void setPlayerScore0(long value) {
        this.playerScore0 = value;
    }

    @JsonProperty("playerScore1")
    public long getPlayerScore1() {
        return playerScore1;
    }

    @JsonProperty("playerScore1")
    public void setPlayerScore1(long value) {
        this.playerScore1 = value;
    }

    @JsonProperty("playerScore10")
    public long getPlayerScore10() {
        return playerScore10;
    }

    @JsonProperty("playerScore10")
    public void setPlayerScore10(long value) {
        this.playerScore10 = value;
    }

    @JsonProperty("playerScore11")
    public long getPlayerScore11() {
        return playerScore11;
    }

    @JsonProperty("playerScore11")
    public void setPlayerScore11(long value) {
        this.playerScore11 = value;
    }

    @JsonProperty("playerScore2")
    public long getPlayerScore2() {
        return playerScore2;
    }

    @JsonProperty("playerScore2")
    public void setPlayerScore2(long value) {
        this.playerScore2 = value;
    }

    @JsonProperty("playerScore3")
    public long getPlayerScore3() {
        return playerScore3;
    }

    @JsonProperty("playerScore3")
    public void setPlayerScore3(long value) {
        this.playerScore3 = value;
    }

    @JsonProperty("playerScore4")
    public long getPlayerScore4() {
        return playerScore4;
    }

    @JsonProperty("playerScore4")
    public void setPlayerScore4(long value) {
        this.playerScore4 = value;
    }

    @JsonProperty("playerScore5")
    public long getPlayerScore5() {
        return playerScore5;
    }

    @JsonProperty("playerScore5")
    public void setPlayerScore5(long value) {
        this.playerScore5 = value;
    }

    @JsonProperty("playerScore6")
    public long getPlayerScore6() {
        return playerScore6;
    }

    @JsonProperty("playerScore6")
    public void setPlayerScore6(long value) {
        this.playerScore6 = value;
    }

    @JsonProperty("playerScore7")
    public long getPlayerScore7() {
        return playerScore7;
    }

    @JsonProperty("playerScore7")
    public void setPlayerScore7(long value) {
        this.playerScore7 = value;
    }

    @JsonProperty("playerScore8")
    public long getPlayerScore8() {
        return playerScore8;
    }

    @JsonProperty("playerScore8")
    public void setPlayerScore8(long value) {
        this.playerScore8 = value;
    }

    @JsonProperty("playerScore9")
    public long getPlayerScore9() {
        return playerScore9;
    }

    @JsonProperty("playerScore9")
    public void setPlayerScore9(long value) {
        this.playerScore9 = value;
    }

    @JsonProperty("playerSubteamId")
    public long getPlayerSubteamID() {
        return playerSubteamID;
    }

    @JsonProperty("playerSubteamId")
    public void setPlayerSubteamID(long value) {
        this.playerSubteamID = value;
    }

    @JsonProperty("profileIcon")
    public long getProfileIcon() {
        return profileIcon;
    }

    @JsonProperty("profileIcon")
    public void setProfileIcon(long value) {
        this.profileIcon = value;
    }

    @JsonProperty("pushPings")
    public long getPushPings() {
        return pushPings;
    }

    @JsonProperty("pushPings")
    public void setPushPings(long value) {
        this.pushPings = value;
    }

    @JsonProperty("puuid")
    public String getPuuid() {
        return puuid;
    }

    @JsonProperty("puuid")
    public void setPuuid(String value) {
        this.puuid = value;
    }

    @JsonProperty("quadraKills")
    public long getQuadraKills() {
        return quadraKills;
    }

    @JsonProperty("quadraKills")
    public void setQuadraKills(long value) {
        this.quadraKills = value;
    }

    @JsonProperty("riotIdGameName")
    public String getRiotIDGameName() {
        return riotIDGameName;
    }

    @JsonProperty("riotIdGameName")
    public void setRiotIDGameName(String value) {
        this.riotIDGameName = value;
    }

    @JsonProperty("riotIdTagline")
    public String getRiotIDTagline() {
        return riotIDTagline;
    }

    @JsonProperty("riotIdTagline")
    public void setRiotIDTagline(String value) {
        this.riotIDTagline = value;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String value) {
        this.role = value;
    }

    @JsonProperty("sightWardsBoughtInGame")
    public long getSightWardsBoughtInGame() {
        return sightWardsBoughtInGame;
    }

    @JsonProperty("sightWardsBoughtInGame")
    public void setSightWardsBoughtInGame(long value) {
        this.sightWardsBoughtInGame = value;
    }

    @JsonProperty("spell1Casts")
    public long getSpell1Casts() {
        return spell1Casts;
    }

    @JsonProperty("spell1Casts")
    public void setSpell1Casts(long value) {
        this.spell1Casts = value;
    }

    @JsonProperty("spell2Casts")
    public long getSpell2Casts() {
        return spell2Casts;
    }

    @JsonProperty("spell2Casts")
    public void setSpell2Casts(long value) {
        this.spell2Casts = value;
    }

    @JsonProperty("spell3Casts")
    public long getSpell3Casts() {
        return spell3Casts;
    }

    @JsonProperty("spell3Casts")
    public void setSpell3Casts(long value) {
        this.spell3Casts = value;
    }

    @JsonProperty("spell4Casts")
    public long getSpell4Casts() {
        return spell4Casts;
    }

    @JsonProperty("spell4Casts")
    public void setSpell4Casts(long value) {
        this.spell4Casts = value;
    }

    @JsonProperty("subteamPlacement")
    public long getSubteamPlacement() {
        return subteamPlacement;
    }

    @JsonProperty("subteamPlacement")
    public void setSubteamPlacement(long value) {
        this.subteamPlacement = value;
    }

    @JsonProperty("summoner1Casts")
    public long getSummoner1Casts() {
        return summoner1Casts;
    }

    @JsonProperty("summoner1Casts")
    public void setSummoner1Casts(long value) {
        this.summoner1Casts = value;
    }

    @JsonProperty("summoner1Id")
    public long getSummoner1ID() {
        return summoner1ID;
    }

    @JsonProperty("summoner1Id")
    public void setSummoner1ID(long value) {
        this.summoner1ID = value;
    }

    @JsonProperty("summoner2Casts")
    public long getSummoner2Casts() {
        return summoner2Casts;
    }

    @JsonProperty("summoner2Casts")
    public void setSummoner2Casts(long value) {
        this.summoner2Casts = value;
    }

    @JsonProperty("summoner2Id")
    public long getSummoner2ID() {
        return summoner2ID;
    }

    @JsonProperty("summoner2Id")
    public void setSummoner2ID(long value) {
        this.summoner2ID = value;
    }

    @JsonProperty("summonerId")
    public String getSummonerID() {
        return summonerID;
    }

    @JsonProperty("summonerId")
    public void setSummonerID(String value) {
        this.summonerID = value;
    }

    @JsonProperty("summonerLevel")
    public long getSummonerLevel() {
        return summonerLevel;
    }

    @JsonProperty("summonerLevel")
    public void setSummonerLevel(long value) {
        this.summonerLevel = value;
    }

    @JsonProperty("summonerName")
    public String getSummonerName() {
        return summonerName;
    }

    @JsonProperty("summonerName")
    public void setSummonerName(String value) {
        this.summonerName = value;
    }

    @JsonProperty("teamEarlySurrendered")
    public boolean getTeamEarlySurrendered() {
        return teamEarlySurrendered;
    }

    @JsonProperty("teamEarlySurrendered")
    public void setTeamEarlySurrendered(boolean value) {
        this.teamEarlySurrendered = value;
    }

    @JsonProperty("teamId")
    public long getTeamID() {
        return teamID;
    }

    @JsonProperty("teamId")
    public void setTeamID(long value) {
        this.teamID = value;
    }

    @JsonProperty("teamPosition")
    public String getTeamPosition() {
        return teamPosition;
    }

    @JsonProperty("teamPosition")
    public void setTeamPosition(String value) {
        this.teamPosition = value;
    }

    @JsonProperty("timeCCingOthers")
    public long getTimeCCingOthers() {
        return timeCCingOthers;
    }

    @JsonProperty("timeCCingOthers")
    public void setTimeCCingOthers(long value) {
        this.timeCCingOthers = value;
    }

    @JsonProperty("timePlayed")
    public long getTimePlayed() {
        return timePlayed;
    }

    @JsonProperty("timePlayed")
    public void setTimePlayed(long value) {
        this.timePlayed = value;
    }

    @JsonProperty("totalAllyJungleMinionsKilled")
    public long getTotalAllyJungleMinionsKilled() {
        return totalAllyJungleMinionsKilled;
    }

    @JsonProperty("totalAllyJungleMinionsKilled")
    public void setTotalAllyJungleMinionsKilled(long value) {
        this.totalAllyJungleMinionsKilled = value;
    }

    @JsonProperty("totalDamageDealt")
    public long getTotalDamageDealt() {
        return totalDamageDealt;
    }

    @JsonProperty("totalDamageDealt")
    public void setTotalDamageDealt(long value) {
        this.totalDamageDealt = value;
    }

    @JsonProperty("totalDamageDealtToChampions")
    public long getTotalDamageDealtToChampions() {
        return totalDamageDealtToChampions;
    }

    @JsonProperty("totalDamageDealtToChampions")
    public void setTotalDamageDealtToChampions(long value) {
        this.totalDamageDealtToChampions = value;
    }

    @JsonProperty("totalDamageShieldedOnTeammates")
    public long getTotalDamageShieldedOnTeammates() {
        return totalDamageShieldedOnTeammates;
    }

    @JsonProperty("totalDamageShieldedOnTeammates")
    public void setTotalDamageShieldedOnTeammates(long value) {
        this.totalDamageShieldedOnTeammates = value;
    }

    @JsonProperty("totalDamageTaken")
    public long getTotalDamageTaken() {
        return totalDamageTaken;
    }

    @JsonProperty("totalDamageTaken")
    public void setTotalDamageTaken(long value) {
        this.totalDamageTaken = value;
    }

    @JsonProperty("totalEnemyJungleMinionsKilled")
    public long getTotalEnemyJungleMinionsKilled() {
        return totalEnemyJungleMinionsKilled;
    }

    @JsonProperty("totalEnemyJungleMinionsKilled")
    public void setTotalEnemyJungleMinionsKilled(long value) {
        this.totalEnemyJungleMinionsKilled = value;
    }

    @JsonProperty("totalHeal")
    public long getTotalHeal() {
        return totalHeal;
    }

    @JsonProperty("totalHeal")
    public void setTotalHeal(long value) {
        this.totalHeal = value;
    }

    @JsonProperty("totalHealsOnTeammates")
    public long getTotalHealsOnTeammates() {
        return totalHealsOnTeammates;
    }

    @JsonProperty("totalHealsOnTeammates")
    public void setTotalHealsOnTeammates(long value) {
        this.totalHealsOnTeammates = value;
    }

    @JsonProperty("totalMinionsKilled")
    public long getTotalMinionsKilled() {
        return totalMinionsKilled;
    }

    @JsonProperty("totalMinionsKilled")
    public void setTotalMinionsKilled(long value) {
        this.totalMinionsKilled = value;
    }

    @JsonProperty("totalTimeCCDealt")
    public long getTotalTimeCCDealt() {
        return totalTimeCCDealt;
    }

    @JsonProperty("totalTimeCCDealt")
    public void setTotalTimeCCDealt(long value) {
        this.totalTimeCCDealt = value;
    }

    @JsonProperty("totalTimeSpentDead")
    public long getTotalTimeSpentDead() {
        return totalTimeSpentDead;
    }

    @JsonProperty("totalTimeSpentDead")
    public void setTotalTimeSpentDead(long value) {
        this.totalTimeSpentDead = value;
    }

    @JsonProperty("totalUnitsHealed")
    public long getTotalUnitsHealed() {
        return totalUnitsHealed;
    }

    @JsonProperty("totalUnitsHealed")
    public void setTotalUnitsHealed(long value) {
        this.totalUnitsHealed = value;
    }

    @JsonProperty("tripleKills")
    public long getTripleKills() {
        return tripleKills;
    }

    @JsonProperty("tripleKills")
    public void setTripleKills(long value) {
        this.tripleKills = value;
    }

    @JsonProperty("trueDamageDealt")
    public long getTrueDamageDealt() {
        return trueDamageDealt;
    }

    @JsonProperty("trueDamageDealt")
    public void setTrueDamageDealt(long value) {
        this.trueDamageDealt = value;
    }

    @JsonProperty("trueDamageDealtToChampions")
    public long getTrueDamageDealtToChampions() {
        return trueDamageDealtToChampions;
    }

    @JsonProperty("trueDamageDealtToChampions")
    public void setTrueDamageDealtToChampions(long value) {
        this.trueDamageDealtToChampions = value;
    }

    @JsonProperty("trueDamageTaken")
    public long getTrueDamageTaken() {
        return trueDamageTaken;
    }

    @JsonProperty("trueDamageTaken")
    public void setTrueDamageTaken(long value) {
        this.trueDamageTaken = value;
    }

    @JsonProperty("turretKills")
    public long getTurretKills() {
        return turretKills;
    }

    @JsonProperty("turretKills")
    public void setTurretKills(long value) {
        this.turretKills = value;
    }

    @JsonProperty("turretTakedowns")
    public long getTurretTakedowns() {
        return turretTakedowns;
    }

    @JsonProperty("turretTakedowns")
    public void setTurretTakedowns(long value) {
        this.turretTakedowns = value;
    }

    @JsonProperty("turretsLost")
    public long getTurretsLost() {
        return turretsLost;
    }

    @JsonProperty("turretsLost")
    public void setTurretsLost(long value) {
        this.turretsLost = value;
    }

    @JsonProperty("unrealKills")
    public long getUnrealKills() {
        return unrealKills;
    }

    @JsonProperty("unrealKills")
    public void setUnrealKills(long value) {
        this.unrealKills = value;
    }

    @JsonProperty("visionClearedPings")
    public long getVisionClearedPings() {
        return visionClearedPings;
    }

    @JsonProperty("visionClearedPings")
    public void setVisionClearedPings(long value) {
        this.visionClearedPings = value;
    }

    @JsonProperty("visionScore")
    public long getVisionScore() {
        return visionScore;
    }

    @JsonProperty("visionScore")
    public void setVisionScore(long value) {
        this.visionScore = value;
    }

    @JsonProperty("visionWardsBoughtInGame")
    public long getVisionWardsBoughtInGame() {
        return visionWardsBoughtInGame;
    }

    @JsonProperty("visionWardsBoughtInGame")
    public void setVisionWardsBoughtInGame(long value) {
        this.visionWardsBoughtInGame = value;
    }

    @JsonProperty("wardsKilled")
    public long getWardsKilled() {
        return wardsKilled;
    }

    @JsonProperty("wardsKilled")
    public void setWardsKilled(long value) {
        this.wardsKilled = value;
    }

    @JsonProperty("wardsPlaced")
    public long getWardsPlaced() {
        return wardsPlaced;
    }

    @JsonProperty("wardsPlaced")
    public void setWardsPlaced(long value) {
        this.wardsPlaced = value;
    }

    @JsonProperty("win")
    public boolean getWin() {
        return win;
    }

    @JsonProperty("win")
    public void setWin(boolean value) {
        this.win = value;
    }
}
