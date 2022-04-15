package com.ucm.restarauntService.service;

import com.ucm.restarauntService.repository.Repository;

public abstract class ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> repository;

    ReadOnlyBaseService(Repository<TE, T> repository) {
        this.repository = repository;
    }
}
