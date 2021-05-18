package com.stackoverflow.nhom24.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class VoteResponse {
    private String userId;
    private Boolean status;
    private String id;
}
