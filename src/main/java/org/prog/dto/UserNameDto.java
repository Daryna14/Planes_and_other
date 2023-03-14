package org.prog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
public class UserNameDto {
    private String title;
    private String first;
    private String last;

        public String getTitle() {
        return title;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String setTitle(String title) {
        return title;
    }

    public String setFirst(String first) {
        return first;
    }

    public String setLast(String last) {
        return last;
    }
}
