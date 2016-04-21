/**
* @package inpu_output_stream
* @author ZS@ZJU
* @version V1.0
*/
package io_stream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectSeriaDemo1 {
    public static void main(String[] args) throws Exception{
        String file = "obj.dat";
        //1.对象的序列化
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file));
        Student stu = new Student("10001", "张三", 20);
        oos.writeObject(stu);
        oos.flush();
        oos.close();
//        ObjectInputStream ois = new ObjectInputStream(
//                new FileInputStream(file));
//        Student s = (Student)ois.readObject();
//        System.out.println(s);
//        ois.close();
//        
    }
    

}
