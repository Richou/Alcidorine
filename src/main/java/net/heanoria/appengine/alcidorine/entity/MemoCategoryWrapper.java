package net.heanoria.appengine.alcidorine.entity;

import java.util.List;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class MemoCategoryWrapper {

    private List<MemoCategory> items;

    public List<MemoCategory> getItems() {
        return items;
    }

    public void setItems(List<MemoCategory> items) {
        this.items = items;
    }

}
