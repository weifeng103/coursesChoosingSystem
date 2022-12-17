package test;



import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test {
    public static void main(String[] args) throws IOException {
        StudentTable studentTable = new StudentTable();
        studentTable.addStudent(new Student(1,"1","1"));
        studentTable.addStudent(new Student(2,"1","1"));
        studentTable.addStudent(new Student(3,"1","1"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("E:\\studentTest.bat"));
        objectOutputStream.writeObject(studentTable);
        objectOutputStream.flush();
        objectOutputStream.close();
        System.out.println("完成");
    }
}
