/**
 * @author 112200338周嘉裕
 * @date 2022/10/20
 */

import com.sun.source.tree.ContinueTree;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String id;//学号
    private String name;//姓名
    private double grade; //高数成绩
    private boolean isOff; //是否退学

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public boolean getIsOff() {
        return isOff;
    }

    public void setIsOff(boolean isOff) {
        this.isOff = isOff;
    }

    @Override
    public String toString() {
        return "学号：" + id + "，姓名：" + name + "，高数成绩：" + grade + "，是否退学：" + isOff;
    }

    public Student(String id, String name, double grade, boolean isOff) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.isOff = isOff;
    }

    private static final Scanner sc = new Scanner(System.in);

    public static void update() {
        sc.useDelimiter("\n");
        System.out.print("请输入要修改成绩的学生的学号：");
        String id = sc.next();
        boolean flag1 = true;//标记输入的学号是否存在
        boolean flag2 = true;//标记成绩修改是否成功
        for (Student stu : list) {
            if (stu.getId().equals(id)) {
                flag1 = false;
                break;
            }
        }
        if (flag1) {
            System.out.println("您修改的学生不存在，请重新输入!");
            update();
        }
        System.out.print("请输入要加的成绩：");
        redo:
        for (Student stu : list) {
            if (stu.getId().equals(id)) {
                if (sc.hasNextInt() && !stu.getIsOff()) {
                    int add = sc.nextInt();//加的成绩
                    if (stu.getGrade() + add <= 100) {
                        stu.setGrade(stu.getGrade() + add);
                        System.out.println("修改成功！" + stu.getName() + "修改后的成绩为：" + stu.getGrade());
                        flag2 = false;
                        break;
                    }
                }
            }
        }
        if (flag2) {
            System.out.println("修改失败，请重新输入!");
            update();
        }
    }

    public static void isPassed(String id) {
        boolean flag = true;
        for (Student stu : list) {
            if (stu.getId().equals(id)) {
                flag = false;
                if (stu.getGrade() < 60)
                    System.out.println(stu.getName() + "挂科了");
                else
                    System.out.println(stu.getName() + "通过了");
            }
        }
        if (flag) {
            System.out.print("不存在该同学，请重新输入学号：");
            isPassed(sc.next());
        }
    }

    public static void unpassedList() {
        boolean flag1 = true, flag2 = true;
        for (Student stu : list) {
            if (stu.getGrade() < 60 && !stu.isOff) {
                System.out.println("挂科的有以下同学：");
                flag1 = false;
                break;
            }
        }
        if (flag1)
            System.out.println("所有人都通过了高数考试！");
        else for (Student stu : list) {
            if (stu.getGrade() < 60 && !stu.isOff) {
                System.out.println(stu.getName());
            }
        }
        for (Student stu : list) {
            if (stu.isOff) {
                System.out.println("退学的有以下同学：");
                flag2 = false;
                break;
            }
        }
        if (flag2)
            System.out.println("没有同学退学！");
        else for (Student stu : list) {
            if (stu.isOff) {
                System.out.println(stu.getName());
            }
        }
    }

    public static void input() {
        sc.useDelimiter("\n");
        while (true) {
            System.out.print("请输入学生的学号：");
            String id = sc.next();
            boolean flag = false; //定义标记
            // 判断学号是否已存在
            for (Student stu : list) {
                if (stu.getId().equals(id)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("学生信息录入重复，请重新输入！");
                continue;
            }
            System.out.print("请输入学生的姓名：");
            String name = sc.next();
            System.out.print("请输入学生的高数成绩：");
            double grade = sc.nextDouble();
            System.out.print("如果该学生已退学，请输入true，否则输入false：");
            boolean isOff = sc.nextBoolean();
            Student student = new Student(id, name, grade, isOff);
            list.add(student);
            System.out.print("信息录入成功！按1继续录入，按其他按键停止录入：");
            if (!sc.next().equals("1")) {
                break;
            }
        }
    }

    static ArrayList<Student> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("接下来请输入所有学生的信息：");
        input();
        update();
        System.out.println("接下来将输出挂科和退学的同学的信息：");
        unpassedList();
        System.out.println("接下来将输出所有同学的信息：");
        for (Student student : list) {
            System.out.println(student.toString());
        }
        System.out.print("接下来查询学生是否挂科，请输入学号：");
        isPassed(sc.next());
        sc.close();
    }
}