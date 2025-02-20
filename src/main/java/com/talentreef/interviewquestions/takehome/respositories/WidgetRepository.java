package com.talentreef.interviewquestions.takehome.respositories;

import com.talentreef.interviewquestions.takehome.models.Widget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface WidgetRepository extends JpaRepository<Widget, Long> {
  Optional<Widget> findByName(String name);
  boolean existsByName(String name);
}
