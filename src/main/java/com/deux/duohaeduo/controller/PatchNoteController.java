package com.deux.duohaeduo.controller;

import com.deux.duohaeduo.dto.response.PatchNoteResponse;
import com.deux.duohaeduo.service.PatchNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lol/patch-notes")
public class PatchNoteController {

    private final PatchNoteService patchNoteService;

    @GetMapping
    public List<PatchNoteResponse> crawlPatchNotices() throws IOException {
        return patchNoteService.findAllPatchNotes();
    }

}
