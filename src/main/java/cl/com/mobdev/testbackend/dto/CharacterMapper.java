package cl.com.mobdev.testbackend.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;


@Mapper(
		componentModel = "spring",
		nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
		unmappedTargetPolicy = ReportingPolicy.IGNORE,
		nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
		)
public interface CharacterMapper {
	
	@Mappings({
		  @Mapping(target = "episodeCount", expression = "java(character.getEpisode() !=null?character.getEpisode().size():0)")})
	public CharacterDto toDto(cl.com.mobdev.testbackend.model.Character character);

}
