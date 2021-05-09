package wooteco.subway.section.dao;

import wooteco.subway.section.domain.Section;
import wooteco.subway.section.domain.Sections;

import java.util.List;

public interface SectionDao {
    Section save(Section section);

    Sections findByLineId(Long lineId);
}
