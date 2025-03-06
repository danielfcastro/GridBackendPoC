package com.ing.grid.controller;

import com.ing.grid.database.entity.MyTable;
import com.ing.grid.database.repository.MyTableRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/mytable")
public class MyTableController {

    private final MyTableRepository repository;

    public MyTableController(MyTableRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public CollectionModel<EntityModel<MyTable>> getAll() {
        List<EntityModel<MyTable>> myTables = repository.findAll().stream()
                .map(myTable -> EntityModel.of(myTable,
                        linkTo(methodOn(MyTableController.class).getOne(myTable.getId())).withSelfRel(),
                        linkTo(methodOn(MyTableController.class).getAll()).withRel("myTables")))
                .collect(Collectors.toList());

        return CollectionModel.of(myTables,
                linkTo(methodOn(MyTableController.class).getAll()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<MyTable> getOne(@PathVariable Long id) {
        MyTable myTable = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("MyTable not found with id: " + id));

        return EntityModel.of(myTable,
                linkTo(methodOn(MyTableController.class).getOne(id)).withSelfRel(),
                linkTo(methodOn(MyTableController.class).getAll()).withRel("myTables"));
    }

    @PostMapping
    public MyTable create(@RequestBody MyTable myTable) {
        return repository.save(myTable);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
