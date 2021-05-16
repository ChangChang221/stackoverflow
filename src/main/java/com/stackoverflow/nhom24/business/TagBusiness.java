package com.stackoverflow.nhom24.business;

import com.stackoverflow.nhom24.entity.Tag;
import com.stackoverflow.nhom24.repository.TagRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TagBusiness {
    private final TagRepository tagRepository;
    public List<Tag> getAll(int page){
        List<Tag> tags = tagRepository.findAll().stream().skip((page-1)*10 + 1).limit(10).collect(Collectors.toList());
        return tags;
    }

    public List<String> getNameTag() {
        List<Tag> tags = tagRepository.findAll();
        List<String> listNameTag = null;
        int sizeTag = tags.size();
        for (int i = 0; i < sizeTag; i++) {
            listNameTag.add(tags.get(i).getName());
        }

        return listNameTag;
    }

    public int getTotal() {
        return tagRepository.findAll().size();
    }
}
