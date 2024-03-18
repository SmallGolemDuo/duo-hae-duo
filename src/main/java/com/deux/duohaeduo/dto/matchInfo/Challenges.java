package com.deux.duohaeduo.dto.matchInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Challenges {

    private long the12AssistStreakCount;
    private long abilityUses;
    private long acesBefore15Minutes;
    private long alliedJungleMonsterKills;
    private long baronTakedowns;
    private long blastConeOppositeOpponentCount;
    private long bountyGold;
    private long buffsStolen;
    private long completeSupportQuestInTime;
    private long controlWardsPlaced;
    private double damagePerMinute;
    private double damageTakenOnTeamPercentage;
    private long dancedWithRiftHerald;
    private long deathsByEnemyChamps;
    private long dodgeSkillShotsSmallWindow;
    private long doubleAces;
    private long dragonTakedowns;
    private double effectiveHealAndShielding;
    private long elderDragonKillsWithOpposingSoul;
    private long elderDragonMultikills;
    private long enemyChampionImmobilizations;
    private long enemyJungleMonsterKills;
    private long epicMonsterKillsNearEnemyJungler;
    private long epicMonsterKillsWithin30SecondsOfSpawn;
    private long epicMonsterSteals;
    private long epicMonsterStolenWithoutSmite;
    private long firstTurretKilled;
    private long flawlessAces;
    private long fullTeamTakedown;
    private double gameLength;
    private long getTakedownsInAllLanesEarlyJungleAsLaner;
    private double goldPerMinute;
    private long hadOpenNexus;
    private long immobilizeAndKillWithAlly;
    private long initialBuffCount;
    private long initialCrabCount;
    private long jungleCSBefore10Minutes;
    private long junglerTakedownsNearDamagedEpicMonster;
    private long kTurretsDestroyedBeforePlatesFall;
    private double kda;
    private long killAfterHiddenWithAlly;
    private double killParticipation;
    private long killedChampTookFullTeamDamageSurvived;
    private long killingSprees;
    private long killsNearEnemyTurret;
    private long killsOnOtherLanesEarlyJungleAsLaner;
    private long killsOnRecentlyHealedByAramPack;
    private long killsUnderOwnTurret;
    private long killsWithHelpFromEpicMonster;
    private long knockEnemyIntoTeamAndKill;
    private long landSkillShotsEarlyGame;
    private long laneMinionsFirst10Minutes;
    private long legendaryCount;
    private List<Long> legendaryItemUsed;
    private long lostAnInhibitor;
    private long maxKillDeficit;
    private long mejaisFullStackInTime;
    private long moreEnemyJungleThanOpponent;
    private long multiKillOneSpell;
    private long multiTurretRiftHeraldCount;
    private long multikills;
    private long multikillsAfterAggressiveFlash;
    private long outerTurretExecutesBefore10Minutes;
    private long outnumberedKills;
    private long outnumberedNexusKill;
    private long perfectDragonSoulsTaken;
    private long perfectGame;
    private long pickKillWithAlly;
    private long poroExplosions;
    private long quickCleanse;
    private long quickFirstTurret;
    private long quickSoloKills;
    private long riftHeraldTakedowns;
    private long saveAllyFromDeath;
    private long scuttleCrabKills;
    private double shortestTimeToAceFromFirstTakedown;
    private long skillshotsDodged;
    private long skillshotsHit;
    private long snowballsHit;
    private long soloBaronKills;
    private long soloKills;
    private long stealthWardsPlaced;
    private long survivedSingleDigitHPCount;
    private long survivedThreeImmobilizesInFight;
    private long takedownOnFirstTurret;
    private long takedowns;
    private long takedownsAfterGainingLevelAdvantage;
    private long takedownsBeforeJungleMinionSpawn;
    private long takedownsFirstXMinutes;
    private long takedownsInAlcove;
    private long takedownsInEnemyFountain;
    private long teamBaronKills;
    private double teamDamagePercentage;
    private long teamElderDragonKills;
    private long teamRiftHeraldKills;
    private long tookLargeDamageSurvived;
    private long turretPlatesTaken;
    private long turretTakedowns;
    private long turretsTakenWithRiftHerald;
    private long twentyMinionsIn3SecondsCount;
    private long twoWardsOneSweeperCount;
    private long unseenRecalls;
    private long visionScorePerMinute;
    private long wardTakedowns;
    private long wardTakedownsBefore20M;
    private long wardsGuarded;
    private Double firstTurretKilledTime;
    private Long highestChampionDamage;

    @JsonProperty("12AssistStreakCount")
    public long getThe12AssistStreakCount() {
        return the12AssistStreakCount;
    }

    @JsonProperty("12AssistStreakCount")
    public void setThe12AssistStreakCount(long value) {
        this.the12AssistStreakCount = value;
    }

    @JsonProperty("abilityUses")
    public long getAbilityUses() {
        return abilityUses;
    }

    @JsonProperty("abilityUses")
    public void setAbilityUses(long value) {
        this.abilityUses = value;
    }

    @JsonProperty("acesBefore15Minutes")
    public long getAcesBefore15Minutes() {
        return acesBefore15Minutes;
    }

    @JsonProperty("acesBefore15Minutes")
    public void setAcesBefore15Minutes(long value) {
        this.acesBefore15Minutes = value;
    }

    @JsonProperty("alliedJungleMonsterKills")
    public long getAlliedJungleMonsterKills() {
        return alliedJungleMonsterKills;
    }

    @JsonProperty("alliedJungleMonsterKills")
    public void setAlliedJungleMonsterKills(long value) {
        this.alliedJungleMonsterKills = value;
    }

    @JsonProperty("baronTakedowns")
    public long getBaronTakedowns() {
        return baronTakedowns;
    }

    @JsonProperty("baronTakedowns")
    public void setBaronTakedowns(long value) {
        this.baronTakedowns = value;
    }

    @JsonProperty("blastConeOppositeOpponentCount")
    public long getBlastConeOppositeOpponentCount() {
        return blastConeOppositeOpponentCount;
    }

    @JsonProperty("blastConeOppositeOpponentCount")
    public void setBlastConeOppositeOpponentCount(long value) {
        this.blastConeOppositeOpponentCount = value;
    }

    @JsonProperty("bountyGold")
    public long getBountyGold() {
        return bountyGold;
    }

    @JsonProperty("bountyGold")
    public void setBountyGold(long value) {
        this.bountyGold = value;
    }

    @JsonProperty("buffsStolen")
    public long getBuffsStolen() {
        return buffsStolen;
    }

    @JsonProperty("buffsStolen")
    public void setBuffsStolen(long value) {
        this.buffsStolen = value;
    }

    @JsonProperty("completeSupportQuestInTime")
    public long getCompleteSupportQuestInTime() {
        return completeSupportQuestInTime;
    }

    @JsonProperty("completeSupportQuestInTime")
    public void setCompleteSupportQuestInTime(long value) {
        this.completeSupportQuestInTime = value;
    }

    @JsonProperty("controlWardsPlaced")
    public long getControlWardsPlaced() {
        return controlWardsPlaced;
    }

    @JsonProperty("controlWardsPlaced")
    public void setControlWardsPlaced(long value) {
        this.controlWardsPlaced = value;
    }

    @JsonProperty("damagePerMinute")
    public double getDamagePerMinute() {
        return damagePerMinute;
    }

    @JsonProperty("damagePerMinute")
    public void setDamagePerMinute(double value) {
        this.damagePerMinute = value;
    }

    @JsonProperty("damageTakenOnTeamPercentage")
    public double getDamageTakenOnTeamPercentage() {
        return damageTakenOnTeamPercentage;
    }

    @JsonProperty("damageTakenOnTeamPercentage")
    public void setDamageTakenOnTeamPercentage(double value) {
        this.damageTakenOnTeamPercentage = value;
    }

    @JsonProperty("dancedWithRiftHerald")
    public long getDancedWithRiftHerald() {
        return dancedWithRiftHerald;
    }

    @JsonProperty("dancedWithRiftHerald")
    public void setDancedWithRiftHerald(long value) {
        this.dancedWithRiftHerald = value;
    }

    @JsonProperty("deathsByEnemyChamps")
    public long getDeathsByEnemyChamps() {
        return deathsByEnemyChamps;
    }

    @JsonProperty("deathsByEnemyChamps")
    public void setDeathsByEnemyChamps(long value) {
        this.deathsByEnemyChamps = value;
    }

    @JsonProperty("dodgeSkillShotsSmallWindow")
    public long getDodgeSkillShotsSmallWindow() {
        return dodgeSkillShotsSmallWindow;
    }

    @JsonProperty("dodgeSkillShotsSmallWindow")
    public void setDodgeSkillShotsSmallWindow(long value) {
        this.dodgeSkillShotsSmallWindow = value;
    }

    @JsonProperty("doubleAces")
    public long getDoubleAces() {
        return doubleAces;
    }

    @JsonProperty("doubleAces")
    public void setDoubleAces(long value) {
        this.doubleAces = value;
    }

    @JsonProperty("dragonTakedowns")
    public long getDragonTakedowns() {
        return dragonTakedowns;
    }

    @JsonProperty("dragonTakedowns")
    public void setDragonTakedowns(long value) {
        this.dragonTakedowns = value;
    }

    @JsonProperty("effectiveHealAndShielding")
    public double getEffectiveHealAndShielding() {
        return effectiveHealAndShielding;
    }

    @JsonProperty("effectiveHealAndShielding")
    public void setEffectiveHealAndShielding(double value) {
        this.effectiveHealAndShielding = value;
    }

    @JsonProperty("elderDragonKillsWithOpposingSoul")
    public long getElderDragonKillsWithOpposingSoul() {
        return elderDragonKillsWithOpposingSoul;
    }

    @JsonProperty("elderDragonKillsWithOpposingSoul")
    public void setElderDragonKillsWithOpposingSoul(long value) {
        this.elderDragonKillsWithOpposingSoul = value;
    }

    @JsonProperty("elderDragonMultikills")
    public long getElderDragonMultikills() {
        return elderDragonMultikills;
    }

    @JsonProperty("elderDragonMultikills")
    public void setElderDragonMultikills(long value) {
        this.elderDragonMultikills = value;
    }

    @JsonProperty("enemyChampionImmobilizations")
    public long getEnemyChampionImmobilizations() {
        return enemyChampionImmobilizations;
    }

    @JsonProperty("enemyChampionImmobilizations")
    public void setEnemyChampionImmobilizations(long value) {
        this.enemyChampionImmobilizations = value;
    }

    @JsonProperty("enemyJungleMonsterKills")
    public long getEnemyJungleMonsterKills() {
        return enemyJungleMonsterKills;
    }

    @JsonProperty("enemyJungleMonsterKills")
    public void setEnemyJungleMonsterKills(long value) {
        this.enemyJungleMonsterKills = value;
    }

    @JsonProperty("epicMonsterKillsNearEnemyJungler")
    public long getEpicMonsterKillsNearEnemyJungler() {
        return epicMonsterKillsNearEnemyJungler;
    }

    @JsonProperty("epicMonsterKillsNearEnemyJungler")
    public void setEpicMonsterKillsNearEnemyJungler(long value) {
        this.epicMonsterKillsNearEnemyJungler = value;
    }

    @JsonProperty("epicMonsterKillsWithin30SecondsOfSpawn")
    public long getEpicMonsterKillsWithin30SecondsOfSpawn() {
        return epicMonsterKillsWithin30SecondsOfSpawn;
    }

    @JsonProperty("epicMonsterKillsWithin30SecondsOfSpawn")
    public void setEpicMonsterKillsWithin30SecondsOfSpawn(long value) {
        this.epicMonsterKillsWithin30SecondsOfSpawn = value;
    }

    @JsonProperty("epicMonsterSteals")
    public long getEpicMonsterSteals() {
        return epicMonsterSteals;
    }

    @JsonProperty("epicMonsterSteals")
    public void setEpicMonsterSteals(long value) {
        this.epicMonsterSteals = value;
    }

    @JsonProperty("epicMonsterStolenWithoutSmite")
    public long getEpicMonsterStolenWithoutSmite() {
        return epicMonsterStolenWithoutSmite;
    }

    @JsonProperty("epicMonsterStolenWithoutSmite")
    public void setEpicMonsterStolenWithoutSmite(long value) {
        this.epicMonsterStolenWithoutSmite = value;
    }

    @JsonProperty("firstTurretKilled")
    public long getFirstTurretKilled() {
        return firstTurretKilled;
    }

    @JsonProperty("firstTurretKilled")
    public void setFirstTurretKilled(long value) {
        this.firstTurretKilled = value;
    }

    @JsonProperty("flawlessAces")
    public long getFlawlessAces() {
        return flawlessAces;
    }

    @JsonProperty("flawlessAces")
    public void setFlawlessAces(long value) {
        this.flawlessAces = value;
    }

    @JsonProperty("fullTeamTakedown")
    public long getFullTeamTakedown() {
        return fullTeamTakedown;
    }

    @JsonProperty("fullTeamTakedown")
    public void setFullTeamTakedown(long value) {
        this.fullTeamTakedown = value;
    }

    @JsonProperty("gameLength")
    public double getGameLength() {
        return gameLength;
    }

    @JsonProperty("gameLength")
    public void setGameLength(double value) {
        this.gameLength = value;
    }

    @JsonProperty("getTakedownsInAllLanesEarlyJungleAsLaner")
    public long getGetTakedownsInAllLanesEarlyJungleAsLaner() {
        return getTakedownsInAllLanesEarlyJungleAsLaner;
    }

    @JsonProperty("getTakedownsInAllLanesEarlyJungleAsLaner")
    public void setGetTakedownsInAllLanesEarlyJungleAsLaner(long value) {
        this.getTakedownsInAllLanesEarlyJungleAsLaner = value;
    }

    @JsonProperty("goldPerMinute")
    public double getGoldPerMinute() {
        return goldPerMinute;
    }

    @JsonProperty("goldPerMinute")
    public void setGoldPerMinute(double value) {
        this.goldPerMinute = value;
    }

    @JsonProperty("hadOpenNexus")
    public long getHadOpenNexus() {
        return hadOpenNexus;
    }

    @JsonProperty("hadOpenNexus")
    public void setHadOpenNexus(long value) {
        this.hadOpenNexus = value;
    }

    @JsonProperty("immobilizeAndKillWithAlly")
    public long getImmobilizeAndKillWithAlly() {
        return immobilizeAndKillWithAlly;
    }

    @JsonProperty("immobilizeAndKillWithAlly")
    public void setImmobilizeAndKillWithAlly(long value) {
        this.immobilizeAndKillWithAlly = value;
    }

    @JsonProperty("initialBuffCount")
    public long getInitialBuffCount() {
        return initialBuffCount;
    }

    @JsonProperty("initialBuffCount")
    public void setInitialBuffCount(long value) {
        this.initialBuffCount = value;
    }

    @JsonProperty("initialCrabCount")
    public long getInitialCrabCount() {
        return initialCrabCount;
    }

    @JsonProperty("initialCrabCount")
    public void setInitialCrabCount(long value) {
        this.initialCrabCount = value;
    }

    @JsonProperty("jungleCsBefore10Minutes")
    public long getJungleCSBefore10Minutes() {
        return jungleCSBefore10Minutes;
    }

    @JsonProperty("jungleCsBefore10Minutes")
    public void setJungleCSBefore10Minutes(long value) {
        this.jungleCSBefore10Minutes = value;
    }

    @JsonProperty("junglerTakedownsNearDamagedEpicMonster")
    public long getJunglerTakedownsNearDamagedEpicMonster() {
        return junglerTakedownsNearDamagedEpicMonster;
    }

    @JsonProperty("junglerTakedownsNearDamagedEpicMonster")
    public void setJunglerTakedownsNearDamagedEpicMonster(long value) {
        this.junglerTakedownsNearDamagedEpicMonster = value;
    }

    @JsonProperty("kTurretsDestroyedBeforePlatesFall")
    public long getKTurretsDestroyedBeforePlatesFall() {
        return kTurretsDestroyedBeforePlatesFall;
    }

    @JsonProperty("kTurretsDestroyedBeforePlatesFall")
    public void setKTurretsDestroyedBeforePlatesFall(long value) {
        this.kTurretsDestroyedBeforePlatesFall = value;
    }

    @JsonProperty("kda")
    public double getKda() {
        return kda;
    }

    @JsonProperty("kda")
    public void setKda(double value) {
        this.kda = value;
    }

    @JsonProperty("killAfterHiddenWithAlly")
    public long getKillAfterHiddenWithAlly() {
        return killAfterHiddenWithAlly;
    }

    @JsonProperty("killAfterHiddenWithAlly")
    public void setKillAfterHiddenWithAlly(long value) {
        this.killAfterHiddenWithAlly = value;
    }

    @JsonProperty("killParticipation")
    public double getKillParticipation() {
        return killParticipation;
    }

    @JsonProperty("killParticipation")
    public void setKillParticipation(double value) {
        this.killParticipation = value;
    }

    @JsonProperty("killedChampTookFullTeamDamageSurvived")
    public long getKilledChampTookFullTeamDamageSurvived() {
        return killedChampTookFullTeamDamageSurvived;
    }

    @JsonProperty("killedChampTookFullTeamDamageSurvived")
    public void setKilledChampTookFullTeamDamageSurvived(long value) {
        this.killedChampTookFullTeamDamageSurvived = value;
    }

    @JsonProperty("killingSprees")
    public long getKillingSprees() {
        return killingSprees;
    }

    @JsonProperty("killingSprees")
    public void setKillingSprees(long value) {
        this.killingSprees = value;
    }

    @JsonProperty("killsNearEnemyTurret")
    public long getKillsNearEnemyTurret() {
        return killsNearEnemyTurret;
    }

    @JsonProperty("killsNearEnemyTurret")
    public void setKillsNearEnemyTurret(long value) {
        this.killsNearEnemyTurret = value;
    }

    @JsonProperty("killsOnOtherLanesEarlyJungleAsLaner")
    public long getKillsOnOtherLanesEarlyJungleAsLaner() {
        return killsOnOtherLanesEarlyJungleAsLaner;
    }

    @JsonProperty("killsOnOtherLanesEarlyJungleAsLaner")
    public void setKillsOnOtherLanesEarlyJungleAsLaner(long value) {
        this.killsOnOtherLanesEarlyJungleAsLaner = value;
    }

    @JsonProperty("killsOnRecentlyHealedByAramPack")
    public long getKillsOnRecentlyHealedByAramPack() {
        return killsOnRecentlyHealedByAramPack;
    }

    @JsonProperty("killsOnRecentlyHealedByAramPack")
    public void setKillsOnRecentlyHealedByAramPack(long value) {
        this.killsOnRecentlyHealedByAramPack = value;
    }

    @JsonProperty("killsUnderOwnTurret")
    public long getKillsUnderOwnTurret() {
        return killsUnderOwnTurret;
    }

    @JsonProperty("killsUnderOwnTurret")
    public void setKillsUnderOwnTurret(long value) {
        this.killsUnderOwnTurret = value;
    }

    @JsonProperty("killsWithHelpFromEpicMonster")
    public long getKillsWithHelpFromEpicMonster() {
        return killsWithHelpFromEpicMonster;
    }

    @JsonProperty("killsWithHelpFromEpicMonster")
    public void setKillsWithHelpFromEpicMonster(long value) {
        this.killsWithHelpFromEpicMonster = value;
    }

    @JsonProperty("knockEnemyIntoTeamAndKill")
    public long getKnockEnemyIntoTeamAndKill() {
        return knockEnemyIntoTeamAndKill;
    }

    @JsonProperty("knockEnemyIntoTeamAndKill")
    public void setKnockEnemyIntoTeamAndKill(long value) {
        this.knockEnemyIntoTeamAndKill = value;
    }

    @JsonProperty("landSkillShotsEarlyGame")
    public long getLandSkillShotsEarlyGame() {
        return landSkillShotsEarlyGame;
    }

    @JsonProperty("landSkillShotsEarlyGame")
    public void setLandSkillShotsEarlyGame(long value) {
        this.landSkillShotsEarlyGame = value;
    }

    @JsonProperty("laneMinionsFirst10Minutes")
    public long getLaneMinionsFirst10Minutes() {
        return laneMinionsFirst10Minutes;
    }

    @JsonProperty("laneMinionsFirst10Minutes")
    public void setLaneMinionsFirst10Minutes(long value) {
        this.laneMinionsFirst10Minutes = value;
    }

    @JsonProperty("legendaryCount")
    public long getLegendaryCount() {
        return legendaryCount;
    }

    @JsonProperty("legendaryCount")
    public void setLegendaryCount(long value) {
        this.legendaryCount = value;
    }

    @JsonProperty("legendaryItemUsed")
    public List<Long> getLegendaryItemUsed() {
        return legendaryItemUsed;
    }

    @JsonProperty("legendaryItemUsed")
    public void setLegendaryItemUsed(List<Long> value) {
        this.legendaryItemUsed = value;
    }

    @JsonProperty("lostAnInhibitor")
    public long getLostAnInhibitor() {
        return lostAnInhibitor;
    }

    @JsonProperty("lostAnInhibitor")
    public void setLostAnInhibitor(long value) {
        this.lostAnInhibitor = value;
    }

    @JsonProperty("maxKillDeficit")
    public long getMaxKillDeficit() {
        return maxKillDeficit;
    }

    @JsonProperty("maxKillDeficit")
    public void setMaxKillDeficit(long value) {
        this.maxKillDeficit = value;
    }

    @JsonProperty("mejaisFullStackInTime")
    public long getMejaisFullStackInTime() {
        return mejaisFullStackInTime;
    }

    @JsonProperty("mejaisFullStackInTime")
    public void setMejaisFullStackInTime(long value) {
        this.mejaisFullStackInTime = value;
    }

    @JsonProperty("moreEnemyJungleThanOpponent")
    public long getMoreEnemyJungleThanOpponent() {
        return moreEnemyJungleThanOpponent;
    }

    @JsonProperty("moreEnemyJungleThanOpponent")
    public void setMoreEnemyJungleThanOpponent(long value) {
        this.moreEnemyJungleThanOpponent = value;
    }

    @JsonProperty("multiKillOneSpell")
    public long getMultiKillOneSpell() {
        return multiKillOneSpell;
    }

    @JsonProperty("multiKillOneSpell")
    public void setMultiKillOneSpell(long value) {
        this.multiKillOneSpell = value;
    }

    @JsonProperty("multiTurretRiftHeraldCount")
    public long getMultiTurretRiftHeraldCount() {
        return multiTurretRiftHeraldCount;
    }

    @JsonProperty("multiTurretRiftHeraldCount")
    public void setMultiTurretRiftHeraldCount(long value) {
        this.multiTurretRiftHeraldCount = value;
    }

    @JsonProperty("multikills")
    public long getMultikills() {
        return multikills;
    }

    @JsonProperty("multikills")
    public void setMultikills(long value) {
        this.multikills = value;
    }

    @JsonProperty("multikillsAfterAggressiveFlash")
    public long getMultikillsAfterAggressiveFlash() {
        return multikillsAfterAggressiveFlash;
    }

    @JsonProperty("multikillsAfterAggressiveFlash")
    public void setMultikillsAfterAggressiveFlash(long value) {
        this.multikillsAfterAggressiveFlash = value;
    }

    @JsonProperty("outerTurretExecutesBefore10Minutes")
    public long getOuterTurretExecutesBefore10Minutes() {
        return outerTurretExecutesBefore10Minutes;
    }

    @JsonProperty("outerTurretExecutesBefore10Minutes")
    public void setOuterTurretExecutesBefore10Minutes(long value) {
        this.outerTurretExecutesBefore10Minutes = value;
    }

    @JsonProperty("outnumberedKills")
    public long getOutnumberedKills() {
        return outnumberedKills;
    }

    @JsonProperty("outnumberedKills")
    public void setOutnumberedKills(long value) {
        this.outnumberedKills = value;
    }

    @JsonProperty("outnumberedNexusKill")
    public long getOutnumberedNexusKill() {
        return outnumberedNexusKill;
    }

    @JsonProperty("outnumberedNexusKill")
    public void setOutnumberedNexusKill(long value) {
        this.outnumberedNexusKill = value;
    }

    @JsonProperty("perfectDragonSoulsTaken")
    public long getPerfectDragonSoulsTaken() {
        return perfectDragonSoulsTaken;
    }

    @JsonProperty("perfectDragonSoulsTaken")
    public void setPerfectDragonSoulsTaken(long value) {
        this.perfectDragonSoulsTaken = value;
    }

    @JsonProperty("perfectGame")
    public long getPerfectGame() {
        return perfectGame;
    }

    @JsonProperty("perfectGame")
    public void setPerfectGame(long value) {
        this.perfectGame = value;
    }

    @JsonProperty("pickKillWithAlly")
    public long getPickKillWithAlly() {
        return pickKillWithAlly;
    }

    @JsonProperty("pickKillWithAlly")
    public void setPickKillWithAlly(long value) {
        this.pickKillWithAlly = value;
    }

    @JsonProperty("poroExplosions")
    public long getPoroExplosions() {
        return poroExplosions;
    }

    @JsonProperty("poroExplosions")
    public void setPoroExplosions(long value) {
        this.poroExplosions = value;
    }

    @JsonProperty("quickCleanse")
    public long getQuickCleanse() {
        return quickCleanse;
    }

    @JsonProperty("quickCleanse")
    public void setQuickCleanse(long value) {
        this.quickCleanse = value;
    }

    @JsonProperty("quickFirstTurret")
    public long getQuickFirstTurret() {
        return quickFirstTurret;
    }

    @JsonProperty("quickFirstTurret")
    public void setQuickFirstTurret(long value) {
        this.quickFirstTurret = value;
    }

    @JsonProperty("quickSoloKills")
    public long getQuickSoloKills() {
        return quickSoloKills;
    }

    @JsonProperty("quickSoloKills")
    public void setQuickSoloKills(long value) {
        this.quickSoloKills = value;
    }

    @JsonProperty("riftHeraldTakedowns")
    public long getRiftHeraldTakedowns() {
        return riftHeraldTakedowns;
    }

    @JsonProperty("riftHeraldTakedowns")
    public void setRiftHeraldTakedowns(long value) {
        this.riftHeraldTakedowns = value;
    }

    @JsonProperty("saveAllyFromDeath")
    public long getSaveAllyFromDeath() {
        return saveAllyFromDeath;
    }

    @JsonProperty("saveAllyFromDeath")
    public void setSaveAllyFromDeath(long value) {
        this.saveAllyFromDeath = value;
    }

    @JsonProperty("scuttleCrabKills")
    public long getScuttleCrabKills() {
        return scuttleCrabKills;
    }

    @JsonProperty("scuttleCrabKills")
    public void setScuttleCrabKills(long value) {
        this.scuttleCrabKills = value;
    }

    @JsonProperty("shortestTimeToAceFromFirstTakedown")
    public double getShortestTimeToAceFromFirstTakedown() {
        return shortestTimeToAceFromFirstTakedown;
    }

    @JsonProperty("shortestTimeToAceFromFirstTakedown")
    public void setShortestTimeToAceFromFirstTakedown(double value) {
        this.shortestTimeToAceFromFirstTakedown = value;
    }

    @JsonProperty("skillshotsDodged")
    public long getSkillshotsDodged() {
        return skillshotsDodged;
    }

    @JsonProperty("skillshotsDodged")
    public void setSkillshotsDodged(long value) {
        this.skillshotsDodged = value;
    }

    @JsonProperty("skillshotsHit")
    public long getSkillshotsHit() {
        return skillshotsHit;
    }

    @JsonProperty("skillshotsHit")
    public void setSkillshotsHit(long value) {
        this.skillshotsHit = value;
    }

    @JsonProperty("snowballsHit")
    public long getSnowballsHit() {
        return snowballsHit;
    }

    @JsonProperty("snowballsHit")
    public void setSnowballsHit(long value) {
        this.snowballsHit = value;
    }

    @JsonProperty("soloBaronKills")
    public long getSoloBaronKills() {
        return soloBaronKills;
    }

    @JsonProperty("soloBaronKills")
    public void setSoloBaronKills(long value) {
        this.soloBaronKills = value;
    }

    @JsonProperty("soloKills")
    public long getSoloKills() {
        return soloKills;
    }

    @JsonProperty("soloKills")
    public void setSoloKills(long value) {
        this.soloKills = value;
    }

    @JsonProperty("stealthWardsPlaced")
    public long getStealthWardsPlaced() {
        return stealthWardsPlaced;
    }

    @JsonProperty("stealthWardsPlaced")
    public void setStealthWardsPlaced(long value) {
        this.stealthWardsPlaced = value;
    }

    @JsonProperty("survivedSingleDigitHpCount")
    public long getSurvivedSingleDigitHPCount() {
        return survivedSingleDigitHPCount;
    }

    @JsonProperty("survivedSingleDigitHpCount")
    public void setSurvivedSingleDigitHPCount(long value) {
        this.survivedSingleDigitHPCount = value;
    }

    @JsonProperty("survivedThreeImmobilizesInFight")
    public long getSurvivedThreeImmobilizesInFight() {
        return survivedThreeImmobilizesInFight;
    }

    @JsonProperty("survivedThreeImmobilizesInFight")
    public void setSurvivedThreeImmobilizesInFight(long value) {
        this.survivedThreeImmobilizesInFight = value;
    }

    @JsonProperty("takedownOnFirstTurret")
    public long getTakedownOnFirstTurret() {
        return takedownOnFirstTurret;
    }

    @JsonProperty("takedownOnFirstTurret")
    public void setTakedownOnFirstTurret(long value) {
        this.takedownOnFirstTurret = value;
    }

    @JsonProperty("takedowns")
    public long getTakedowns() {
        return takedowns;
    }

    @JsonProperty("takedowns")
    public void setTakedowns(long value) {
        this.takedowns = value;
    }

    @JsonProperty("takedownsAfterGainingLevelAdvantage")
    public long getTakedownsAfterGainingLevelAdvantage() {
        return takedownsAfterGainingLevelAdvantage;
    }

    @JsonProperty("takedownsAfterGainingLevelAdvantage")
    public void setTakedownsAfterGainingLevelAdvantage(long value) {
        this.takedownsAfterGainingLevelAdvantage = value;
    }

    @JsonProperty("takedownsBeforeJungleMinionSpawn")
    public long getTakedownsBeforeJungleMinionSpawn() {
        return takedownsBeforeJungleMinionSpawn;
    }

    @JsonProperty("takedownsBeforeJungleMinionSpawn")
    public void setTakedownsBeforeJungleMinionSpawn(long value) {
        this.takedownsBeforeJungleMinionSpawn = value;
    }

    @JsonProperty("takedownsFirstXMinutes")
    public long getTakedownsFirstXMinutes() {
        return takedownsFirstXMinutes;
    }

    @JsonProperty("takedownsFirstXMinutes")
    public void setTakedownsFirstXMinutes(long value) {
        this.takedownsFirstXMinutes = value;
    }

    @JsonProperty("takedownsInAlcove")
    public long getTakedownsInAlcove() {
        return takedownsInAlcove;
    }

    @JsonProperty("takedownsInAlcove")
    public void setTakedownsInAlcove(long value) {
        this.takedownsInAlcove = value;
    }

    @JsonProperty("takedownsInEnemyFountain")
    public long getTakedownsInEnemyFountain() {
        return takedownsInEnemyFountain;
    }

    @JsonProperty("takedownsInEnemyFountain")
    public void setTakedownsInEnemyFountain(long value) {
        this.takedownsInEnemyFountain = value;
    }

    @JsonProperty("teamBaronKills")
    public long getTeamBaronKills() {
        return teamBaronKills;
    }

    @JsonProperty("teamBaronKills")
    public void setTeamBaronKills(long value) {
        this.teamBaronKills = value;
    }

    @JsonProperty("teamDamagePercentage")
    public double getTeamDamagePercentage() {
        return teamDamagePercentage;
    }

    @JsonProperty("teamDamagePercentage")
    public void setTeamDamagePercentage(double value) {
        this.teamDamagePercentage = value;
    }

    @JsonProperty("teamElderDragonKills")
    public long getTeamElderDragonKills() {
        return teamElderDragonKills;
    }

    @JsonProperty("teamElderDragonKills")
    public void setTeamElderDragonKills(long value) {
        this.teamElderDragonKills = value;
    }

    @JsonProperty("teamRiftHeraldKills")
    public long getTeamRiftHeraldKills() {
        return teamRiftHeraldKills;
    }

    @JsonProperty("teamRiftHeraldKills")
    public void setTeamRiftHeraldKills(long value) {
        this.teamRiftHeraldKills = value;
    }

    @JsonProperty("tookLargeDamageSurvived")
    public long getTookLargeDamageSurvived() {
        return tookLargeDamageSurvived;
    }

    @JsonProperty("tookLargeDamageSurvived")
    public void setTookLargeDamageSurvived(long value) {
        this.tookLargeDamageSurvived = value;
    }

    @JsonProperty("turretPlatesTaken")
    public long getTurretPlatesTaken() {
        return turretPlatesTaken;
    }

    @JsonProperty("turretPlatesTaken")
    public void setTurretPlatesTaken(long value) {
        this.turretPlatesTaken = value;
    }

    @JsonProperty("turretTakedowns")
    public long getTurretTakedowns() {
        return turretTakedowns;
    }

    @JsonProperty("turretTakedowns")
    public void setTurretTakedowns(long value) {
        this.turretTakedowns = value;
    }

    @JsonProperty("turretsTakenWithRiftHerald")
    public long getTurretsTakenWithRiftHerald() {
        return turretsTakenWithRiftHerald;
    }

    @JsonProperty("turretsTakenWithRiftHerald")
    public void setTurretsTakenWithRiftHerald(long value) {
        this.turretsTakenWithRiftHerald = value;
    }

    @JsonProperty("twentyMinionsIn3SecondsCount")
    public long getTwentyMinionsIn3SecondsCount() {
        return twentyMinionsIn3SecondsCount;
    }

    @JsonProperty("twentyMinionsIn3SecondsCount")
    public void setTwentyMinionsIn3SecondsCount(long value) {
        this.twentyMinionsIn3SecondsCount = value;
    }

    @JsonProperty("twoWardsOneSweeperCount")
    public long getTwoWardsOneSweeperCount() {
        return twoWardsOneSweeperCount;
    }

    @JsonProperty("twoWardsOneSweeperCount")
    public void setTwoWardsOneSweeperCount(long value) {
        this.twoWardsOneSweeperCount = value;
    }

    @JsonProperty("unseenRecalls")
    public long getUnseenRecalls() {
        return unseenRecalls;
    }

    @JsonProperty("unseenRecalls")
    public void setUnseenRecalls(long value) {
        this.unseenRecalls = value;
    }

    @JsonProperty("visionScorePerMinute")
    public long getVisionScorePerMinute() {
        return visionScorePerMinute;
    }

    @JsonProperty("visionScorePerMinute")
    public void setVisionScorePerMinute(long value) {
        this.visionScorePerMinute = value;
    }

    @JsonProperty("wardTakedowns")
    public long getWardTakedowns() {
        return wardTakedowns;
    }

    @JsonProperty("wardTakedowns")
    public void setWardTakedowns(long value) {
        this.wardTakedowns = value;
    }

    @JsonProperty("wardTakedownsBefore20M")
    public long getWardTakedownsBefore20M() {
        return wardTakedownsBefore20M;
    }

    @JsonProperty("wardTakedownsBefore20M")
    public void setWardTakedownsBefore20M(long value) {
        this.wardTakedownsBefore20M = value;
    }

    @JsonProperty("wardsGuarded")
    public long getWardsGuarded() {
        return wardsGuarded;
    }

    @JsonProperty("wardsGuarded")
    public void setWardsGuarded(long value) {
        this.wardsGuarded = value;
    }

    @JsonProperty("firstTurretKilledTime")
    public Double getFirstTurretKilledTime() {
        return firstTurretKilledTime;
    }

    @JsonProperty("firstTurretKilledTime")
    public void setFirstTurretKilledTime(Double value) {
        this.firstTurretKilledTime = value;
    }

    @JsonProperty("highestChampionDamage")
    public Long getHighestChampionDamage() {
        return highestChampionDamage;
    }

    @JsonProperty("highestChampionDamage")
    public void setHighestChampionDamage(Long value) {
        this.highestChampionDamage = value;
    }
}
