package org.burningokr.dto.okr;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.burningokr.model.okr.Unit;

import java.util.ArrayList;
import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
public class KeyResultDto {

  private Long id;

  @NotNull
  private Long parentObjectiveId;

  @Size(
      min = 1,
      max = 255,
      message = "The title of a key result may not be longer than 255 characters."
  )
  private String title;

  @Size(
      min = 1,
      max = 1023,
      message = "The description of a key result may not be longer than 1023 characters."
  )
  private String description;

  @PositiveOrZero
  private Long startValue;

  @PositiveOrZero
  private Long currentValue;

  @PositiveOrZero
  private Long targetValue;

  private Unit unit = Unit.NUMBER;

  private int sequence;

  private Collection<Long> noteIds = new ArrayList<>();

  private Collection<KeyResultMilestoneDto> keyResultMilestoneDtos = new ArrayList<>();

  public KeyResultDto() {}
}

