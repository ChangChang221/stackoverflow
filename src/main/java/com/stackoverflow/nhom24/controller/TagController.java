package com.stackoverflow.nhom24.controller;

import com.stackoverflow.nhom24.business.QuestionBusiness;
import com.stackoverflow.nhom24.business.TagBusiness;
import com.stackoverflow.nhom24.entity.Tag;
import com.stackoverflow.nhom24.model.response.TagResponse;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class TagController {
    private final TagBusiness tagBusiness;
    private final QuestionBusiness questionBusiness;

    @GetMapping(value = "/tags")
    public String tags(final ModelMap modelMap, Integer page, String tab) {
        boolean statustab = true;
        if(page == null){
            page = 1;
        }
        if(tab == null) {
            statustab = false;
            tab = "newest";
        }
        int total  = tagBusiness.getTotal();
        int x = total/10 + 1;
        System.out.println("total = " + total + ", total/10+1 = " + x);
        List<Tag> listTag = tagBusiness.getAll(page);
        List<TagResponse> responses = questionBusiness.countQuestionTag(listTag, page, tab);
        modelMap.addAttribute("tags", responses);
        modelMap.addAttribute("total", total);
        modelMap.addAttribute("pagination", (int) ( total/ 15) + 1);
        modelMap.addAttribute("page", page);
//        modelMap.addAttribute("cntQuestionTag", cntQuestionTag);
        return "tags";
    }

}
