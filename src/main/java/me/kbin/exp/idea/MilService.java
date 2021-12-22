package me.kbin.exp.idea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MilService {

  @Autowired
  MilRepository milRepository;

  public Mil test(){
    Mil save = milRepository.save(new Mil());
    return save;
  }

  public Mil get(Long id) {
    boolean exist = milRepository.existsById(id);
    if (exist)return null;
    return milRepository.findById(id).get();
  }
}
