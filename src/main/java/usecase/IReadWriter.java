package usecase;

import java.io.IOException;

public interface IReadWriter {
    Object read() throws IOException, ClassNotFoundException;
    void write(Object o) throws IOException;
}