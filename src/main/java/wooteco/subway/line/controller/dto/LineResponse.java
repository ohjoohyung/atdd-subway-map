package wooteco.subway.line.controller.dto;

import wooteco.subway.line.domain.Line;
import wooteco.subway.section.domain.Section;
import wooteco.subway.section.domain.Sections;
import wooteco.subway.station.controller.dto.StationResponse;

import java.util.ArrayList;
import java.util.List;

public class LineResponse {
    private Long id;
    private String name;
    private String color;
    private List<StationResponse> stations;

    public LineResponse() {
    }

    public LineResponse(Long id, String name, String color, List<StationResponse> stations) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.stations = stations;
    }

    public LineResponse(Line line) {
        this.id = line.getId();
        this.name = line.getName().text();
        this.color = line.getColor().text();
        this.stations = convertSectionsToStations(line.getSections());
    }

    private List<StationResponse> convertSectionsToStations(Sections sections) {
        List<Section> sectionList = sections.sections();
        List<StationResponse> stationResponses = new ArrayList<>();
        stationResponses.add(new StationResponse(sectionList.get(0).getUpStation()));
        for (Section section : sectionList) {
            stationResponses.add(new StationResponse(section.getDownStation()));
        }
        return stationResponses;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public List<StationResponse> getStations() {
        return stations;
    }
}