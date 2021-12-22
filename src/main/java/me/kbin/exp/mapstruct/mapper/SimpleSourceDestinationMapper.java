package me.kbin.exp.mapstruct.mapper;

import me.kbin.exp.mapstruct.model.SimpleDestination;
import me.kbin.exp.mapstruct.model.SimpleSource;
import org.mapstruct.Mapper;

@Mapper
public interface SimpleSourceDestinationMapper {
  SimpleDestination sourceToDestination(SimpleSource source);
  SimpleSource destinationToSource(SimpleDestination destination);
}
