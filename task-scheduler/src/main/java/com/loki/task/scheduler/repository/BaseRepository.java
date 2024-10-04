package com.loki.task.scheduler.repository;

import java.util.Map;
import java.util.Optional;

public interface BaseRepository<T> {
    public T create(T object);
    public Optional<T> get(Integer primaryKey);
    public boolean delete(Integer primaryKey);
    public Map<Integer, T> getAll();

}
