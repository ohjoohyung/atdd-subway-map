package wooteco.subway.section.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wooteco.subway.section.controller.dto.SectionRequest;
import wooteco.subway.section.service.SectionService;

@RestController
@RequestMapping("/lines/{lineId}")
public class SectionApiController {

    private final SectionService sectionService;

    public SectionApiController(SectionService sectionService) {
        this.sectionService = sectionService;
    }
}
