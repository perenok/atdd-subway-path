package wooteco.subway.admin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wooteco.subway.admin.dto.ShortestDistanceResponse;
import wooteco.subway.admin.service.LineService;

@RequestMapping("/path")
@RestController
public class PathController {
    private LineService lineService;

    public PathController(LineService lineService) {
        this.lineService = lineService;
    }

    @GetMapping("/distance")
    public ResponseEntity<ShortestDistanceResponse> findShortestDistancePath(
        @RequestParam("source") String source,
        @RequestParam("target") String target) {
        ShortestDistanceResponse shortestDistanceResponse = lineService.searchShortestDistancePath(
            source, target);
        return ResponseEntity.ok().body(shortestDistanceResponse);
    }
}
