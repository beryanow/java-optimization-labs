package ru.nsu.g.beryanov.book_library.mapping;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.nsu.g.beryanov.book_library.dto.AssessmentDto;
import ru.nsu.g.beryanov.book_library.model.Assessment;

import java.util.List;

@Mapper(uses = {BookReadMapper.class}, componentModel = "spring")
public interface AssessmentMapper {
    @Mapping(target = "booksReadById", qualifiedByName = "toIncompleteBookReadDtoList")
    AssessmentDto toDto(Assessment assessment);
    Assessment toEntity(AssessmentDto assessmentDto);

    @Named("toIncompleteAssessmentDto")
    @Mapping(target = "booksReadById", ignore = true)
    AssessmentDto toIncompleteDto(Assessment assessment);

    @Named("toIncompleteAssessmentDtoList")
    @IterableMapping(qualifiedByName = "toIncompleteAssessmentDto")
    List<AssessmentDto> toIncompleteDtoList(List<Assessment> assessmentList);

    List<AssessmentDto> toDtoList(List<Assessment> assessmentList);
    List<Assessment> toEntityList(List<AssessmentDto> assessmentDtoList);
}
