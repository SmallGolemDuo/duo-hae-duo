package com.deux.duohaeduo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatchNoteResponse {

    private String subject;
    private String patchNoteUrl;
    private String imageUrl;

    public static PatchNoteResponse from(String subject, String patchNoteUrl, String imageUrl) {
        return PatchNoteResponse.builder()
                .subject(subject)
                .patchNoteUrl(patchNoteUrl)
                .imageUrl(imageUrl)
                .build();
    }

}
