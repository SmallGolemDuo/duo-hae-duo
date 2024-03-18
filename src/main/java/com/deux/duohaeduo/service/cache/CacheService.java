package com.deux.duohaeduo.service.cache;

import com.deux.duohaeduo.dto.SummonerData;
import com.deux.duohaeduo.dto.matchInfo.SummonerMatchInfo;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class CacheService {

    private final Cache<String, SummonerData> summonerDataCache;
    private final Cache<String, SummonerMatchInfo> matchInfosCache;

    public CacheService() {
        // 캐시 초기화: 최대 1000개의 항목을 저장하고, 항목은 1시간 후에 만료됩니다.
        this.summonerDataCache = Caffeine.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(1, TimeUnit.HOURS)
                .build();
        this.matchInfosCache = Caffeine.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(1, TimeUnit.HOURS)
                .build();
    }

    // 소환사 정보 캐시에서 데이터 조회하는 메소드
    public SummonerData findRiotGameSummonerDataFromCache(String cacheKey) {
        return summonerDataCache.getIfPresent(cacheKey);
    }

    // 소환사 정보 캐시에 데이터 저장하는 메소드
    public void summonerDataCacheResult(String cacheKey, SummonerData result) {
        summonerDataCache.put(cacheKey, result);
    }

    // 매치 정보 캐시에서 데이터 조회하는 메소드
    public SummonerMatchInfo findRiotGameMatchInfosFromCache(String cacheKey) {
        return matchInfosCache.getIfPresent(cacheKey);
    }

    // 매치 정보 캐시에 데이터 저장하는 메소드
    public void matchInfosCacheResult(String cacheKey, SummonerMatchInfo result) {
        matchInfosCache.put(cacheKey, result);
    }

}

