package me.kbin.exp.session;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kbin.exp.codeenum.UserType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
@RequiredArgsConstructor
@Slf4j
public class SessionController {

  private final HttpSession httpSession;
  private final TestVO setVO = new TestVO(1L, "email", 1, UserType.ADMIN);

  @GetMapping("/object")
  public void getObject() {
    TestVO testVO = (TestVO) httpSession.getAttribute("object");
    log.info(testVO.toString());
  }

  @PostMapping("/object")
  public void setObject() {
    httpSession.setAttribute("object", setVO);
  }

  @GetMapping("/java")
  public void getJava() throws IOException, ClassNotFoundException {
    String encode = (String) httpSession.getAttribute(
        "java");
    byte[] decode = Base64.getDecoder().decode(encode);
    try (ByteArrayInputStream bais = new ByteArrayInputStream(decode)) {
      try (ObjectInputStream ois = new ObjectInputStream(bais)) {
        Object objectMember = ois.readObject();
        TestVO vo = (TestVO) objectMember;
        log.info(vo.toString());
      }
    }
  }

  @PostMapping("/java")
  public void setJava() throws IOException {
    byte[] serializedMember;
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
      try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
        oos.writeObject(setVO);
        serializedMember = baos.toByteArray();
      }
    }
    String encode = Base64.getEncoder().encodeToString(serializedMember);
    httpSession.setAttribute("java", encode);
  }

  @GetMapping("/json")
  public void getJson() throws IOException {
    String json = (String) httpSession.getAttribute("json");
    ObjectMapper objectMapper = new ObjectMapper();
    TestVO testVO = objectMapper.readValue(json, TestVO.class);
    log.info(testVO.toString());

  }

  @PostMapping("/json")
  public void setJson() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    String value = objectMapper.writeValueAsString(setVO);
    httpSession.setAttribute("json", value);
  }
}
