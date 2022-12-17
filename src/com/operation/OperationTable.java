package com.operation;

import java.io.IOException;

public interface OperationTable {
    boolean add(Object object) throws IOException, ClassNotFoundException;
    void deleteTable() throws IOException;
    boolean deleteById(int id) throws IOException, ClassNotFoundException;
    void show() throws IOException, ClassNotFoundException;
    void findById(int id) throws IOException, ClassNotFoundException;
}
