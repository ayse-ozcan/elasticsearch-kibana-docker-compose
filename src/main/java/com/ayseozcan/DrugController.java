package com.ayseozcan;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/drugs")
@RequiredArgsConstructor
public class DrugController {
    private final DrugService drugService;

    @PostMapping("/save")
    public ResponseEntity<Boolean> save(@RequestBody Drug drug) {
        return ResponseEntity.ok(drugService.save(drug));
    }

    @GetMapping(value = "/find-all")
    public ResponseEntity<Iterable<Drug>> findAll() {
        return ResponseEntity.ok(drugService.findAll());
    }
}
