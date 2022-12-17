package test;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("E:\\studentTest.bat"));
        StudentTable studentTable = (StudentTable) objectInputStream.readObject();
        studentTable.showStudent();
    }
}
