package pers.xiaoming.notebook.concurrent.thread.threadlocal;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
class Entity {
    private String name;
    private List<Integer> list;
    private List<Entity> subEntities;

    Entity(String name) {
        this.name = name;
        this.list = new ArrayList<>();
        this.subEntities = new ArrayList<>();
    }
}
