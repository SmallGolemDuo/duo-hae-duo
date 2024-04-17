package com.deux.duohaeduo.service;

import com.deux.duohaeduo.dto.response.PatchNoteResponse;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PatchNoteService {

    private static final String LOL_BASE_URL = "https://www.leagueoflegends.com";
    private static final String PATCH_NOTES_URL = LOL_BASE_URL + "/ko-kr/news/tags/patch-notes/";

    public List<PatchNoteResponse> findAllPatchNotes() throws IOException {
        Document doc = Jsoup.connect(PATCH_NOTES_URL).get();
        return getPatchNotes(doc.select(".style__Item-sc-106zuld-3"));
    }

    private List<PatchNoteResponse> getPatchNotes(Elements items) {
        List<PatchNoteResponse> patchNotes = new ArrayList<>();
        for (Element item : items) {
            PatchNoteResponse patchNote = crawlPatchNoteItem(item);
            if (patchNote == null) {
                throw new IllegalArgumentException("패치 노트 정보가 없습니다.");
            }
            patchNotes.add(patchNote);
        }
        return patchNotes;
    }

    private PatchNoteResponse crawlPatchNoteItem(Element item) {
        Element titleElement = item.selectFirst(".style__Title-sc-1h41bzo-8");
        Element linkElement = item.selectFirst(".style__Wrapper-sc-1h41bzo-0");
        Element imageElement = item.selectFirst(".style__ImageWrapper-sc-1h41bzo-5 img");

        if (titleElement == null || linkElement == null || imageElement == null) {
            return null;
        }
        return PatchNoteResponse.from(
                titleElement.text(),
                LOL_BASE_URL + linkElement.attr("href"),
                imageElement.attr("src"));
    }

}