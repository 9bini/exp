package me.kbin.exp.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Base64;

public class SerializationMain {

  static Member member = new Member("이름", "email", 10);

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    String serialization = serialization();
    System.out.println("===================");
    deserialization(serialization);
    System.out.println("===================");
    csv();
    System.out.println("===================");
    json();
  }

  private static String serialization() throws IOException {
    // ObjectOutputStream
    byte[] serializedMember;
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
      try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
        oos.writeObject(member);
        serializedMember = baos.toByteArray();
      }
    }
    System.out.println(Arrays.toString(serializedMember));
    System.out.println(Base64.getEncoder().encodeToString(serializedMember));
    return Base64.getEncoder().encodeToString(serializedMember);
  }

  private static void deserialization(String serialization)
      throws IOException, ClassNotFoundException {
    byte[] decode = Base64.getDecoder().decode(serialization);
    try (ByteArrayInputStream bais = new ByteArrayInputStream(decode)) {
      try (ObjectInputStream ois = new ObjectInputStream(bais)) {
        Object objectMember = ois.readObject();
        Member member = (Member) objectMember;
        System.out.println(member.toString());
      }
    }
  }

  private static void csv() {
    String csv = String.format("%s,%s,%d", member.getName(), member.getEmail(), member.getAge());
    System.out.println("csv = " + csv);
  }

  private static void json() throws JsonProcessingException {
    SimpleModule simpleModule = new SimpleModule();
    // Member 클래스는 `CustomSerializer`로 Serialize 하겠다는 의지의 표현.
    simpleModule.addSerializer(Member.class, new CustomSerializer());

    ObjectMapper customObjectMapper = new ObjectMapper();
    customObjectMapper.registerModule(simpleModule);
    String customValue = customObjectMapper.writeValueAsString(member);
    System.out.println(customValue);

    System.out.println("============================");

    ObjectMapper objectMapper = new ObjectMapper();
    String value = objectMapper.writeValueAsString(member);
    System.out.println(value);
  }

}
