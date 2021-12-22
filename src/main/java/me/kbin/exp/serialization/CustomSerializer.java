package me.kbin.exp.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class CustomSerializer extends JsonSerializer<Member> {

  @Override
  public void serialize(Member member, JsonGenerator gen,
      SerializerProvider serializer) throws IOException {
    gen.writeStartObject();

    gen.writeFieldName("cName");
    gen.writeString(member.getName());

    gen.writeFieldName("cEmail");
    gen.writeObject(member.getEmail());

    gen.writeFieldName("cAge");
    gen.writeObject(String.valueOf(member.getAge()));

    gen.writeEndObject();
  }
}
